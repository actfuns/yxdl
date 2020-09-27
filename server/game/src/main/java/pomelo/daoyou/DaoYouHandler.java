package pomelo.daoyou;

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


public final class DaoYouHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class DaoYouInfo
            extends GeneratedMessage
            implements DaoYouInfoOrBuilder {
        private static final DaoYouInfo defaultInstance = new DaoYouInfo(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerId_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.playerName_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.playerLvl_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.pro_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.playerUpLvl_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.areaName_ = bs;
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.playerFightPower_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.isAdmin_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.onlineState_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.lastActiveTime_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 0x400;
                            this.joinTime_ = input.readInt32();
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouInfo.class, Builder.class);
        }

        public static Parser<DaoYouInfo> PARSER = (Parser<DaoYouInfo>) new AbstractParser<DaoYouInfo>() {
            public DaoYouHandler.DaoYouInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        public static final int PLAYERNAME_FIELD_NUMBER = 2;
        private Object playerName_;
        public static final int PLAYERLVL_FIELD_NUMBER = 3;
        private int playerLvl_;
        public static final int PRO_FIELD_NUMBER = 4;
        private int pro_;
        public static final int PLAYERUPLVL_FIELD_NUMBER = 5;
        private int playerUpLvl_;
        public static final int AREANAME_FIELD_NUMBER = 6;
        private Object areaName_;
        public static final int PLAYERFIGHTPOWER_FIELD_NUMBER = 7;
        private int playerFightPower_;
        public static final int ISADMIN_FIELD_NUMBER = 8;
        private int isAdmin_;
        public static final int ONLINESTATE_FIELD_NUMBER = 9;
        private int onlineState_;
        public static final int LASTACTIVETIME_FIELD_NUMBER = 10;
        private int lastActiveTime_;
        public static final int JOINTIME_FIELD_NUMBER = 11;
        private int joinTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerId_ = s;
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

        public boolean hasPlayerName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public String getPlayerName() {
            Object ref = this.playerName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.playerName_ = s;
            return s;
        }

        public ByteString getPlayerNameBytes() {
            Object ref = this.playerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasPlayerLvl() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getPlayerLvl() {
            return this.playerLvl_;
        }

        public boolean hasPro() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasPlayerUpLvl() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getPlayerUpLvl() {
            return this.playerUpLvl_;
        }

        public boolean hasAreaName() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getAreaName() {
            Object ref = this.areaName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.areaName_ = s;
            return s;
        }

        public ByteString getAreaNameBytes() {
            Object ref = this.areaName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.areaName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasPlayerFightPower() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getPlayerFightPower() {
            return this.playerFightPower_;
        }

        public boolean hasIsAdmin() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getIsAdmin() {
            return this.isAdmin_;
        }

        public boolean hasOnlineState() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getOnlineState() {
            return this.onlineState_;
        }

        public boolean hasLastActiveTime() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getLastActiveTime() {
            return this.lastActiveTime_;
        }

        public boolean hasJoinTime() {
            return ((this.bitField0_ & 0x400) == 1024);
        }

        public int getJoinTime() {
            return this.joinTime_;
        }

        private void initFields() {
            this.playerId_ = "";
            this.playerName_ = "";
            this.playerLvl_ = 0;
            this.pro_ = 0;
            this.playerUpLvl_ = 0;
            this.areaName_ = "";
            this.playerFightPower_ = 0;
            this.isAdmin_ = 0;
            this.onlineState_ = 0;
            this.lastActiveTime_ = 0;
            this.joinTime_ = 0;
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
                output.writeBytes(1, getPlayerIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getPlayerNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.playerLvl_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.playerUpLvl_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(6, getAreaNameBytes());
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.playerFightPower_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(8, this.isAdmin_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.onlineState_);
            if ((this.bitField0_ & 0x200) == 512)
                output.writeInt32(10, this.lastActiveTime_);
            if ((this.bitField0_ & 0x400) == 1024)
                output.writeInt32(11, this.joinTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getPlayerNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.playerLvl_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.playerUpLvl_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(6, getAreaNameBytes());
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.playerFightPower_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.isAdmin_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.onlineState_);
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt32Size(10, this.lastActiveTime_);
            if ((this.bitField0_ & 0x400) == 1024)
                size += CodedOutputStream.computeInt32Size(11, this.joinTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouInfo) PARSER.parseFrom(data);
        }

        public static DaoYouInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouInfo) PARSER.parseFrom(data);
        }

        public static DaoYouInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouInfo parseFrom(InputStream input) throws IOException {
            return (DaoYouInfo) PARSER.parseFrom(input);
        }

        public static DaoYouInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouInfo) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouInfo parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouInfo) PARSER.parseFrom(input);
        }

        public static DaoYouInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouInfoOrBuilder {
            private int bitField0_;
            private Object playerId_;
            private Object playerName_;
            private int playerLvl_;
            private int pro_;
            private int playerUpLvl_;
            private Object areaName_;
            private int playerFightPower_;
            private int isAdmin_;
            private int onlineState_;
            private int lastActiveTime_;
            private int joinTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouInfo.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                this.playerName_ = "";
                this.areaName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                this.playerName_ = "";
                this.areaName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerLvl_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.playerUpLvl_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.areaName_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.playerFightPower_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.isAdmin_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.onlineState_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.lastActiveTime_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.joinTime_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInfo_descriptor;
            }

            public DaoYouHandler.DaoYouInfo getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouInfo.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouInfo build() {
                DaoYouHandler.DaoYouInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouInfo buildPartial() {
                DaoYouHandler.DaoYouInfo result = new DaoYouHandler.DaoYouInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.playerId_ = this.playerId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.playerName_ = this.playerName_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.playerLvl_ = this.playerLvl_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.playerUpLvl_ = this.playerUpLvl_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.areaName_ = this.areaName_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.playerFightPower_ = this.playerFightPower_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.isAdmin_ = this.isAdmin_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.onlineState_ = this.onlineState_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x200;
                result.lastActiveTime_ = this.lastActiveTime_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x400;
                result.joinTime_ = this.joinTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouInfo)
                    return mergeFrom((DaoYouHandler.DaoYouInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouInfo other) {
                if (other == DaoYouHandler.DaoYouInfo.getDefaultInstance())
                    return this;
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                if (other.hasPlayerName()) {
                    this.bitField0_ |= 0x2;
                    this.playerName_ = other.playerName_;
                    onChanged();
                }
                if (other.hasPlayerLvl())
                    setPlayerLvl(other.getPlayerLvl());
                if (other.hasPro())
                    setPro(other.getPro());
                if (other.hasPlayerUpLvl())
                    setPlayerUpLvl(other.getPlayerUpLvl());
                if (other.hasAreaName()) {
                    this.bitField0_ |= 0x20;
                    this.areaName_ = other.areaName_;
                    onChanged();
                }
                if (other.hasPlayerFightPower())
                    setPlayerFightPower(other.getPlayerFightPower());
                if (other.hasIsAdmin())
                    setIsAdmin(other.getIsAdmin());
                if (other.hasOnlineState())
                    setOnlineState(other.getOnlineState());
                if (other.hasLastActiveTime())
                    setLastActiveTime(other.getLastActiveTime());
                if (other.hasJoinTime())
                    setJoinTime(other.getJoinTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouInfo parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouInfo) DaoYouHandler.DaoYouInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getPlayerId() {
                Object ref = this.playerId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.playerId_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = DaoYouHandler.DaoYouInfo.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public boolean hasPlayerName() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getPlayerName() {
                Object ref = this.playerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.playerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPlayerNameBytes() {
                Object ref = this.playerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.playerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerName_ = DaoYouHandler.DaoYouInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasPlayerLvl() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getPlayerLvl() {
                return this.playerLvl_;
            }

            public Builder setPlayerLvl(int value) {
                this.bitField0_ |= 0x4;
                this.playerLvl_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerLvl() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.playerLvl_ = 0;
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

            public boolean hasPlayerUpLvl() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getPlayerUpLvl() {
                return this.playerUpLvl_;
            }

            public Builder setPlayerUpLvl(int value) {
                this.bitField0_ |= 0x10;
                this.playerUpLvl_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerUpLvl() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.playerUpLvl_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAreaName() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getAreaName() {
                Object ref = this.areaName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.areaName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getAreaNameBytes() {
                Object ref = this.areaName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.areaName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setAreaName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.areaName_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaName() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.areaName_ = DaoYouHandler.DaoYouInfo.getDefaultInstance().getAreaName();
                onChanged();
                return this;
            }

            public Builder setAreaNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.areaName_ = value;
                onChanged();
                return this;
            }

            public boolean hasPlayerFightPower() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getPlayerFightPower() {
                return this.playerFightPower_;
            }

            public Builder setPlayerFightPower(int value) {
                this.bitField0_ |= 0x40;
                this.playerFightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerFightPower() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.playerFightPower_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsAdmin() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getIsAdmin() {
                return this.isAdmin_;
            }

            public Builder setIsAdmin(int value) {
                this.bitField0_ |= 0x80;
                this.isAdmin_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAdmin() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.isAdmin_ = 0;
                onChanged();
                return this;
            }

            public boolean hasOnlineState() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getOnlineState() {
                return this.onlineState_;
            }

            public Builder setOnlineState(int value) {
                this.bitField0_ |= 0x100;
                this.onlineState_ = value;
                onChanged();
                return this;
            }

            public Builder clearOnlineState() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.onlineState_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLastActiveTime() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getLastActiveTime() {
                return this.lastActiveTime_;
            }

            public Builder setLastActiveTime(int value) {
                this.bitField0_ |= 0x200;
                this.lastActiveTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastActiveTime() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.lastActiveTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasJoinTime() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public int getJoinTime() {
                return this.joinTime_;
            }

            public Builder setJoinTime(int value) {
                this.bitField0_ |= 0x400;
                this.joinTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearJoinTime() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.joinTime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class DaoYouMessage extends GeneratedMessage implements DaoYouMessageOrBuilder {
        private static final DaoYouMessage defaultInstance = new DaoYouMessage(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouMessage(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouMessage(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouMessage getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouMessage getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.type_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.content_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.time_ = input.readInt32();
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMessage_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouMessage.class, Builder.class);
        }

        public static Parser<DaoYouMessage> PARSER = (Parser<DaoYouMessage>) new AbstractParser<DaoYouMessage>() {
            public DaoYouHandler.DaoYouMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouMessage(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int CONTENT_FIELD_NUMBER = 2;
        private Object content_;
        public static final int TIME_FIELD_NUMBER = 3;
        private int time_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouMessage> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasContent() {
            return ((this.bitField0_ & 0x2) == 2);
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

        public boolean hasTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getTime() {
            return this.time_;
        }

        private void initFields() {
            this.type_ = 0;
            this.content_ = "";
            this.time_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.type_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getContentBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.time_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.type_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getContentBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.time_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouMessage) PARSER.parseFrom(data);
        }

        public static DaoYouMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouMessage) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouMessage) PARSER.parseFrom(data);
        }

        public static DaoYouMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouMessage) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouMessage parseFrom(InputStream input) throws IOException {
            return (DaoYouMessage) PARSER.parseFrom(input);
        }

        public static DaoYouMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouMessage) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouMessage parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouMessage) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouMessage) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouMessage parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouMessage) PARSER.parseFrom(input);
        }

        public static DaoYouMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouMessage) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouMessage prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouMessageOrBuilder {
            private int bitField0_;
            private int type_;
            private Object content_;
            private int time_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMessage_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouMessage.class, Builder.class);
            }

            private Builder() {
                this.content_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.content_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouMessage.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.content_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.time_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMessage_descriptor;
            }

            public DaoYouHandler.DaoYouMessage getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouMessage.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouMessage build() {
                DaoYouHandler.DaoYouMessage result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouMessage buildPartial() {
                DaoYouHandler.DaoYouMessage result = new DaoYouHandler.DaoYouMessage(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.content_ = this.content_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.time_ = this.time_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouMessage) return mergeFrom((DaoYouHandler.DaoYouMessage) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouMessage other) {
                if (other == DaoYouHandler.DaoYouMessage.getDefaultInstance()) return this;
                if (other.hasType()) setType(other.getType());
                if (other.hasContent()) {
                    this.bitField0_ |= 0x2;
                    this.content_ = other.content_;
                    onChanged();
                }
                if (other.hasTime()) setTime(other.getTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouMessage parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouMessage) DaoYouHandler.DaoYouMessage.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouMessage) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x1;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasContent() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.content_ = value;
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.content_ = DaoYouHandler.DaoYouMessage.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.content_ = value;
                onChanged();
                return this;
            }

            public boolean hasTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getTime() {
                return this.time_;
            }

            public Builder setTime(int value) {
                this.bitField0_ |= 0x4;
                this.time_ = value;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.time_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class DaoYouRequest
            extends GeneratedMessage
            implements DaoYouRequestOrBuilder {
        private static final DaoYouRequest defaultInstance = new DaoYouRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouRequest.class, Builder.class);
        }

        public static Parser<DaoYouRequest> PARSER = (Parser<DaoYouRequest>) new AbstractParser<DaoYouRequest>() {
            public DaoYouHandler.DaoYouRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouRequest> getParserForType() {
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

        public static DaoYouRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouRequest) PARSER.parseFrom(data);
        }

        public static DaoYouRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouRequest) PARSER.parseFrom(data);
        }

        public static DaoYouRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouRequest) PARSER.parseFrom(input);
        }

        public static DaoYouRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouRequest) PARSER.parseFrom(input);
        }

        public static DaoYouRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouRequest.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRequest_descriptor;
            }

            public DaoYouHandler.DaoYouRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouRequest build() {
                DaoYouHandler.DaoYouRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouRequest buildPartial() {
                DaoYouHandler.DaoYouRequest result = new DaoYouHandler.DaoYouRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouRequest) return mergeFrom((DaoYouHandler.DaoYouRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouRequest other) {
                if (other == DaoYouHandler.DaoYouRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouRequest) DaoYouHandler.DaoYouRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouRequest) e.getUnfinishedMessage();
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


    public static final class DaoYouResponse
            extends GeneratedMessage
            implements DaoYouResponseOrBuilder {
        private static final DaoYouResponse defaultInstance = new DaoYouResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.isHasDaoYou_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.isEditedDyName_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.dyId_ = bs;
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.dyName_ = bs;
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.dyFightPower_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.dyRank_ = input.readInt32();
                            break;
                        case 74:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x100;
                            this.dyNotice_ = bs;
                            break;
                        case 82:
                            if ((mutable_bitField0_ & 0x200) != 512) {
                                this.message_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x200;
                            }
                            this.message_.add(input.readMessage(DaoYouHandler.DaoYouMessage.PARSER, extensionRegistry));
                            break;
                        case 90:
                            if ((mutable_bitField0_ & 0x400) != 1024) {
                                this.dyInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x400;
                            }
                            this.dyInfo_.add(input.readMessage(DaoYouHandler.DaoYouInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x200) == 512) this.message_ = Collections.unmodifiableList(this.message_);
                if ((mutable_bitField0_ & 0x400) == 1024) this.dyInfo_ = Collections.unmodifiableList(this.dyInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouResponse.class, Builder.class);
        }

        public static Parser<DaoYouResponse> PARSER = (Parser<DaoYouResponse>) new AbstractParser<DaoYouResponse>() {
            public DaoYouHandler.DaoYouResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int ISHASDAOYOU_FIELD_NUMBER = 3;
        private int isHasDaoYou_;
        public static final int ISEDITEDDYNAME_FIELD_NUMBER = 4;
        private int isEditedDyName_;
        public static final int DYID_FIELD_NUMBER = 5;
        private Object dyId_;
        public static final int DYNAME_FIELD_NUMBER = 6;
        private Object dyName_;
        public static final int DYFIGHTPOWER_FIELD_NUMBER = 7;
        private int dyFightPower_;
        public static final int DYRANK_FIELD_NUMBER = 8;
        private int dyRank_;
        public static final int DYNOTICE_FIELD_NUMBER = 9;
        private Object dyNotice_;
        public static final int MESSAGE_FIELD_NUMBER = 10;
        private List<DaoYouHandler.DaoYouMessage> message_;
        public static final int DYINFO_FIELD_NUMBER = 11;
        private List<DaoYouHandler.DaoYouInfo> dyInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouResponse> getParserForType() {
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

        public boolean hasIsHasDaoYou() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getIsHasDaoYou() {
            return this.isHasDaoYou_;
        }

        public boolean hasIsEditedDyName() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getIsEditedDyName() {
            return this.isEditedDyName_;
        }

        public boolean hasDyId() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getDyId() {
            Object ref = this.dyId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.dyId_ = s;
            return s;
        }

        public ByteString getDyIdBytes() {
            Object ref = this.dyId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dyId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasDyName() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getDyName() {
            Object ref = this.dyName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.dyName_ = s;
            return s;
        }

        public ByteString getDyNameBytes() {
            Object ref = this.dyName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dyName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasDyFightPower() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getDyFightPower() {
            return this.dyFightPower_;
        }

        public boolean hasDyRank() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getDyRank() {
            return this.dyRank_;
        }

        public boolean hasDyNotice() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public String getDyNotice() {
            Object ref = this.dyNotice_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.dyNotice_ = s;
            return s;
        }

        public ByteString getDyNoticeBytes() {
            Object ref = this.dyNotice_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dyNotice_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public List<DaoYouHandler.DaoYouMessage> getMessageList() {
            return this.message_;
        }

        public List<? extends DaoYouHandler.DaoYouMessageOrBuilder> getMessageOrBuilderList() {
            return (List) this.message_;
        }

        public int getMessageCount() {
            return this.message_.size();
        }

        public DaoYouHandler.DaoYouMessage getMessage(int index) {
            return this.message_.get(index);
        }

        public DaoYouHandler.DaoYouMessageOrBuilder getMessageOrBuilder(int index) {
            return this.message_.get(index);
        }

        public List<DaoYouHandler.DaoYouInfo> getDyInfoList() {
            return this.dyInfo_;
        }

        public List<? extends DaoYouHandler.DaoYouInfoOrBuilder> getDyInfoOrBuilderList() {
            return (List) this.dyInfo_;
        }

        public int getDyInfoCount() {
            return this.dyInfo_.size();
        }

        public DaoYouHandler.DaoYouInfo getDyInfo(int index) {
            return this.dyInfo_.get(index);
        }

        static {
            defaultInstance.initFields();
        }

        public DaoYouHandler.DaoYouInfoOrBuilder getDyInfoOrBuilder(int index) {
            return this.dyInfo_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.isHasDaoYou_ = 0;
            this.isEditedDyName_ = 0;
            this.dyId_ = "";
            this.dyName_ = "";
            this.dyFightPower_ = 0;
            this.dyRank_ = 0;
            this.dyNotice_ = "";
            this.message_ = Collections.emptyList();
            this.dyInfo_ = Collections.emptyList();
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
                output.writeInt32(3, this.isHasDaoYou_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.isEditedDyName_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(5, getDyIdBytes());
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(6, getDyNameBytes());
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.dyFightPower_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(8, this.dyRank_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeBytes(9, getDyNoticeBytes());
            int i;
            for (i = 0; i < this.message_.size(); i++)
                output.writeMessage(10, (MessageLite) this.message_.get(i));
            for (i = 0; i < this.dyInfo_.size(); i++)
                output.writeMessage(11, (MessageLite) this.dyInfo_.get(i));
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
                size += CodedOutputStream.computeInt32Size(3, this.isHasDaoYou_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.isEditedDyName_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(5, getDyIdBytes());
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(6, getDyNameBytes());
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.dyFightPower_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.dyRank_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeBytesSize(9, getDyNoticeBytes());
            int i;
            for (i = 0; i < this.message_.size(); i++)
                size += CodedOutputStream.computeMessageSize(10, (MessageLite) this.message_.get(i));
            for (i = 0; i < this.dyInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(11, (MessageLite) this.dyInfo_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouResponse) PARSER.parseFrom(data);
        }

        public static DaoYouResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouResponse) PARSER.parseFrom(data);
        }

        public static DaoYouResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouResponse) PARSER.parseFrom(input);
        }

        public static DaoYouResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouResponse) PARSER.parseFrom(input);
        }

        public static DaoYouResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int isHasDaoYou_;
            private int isEditedDyName_;
            private Object dyId_;
            private Object dyName_;
            private int dyFightPower_;
            private int dyRank_;
            private Object dyNotice_;
            private List<DaoYouHandler.DaoYouMessage> message_;
            private RepeatedFieldBuilder<DaoYouHandler.DaoYouMessage, DaoYouHandler.DaoYouMessage.Builder, DaoYouHandler.DaoYouMessageOrBuilder> messageBuilder_;
            private List<DaoYouHandler.DaoYouInfo> dyInfo_;
            private RepeatedFieldBuilder<DaoYouHandler.DaoYouInfo, DaoYouHandler.DaoYouInfo.Builder, DaoYouHandler.DaoYouInfoOrBuilder> dyInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.dyId_ = "";
                this.dyName_ = "";
                this.dyNotice_ = "";
                this.message_ = Collections.emptyList();
                this.dyInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.dyId_ = "";
                this.dyName_ = "";
                this.dyNotice_ = "";
                this.message_ = Collections.emptyList();
                this.dyInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouResponse.alwaysUseFieldBuilders) {
                    getMessageFieldBuilder();
                    getDyInfoFieldBuilder();
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
                this.isHasDaoYou_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.isEditedDyName_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.dyId_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.dyName_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.dyFightPower_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.dyRank_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.dyNotice_ = "";
                this.bitField0_ &= 0xFFFFFEFF;
                if (this.messageBuilder_ == null) {
                    this.message_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFDFF;
                } else {
                    this.messageBuilder_.clear();
                }
                if (this.dyInfoBuilder_ == null) {
                    this.dyInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFBFF;
                } else {
                    this.dyInfoBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouResponse_descriptor;
            }

            public DaoYouHandler.DaoYouResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouResponse build() {
                DaoYouHandler.DaoYouResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouResponse buildPartial() {
                DaoYouHandler.DaoYouResponse result = new DaoYouHandler.DaoYouResponse(this);
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
                result.isHasDaoYou_ = this.isHasDaoYou_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.isEditedDyName_ = this.isEditedDyName_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.dyId_ = this.dyId_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.dyName_ = this.dyName_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.dyFightPower_ = this.dyFightPower_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.dyRank_ = this.dyRank_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.dyNotice_ = this.dyNotice_;
                if (this.messageBuilder_ == null) {
                    if ((this.bitField0_ & 0x200) == 512) {
                        this.message_ = Collections.unmodifiableList(this.message_);
                        this.bitField0_ &= 0xFFFFFDFF;
                    }
                    result.message_ = this.message_;
                } else {
                    result.message_ = this.messageBuilder_.build();
                }
                if (this.dyInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x400) == 1024) {
                        this.dyInfo_ = Collections.unmodifiableList(this.dyInfo_);
                        this.bitField0_ &= 0xFFFFFBFF;
                    }
                    result.dyInfo_ = this.dyInfo_;
                } else {
                    result.dyInfo_ = this.dyInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouResponse)
                    return mergeFrom((DaoYouHandler.DaoYouResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouResponse other) {
                if (other == DaoYouHandler.DaoYouResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasIsHasDaoYou())
                    setIsHasDaoYou(other.getIsHasDaoYou());
                if (other.hasIsEditedDyName())
                    setIsEditedDyName(other.getIsEditedDyName());
                if (other.hasDyId()) {
                    this.bitField0_ |= 0x10;
                    this.dyId_ = other.dyId_;
                    onChanged();
                }
                if (other.hasDyName()) {
                    this.bitField0_ |= 0x20;
                    this.dyName_ = other.dyName_;
                    onChanged();
                }
                if (other.hasDyFightPower())
                    setDyFightPower(other.getDyFightPower());
                if (other.hasDyRank())
                    setDyRank(other.getDyRank());
                if (other.hasDyNotice()) {
                    this.bitField0_ |= 0x100;
                    this.dyNotice_ = other.dyNotice_;
                    onChanged();
                }
                if (this.messageBuilder_ == null) {
                    if (!other.message_.isEmpty()) {
                        if (this.message_.isEmpty()) {
                            this.message_ = other.message_;
                            this.bitField0_ &= 0xFFFFFDFF;
                        } else {
                            ensureMessageIsMutable();
                            this.message_.addAll(other.message_);
                        }
                        onChanged();
                    }
                } else if (!other.message_.isEmpty()) {
                    if (this.messageBuilder_.isEmpty()) {
                        this.messageBuilder_.dispose();
                        this.messageBuilder_ = null;
                        this.message_ = other.message_;
                        this.bitField0_ &= 0xFFFFFDFF;
                        this.messageBuilder_ = DaoYouHandler.DaoYouResponse.alwaysUseFieldBuilders ? getMessageFieldBuilder() : null;
                    } else {
                        this.messageBuilder_.addAllMessages(other.message_);
                    }
                }
                if (this.dyInfoBuilder_ == null) {
                    if (!other.dyInfo_.isEmpty()) {
                        if (this.dyInfo_.isEmpty()) {
                            this.dyInfo_ = other.dyInfo_;
                            this.bitField0_ &= 0xFFFFFBFF;
                        } else {
                            ensureDyInfoIsMutable();
                            this.dyInfo_.addAll(other.dyInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.dyInfo_.isEmpty()) {
                    if (this.dyInfoBuilder_.isEmpty()) {
                        this.dyInfoBuilder_.dispose();
                        this.dyInfoBuilder_ = null;
                        this.dyInfo_ = other.dyInfo_;
                        this.bitField0_ &= 0xFFFFFBFF;
                        this.dyInfoBuilder_ = DaoYouHandler.DaoYouResponse.alwaysUseFieldBuilders ? getDyInfoFieldBuilder() : null;
                    } else {
                        this.dyInfoBuilder_.addAllMessages(other.dyInfo_);
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
                DaoYouHandler.DaoYouResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouResponse) DaoYouHandler.DaoYouResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasIsHasDaoYou() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getIsHasDaoYou() {
                return this.isHasDaoYou_;
            }

            public Builder setIsHasDaoYou(int value) {
                this.bitField0_ |= 0x4;
                this.isHasDaoYou_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHasDaoYou() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.isHasDaoYou_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsEditedDyName() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getIsEditedDyName() {
                return this.isEditedDyName_;
            }

            public Builder setIsEditedDyName(int value) {
                this.bitField0_ |= 0x8;
                this.isEditedDyName_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEditedDyName() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.isEditedDyName_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDyId() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getDyId() {
                Object ref = this.dyId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.dyId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDyIdBytes() {
                Object ref = this.dyId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.dyId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setDyId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.dyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDyId() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.dyId_ = DaoYouHandler.DaoYouResponse.getDefaultInstance().getDyId();
                onChanged();
                return this;
            }

            public Builder setDyIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.dyId_ = value;
                onChanged();
                return this;
            }

            public boolean hasDyName() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getDyName() {
                Object ref = this.dyName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.dyName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDyNameBytes() {
                Object ref = this.dyName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.dyName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setDyName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.dyName_ = value;
                onChanged();
                return this;
            }

            public Builder clearDyName() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.dyName_ = DaoYouHandler.DaoYouResponse.getDefaultInstance().getDyName();
                onChanged();
                return this;
            }

            public Builder setDyNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.dyName_ = value;
                onChanged();
                return this;
            }

            public boolean hasDyFightPower() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getDyFightPower() {
                return this.dyFightPower_;
            }

            public Builder setDyFightPower(int value) {
                this.bitField0_ |= 0x40;
                this.dyFightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearDyFightPower() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.dyFightPower_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDyRank() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getDyRank() {
                return this.dyRank_;
            }

            public Builder setDyRank(int value) {
                this.bitField0_ |= 0x80;
                this.dyRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearDyRank() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.dyRank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDyNotice() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public String getDyNotice() {
                Object ref = this.dyNotice_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.dyNotice_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDyNoticeBytes() {
                Object ref = this.dyNotice_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.dyNotice_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setDyNotice(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x100;
                this.dyNotice_ = value;
                onChanged();
                return this;
            }

            public Builder clearDyNotice() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.dyNotice_ = DaoYouHandler.DaoYouResponse.getDefaultInstance().getDyNotice();
                onChanged();
                return this;
            }

            public Builder setDyNoticeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x100;
                this.dyNotice_ = value;
                onChanged();
                return this;
            }

            private void ensureMessageIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.message_ = new ArrayList<>(this.message_);
                    this.bitField0_ |= 0x200;
                }
            }

            public List<DaoYouHandler.DaoYouMessage> getMessageList() {
                if (this.messageBuilder_ == null)
                    return Collections.unmodifiableList(this.message_);
                return this.messageBuilder_.getMessageList();
            }

            public int getMessageCount() {
                if (this.messageBuilder_ == null)
                    return this.message_.size();
                return this.messageBuilder_.getCount();
            }

            public DaoYouHandler.DaoYouMessage getMessage(int index) {
                if (this.messageBuilder_ == null)
                    return this.message_.get(index);
                return (DaoYouHandler.DaoYouMessage) this.messageBuilder_.getMessage(index);
            }

            public Builder setMessage(int index, DaoYouHandler.DaoYouMessage value) {
                if (this.messageBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMessageIsMutable();
                    this.message_.set(index, value);
                    onChanged();
                } else {
                    this.messageBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMessage(int index, DaoYouHandler.DaoYouMessage.Builder builderForValue) {
                if (this.messageBuilder_ == null) {
                    ensureMessageIsMutable();
                    this.message_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.messageBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMessage(DaoYouHandler.DaoYouMessage value) {
                if (this.messageBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMessageIsMutable();
                    this.message_.add(value);
                    onChanged();
                } else {
                    this.messageBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMessage(int index, DaoYouHandler.DaoYouMessage value) {
                if (this.messageBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMessageIsMutable();
                    this.message_.add(index, value);
                    onChanged();
                } else {
                    this.messageBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMessage(DaoYouHandler.DaoYouMessage.Builder builderForValue) {
                if (this.messageBuilder_ == null) {
                    ensureMessageIsMutable();
                    this.message_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.messageBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMessage(int index, DaoYouHandler.DaoYouMessage.Builder builderForValue) {
                if (this.messageBuilder_ == null) {
                    ensureMessageIsMutable();
                    this.message_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.messageBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMessage(Iterable<? extends DaoYouHandler.DaoYouMessage> values) {
                if (this.messageBuilder_ == null) {
                    ensureMessageIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.message_);
                    onChanged();
                } else {
                    this.messageBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMessage() {
                if (this.messageBuilder_ == null) {
                    this.message_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFDFF;
                    onChanged();
                } else {
                    this.messageBuilder_.clear();
                }
                return this;
            }

            public Builder removeMessage(int index) {
                if (this.messageBuilder_ == null) {
                    ensureMessageIsMutable();
                    this.message_.remove(index);
                    onChanged();
                } else {
                    this.messageBuilder_.remove(index);
                }
                return this;
            }

            public DaoYouHandler.DaoYouMessage.Builder getMessageBuilder(int index) {
                return (DaoYouHandler.DaoYouMessage.Builder) getMessageFieldBuilder().getBuilder(index);
            }

            public DaoYouHandler.DaoYouMessageOrBuilder getMessageOrBuilder(int index) {
                if (this.messageBuilder_ == null)
                    return this.message_.get(index);
                return (DaoYouHandler.DaoYouMessageOrBuilder) this.messageBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends DaoYouHandler.DaoYouMessageOrBuilder> getMessageOrBuilderList() {
                if (this.messageBuilder_ != null)
                    return this.messageBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.message_);
            }

            public DaoYouHandler.DaoYouMessage.Builder addMessageBuilder() {
                return (DaoYouHandler.DaoYouMessage.Builder) getMessageFieldBuilder().addBuilder(DaoYouHandler.DaoYouMessage.getDefaultInstance());
            }

            public DaoYouHandler.DaoYouMessage.Builder addMessageBuilder(int index) {
                return (DaoYouHandler.DaoYouMessage.Builder) getMessageFieldBuilder().addBuilder(index, DaoYouHandler.DaoYouMessage.getDefaultInstance());
            }

            public List<DaoYouHandler.DaoYouMessage.Builder> getMessageBuilderList() {
                return getMessageFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DaoYouHandler.DaoYouMessage, DaoYouHandler.DaoYouMessage.Builder, DaoYouHandler.DaoYouMessageOrBuilder> getMessageFieldBuilder() {
                if (this.messageBuilder_ == null) {
                    this.messageBuilder_ = new RepeatedFieldBuilder(this.message_, ((this.bitField0_ & 0x200) == 512), getParentForChildren(), isClean());
                    this.message_ = null;
                }
                return this.messageBuilder_;
            }

            private void ensureDyInfoIsMutable() {
                if ((this.bitField0_ & 0x400) != 1024) {
                    this.dyInfo_ = new ArrayList<>(this.dyInfo_);
                    this.bitField0_ |= 0x400;
                }
            }

            public List<DaoYouHandler.DaoYouInfo> getDyInfoList() {
                if (this.dyInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.dyInfo_);
                return this.dyInfoBuilder_.getMessageList();
            }

            public int getDyInfoCount() {
                if (this.dyInfoBuilder_ == null)
                    return this.dyInfo_.size();
                return this.dyInfoBuilder_.getCount();
            }

            public DaoYouHandler.DaoYouInfo getDyInfo(int index) {
                if (this.dyInfoBuilder_ == null)
                    return this.dyInfo_.get(index);
                return (DaoYouHandler.DaoYouInfo) this.dyInfoBuilder_.getMessage(index);
            }

            public Builder setDyInfo(int index, DaoYouHandler.DaoYouInfo value) {
                if (this.dyInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDyInfoIsMutable();
                    this.dyInfo_.set(index, value);
                    onChanged();
                } else {
                    this.dyInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setDyInfo(int index, DaoYouHandler.DaoYouInfo.Builder builderForValue) {
                if (this.dyInfoBuilder_ == null) {
                    ensureDyInfoIsMutable();
                    this.dyInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dyInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDyInfo(DaoYouHandler.DaoYouInfo value) {
                if (this.dyInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDyInfoIsMutable();
                    this.dyInfo_.add(value);
                    onChanged();
                } else {
                    this.dyInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addDyInfo(int index, DaoYouHandler.DaoYouInfo value) {
                if (this.dyInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDyInfoIsMutable();
                    this.dyInfo_.add(index, value);
                    onChanged();
                } else {
                    this.dyInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addDyInfo(DaoYouHandler.DaoYouInfo.Builder builderForValue) {
                if (this.dyInfoBuilder_ == null) {
                    ensureDyInfoIsMutable();
                    this.dyInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dyInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDyInfo(int index, DaoYouHandler.DaoYouInfo.Builder builderForValue) {
                if (this.dyInfoBuilder_ == null) {
                    ensureDyInfoIsMutable();
                    this.dyInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dyInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDyInfo(Iterable<? extends DaoYouHandler.DaoYouInfo> values) {
                if (this.dyInfoBuilder_ == null) {
                    ensureDyInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.dyInfo_);
                    onChanged();
                } else {
                    this.dyInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDyInfo() {
                if (this.dyInfoBuilder_ == null) {
                    this.dyInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFBFF;
                    onChanged();
                } else {
                    this.dyInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeDyInfo(int index) {
                if (this.dyInfoBuilder_ == null) {
                    ensureDyInfoIsMutable();
                    this.dyInfo_.remove(index);
                    onChanged();
                } else {
                    this.dyInfoBuilder_.remove(index);
                }
                return this;
            }

            public DaoYouHandler.DaoYouInfo.Builder getDyInfoBuilder(int index) {
                return (DaoYouHandler.DaoYouInfo.Builder) getDyInfoFieldBuilder().getBuilder(index);
            }

            public DaoYouHandler.DaoYouInfoOrBuilder getDyInfoOrBuilder(int index) {
                if (this.dyInfoBuilder_ == null)
                    return this.dyInfo_.get(index);
                return (DaoYouHandler.DaoYouInfoOrBuilder) this.dyInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends DaoYouHandler.DaoYouInfoOrBuilder> getDyInfoOrBuilderList() {
                if (this.dyInfoBuilder_ != null)
                    return this.dyInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.dyInfo_);
            }

            public DaoYouHandler.DaoYouInfo.Builder addDyInfoBuilder() {
                return (DaoYouHandler.DaoYouInfo.Builder) getDyInfoFieldBuilder().addBuilder(DaoYouHandler.DaoYouInfo.getDefaultInstance());
            }

            public DaoYouHandler.DaoYouInfo.Builder addDyInfoBuilder(int index) {
                return (DaoYouHandler.DaoYouInfo.Builder) getDyInfoFieldBuilder().addBuilder(index, DaoYouHandler.DaoYouInfo.getDefaultInstance());
            }

            public List<DaoYouHandler.DaoYouInfo.Builder> getDyInfoBuilderList() {
                return getDyInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DaoYouHandler.DaoYouInfo, DaoYouHandler.DaoYouInfo.Builder, DaoYouHandler.DaoYouInfoOrBuilder> getDyInfoFieldBuilder() {
                if (this.dyInfoBuilder_ == null) {
                    this.dyInfoBuilder_ = new RepeatedFieldBuilder(this.dyInfo_, ((this.bitField0_ & 0x400) == 1024), getParentForChildren(), isClean());
                    this.dyInfo_ = null;
                }
                return this.dyInfoBuilder_;
            }
        }
    }

    public static final class DaoYouInviteDaoYouRequest extends GeneratedMessage implements DaoYouInviteDaoYouRequestOrBuilder {
        private static final DaoYouInviteDaoYouRequest defaultInstance = new DaoYouInviteDaoYouRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouInviteDaoYouRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouInviteDaoYouRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouInviteDaoYouRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouInviteDaoYouRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouInviteDaoYouRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerId_ = bs;
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouInviteDaoYouRequest.class, Builder.class);
        }

        public static Parser<DaoYouInviteDaoYouRequest> PARSER = (Parser<DaoYouInviteDaoYouRequest>) new AbstractParser<DaoYouInviteDaoYouRequest>() {
            public DaoYouHandler.DaoYouInviteDaoYouRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouInviteDaoYouRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouInviteDaoYouRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerId_ = s;
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

        private void initFields() {
            this.playerId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getPlayerIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouInviteDaoYouRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(data);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(data);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(input);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouInviteDaoYouRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouInviteDaoYouRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(input);
        }

        public static DaoYouInviteDaoYouRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInviteDaoYouRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouInviteDaoYouRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouInviteDaoYouRequestOrBuilder {
            private int bitField0_;
            private Object playerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouInviteDaoYouRequest.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouInviteDaoYouRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_descriptor;
            }

            public DaoYouHandler.DaoYouInviteDaoYouRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouInviteDaoYouRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouInviteDaoYouRequest build() {
                DaoYouHandler.DaoYouInviteDaoYouRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouInviteDaoYouRequest buildPartial() {
                DaoYouHandler.DaoYouInviteDaoYouRequest result = new DaoYouHandler.DaoYouInviteDaoYouRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.playerId_ = this.playerId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouInviteDaoYouRequest)
                    return mergeFrom((DaoYouHandler.DaoYouInviteDaoYouRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouInviteDaoYouRequest other) {
                if (other == DaoYouHandler.DaoYouInviteDaoYouRequest.getDefaultInstance()) return this;
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPlayerId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouInviteDaoYouRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouInviteDaoYouRequest) DaoYouHandler.DaoYouInviteDaoYouRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouInviteDaoYouRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
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
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = DaoYouHandler.DaoYouInviteDaoYouRequest.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouInviteDaoYouResponse
            extends GeneratedMessage
            implements DaoYouInviteDaoYouResponseOrBuilder {
        private static final DaoYouInviteDaoYouResponse defaultInstance = new DaoYouInviteDaoYouResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouInviteDaoYouResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouInviteDaoYouResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouInviteDaoYouResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouInviteDaoYouResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouInviteDaoYouResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouInviteDaoYouResponse.class, Builder.class);
        }

        public static Parser<DaoYouInviteDaoYouResponse> PARSER = (Parser<DaoYouInviteDaoYouResponse>) new AbstractParser<DaoYouInviteDaoYouResponse>() {
            public DaoYouHandler.DaoYouInviteDaoYouResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouInviteDaoYouResponse(input, extensionRegistry);
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

        public Parser<DaoYouInviteDaoYouResponse> getParserForType() {
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

        public static DaoYouInviteDaoYouResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(data);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(data);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(input);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouInviteDaoYouResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouInviteDaoYouResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(input);
        }

        public static DaoYouInviteDaoYouResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouInviteDaoYouResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouInviteDaoYouResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouInviteDaoYouResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouInviteDaoYouResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouInviteDaoYouResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_descriptor;
            }

            public DaoYouHandler.DaoYouInviteDaoYouResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouInviteDaoYouResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouInviteDaoYouResponse build() {
                DaoYouHandler.DaoYouInviteDaoYouResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouInviteDaoYouResponse buildPartial() {
                DaoYouHandler.DaoYouInviteDaoYouResponse result = new DaoYouHandler.DaoYouInviteDaoYouResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouInviteDaoYouResponse)
                    return mergeFrom((DaoYouHandler.DaoYouInviteDaoYouResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouInviteDaoYouResponse other) {
                if (other == DaoYouHandler.DaoYouInviteDaoYouResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouInviteDaoYouResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouInviteDaoYouResponse) DaoYouHandler.DaoYouInviteDaoYouResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouInviteDaoYouResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouInviteDaoYouResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouFastInviteDaoYouRequest
            extends GeneratedMessage
            implements DaoYouFastInviteDaoYouRequestOrBuilder {
        private static final DaoYouFastInviteDaoYouRequest defaultInstance = new DaoYouFastInviteDaoYouRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouFastInviteDaoYouRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouFastInviteDaoYouRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouFastInviteDaoYouRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouFastInviteDaoYouRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouFastInviteDaoYouRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouFastInviteDaoYouRequest.class, Builder.class);
        }

        public static Parser<DaoYouFastInviteDaoYouRequest> PARSER = (Parser<DaoYouFastInviteDaoYouRequest>) new AbstractParser<DaoYouFastInviteDaoYouRequest>() {
            public DaoYouHandler.DaoYouFastInviteDaoYouRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouFastInviteDaoYouRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouFastInviteDaoYouRequest> getParserForType() {
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

        public static DaoYouFastInviteDaoYouRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(data);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(data);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(input);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouFastInviteDaoYouRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(input);
        }

        public static DaoYouFastInviteDaoYouRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouFastInviteDaoYouRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouFastInviteDaoYouRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouFastInviteDaoYouRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouFastInviteDaoYouRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouFastInviteDaoYouRequest.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_descriptor;
            }

            public DaoYouHandler.DaoYouFastInviteDaoYouRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouFastInviteDaoYouRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouFastInviteDaoYouRequest build() {
                DaoYouHandler.DaoYouFastInviteDaoYouRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouFastInviteDaoYouRequest buildPartial() {
                DaoYouHandler.DaoYouFastInviteDaoYouRequest result = new DaoYouHandler.DaoYouFastInviteDaoYouRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouFastInviteDaoYouRequest)
                    return mergeFrom((DaoYouHandler.DaoYouFastInviteDaoYouRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouFastInviteDaoYouRequest other) {
                if (other == DaoYouHandler.DaoYouFastInviteDaoYouRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouFastInviteDaoYouRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouFastInviteDaoYouRequest) DaoYouHandler.DaoYouFastInviteDaoYouRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouFastInviteDaoYouRequest) e.getUnfinishedMessage();
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


    public static final class DaoYouFastInviteDaoYouResponse
            extends GeneratedMessage
            implements DaoYouFastInviteDaoYouResponseOrBuilder {
        private static final DaoYouFastInviteDaoYouResponse defaultInstance = new DaoYouFastInviteDaoYouResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouFastInviteDaoYouResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouFastInviteDaoYouResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouFastInviteDaoYouResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouFastInviteDaoYouResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouFastInviteDaoYouResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouFastInviteDaoYouResponse.class, Builder.class);
        }

        public static Parser<DaoYouFastInviteDaoYouResponse> PARSER = (Parser<DaoYouFastInviteDaoYouResponse>) new AbstractParser<DaoYouFastInviteDaoYouResponse>() {
            public DaoYouHandler.DaoYouFastInviteDaoYouResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouFastInviteDaoYouResponse(input, extensionRegistry);
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

        public Parser<DaoYouFastInviteDaoYouResponse> getParserForType() {
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

        public static DaoYouFastInviteDaoYouResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(data);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(data);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(input);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouFastInviteDaoYouResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(input);
        }

        public static DaoYouFastInviteDaoYouResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouFastInviteDaoYouResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouFastInviteDaoYouResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouFastInviteDaoYouResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouFastInviteDaoYouResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouFastInviteDaoYouResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_descriptor;
            }

            public DaoYouHandler.DaoYouFastInviteDaoYouResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouFastInviteDaoYouResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouFastInviteDaoYouResponse build() {
                DaoYouHandler.DaoYouFastInviteDaoYouResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouFastInviteDaoYouResponse buildPartial() {
                DaoYouHandler.DaoYouFastInviteDaoYouResponse result = new DaoYouHandler.DaoYouFastInviteDaoYouResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouFastInviteDaoYouResponse)
                    return mergeFrom((DaoYouHandler.DaoYouFastInviteDaoYouResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouFastInviteDaoYouResponse other) {
                if (other == DaoYouHandler.DaoYouFastInviteDaoYouResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouFastInviteDaoYouResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouFastInviteDaoYouResponse) DaoYouHandler.DaoYouFastInviteDaoYouResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouFastInviteDaoYouResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouFastInviteDaoYouResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouEditTeamNameRequest
            extends GeneratedMessage
            implements DaoYouEditTeamNameRequestOrBuilder {
        private static final DaoYouEditTeamNameRequest defaultInstance = new DaoYouEditTeamNameRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouEditTeamNameRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouEditTeamNameRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouEditTeamNameRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouEditTeamNameRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouEditTeamNameRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.teamName_ = bs;
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouEditTeamNameRequest.class, Builder.class);
        }

        public static Parser<DaoYouEditTeamNameRequest> PARSER = (Parser<DaoYouEditTeamNameRequest>) new AbstractParser<DaoYouEditTeamNameRequest>() {
            public DaoYouHandler.DaoYouEditTeamNameRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouEditTeamNameRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TEAMNAME_FIELD_NUMBER = 1;
        private Object teamName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouEditTeamNameRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasTeamName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getTeamName() {
            Object ref = this.teamName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.teamName_ = s;
            return s;
        }

        public ByteString getTeamNameBytes() {
            Object ref = this.teamName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.teamName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.teamName_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasTeamName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getTeamNameBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getTeamNameBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouEditTeamNameRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(data);
        }

        public static DaoYouEditTeamNameRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouEditTeamNameRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(data);
        }

        public static DaoYouEditTeamNameRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouEditTeamNameRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(input);
        }

        public static DaoYouEditTeamNameRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouEditTeamNameRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouEditTeamNameRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouEditTeamNameRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouEditTeamNameRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouEditTeamNameRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(input);
        }

        public static DaoYouEditTeamNameRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouEditTeamNameRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouEditTeamNameRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouEditTeamNameRequestOrBuilder {
            private int bitField0_;
            private Object teamName_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouEditTeamNameRequest.class, Builder.class);
            }

            private Builder() {
                this.teamName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.teamName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouEditTeamNameRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.teamName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_descriptor;
            }

            public DaoYouHandler.DaoYouEditTeamNameRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouEditTeamNameRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouEditTeamNameRequest build() {
                DaoYouHandler.DaoYouEditTeamNameRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouEditTeamNameRequest buildPartial() {
                DaoYouHandler.DaoYouEditTeamNameRequest result = new DaoYouHandler.DaoYouEditTeamNameRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.teamName_ = this.teamName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouEditTeamNameRequest)
                    return mergeFrom((DaoYouHandler.DaoYouEditTeamNameRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouEditTeamNameRequest other) {
                if (other == DaoYouHandler.DaoYouEditTeamNameRequest.getDefaultInstance()) return this;
                if (other.hasTeamName()) {
                    this.bitField0_ |= 0x1;
                    this.teamName_ = other.teamName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTeamName()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouEditTeamNameRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouEditTeamNameRequest) DaoYouHandler.DaoYouEditTeamNameRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouEditTeamNameRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTeamName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getTeamName() {
                Object ref = this.teamName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.teamName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTeamNameBytes() {
                Object ref = this.teamName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.teamName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTeamName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.teamName_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.teamName_ = DaoYouHandler.DaoYouEditTeamNameRequest.getDefaultInstance().getTeamName();
                onChanged();
                return this;
            }

            public Builder setTeamNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.teamName_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouEditTeamNameResponse
            extends GeneratedMessage
            implements DaoYouEditTeamNameResponseOrBuilder {
        private static final DaoYouEditTeamNameResponse defaultInstance = new DaoYouEditTeamNameResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouEditTeamNameResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouEditTeamNameResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouEditTeamNameResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouEditTeamNameResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouEditTeamNameResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouEditTeamNameResponse.class, Builder.class);
        }

        public static Parser<DaoYouEditTeamNameResponse> PARSER = (Parser<DaoYouEditTeamNameResponse>) new AbstractParser<DaoYouEditTeamNameResponse>() {
            public DaoYouHandler.DaoYouEditTeamNameResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouEditTeamNameResponse(input, extensionRegistry);
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

        public Parser<DaoYouEditTeamNameResponse> getParserForType() {
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

        public static DaoYouEditTeamNameResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(data);
        }

        public static DaoYouEditTeamNameResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouEditTeamNameResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(data);
        }

        public static DaoYouEditTeamNameResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouEditTeamNameResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(input);
        }

        public static DaoYouEditTeamNameResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouEditTeamNameResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouEditTeamNameResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouEditTeamNameResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouEditTeamNameResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouEditTeamNameResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(input);
        }

        public static DaoYouEditTeamNameResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouEditTeamNameResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouEditTeamNameResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouEditTeamNameResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouEditTeamNameResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouEditTeamNameResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_descriptor;
            }

            public DaoYouHandler.DaoYouEditTeamNameResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouEditTeamNameResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouEditTeamNameResponse build() {
                DaoYouHandler.DaoYouEditTeamNameResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouEditTeamNameResponse buildPartial() {
                DaoYouHandler.DaoYouEditTeamNameResponse result = new DaoYouHandler.DaoYouEditTeamNameResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouEditTeamNameResponse)
                    return mergeFrom((DaoYouHandler.DaoYouEditTeamNameResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouEditTeamNameResponse other) {
                if (other == DaoYouHandler.DaoYouEditTeamNameResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouEditTeamNameResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouEditTeamNameResponse) DaoYouHandler.DaoYouEditTeamNameResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouEditTeamNameResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouEditTeamNameResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouLeaveMessageRequest
            extends GeneratedMessage
            implements DaoYouLeaveMessageRequestOrBuilder {
        private static final DaoYouLeaveMessageRequest defaultInstance = new DaoYouLeaveMessageRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouLeaveMessageRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouLeaveMessageRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouLeaveMessageRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouLeaveMessageRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouLeaveMessageRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.message_ = bs;
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouLeaveMessageRequest.class, Builder.class);
        }

        public static Parser<DaoYouLeaveMessageRequest> PARSER = (Parser<DaoYouLeaveMessageRequest>) new AbstractParser<DaoYouLeaveMessageRequest>() {
            public DaoYouHandler.DaoYouLeaveMessageRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouLeaveMessageRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int MESSAGE_FIELD_NUMBER = 1;
        private Object message_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouLeaveMessageRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasMessage() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getMessage() {
            Object ref = this.message_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.message_ = s;
            return s;
        }

        public ByteString getMessageBytes() {
            Object ref = this.message_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.message_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.message_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasMessage()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getMessageBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getMessageBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouLeaveMessageRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(data);
        }

        public static DaoYouLeaveMessageRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouLeaveMessageRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(data);
        }

        public static DaoYouLeaveMessageRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouLeaveMessageRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(input);
        }

        public static DaoYouLeaveMessageRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouLeaveMessageRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouLeaveMessageRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouLeaveMessageRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouLeaveMessageRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouLeaveMessageRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(input);
        }

        public static DaoYouLeaveMessageRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouLeaveMessageRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouLeaveMessageRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouLeaveMessageRequestOrBuilder {
            private int bitField0_;
            private Object message_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouLeaveMessageRequest.class, Builder.class);
            }

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouLeaveMessageRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.message_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_descriptor;
            }

            public DaoYouHandler.DaoYouLeaveMessageRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouLeaveMessageRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouLeaveMessageRequest build() {
                DaoYouHandler.DaoYouLeaveMessageRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouLeaveMessageRequest buildPartial() {
                DaoYouHandler.DaoYouLeaveMessageRequest result = new DaoYouHandler.DaoYouLeaveMessageRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.message_ = this.message_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouLeaveMessageRequest)
                    return mergeFrom((DaoYouHandler.DaoYouLeaveMessageRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouLeaveMessageRequest other) {
                if (other == DaoYouHandler.DaoYouLeaveMessageRequest.getDefaultInstance()) return this;
                if (other.hasMessage()) {
                    this.bitField0_ |= 0x1;
                    this.message_ = other.message_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasMessage()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouLeaveMessageRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouLeaveMessageRequest) DaoYouHandler.DaoYouLeaveMessageRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouLeaveMessageRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasMessage() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getMessage() {
                Object ref = this.message_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.message_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMessageBytes() {
                Object ref = this.message_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.message_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMessage(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.message_ = value;
                onChanged();
                return this;
            }

            public Builder clearMessage() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.message_ = DaoYouHandler.DaoYouLeaveMessageRequest.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public Builder setMessageBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.message_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouLeaveMessageResponse
            extends GeneratedMessage
            implements DaoYouLeaveMessageResponseOrBuilder {
        private static final DaoYouLeaveMessageResponse defaultInstance = new DaoYouLeaveMessageResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouLeaveMessageResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouLeaveMessageResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouLeaveMessageResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouLeaveMessageResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouLeaveMessageResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouLeaveMessageResponse.class, Builder.class);
        }

        public static Parser<DaoYouLeaveMessageResponse> PARSER = (Parser<DaoYouLeaveMessageResponse>) new AbstractParser<DaoYouLeaveMessageResponse>() {
            public DaoYouHandler.DaoYouLeaveMessageResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouLeaveMessageResponse(input, extensionRegistry);
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

        public Parser<DaoYouLeaveMessageResponse> getParserForType() {
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

        public static DaoYouLeaveMessageResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(data);
        }

        public static DaoYouLeaveMessageResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouLeaveMessageResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(data);
        }

        public static DaoYouLeaveMessageResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouLeaveMessageResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(input);
        }

        public static DaoYouLeaveMessageResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouLeaveMessageResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouLeaveMessageResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouLeaveMessageResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouLeaveMessageResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouLeaveMessageResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(input);
        }

        public static DaoYouLeaveMessageResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouLeaveMessageResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouLeaveMessageResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouLeaveMessageResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouLeaveMessageResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouLeaveMessageResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_descriptor;
            }

            public DaoYouHandler.DaoYouLeaveMessageResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouLeaveMessageResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouLeaveMessageResponse build() {
                DaoYouHandler.DaoYouLeaveMessageResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouLeaveMessageResponse buildPartial() {
                DaoYouHandler.DaoYouLeaveMessageResponse result = new DaoYouHandler.DaoYouLeaveMessageResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouLeaveMessageResponse)
                    return mergeFrom((DaoYouHandler.DaoYouLeaveMessageResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouLeaveMessageResponse other) {
                if (other == DaoYouHandler.DaoYouLeaveMessageResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouLeaveMessageResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouLeaveMessageResponse) DaoYouHandler.DaoYouLeaveMessageResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouLeaveMessageResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouLeaveMessageResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouNoticeRequest
            extends GeneratedMessage
            implements DaoYouNoticeRequestOrBuilder {
        private static final DaoYouNoticeRequest defaultInstance = new DaoYouNoticeRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouNoticeRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouNoticeRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouNoticeRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouNoticeRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouNoticeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.notice_ = bs;
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouNoticeRequest.class, Builder.class);
        }

        public static Parser<DaoYouNoticeRequest> PARSER = (Parser<DaoYouNoticeRequest>) new AbstractParser<DaoYouNoticeRequest>() {
            public DaoYouHandler.DaoYouNoticeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouNoticeRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int NOTICE_FIELD_NUMBER = 1;
        private Object notice_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouNoticeRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasNotice() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getNotice() {
            Object ref = this.notice_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.notice_ = s;
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

        private void initFields() {
            this.notice_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasNotice()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getNoticeBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getNoticeBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouNoticeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(data);
        }

        public static DaoYouNoticeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouNoticeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(data);
        }

        public static DaoYouNoticeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouNoticeRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(input);
        }

        public static DaoYouNoticeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouNoticeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouNoticeRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouNoticeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouNoticeRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouNoticeRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(input);
        }

        public static DaoYouNoticeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouNoticeRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouNoticeRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouNoticeRequestOrBuilder {
            private int bitField0_;
            private Object notice_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouNoticeRequest.class, Builder.class);
            }

            private Builder() {
                this.notice_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.notice_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouNoticeRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.notice_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeRequest_descriptor;
            }

            public DaoYouHandler.DaoYouNoticeRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouNoticeRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouNoticeRequest build() {
                DaoYouHandler.DaoYouNoticeRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouNoticeRequest buildPartial() {
                DaoYouHandler.DaoYouNoticeRequest result = new DaoYouHandler.DaoYouNoticeRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.notice_ = this.notice_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouNoticeRequest)
                    return mergeFrom((DaoYouHandler.DaoYouNoticeRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouNoticeRequest other) {
                if (other == DaoYouHandler.DaoYouNoticeRequest.getDefaultInstance()) return this;
                if (other.hasNotice()) {
                    this.bitField0_ |= 0x1;
                    this.notice_ = other.notice_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasNotice()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouNoticeRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouNoticeRequest) DaoYouHandler.DaoYouNoticeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouNoticeRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasNotice() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getNotice() {
                Object ref = this.notice_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.notice_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.notice_ = value;
                onChanged();
                return this;
            }

            public Builder clearNotice() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.notice_ = DaoYouHandler.DaoYouNoticeRequest.getDefaultInstance().getNotice();
                onChanged();
                return this;
            }

            public Builder setNoticeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.notice_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouNoticeResponse
            extends GeneratedMessage
            implements DaoYouNoticeResponseOrBuilder {
        private static final DaoYouNoticeResponse defaultInstance = new DaoYouNoticeResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouNoticeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouNoticeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouNoticeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouNoticeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouNoticeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouNoticeResponse.class, Builder.class);
        }

        public static Parser<DaoYouNoticeResponse> PARSER = (Parser<DaoYouNoticeResponse>) new AbstractParser<DaoYouNoticeResponse>() {
            public DaoYouHandler.DaoYouNoticeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouNoticeResponse(input, extensionRegistry);
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

        public Parser<DaoYouNoticeResponse> getParserForType() {
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

        public static DaoYouNoticeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(data);
        }

        public static DaoYouNoticeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouNoticeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(data);
        }

        public static DaoYouNoticeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouNoticeResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(input);
        }

        public static DaoYouNoticeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouNoticeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouNoticeResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouNoticeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouNoticeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouNoticeResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(input);
        }

        public static DaoYouNoticeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouNoticeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouNoticeResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouNoticeResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouNoticeResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouNoticeResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouNoticeResponse_descriptor;
            }

            public DaoYouHandler.DaoYouNoticeResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouNoticeResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouNoticeResponse build() {
                DaoYouHandler.DaoYouNoticeResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouNoticeResponse buildPartial() {
                DaoYouHandler.DaoYouNoticeResponse result = new DaoYouHandler.DaoYouNoticeResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouNoticeResponse)
                    return mergeFrom((DaoYouHandler.DaoYouNoticeResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouNoticeResponse other) {
                if (other == DaoYouHandler.DaoYouNoticeResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouNoticeResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouNoticeResponse) DaoYouHandler.DaoYouNoticeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouNoticeResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouNoticeResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouKickTeamRequest
            extends GeneratedMessage
            implements DaoYouKickTeamRequestOrBuilder {
        private static final DaoYouKickTeamRequest defaultInstance = new DaoYouKickTeamRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouKickTeamRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouKickTeamRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouKickTeamRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouKickTeamRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouKickTeamRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerId_ = bs;
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouKickTeamRequest.class, Builder.class);
        }

        public static Parser<DaoYouKickTeamRequest> PARSER = (Parser<DaoYouKickTeamRequest>) new AbstractParser<DaoYouKickTeamRequest>() {
            public DaoYouHandler.DaoYouKickTeamRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouKickTeamRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouKickTeamRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerId_ = s;
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

        private void initFields() {
            this.playerId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getPlayerIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouKickTeamRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(data);
        }

        public static DaoYouKickTeamRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouKickTeamRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(data);
        }

        public static DaoYouKickTeamRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouKickTeamRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(input);
        }

        public static DaoYouKickTeamRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouKickTeamRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouKickTeamRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouKickTeamRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouKickTeamRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouKickTeamRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(input);
        }

        public static DaoYouKickTeamRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouKickTeamRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouKickTeamRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouKickTeamRequestOrBuilder {
            private int bitField0_;
            private Object playerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouKickTeamRequest.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouKickTeamRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamRequest_descriptor;
            }

            public DaoYouHandler.DaoYouKickTeamRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouKickTeamRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouKickTeamRequest build() {
                DaoYouHandler.DaoYouKickTeamRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouKickTeamRequest buildPartial() {
                DaoYouHandler.DaoYouKickTeamRequest result = new DaoYouHandler.DaoYouKickTeamRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.playerId_ = this.playerId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouKickTeamRequest)
                    return mergeFrom((DaoYouHandler.DaoYouKickTeamRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouKickTeamRequest other) {
                if (other == DaoYouHandler.DaoYouKickTeamRequest.getDefaultInstance()) return this;
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPlayerId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouKickTeamRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouKickTeamRequest) DaoYouHandler.DaoYouKickTeamRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouKickTeamRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
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
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = DaoYouHandler.DaoYouKickTeamRequest.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouKickTeamResponse
            extends GeneratedMessage
            implements DaoYouKickTeamResponseOrBuilder {
        private static final DaoYouKickTeamResponse defaultInstance = new DaoYouKickTeamResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouKickTeamResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouKickTeamResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouKickTeamResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouKickTeamResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouKickTeamResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouKickTeamResponse.class, Builder.class);
        }

        public static Parser<DaoYouKickTeamResponse> PARSER = (Parser<DaoYouKickTeamResponse>) new AbstractParser<DaoYouKickTeamResponse>() {
            public DaoYouHandler.DaoYouKickTeamResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouKickTeamResponse(input, extensionRegistry);
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

        public Parser<DaoYouKickTeamResponse> getParserForType() {
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

        public static DaoYouKickTeamResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(data);
        }

        public static DaoYouKickTeamResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouKickTeamResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(data);
        }

        public static DaoYouKickTeamResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouKickTeamResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(input);
        }

        public static DaoYouKickTeamResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouKickTeamResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouKickTeamResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouKickTeamResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouKickTeamResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouKickTeamResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(input);
        }

        public static DaoYouKickTeamResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouKickTeamResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouKickTeamResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouKickTeamResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouKickTeamResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouKickTeamResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouKickTeamResponse_descriptor;
            }

            public DaoYouHandler.DaoYouKickTeamResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouKickTeamResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouKickTeamResponse build() {
                DaoYouHandler.DaoYouKickTeamResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouKickTeamResponse buildPartial() {
                DaoYouHandler.DaoYouKickTeamResponse result = new DaoYouHandler.DaoYouKickTeamResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouKickTeamResponse)
                    return mergeFrom((DaoYouHandler.DaoYouKickTeamResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouKickTeamResponse other) {
                if (other == DaoYouHandler.DaoYouKickTeamResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouKickTeamResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouKickTeamResponse) DaoYouHandler.DaoYouKickTeamResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouKickTeamResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouKickTeamResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouTransferAdminRequest
            extends GeneratedMessage
            implements DaoYouTransferAdminRequestOrBuilder {
        private static final DaoYouTransferAdminRequest defaultInstance = new DaoYouTransferAdminRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouTransferAdminRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouTransferAdminRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouTransferAdminRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouTransferAdminRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouTransferAdminRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerId_ = bs;
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouTransferAdminRequest.class, Builder.class);
        }

        public static Parser<DaoYouTransferAdminRequest> PARSER = (Parser<DaoYouTransferAdminRequest>) new AbstractParser<DaoYouTransferAdminRequest>() {
            public DaoYouHandler.DaoYouTransferAdminRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouTransferAdminRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouTransferAdminRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerId_ = s;
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

        private void initFields() {
            this.playerId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getPlayerIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouTransferAdminRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(data);
        }

        public static DaoYouTransferAdminRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouTransferAdminRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(data);
        }

        public static DaoYouTransferAdminRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouTransferAdminRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(input);
        }

        public static DaoYouTransferAdminRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouTransferAdminRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouTransferAdminRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouTransferAdminRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouTransferAdminRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouTransferAdminRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(input);
        }

        public static DaoYouTransferAdminRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouTransferAdminRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouTransferAdminRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouTransferAdminRequestOrBuilder {
            private int bitField0_;
            private Object playerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouTransferAdminRequest.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouTransferAdminRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_descriptor;
            }

            public DaoYouHandler.DaoYouTransferAdminRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouTransferAdminRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouTransferAdminRequest build() {
                DaoYouHandler.DaoYouTransferAdminRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouTransferAdminRequest buildPartial() {
                DaoYouHandler.DaoYouTransferAdminRequest result = new DaoYouHandler.DaoYouTransferAdminRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.playerId_ = this.playerId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouTransferAdminRequest)
                    return mergeFrom((DaoYouHandler.DaoYouTransferAdminRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouTransferAdminRequest other) {
                if (other == DaoYouHandler.DaoYouTransferAdminRequest.getDefaultInstance()) return this;
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPlayerId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouTransferAdminRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouTransferAdminRequest) DaoYouHandler.DaoYouTransferAdminRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouTransferAdminRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
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
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = DaoYouHandler.DaoYouTransferAdminRequest.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouTransferAdminResponse
            extends GeneratedMessage
            implements DaoYouTransferAdminResponseOrBuilder {
        private static final DaoYouTransferAdminResponse defaultInstance = new DaoYouTransferAdminResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouTransferAdminResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouTransferAdminResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouTransferAdminResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouTransferAdminResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouTransferAdminResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouTransferAdminResponse.class, Builder.class);
        }

        public static Parser<DaoYouTransferAdminResponse> PARSER = (Parser<DaoYouTransferAdminResponse>) new AbstractParser<DaoYouTransferAdminResponse>() {
            public DaoYouHandler.DaoYouTransferAdminResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouTransferAdminResponse(input, extensionRegistry);
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

        public Parser<DaoYouTransferAdminResponse> getParserForType() {
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

        public static DaoYouTransferAdminResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(data);
        }

        public static DaoYouTransferAdminResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouTransferAdminResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(data);
        }

        public static DaoYouTransferAdminResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouTransferAdminResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(input);
        }

        public static DaoYouTransferAdminResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouTransferAdminResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouTransferAdminResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouTransferAdminResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouTransferAdminResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouTransferAdminResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(input);
        }

        public static DaoYouTransferAdminResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouTransferAdminResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouTransferAdminResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouTransferAdminResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouTransferAdminResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouTransferAdminResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_descriptor;
            }

            public DaoYouHandler.DaoYouTransferAdminResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouTransferAdminResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouTransferAdminResponse build() {
                DaoYouHandler.DaoYouTransferAdminResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouTransferAdminResponse buildPartial() {
                DaoYouHandler.DaoYouTransferAdminResponse result = new DaoYouHandler.DaoYouTransferAdminResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouTransferAdminResponse)
                    return mergeFrom((DaoYouHandler.DaoYouTransferAdminResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouTransferAdminResponse other) {
                if (other == DaoYouHandler.DaoYouTransferAdminResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouTransferAdminResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouTransferAdminResponse) DaoYouHandler.DaoYouTransferAdminResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouTransferAdminResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouTransferAdminResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouQuitTeamRequest
            extends GeneratedMessage
            implements DaoYouQuitTeamRequestOrBuilder {
        private static final DaoYouQuitTeamRequest defaultInstance = new DaoYouQuitTeamRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouQuitTeamRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouQuitTeamRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouQuitTeamRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouQuitTeamRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouQuitTeamRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouQuitTeamRequest.class, Builder.class);
        }

        public static Parser<DaoYouQuitTeamRequest> PARSER = (Parser<DaoYouQuitTeamRequest>) new AbstractParser<DaoYouQuitTeamRequest>() {
            public DaoYouHandler.DaoYouQuitTeamRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouQuitTeamRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouQuitTeamRequest> getParserForType() {
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

        public static DaoYouQuitTeamRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(data);
        }

        public static DaoYouQuitTeamRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouQuitTeamRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(data);
        }

        public static DaoYouQuitTeamRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouQuitTeamRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(input);
        }

        public static DaoYouQuitTeamRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouQuitTeamRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouQuitTeamRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouQuitTeamRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouQuitTeamRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouQuitTeamRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(input);
        }

        public static DaoYouQuitTeamRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouQuitTeamRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouQuitTeamRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouQuitTeamRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouQuitTeamRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouQuitTeamRequest.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_descriptor;
            }

            public DaoYouHandler.DaoYouQuitTeamRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouQuitTeamRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouQuitTeamRequest build() {
                DaoYouHandler.DaoYouQuitTeamRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouQuitTeamRequest buildPartial() {
                DaoYouHandler.DaoYouQuitTeamRequest result = new DaoYouHandler.DaoYouQuitTeamRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouQuitTeamRequest)
                    return mergeFrom((DaoYouHandler.DaoYouQuitTeamRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouQuitTeamRequest other) {
                if (other == DaoYouHandler.DaoYouQuitTeamRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouQuitTeamRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouQuitTeamRequest) DaoYouHandler.DaoYouQuitTeamRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouQuitTeamRequest) e.getUnfinishedMessage();
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


    public static final class DaoYouQuitTeamResponse
            extends GeneratedMessage
            implements DaoYouQuitTeamResponseOrBuilder {
        private static final DaoYouQuitTeamResponse defaultInstance = new DaoYouQuitTeamResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouQuitTeamResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouQuitTeamResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouQuitTeamResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouQuitTeamResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouQuitTeamResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouQuitTeamResponse.class, Builder.class);
        }

        public static Parser<DaoYouQuitTeamResponse> PARSER = (Parser<DaoYouQuitTeamResponse>) new AbstractParser<DaoYouQuitTeamResponse>() {
            public DaoYouHandler.DaoYouQuitTeamResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouQuitTeamResponse(input, extensionRegistry);
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

        public Parser<DaoYouQuitTeamResponse> getParserForType() {
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

        public static DaoYouQuitTeamResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(data);
        }

        public static DaoYouQuitTeamResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouQuitTeamResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(data);
        }

        public static DaoYouQuitTeamResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouQuitTeamResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(input);
        }

        public static DaoYouQuitTeamResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouQuitTeamResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouQuitTeamResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouQuitTeamResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouQuitTeamResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouQuitTeamResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(input);
        }

        public static DaoYouQuitTeamResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouQuitTeamResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouQuitTeamResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouQuitTeamResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouQuitTeamResponse.class, Builder.class);
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
                if (DaoYouHandler.DaoYouQuitTeamResponse.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_descriptor;
            }

            public DaoYouHandler.DaoYouQuitTeamResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouQuitTeamResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouQuitTeamResponse build() {
                DaoYouHandler.DaoYouQuitTeamResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouQuitTeamResponse buildPartial() {
                DaoYouHandler.DaoYouQuitTeamResponse result = new DaoYouHandler.DaoYouQuitTeamResponse(this);
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
                if (other instanceof DaoYouHandler.DaoYouQuitTeamResponse)
                    return mergeFrom((DaoYouHandler.DaoYouQuitTeamResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouQuitTeamResponse other) {
                if (other == DaoYouHandler.DaoYouQuitTeamResponse.getDefaultInstance()) return this;
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
                DaoYouHandler.DaoYouQuitTeamResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouQuitTeamResponse) DaoYouHandler.DaoYouQuitTeamResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouQuitTeamResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouQuitTeamResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DaoYouRebateRequest
            extends GeneratedMessage
            implements DaoYouRebateRequestOrBuilder {
        private static final DaoYouRebateRequest defaultInstance = new DaoYouRebateRequest(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouRebateRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouRebateRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouRebateRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouRebateRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouRebateRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouRebateRequest.class, Builder.class);
        }

        public static Parser<DaoYouRebateRequest> PARSER = (Parser<DaoYouRebateRequest>) new AbstractParser<DaoYouRebateRequest>() {
            public DaoYouHandler.DaoYouRebateRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouRebateRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouRebateRequest> getParserForType() {
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

        public static DaoYouRebateRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouRebateRequest) PARSER.parseFrom(data);
        }

        public static DaoYouRebateRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRebateRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouRebateRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouRebateRequest) PARSER.parseFrom(data);
        }

        public static DaoYouRebateRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRebateRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouRebateRequest parseFrom(InputStream input) throws IOException {
            return (DaoYouRebateRequest) PARSER.parseFrom(input);
        }

        public static DaoYouRebateRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouRebateRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouRebateRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouRebateRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouRebateRequest parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouRebateRequest) PARSER.parseFrom(input);
        }

        public static DaoYouRebateRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouRebateRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouRebateRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouRebateRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouRebateRequest.alwaysUseFieldBuilders) ;
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
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateRequest_descriptor;
            }

            public DaoYouHandler.DaoYouRebateRequest getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouRebateRequest.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouRebateRequest build() {
                DaoYouHandler.DaoYouRebateRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouRebateRequest buildPartial() {
                DaoYouHandler.DaoYouRebateRequest result = new DaoYouHandler.DaoYouRebateRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouRebateRequest)
                    return mergeFrom((DaoYouHandler.DaoYouRebateRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouRebateRequest other) {
                if (other == DaoYouHandler.DaoYouRebateRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouRebateRequest parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouRebateRequest) DaoYouHandler.DaoYouRebateRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouRebateRequest) e.getUnfinishedMessage();
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


    public static final class DaoYouMemRebaeReciveInfo
            extends GeneratedMessage
            implements DaoYouMemRebaeReciveInfoOrBuilder {
        private static final DaoYouMemRebaeReciveInfo defaultInstance = new DaoYouMemRebaeReciveInfo(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouMemRebaeReciveInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouMemRebaeReciveInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouMemRebaeReciveInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouMemRebaeReciveInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouMemRebaeReciveInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerName_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.reciveNumber_ = input.readInt32();
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
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouMemRebaeReciveInfo.class, Builder.class);
        }

        public static Parser<DaoYouMemRebaeReciveInfo> PARSER = (Parser<DaoYouMemRebaeReciveInfo>) new AbstractParser<DaoYouMemRebaeReciveInfo>() {
            public DaoYouHandler.DaoYouMemRebaeReciveInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouMemRebaeReciveInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERNAME_FIELD_NUMBER = 1;
        private Object playerName_;
        public static final int RECIVENUMBER_FIELD_NUMBER = 2;
        private int reciveNumber_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouMemRebaeReciveInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerName() {
            Object ref = this.playerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerName_ = s;
            return s;
        }

        public ByteString getPlayerNameBytes() {
            Object ref = this.playerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasReciveNumber() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getReciveNumber() {
            return this.reciveNumber_;
        }

        private void initFields() {
            this.playerName_ = "";
            this.reciveNumber_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getPlayerNameBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.reciveNumber_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getPlayerNameBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.reciveNumber_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(data);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(data);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(InputStream input) throws IOException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(input);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouMemRebaeReciveInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouMemRebaeReciveInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(input);
        }

        public static DaoYouMemRebaeReciveInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouMemRebaeReciveInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouMemRebaeReciveInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder {
            private int bitField0_;
            private Object playerName_;
            private int reciveNumber_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouMemRebaeReciveInfo.class, Builder.class);
            }

            private Builder() {
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouMemRebaeReciveInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.reciveNumber_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_descriptor;
            }

            public DaoYouHandler.DaoYouMemRebaeReciveInfo getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouMemRebaeReciveInfo.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouMemRebaeReciveInfo build() {
                DaoYouHandler.DaoYouMemRebaeReciveInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouMemRebaeReciveInfo buildPartial() {
                DaoYouHandler.DaoYouMemRebaeReciveInfo result = new DaoYouHandler.DaoYouMemRebaeReciveInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.playerName_ = this.playerName_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.reciveNumber_ = this.reciveNumber_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouMemRebaeReciveInfo)
                    return mergeFrom((DaoYouHandler.DaoYouMemRebaeReciveInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouMemRebaeReciveInfo other) {
                if (other == DaoYouHandler.DaoYouMemRebaeReciveInfo.getDefaultInstance()) return this;
                if (other.hasPlayerName()) {
                    this.bitField0_ |= 0x1;
                    this.playerName_ = other.playerName_;
                    onChanged();
                }
                if (other.hasReciveNumber()) setReciveNumber(other.getReciveNumber());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouMemRebaeReciveInfo parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouMemRebaeReciveInfo) DaoYouHandler.DaoYouMemRebaeReciveInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouMemRebaeReciveInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getPlayerName() {
                Object ref = this.playerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.playerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPlayerNameBytes() {
                Object ref = this.playerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.playerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPlayerName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerName_ = DaoYouHandler.DaoYouMemRebaeReciveInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasReciveNumber() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getReciveNumber() {
                return this.reciveNumber_;
            }

            public Builder setReciveNumber(int value) {
                this.bitField0_ |= 0x2;
                this.reciveNumber_ = value;
                onChanged();
                return this;
            }

            public Builder clearReciveNumber() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.reciveNumber_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DaoYouRebateInfo
            extends GeneratedMessage
            implements DaoYouRebateInfoOrBuilder {
        private static final DaoYouRebateInfo defaultInstance = new DaoYouRebateInfo(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouRebateInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouRebateInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouRebateInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouRebateInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouRebateInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerName_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.totalSendRebate_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.todaySendRebate_ = input.readInt32();
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.memRebaeReciveInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.memRebaeReciveInfo_.add(input.readMessage(DaoYouHandler.DaoYouMemRebaeReciveInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.memRebaeReciveInfo_ = Collections.unmodifiableList(this.memRebaeReciveInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouRebateInfo.class, Builder.class);
        }

        public static Parser<DaoYouRebateInfo> PARSER = (Parser<DaoYouRebateInfo>) new AbstractParser<DaoYouRebateInfo>() {
            public DaoYouHandler.DaoYouRebateInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouRebateInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERNAME_FIELD_NUMBER = 1;
        private Object playerName_;
        public static final int TOTALSENDREBATE_FIELD_NUMBER = 2;
        private int totalSendRebate_;
        public static final int TODAYSENDREBATE_FIELD_NUMBER = 3;
        private int todaySendRebate_;
        public static final int MEMREBAERECIVEINFO_FIELD_NUMBER = 4;
        private List<DaoYouHandler.DaoYouMemRebaeReciveInfo> memRebaeReciveInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouRebateInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerName() {
            Object ref = this.playerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerName_ = s;
            return s;
        }

        public ByteString getPlayerNameBytes() {
            Object ref = this.playerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasTotalSendRebate() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getTotalSendRebate() {
            return this.totalSendRebate_;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasTodaySendRebate() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getTodaySendRebate() {
            return this.todaySendRebate_;
        }


        public List<DaoYouHandler.DaoYouMemRebaeReciveInfo> getMemRebaeReciveInfoList() {
            return this.memRebaeReciveInfo_;
        }


        public List<? extends DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder> getMemRebaeReciveInfoOrBuilderList() {
            return (List) this.memRebaeReciveInfo_;
        }


        public int getMemRebaeReciveInfoCount() {
            return this.memRebaeReciveInfo_.size();
        }


        public DaoYouHandler.DaoYouMemRebaeReciveInfo getMemRebaeReciveInfo(int index) {
            return this.memRebaeReciveInfo_.get(index);
        }


        public DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder getMemRebaeReciveInfoOrBuilder(int index) {
            return this.memRebaeReciveInfo_.get(index);
        }


        private void initFields() {
            this.playerName_ = "";
            this.totalSendRebate_ = 0;
            this.todaySendRebate_ = 0;
            this.memRebaeReciveInfo_ = Collections.emptyList();
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getPlayerNameBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.totalSendRebate_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.todaySendRebate_);
            }
            for (int i = 0; i < this.memRebaeReciveInfo_.size(); i++) {
                output.writeMessage(4, (MessageLite) this.memRebaeReciveInfo_.get(i));
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
                size += CodedOutputStream.computeBytesSize(1, getPlayerNameBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.totalSendRebate_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.todaySendRebate_);
            }
            for (int i = 0; i < this.memRebaeReciveInfo_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.memRebaeReciveInfo_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static DaoYouRebateInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouRebateInfo) PARSER.parseFrom(data);
        }


        public static DaoYouRebateInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRebateInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DaoYouRebateInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouRebateInfo) PARSER.parseFrom(data);
        }


        public static DaoYouRebateInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRebateInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DaoYouRebateInfo parseFrom(InputStream input) throws IOException {
            return (DaoYouRebateInfo) PARSER.parseFrom(input);
        }


        public static DaoYouRebateInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static DaoYouRebateInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouRebateInfo) PARSER.parseDelimitedFrom(input);
        }


        public static DaoYouRebateInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static DaoYouRebateInfo parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouRebateInfo) PARSER.parseFrom(input);
        }


        public static DaoYouRebateInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(DaoYouRebateInfo prototype) {
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
                implements DaoYouHandler.DaoYouRebateInfoOrBuilder {
            private int bitField0_;


            private Object playerName_;


            private int totalSendRebate_;


            private int todaySendRebate_;


            private List<DaoYouHandler.DaoYouMemRebaeReciveInfo> memRebaeReciveInfo_;


            private RepeatedFieldBuilder<DaoYouHandler.DaoYouMemRebaeReciveInfo, DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder, DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder> memRebaeReciveInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouRebateInfo.class, Builder.class);
            }


            private Builder() {
                this.playerName_ = "";
                this.memRebaeReciveInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerName_ = "";
                this.memRebaeReciveInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouRebateInfo.alwaysUseFieldBuilders) {
                    getMemRebaeReciveInfoFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.playerName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.totalSendRebate_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.todaySendRebate_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    this.memRebaeReciveInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.memRebaeReciveInfoBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateInfo_descriptor;
            }


            public DaoYouHandler.DaoYouRebateInfo getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouRebateInfo.getDefaultInstance();
            }


            public DaoYouHandler.DaoYouRebateInfo build() {
                DaoYouHandler.DaoYouRebateInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public DaoYouHandler.DaoYouRebateInfo buildPartial() {
                DaoYouHandler.DaoYouRebateInfo result = new DaoYouHandler.DaoYouRebateInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.playerName_ = this.playerName_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.totalSendRebate_ = this.totalSendRebate_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.todaySendRebate_ = this.todaySendRebate_;
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.memRebaeReciveInfo_ = Collections.unmodifiableList(this.memRebaeReciveInfo_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.memRebaeReciveInfo_ = this.memRebaeReciveInfo_;
                } else {
                    result.memRebaeReciveInfo_ = this.memRebaeReciveInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouRebateInfo) {
                    return mergeFrom((DaoYouHandler.DaoYouRebateInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(DaoYouHandler.DaoYouRebateInfo other) {
                if (other == DaoYouHandler.DaoYouRebateInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPlayerName()) {
                    this.bitField0_ |= 0x1;
                    this.playerName_ = other.playerName_;
                    onChanged();
                }
                if (other.hasTotalSendRebate()) {
                    setTotalSendRebate(other.getTotalSendRebate());
                }
                if (other.hasTodaySendRebate()) {
                    setTodaySendRebate(other.getTodaySendRebate());
                }
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    if (!other.memRebaeReciveInfo_.isEmpty()) {
                        if (this.memRebaeReciveInfo_.isEmpty()) {
                            this.memRebaeReciveInfo_ = other.memRebaeReciveInfo_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureMemRebaeReciveInfoIsMutable();
                            this.memRebaeReciveInfo_.addAll(other.memRebaeReciveInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.memRebaeReciveInfo_.isEmpty()) {
                    if (this.memRebaeReciveInfoBuilder_.isEmpty()) {
                        this.memRebaeReciveInfoBuilder_.dispose();
                        this.memRebaeReciveInfoBuilder_ = null;
                        this.memRebaeReciveInfo_ = other.memRebaeReciveInfo_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.memRebaeReciveInfoBuilder_ = DaoYouHandler.DaoYouRebateInfo.alwaysUseFieldBuilders ? getMemRebaeReciveInfoFieldBuilder() : null;
                    } else {
                        this.memRebaeReciveInfoBuilder_.addAllMessages(other.memRebaeReciveInfo_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DaoYouHandler.DaoYouRebateInfo parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouRebateInfo) DaoYouHandler.DaoYouRebateInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouRebateInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasPlayerName() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getPlayerName() {
                Object ref = this.playerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.playerName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getPlayerNameBytes() {
                Object ref = this.playerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.playerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setPlayerName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.playerName_ = value;
                onChanged();
                return this;
            }


            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerName_ = DaoYouHandler.DaoYouRebateInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }


            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.playerName_ = value;
                onChanged();
                return this;
            }


            public boolean hasTotalSendRebate() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getTotalSendRebate() {
                return this.totalSendRebate_;
            }


            public Builder setTotalSendRebate(int value) {
                this.bitField0_ |= 0x2;
                this.totalSendRebate_ = value;
                onChanged();
                return this;
            }


            public Builder clearTotalSendRebate() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.totalSendRebate_ = 0;
                onChanged();
                return this;
            }


            public boolean hasTodaySendRebate() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getTodaySendRebate() {
                return this.todaySendRebate_;
            }


            public Builder setTodaySendRebate(int value) {
                this.bitField0_ |= 0x4;
                this.todaySendRebate_ = value;
                onChanged();
                return this;
            }


            public Builder clearTodaySendRebate() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.todaySendRebate_ = 0;
                onChanged();
                return this;
            }


            private void ensureMemRebaeReciveInfoIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.memRebaeReciveInfo_ = new ArrayList<>(this.memRebaeReciveInfo_);
                    this.bitField0_ |= 0x8;
                }
            }


            public List<DaoYouHandler.DaoYouMemRebaeReciveInfo> getMemRebaeReciveInfoList() {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    return Collections.unmodifiableList(this.memRebaeReciveInfo_);
                }
                return this.memRebaeReciveInfoBuilder_.getMessageList();
            }


            public int getMemRebaeReciveInfoCount() {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    return this.memRebaeReciveInfo_.size();
                }
                return this.memRebaeReciveInfoBuilder_.getCount();
            }


            public DaoYouHandler.DaoYouMemRebaeReciveInfo getMemRebaeReciveInfo(int index) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    return this.memRebaeReciveInfo_.get(index);
                }
                return (DaoYouHandler.DaoYouMemRebaeReciveInfo) this.memRebaeReciveInfoBuilder_.getMessage(index);
            }


            public Builder setMemRebaeReciveInfo(int index, DaoYouHandler.DaoYouMemRebaeReciveInfo value) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.set(index, value);
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setMemRebaeReciveInfo(int index, DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder builderForValue) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addMemRebaeReciveInfo(DaoYouHandler.DaoYouMemRebaeReciveInfo value) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.add(value);
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addMemRebaeReciveInfo(int index, DaoYouHandler.DaoYouMemRebaeReciveInfo value) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.add(index, value);
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addMemRebaeReciveInfo(DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder builderForValue) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addMemRebaeReciveInfo(int index, DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder builderForValue) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllMemRebaeReciveInfo(Iterable<? extends DaoYouHandler.DaoYouMemRebaeReciveInfo> values) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    ensureMemRebaeReciveInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.memRebaeReciveInfo_);
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearMemRebaeReciveInfo() {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    this.memRebaeReciveInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.clear();
                }
                return this;
            }


            public Builder removeMemRebaeReciveInfo(int index) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    ensureMemRebaeReciveInfoIsMutable();
                    this.memRebaeReciveInfo_.remove(index);
                    onChanged();
                } else {
                    this.memRebaeReciveInfoBuilder_.remove(index);
                }
                return this;
            }


            public DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder getMemRebaeReciveInfoBuilder(int index) {
                return (DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder) getMemRebaeReciveInfoFieldBuilder().getBuilder(index);
            }


            public DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder getMemRebaeReciveInfoOrBuilder(int index) {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    return this.memRebaeReciveInfo_.get(index);
                }
                return (DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder) this.memRebaeReciveInfoBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder> getMemRebaeReciveInfoOrBuilderList() {
                if (this.memRebaeReciveInfoBuilder_ != null) {
                    return this.memRebaeReciveInfoBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.memRebaeReciveInfo_);
            }


            public DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder addMemRebaeReciveInfoBuilder() {
                return (DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder) getMemRebaeReciveInfoFieldBuilder().addBuilder(DaoYouHandler.DaoYouMemRebaeReciveInfo.getDefaultInstance());
            }


            public DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder addMemRebaeReciveInfoBuilder(int index) {
                return (DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder) getMemRebaeReciveInfoFieldBuilder().addBuilder(index, DaoYouHandler.DaoYouMemRebaeReciveInfo.getDefaultInstance());
            }


            public List<DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder> getMemRebaeReciveInfoBuilderList() {
                return getMemRebaeReciveInfoFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<DaoYouHandler.DaoYouMemRebaeReciveInfo, DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder, DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder> getMemRebaeReciveInfoFieldBuilder() {
                if (this.memRebaeReciveInfoBuilder_ == null) {
                    this.memRebaeReciveInfoBuilder_ = new RepeatedFieldBuilder(this.memRebaeReciveInfo_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.memRebaeReciveInfo_ = null;
                }
                return this.memRebaeReciveInfoBuilder_;
            }
        }
    }


    public static final class DaoYouRebateResponse
            extends GeneratedMessage
            implements DaoYouRebateResponseOrBuilder {
        private static final DaoYouRebateResponse defaultInstance = new DaoYouRebateResponse(true);
        private final UnknownFieldSet unknownFields;

        private DaoYouRebateResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DaoYouRebateResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DaoYouRebateResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DaoYouRebateResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DaoYouRebateResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.selfTotalReciveRebate_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.selfTodayReciveRebate_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.ri_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.ri_.add(input.readMessage(DaoYouHandler.DaoYouRebateInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16) this.ri_ = Collections.unmodifiableList(this.ri_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouRebateResponse.class, Builder.class);
        }

        public static Parser<DaoYouRebateResponse> PARSER = (Parser<DaoYouRebateResponse>) new AbstractParser<DaoYouRebateResponse>() {
            public DaoYouHandler.DaoYouRebateResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DaoYouHandler.DaoYouRebateResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int SELFTOTALRECIVEREBATE_FIELD_NUMBER = 3;
        private int selfTotalReciveRebate_;
        public static final int SELFTODAYRECIVEREBATE_FIELD_NUMBER = 4;
        private int selfTodayReciveRebate_;
        public static final int RI_FIELD_NUMBER = 5;
        private List<DaoYouHandler.DaoYouRebateInfo> ri_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DaoYouRebateResponse> getParserForType() {
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

        public boolean hasSelfTotalReciveRebate() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getSelfTotalReciveRebate() {
            return this.selfTotalReciveRebate_;
        }

        public boolean hasSelfTodayReciveRebate() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getSelfTodayReciveRebate() {
            return this.selfTodayReciveRebate_;
        }

        public List<DaoYouHandler.DaoYouRebateInfo> getRiList() {
            return this.ri_;
        }

        public List<? extends DaoYouHandler.DaoYouRebateInfoOrBuilder> getRiOrBuilderList() {
            return (List) this.ri_;
        }

        public int getRiCount() {
            return this.ri_.size();
        }

        public DaoYouHandler.DaoYouRebateInfo getRi(int index) {
            return this.ri_.get(index);
        }

        public DaoYouHandler.DaoYouRebateInfoOrBuilder getRiOrBuilder(int index) {
            return this.ri_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.selfTotalReciveRebate_ = 0;
            this.selfTodayReciveRebate_ = 0;
            this.ri_ = Collections.emptyList();
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
                output.writeInt32(3, this.selfTotalReciveRebate_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.selfTodayReciveRebate_);
            for (int i = 0; i < this.ri_.size(); i++)
                output.writeMessage(5, (MessageLite) this.ri_.get(i));
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
                size += CodedOutputStream.computeInt32Size(3, this.selfTotalReciveRebate_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.selfTodayReciveRebate_);
            for (int i = 0; i < this.ri_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.ri_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DaoYouRebateResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DaoYouRebateResponse) PARSER.parseFrom(data);
        }

        public static DaoYouRebateResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRebateResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouRebateResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DaoYouRebateResponse) PARSER.parseFrom(data);
        }

        public static DaoYouRebateResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DaoYouRebateResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DaoYouRebateResponse parseFrom(InputStream input) throws IOException {
            return (DaoYouRebateResponse) PARSER.parseFrom(input);
        }

        public static DaoYouRebateResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DaoYouRebateResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DaoYouRebateResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DaoYouRebateResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DaoYouRebateResponse parseFrom(CodedInputStream input) throws IOException {
            return (DaoYouRebateResponse) PARSER.parseFrom(input);
        }

        public static DaoYouRebateResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DaoYouRebateResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DaoYouRebateResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DaoYouHandler.DaoYouRebateResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int selfTotalReciveRebate_;
            private int selfTodayReciveRebate_;
            private List<DaoYouHandler.DaoYouRebateInfo> ri_;
            private RepeatedFieldBuilder<DaoYouHandler.DaoYouRebateInfo, DaoYouHandler.DaoYouRebateInfo.Builder, DaoYouHandler.DaoYouRebateInfoOrBuilder> riBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DaoYouHandler.DaoYouRebateResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.ri_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.ri_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DaoYouHandler.DaoYouRebateResponse.alwaysUseFieldBuilders)
                    getRiFieldBuilder();
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
                this.selfTotalReciveRebate_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.selfTodayReciveRebate_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.riBuilder_ == null) {
                    this.ri_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.riBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return DaoYouHandler.internal_static_pomelo_daoyou_DaoYouRebateResponse_descriptor;
            }

            public DaoYouHandler.DaoYouRebateResponse getDefaultInstanceForType() {
                return DaoYouHandler.DaoYouRebateResponse.getDefaultInstance();
            }

            public DaoYouHandler.DaoYouRebateResponse build() {
                DaoYouHandler.DaoYouRebateResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public DaoYouHandler.DaoYouRebateResponse buildPartial() {
                DaoYouHandler.DaoYouRebateResponse result = new DaoYouHandler.DaoYouRebateResponse(this);
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
                result.selfTotalReciveRebate_ = this.selfTotalReciveRebate_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.selfTodayReciveRebate_ = this.selfTodayReciveRebate_;
                if (this.riBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.ri_ = Collections.unmodifiableList(this.ri_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.ri_ = this.ri_;
                } else {
                    result.ri_ = this.riBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DaoYouHandler.DaoYouRebateResponse)
                    return mergeFrom((DaoYouHandler.DaoYouRebateResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DaoYouHandler.DaoYouRebateResponse other) {
                if (other == DaoYouHandler.DaoYouRebateResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasSelfTotalReciveRebate())
                    setSelfTotalReciveRebate(other.getSelfTotalReciveRebate());
                if (other.hasSelfTodayReciveRebate())
                    setSelfTodayReciveRebate(other.getSelfTodayReciveRebate());
                if (this.riBuilder_ == null) {
                    if (!other.ri_.isEmpty()) {
                        if (this.ri_.isEmpty()) {
                            this.ri_ = other.ri_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureRiIsMutable();
                            this.ri_.addAll(other.ri_);
                        }
                        onChanged();
                    }
                } else if (!other.ri_.isEmpty()) {
                    if (this.riBuilder_.isEmpty()) {
                        this.riBuilder_.dispose();
                        this.riBuilder_ = null;
                        this.ri_ = other.ri_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.riBuilder_ = DaoYouHandler.DaoYouRebateResponse.alwaysUseFieldBuilders ? getRiFieldBuilder() : null;
                    } else {
                        this.riBuilder_.addAllMessages(other.ri_);
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
                DaoYouHandler.DaoYouRebateResponse parsedMessage = null;
                try {
                    parsedMessage = (DaoYouHandler.DaoYouRebateResponse) DaoYouHandler.DaoYouRebateResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DaoYouHandler.DaoYouRebateResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = DaoYouHandler.DaoYouRebateResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasSelfTotalReciveRebate() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getSelfTotalReciveRebate() {
                return this.selfTotalReciveRebate_;
            }

            public Builder setSelfTotalReciveRebate(int value) {
                this.bitField0_ |= 0x4;
                this.selfTotalReciveRebate_ = value;
                onChanged();
                return this;
            }

            public Builder clearSelfTotalReciveRebate() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.selfTotalReciveRebate_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSelfTodayReciveRebate() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getSelfTodayReciveRebate() {
                return this.selfTodayReciveRebate_;
            }

            public Builder setSelfTodayReciveRebate(int value) {
                this.bitField0_ |= 0x8;
                this.selfTodayReciveRebate_ = value;
                onChanged();
                return this;
            }

            public Builder clearSelfTodayReciveRebate() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.selfTodayReciveRebate_ = 0;
                onChanged();
                return this;
            }

            private void ensureRiIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.ri_ = new ArrayList<>(this.ri_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<DaoYouHandler.DaoYouRebateInfo> getRiList() {
                if (this.riBuilder_ == null)
                    return Collections.unmodifiableList(this.ri_);
                return this.riBuilder_.getMessageList();
            }

            public int getRiCount() {
                if (this.riBuilder_ == null)
                    return this.ri_.size();
                return this.riBuilder_.getCount();
            }

            public DaoYouHandler.DaoYouRebateInfo getRi(int index) {
                if (this.riBuilder_ == null)
                    return this.ri_.get(index);
                return (DaoYouHandler.DaoYouRebateInfo) this.riBuilder_.getMessage(index);
            }

            public Builder setRi(int index, DaoYouHandler.DaoYouRebateInfo value) {
                if (this.riBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRiIsMutable();
                    this.ri_.set(index, value);
                    onChanged();
                } else {
                    this.riBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setRi(int index, DaoYouHandler.DaoYouRebateInfo.Builder builderForValue) {
                if (this.riBuilder_ == null) {
                    ensureRiIsMutable();
                    this.ri_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.riBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRi(DaoYouHandler.DaoYouRebateInfo value) {
                if (this.riBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRiIsMutable();
                    this.ri_.add(value);
                    onChanged();
                } else {
                    this.riBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addRi(int index, DaoYouHandler.DaoYouRebateInfo value) {
                if (this.riBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRiIsMutable();
                    this.ri_.add(index, value);
                    onChanged();
                } else {
                    this.riBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addRi(DaoYouHandler.DaoYouRebateInfo.Builder builderForValue) {
                if (this.riBuilder_ == null) {
                    ensureRiIsMutable();
                    this.ri_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.riBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRi(int index, DaoYouHandler.DaoYouRebateInfo.Builder builderForValue) {
                if (this.riBuilder_ == null) {
                    ensureRiIsMutable();
                    this.ri_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.riBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRi(Iterable<? extends DaoYouHandler.DaoYouRebateInfo> values) {
                if (this.riBuilder_ == null) {
                    ensureRiIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.ri_);
                    onChanged();
                } else {
                    this.riBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRi() {
                if (this.riBuilder_ == null) {
                    this.ri_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.riBuilder_.clear();
                }
                return this;
            }

            public Builder removeRi(int index) {
                if (this.riBuilder_ == null) {
                    ensureRiIsMutable();
                    this.ri_.remove(index);
                    onChanged();
                } else {
                    this.riBuilder_.remove(index);
                }
                return this;
            }

            public DaoYouHandler.DaoYouRebateInfo.Builder getRiBuilder(int index) {
                return (DaoYouHandler.DaoYouRebateInfo.Builder) getRiFieldBuilder().getBuilder(index);
            }

            public DaoYouHandler.DaoYouRebateInfoOrBuilder getRiOrBuilder(int index) {
                if (this.riBuilder_ == null)
                    return this.ri_.get(index);
                return (DaoYouHandler.DaoYouRebateInfoOrBuilder) this.riBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends DaoYouHandler.DaoYouRebateInfoOrBuilder> getRiOrBuilderList() {
                if (this.riBuilder_ != null)
                    return this.riBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.ri_);
            }

            public DaoYouHandler.DaoYouRebateInfo.Builder addRiBuilder() {
                return (DaoYouHandler.DaoYouRebateInfo.Builder) getRiFieldBuilder().addBuilder(DaoYouHandler.DaoYouRebateInfo.getDefaultInstance());
            }

            public DaoYouHandler.DaoYouRebateInfo.Builder addRiBuilder(int index) {
                return (DaoYouHandler.DaoYouRebateInfo.Builder) getRiFieldBuilder().addBuilder(index, DaoYouHandler.DaoYouRebateInfo.getDefaultInstance());
            }

            public List<DaoYouHandler.DaoYouRebateInfo.Builder> getRiBuilderList() {
                return getRiFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DaoYouHandler.DaoYouRebateInfo, DaoYouHandler.DaoYouRebateInfo.Builder, DaoYouHandler.DaoYouRebateInfoOrBuilder> getRiFieldBuilder() {
                if (this.riBuilder_ == null) {
                    this.riBuilder_ = new RepeatedFieldBuilder(this.ri_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.ri_ = null;
                }
                return this.riBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\023daoYouHandler.proto\022\rpomelo.daoyou\"ã\001\n\nDaoYouInfo\022\020\n\bplayerId\030\001 \001(\t\022\022\n\nplayerName\030\002 \001(\t\022\021\n\tplayerLvl\030\003 \001(\005\022\013\n\003pro\030\004 \001(\005\022\023\n\013playerUpLvl\030\005 \001(\005\022\020\n\bareaName\030\006 \001(\t\022\030\n\020playerFightPower\030\007 \001(\005\022\017\n\007isAdmin\030\b \001(\005\022\023\n\013onlineState\030\t \001(\005\022\026\n\016lastActiveTime\030\n \001(\005\022\020\n\bjoinTime\030\013 \001(\005\"<\n\rDaoYouMessage\022\f\n\004type\030\001 \001(\005\022\017\n\007content\030\002 \001(\t\022\f\n\004time\030\003 \001(\005\"\017\n\rDaoYouRequest\"\002\n\016DaoYouResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022", "\023\n\013isHasDaoYou\030\003 \001(\005\022\026\n\016isEditedDyName\030\004 \001(\005\022\f\n\004dyId\030\005 \001(\t\022\016\n\006dyName\030\006 \001(\t\022\024\n\fdyFightPower\030\007 \001(\005\022\016\n\006dyRank\030\b \001(\005\022\020\n\bdyNotice\030\t \001(\t\022-\n\007message\030\n \003(\0132\034.pomelo.daoyou.DaoYouMessage\022)\n\006dyInfo\030\013 \003(\0132\031.pomelo.daoyou.DaoYouInfo\"-\n\031DaoYouInviteDaoYouRequest\022\020\n\bplayerId\030\001 \002(\t\"?\n\032DaoYouInviteDaoYouResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\037\n\035DaoYouFastInviteDaoYouRequest\"C\n\036DaoYouFastInviteDaoYouResponse\022", "\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"-\n\031DaoYouEditTeamNameRequest\022\020\n\bteamName\030\001 \002(\t\"?\n\032DaoYouEditTeamNameResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\",\n\031DaoYouLeaveMessageRequest\022\017\n\007message\030\001 \002(\t\"?\n\032DaoYouLeaveMessageResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"%\n\023DaoYouNoticeRequest\022\016\n\006notice\030\001 \002(\t\"9\n\024DaoYouNoticeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\")\n\025DaoYouKickTeamRequest\022\020\n\bplayerId\030\001 \002(\t\";", "\n\026DaoYouKickTeamResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\".\n\032DaoYouTransferAdminRequest\022\020\n\bplayerId\030\001 \002(\t\"@\n\033DaoYouTransferAdminResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\027\n\025DaoYouQuitTeamRequest\";\n\026DaoYouQuitTeamResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\025\n\023DaoYouRebateRequest\"D\n\030DaoYouMemRebaeReciveInfo\022\022\n\nplayerName\030\001 \001(\t\022\024\n\freciveNumber\030\002 \001(\005\"\001\n\020DaoYouRebateInfo\022\022\n\nplayerName\030\001 \001(\t\022\027\n\017tot", "alSendRebate\030\002 \001(\005\022\027\n\017todaySendRebate\030\003 \001(\005\022C\n\022memRebaeReciveInfo\030\004 \003(\0132'.pomelo.daoyou.DaoYouMemRebaeReciveInfo\"¤\001\n\024DaoYouRebateResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\035\n\025selfTotalReciveRebate\030\003 \001(\005\022\035\n\025selfTodayReciveRebate\030\004 \001(\005\022+\n\002ri\030\005 \003(\0132\037.pomelo.daoyou.DaoYouRebateInfo2²\b\n\rdaoYouHandler\022L\n\rdaoYouRequest\022\034.pomelo.daoyou.DaoYouRequest\032\035.pomelo.daoyou.DaoYouResponse\022p\n\031daoYouInviteDaoYouReq", "uest\022(.pomelo.daoyou.DaoYouInviteDaoYouRequest\032).pomelo.daoyou.DaoYouInviteDaoYouResponse\022|\n\035daoYouFastInviteDaoYouRequest\022,.pomelo.daoyou.DaoYouFastInviteDaoYouRequest\032-.pomelo.daoyou.DaoYouFastInviteDaoYouResponse\022p\n\031daoYouEditTeamNameRequest\022(.pomelo.daoyou.DaoYouEditTeamNameRequest\032).pomelo.daoyou.DaoYouEditTeamNameResponse\022p\n\031daoYouLeaveMessageRequest\022(.pomelo.daoyou.DaoYouLeaveMessageRequest", "\032).pomelo.daoyou.DaoYouLeaveMessageResponse\022^\n\023daoYouNoticeRequest\022\".pomelo.daoyou.DaoYouNoticeRequest\032#.pomelo.daoyou.DaoYouNoticeResponse\022d\n\025daoYouKickTeamRequest\022$.pomelo.daoyou.DaoYouKickTeamRequest\032%.pomelo.daoyou.DaoYouKickTeamResponse\022s\n\032daoYouTransferAdminRequest\022).pomelo.daoyou.DaoYouTransferAdminRequest\032*.pomelo.daoyou.DaoYouTransferAdminResponse\022d\n\025daoYouQuitTeamRequest\022$.pomelo.daoyou.", "DaoYouQuitTeamRequest\032%.pomelo.daoyou.DaoYouQuitTeamResponse\022^\n\023daoYouRebateRequest\022\".pomelo.daoyou.DaoYouRebateRequest\032#.pomelo.daoyou.DaoYouRebateResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                DaoYouHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouInfo_descriptor, new String[]{"PlayerId", "PlayerName", "PlayerLvl", "Pro", "PlayerUpLvl", "AreaName", "PlayerFightPower", "IsAdmin", "OnlineState", "LastActiveTime", "JoinTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouMessage_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouMessage_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouMessage_descriptor, new String[]{"Type", "Content", "Time"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "IsHasDaoYou", "IsEditedDyName", "DyId", "DyName", "DyFightPower", "DyRank", "DyNotice", "Message", "DyInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouInviteDaoYouRequest_descriptor, new String[]{"PlayerId"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouInviteDaoYouResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouFastInviteDaoYouResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouEditTeamNameRequest_descriptor, new String[]{"TeamName"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouEditTeamNameResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouLeaveMessageRequest_descriptor, new String[]{"Message"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouLeaveMessageResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouNoticeRequest_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouNoticeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouNoticeRequest_descriptor, new String[]{"Notice"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouNoticeResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouNoticeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouNoticeResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouKickTeamRequest_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouKickTeamRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouKickTeamRequest_descriptor, new String[]{"PlayerId"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouKickTeamResponse_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouKickTeamResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouKickTeamResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouTransferAdminRequest_descriptor, new String[]{"PlayerId"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_descriptor = getDescriptor().getMessageTypes().get(17);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouTransferAdminResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_descriptor = getDescriptor().getMessageTypes().get(18);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouQuitTeamRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_descriptor = getDescriptor().getMessageTypes().get(19);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouQuitTeamResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouRebateRequest_descriptor = getDescriptor().getMessageTypes().get(20);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouRebateRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouRebateRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_descriptor = getDescriptor().getMessageTypes().get(21);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouMemRebaeReciveInfo_descriptor, new String[]{"PlayerName", "ReciveNumber"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouRebateInfo_descriptor = getDescriptor().getMessageTypes().get(22);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouRebateInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouRebateInfo_descriptor, new String[]{"PlayerName", "TotalSendRebate", "TodaySendRebate", "MemRebaeReciveInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_daoyou_DaoYouRebateResponse_descriptor = getDescriptor().getMessageTypes().get(23);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_daoyou_DaoYouRebateResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_daoyou_DaoYouRebateResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "SelfTotalReciveRebate", "SelfTodayReciveRebate", "Ri"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface DaoYouRebateResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasSelfTotalReciveRebate();

        int getSelfTotalReciveRebate();

        boolean hasSelfTodayReciveRebate();

        int getSelfTodayReciveRebate();

        List<DaoYouHandler.DaoYouRebateInfo> getRiList();

        DaoYouHandler.DaoYouRebateInfo getRi(int param1Int);

        int getRiCount();

        List<? extends DaoYouHandler.DaoYouRebateInfoOrBuilder> getRiOrBuilderList();

        DaoYouHandler.DaoYouRebateInfoOrBuilder getRiOrBuilder(int param1Int);
    }

    public static interface DaoYouRebateInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();

        boolean hasTotalSendRebate();

        int getTotalSendRebate();

        boolean hasTodaySendRebate();

        int getTodaySendRebate();

        List<DaoYouHandler.DaoYouMemRebaeReciveInfo> getMemRebaeReciveInfoList();

        DaoYouHandler.DaoYouMemRebaeReciveInfo getMemRebaeReciveInfo(int param1Int);

        int getMemRebaeReciveInfoCount();

        List<? extends DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder> getMemRebaeReciveInfoOrBuilderList();

        DaoYouHandler.DaoYouMemRebaeReciveInfoOrBuilder getMemRebaeReciveInfoOrBuilder(int param1Int);
    }

    public static interface DaoYouMemRebaeReciveInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();

        boolean hasReciveNumber();

        int getReciveNumber();
    }

    public static interface DaoYouRebateRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface DaoYouQuitTeamResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouQuitTeamRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface DaoYouTransferAdminResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouTransferAdminRequestOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();
    }

    public static interface DaoYouKickTeamResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouKickTeamRequestOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();
    }

    public static interface DaoYouNoticeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouNoticeRequestOrBuilder extends MessageOrBuilder {
        boolean hasNotice();

        String getNotice();

        ByteString getNoticeBytes();
    }

    public static interface DaoYouLeaveMessageResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouLeaveMessageRequestOrBuilder extends MessageOrBuilder {
        boolean hasMessage();

        String getMessage();

        ByteString getMessageBytes();
    }

    public static interface DaoYouEditTeamNameResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouEditTeamNameRequestOrBuilder extends MessageOrBuilder {
        boolean hasTeamName();

        String getTeamName();

        ByteString getTeamNameBytes();
    }

    public static interface DaoYouFastInviteDaoYouResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouFastInviteDaoYouRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface DaoYouInviteDaoYouResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DaoYouInviteDaoYouRequestOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();
    }

    public static interface DaoYouResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasIsHasDaoYou();

        int getIsHasDaoYou();

        boolean hasIsEditedDyName();

        int getIsEditedDyName();

        boolean hasDyId();

        String getDyId();

        ByteString getDyIdBytes();

        boolean hasDyName();

        String getDyName();

        ByteString getDyNameBytes();

        boolean hasDyFightPower();

        int getDyFightPower();

        boolean hasDyRank();

        int getDyRank();

        boolean hasDyNotice();

        String getDyNotice();

        ByteString getDyNoticeBytes();

        List<DaoYouHandler.DaoYouMessage> getMessageList();

        DaoYouHandler.DaoYouMessage getMessage(int param1Int);

        int getMessageCount();

        List<? extends DaoYouHandler.DaoYouMessageOrBuilder> getMessageOrBuilderList();

        DaoYouHandler.DaoYouMessageOrBuilder getMessageOrBuilder(int param1Int);

        List<DaoYouHandler.DaoYouInfo> getDyInfoList();

        DaoYouHandler.DaoYouInfo getDyInfo(int param1Int);

        int getDyInfoCount();

        List<? extends DaoYouHandler.DaoYouInfoOrBuilder> getDyInfoOrBuilderList();

        DaoYouHandler.DaoYouInfoOrBuilder getDyInfoOrBuilder(int param1Int);
    }

    public static interface DaoYouRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface DaoYouMessageOrBuilder extends MessageOrBuilder {
        boolean hasType();

        int getType();

        boolean hasContent();

        String getContent();

        ByteString getContentBytes();

        boolean hasTime();

        int getTime();
    }

    public static interface DaoYouInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();

        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();

        boolean hasPlayerLvl();

        int getPlayerLvl();

        boolean hasPro();

        int getPro();

        boolean hasPlayerUpLvl();

        int getPlayerUpLvl();

        boolean hasAreaName();

        String getAreaName();

        ByteString getAreaNameBytes();

        boolean hasPlayerFightPower();

        int getPlayerFightPower();

        boolean hasIsAdmin();

        int getIsAdmin();

        boolean hasOnlineState();

        int getOnlineState();

        boolean hasLastActiveTime();

        int getLastActiveTime();

        boolean hasJoinTime();

        int getJoinTime();
    }
}


