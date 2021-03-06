package pomelo.five2five;

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


public final class Five2FiveHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Five2FiveRequest
            extends GeneratedMessage
            implements Five2FiveRequestOrBuilder {
        private static final Five2FiveRequest defaultInstance = new Five2FiveRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveRequest.class, Builder.class);
        }

        public static Parser<Five2FiveRequest> PARSER = (Parser<Five2FiveRequest>) new AbstractParser<Five2FiveRequest>() {
            public Five2FiveHandler.Five2FiveRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveRequest> getParserForType() {
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

        public static Five2FiveRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveRequest build() {
                Five2FiveHandler.Five2FiveRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveRequest buildPartial() {
                Five2FiveHandler.Five2FiveRequest result = new Five2FiveHandler.Five2FiveRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveRequest other) {
                if (other == Five2FiveHandler.Five2FiveRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveRequest) Five2FiveHandler.Five2FiveRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveRankInfo
            extends GeneratedMessage
            implements Five2FiveRankInfoOrBuilder {
        private static final Five2FiveRankInfo defaultInstance = new Five2FiveRankInfo(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveRankInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveRankInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveRankInfo getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveRankInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveRankInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.playerFightPower_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRankInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveRankInfo.class, Builder.class);
        }

        public static Parser<Five2FiveRankInfo> PARSER = (Parser<Five2FiveRankInfo>) new AbstractParser<Five2FiveRankInfo>() {
            public Five2FiveHandler.Five2FiveRankInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveRankInfo(input, extensionRegistry);
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
        public static final int PLAYERFIGHTPOWER_FIELD_NUMBER = 6;
        private int playerFightPower_;
        public static final int SCORE_FIELD_NUMBER = 7;
        private int score_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveRankInfo> getParserForType() {
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

        public boolean hasPlayerFightPower() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getPlayerFightPower() {
            return this.playerFightPower_;
        }

        public boolean hasScore() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getScore() {
            return this.score_;
        }

        private void initFields() {
            this.playerId_ = "";
            this.playerName_ = "";
            this.playerLvl_ = 0;
            this.pro_ = 0;
            this.playerUpLvl_ = 0;
            this.playerFightPower_ = 0;
            this.score_ = 0;
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
                output.writeInt32(6, this.playerFightPower_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.score_);
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
                size += CodedOutputStream.computeInt32Size(6, this.playerFightPower_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.score_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveRankInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveRankInfo) PARSER.parseFrom(data);
        }

        public static Five2FiveRankInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRankInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRankInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveRankInfo) PARSER.parseFrom(data);
        }

        public static Five2FiveRankInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRankInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRankInfo parseFrom(InputStream input) throws IOException {
            return (Five2FiveRankInfo) PARSER.parseFrom(input);
        }

        public static Five2FiveRankInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRankInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveRankInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveRankInfo) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveRankInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRankInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveRankInfo parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveRankInfo) PARSER.parseFrom(input);
        }

        public static Five2FiveRankInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRankInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveRankInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveRankInfoOrBuilder {
            private int bitField0_;
            private Object playerId_;
            private Object playerName_;
            private int playerLvl_;
            private int pro_;
            private int playerUpLvl_;
            private int playerFightPower_;
            private int score_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRankInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveRankInfo.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveRankInfo.alwaysUseFieldBuilders) ;
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
                this.playerFightPower_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRankInfo_descriptor;
            }

            public Five2FiveHandler.Five2FiveRankInfo getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveRankInfo build() {
                Five2FiveHandler.Five2FiveRankInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveRankInfo buildPartial() {
                Five2FiveHandler.Five2FiveRankInfo result = new Five2FiveHandler.Five2FiveRankInfo(this);
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
                result.playerFightPower_ = this.playerFightPower_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.score_ = this.score_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveRankInfo)
                    return mergeFrom((Five2FiveHandler.Five2FiveRankInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveRankInfo other) {
                if (other == Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance())
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
                if (other.hasPlayerFightPower())
                    setPlayerFightPower(other.getPlayerFightPower());
                if (other.hasScore())
                    setScore(other.getScore());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveRankInfo parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveRankInfo) Five2FiveHandler.Five2FiveRankInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveRankInfo) e.getUnfinishedMessage();
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
                this.playerId_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance().getPlayerId();
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
                this.playerName_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance().getPlayerName();
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

            public boolean hasPlayerFightPower() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getPlayerFightPower() {
                return this.playerFightPower_;
            }

            public Builder setPlayerFightPower(int value) {
                this.bitField0_ |= 0x20;
                this.playerFightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerFightPower() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.playerFightPower_ = 0;
                onChanged();
                return this;
            }

            public boolean hasScore() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.bitField0_ |= 0x40;
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.score_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveMatchTime extends GeneratedMessage implements Five2FiveMatchTimeOrBuilder {
        private static final Five2FiveMatchTime defaultInstance = new Five2FiveMatchTime(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchTime(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchTime(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchTime getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchTime getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchTime(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.avgWaitTime_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.matchTime_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchTime_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchTime_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchTime.class, Builder.class);
        }

        public static Parser<Five2FiveMatchTime> PARSER = (Parser<Five2FiveMatchTime>) new AbstractParser<Five2FiveMatchTime>() {
            public Five2FiveHandler.Five2FiveMatchTime parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchTime(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int AVGWAITTIME_FIELD_NUMBER = 1;
        private int avgWaitTime_;
        public static final int MATCHTIME_FIELD_NUMBER = 2;
        private int matchTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchTime> getParserForType() {
            return PARSER;
        }

        public boolean hasAvgWaitTime() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getAvgWaitTime() {
            return this.avgWaitTime_;
        }

        public boolean hasMatchTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getMatchTime() {
            return this.matchTime_;
        }

        private void initFields() {
            this.avgWaitTime_ = 0;
            this.matchTime_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.avgWaitTime_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.matchTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.avgWaitTime_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.matchTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveMatchTime parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchTime) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchTime parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchTime) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchTime parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchTime) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchTime parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchTime) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchTime parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchTime) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchTime parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchTime) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchTime parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchTime) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveMatchTime parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchTime) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchTime parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchTime) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchTime parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchTime) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveMatchTime prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveMatchTimeOrBuilder {
            private int bitField0_;
            private int avgWaitTime_;
            private int matchTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchTime_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchTime_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchTime.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchTime.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.avgWaitTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.matchTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchTime_descriptor;
            }

            public Five2FiveHandler.Five2FiveMatchTime getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveMatchTime build() {
                Five2FiveHandler.Five2FiveMatchTime result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveMatchTime buildPartial() {
                Five2FiveHandler.Five2FiveMatchTime result = new Five2FiveHandler.Five2FiveMatchTime(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.avgWaitTime_ = this.avgWaitTime_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.matchTime_ = this.matchTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchTime)
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchTime) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchTime other) {
                if (other == Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance()) return this;
                if (other.hasAvgWaitTime()) setAvgWaitTime(other.getAvgWaitTime());
                if (other.hasMatchTime()) setMatchTime(other.getMatchTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchTime parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchTime) Five2FiveHandler.Five2FiveMatchTime.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchTime) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasAvgWaitTime() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getAvgWaitTime() {
                return this.avgWaitTime_;
            }

            public Builder setAvgWaitTime(int value) {
                this.bitField0_ |= 0x1;
                this.avgWaitTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvgWaitTime() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.avgWaitTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMatchTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getMatchTime() {
                return this.matchTime_;
            }

            public Builder setMatchTime(int value) {
                this.bitField0_ |= 0x2;
                this.matchTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearMatchTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.matchTime_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class Five2FiveResponse
            extends GeneratedMessage
            implements Five2FiveResponseOrBuilder {
        private static final Five2FiveResponse defaultInstance = new Five2FiveResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    Five2FiveHandler.Five2FiveRankInfo.Builder builder;
                    Five2FiveHandler.Five2FiveMatchTime.Builder subBuilder;
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
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.s2CMsg_ = byteString1;
                            break;
                        case 26:
                            builder = null;
                            if ((this.bitField0_ & 0x4) == 4) builder = this.firstRankInfo_.toBuilder();
                            this.firstRankInfo_ = (Five2FiveHandler.Five2FiveRankInfo) input.readMessage(Five2FiveHandler.Five2FiveRankInfo.PARSER, extensionRegistry);
                            if (builder != null) {
                                builder.mergeFrom(this.firstRankInfo_);
                                this.firstRankInfo_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.score_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.rank_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.win_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.tie_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.fail_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.mvp_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.totalCanReciveCount_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 0x400;
                            this.hasRecivedCount_ = input.readInt32();
                            break;
                        case 98:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x800) == 2048) subBuilder = this.five2FiveMatchTime_.toBuilder();
                            this.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) input.readMessage(Five2FiveHandler.Five2FiveMatchTime.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.five2FiveMatchTime_);
                                this.five2FiveMatchTime_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x800;
                            break;
                        case 104:
                            this.bitField0_ |= 0x1000;
                            this.matchPeople_ = input.readInt32();
                            break;
                        case 114:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2000;
                            this.seasonEndTime_ = bs;
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveResponse.class, Builder.class);
        }

        public static Parser<Five2FiveResponse> PARSER = (Parser<Five2FiveResponse>) new AbstractParser<Five2FiveResponse>() {
            public Five2FiveHandler.Five2FiveResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int FIRSTRANKINFO_FIELD_NUMBER = 3;
        private Five2FiveHandler.Five2FiveRankInfo firstRankInfo_;
        public static final int SCORE_FIELD_NUMBER = 4;
        private int score_;
        public static final int RANK_FIELD_NUMBER = 5;
        private int rank_;
        public static final int WIN_FIELD_NUMBER = 6;
        private int win_;
        public static final int TIE_FIELD_NUMBER = 7;
        private int tie_;
        public static final int FAIL_FIELD_NUMBER = 8;
        private int fail_;
        public static final int MVP_FIELD_NUMBER = 9;
        private int mvp_;
        public static final int TOTALCANRECIVECOUNT_FIELD_NUMBER = 10;
        private int totalCanReciveCount_;
        public static final int HASRECIVEDCOUNT_FIELD_NUMBER = 11;
        private int hasRecivedCount_;
        public static final int FIVE2FIVEMATCHTIME_FIELD_NUMBER = 12;
        private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
        public static final int MATCHPEOPLE_FIELD_NUMBER = 13;
        private int matchPeople_;
        public static final int SEASONENDTIME_FIELD_NUMBER = 14;
        private Object seasonEndTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveResponse> getParserForType() {
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

        public boolean hasFirstRankInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public Five2FiveHandler.Five2FiveRankInfo getFirstRankInfo() {
            return this.firstRankInfo_;
        }

        public Five2FiveHandler.Five2FiveRankInfoOrBuilder getFirstRankInfoOrBuilder() {
            return this.firstRankInfo_;
        }

        public boolean hasScore() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getScore() {
            return this.score_;
        }

        public boolean hasRank() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getRank() {
            return this.rank_;
        }

        public boolean hasWin() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getWin() {
            return this.win_;
        }

        public boolean hasTie() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getTie() {
            return this.tie_;
        }

        public boolean hasFail() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getFail() {
            return this.fail_;
        }

        public boolean hasMvp() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getMvp() {
            return this.mvp_;
        }

        public boolean hasTotalCanReciveCount() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getTotalCanReciveCount() {
            return this.totalCanReciveCount_;
        }

        public boolean hasHasRecivedCount() {
            return ((this.bitField0_ & 0x400) == 1024);
        }

        public int getHasRecivedCount() {
            return this.hasRecivedCount_;
        }

        public boolean hasFive2FiveMatchTime() {
            return ((this.bitField0_ & 0x800) == 2048);
        }

        public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
            return this.five2FiveMatchTime_;
        }

        public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
            return this.five2FiveMatchTime_;
        }

        public boolean hasMatchPeople() {
            return ((this.bitField0_ & 0x1000) == 4096);
        }

        public int getMatchPeople() {
            return this.matchPeople_;
        }

        public boolean hasSeasonEndTime() {
            return ((this.bitField0_ & 0x2000) == 8192);
        }

        public String getSeasonEndTime() {
            Object ref = this.seasonEndTime_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.seasonEndTime_ = s;
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

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.firstRankInfo_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance();
            this.score_ = 0;
            this.rank_ = 0;
            this.win_ = 0;
            this.tie_ = 0;
            this.fail_ = 0;
            this.mvp_ = 0;
            this.totalCanReciveCount_ = 0;
            this.hasRecivedCount_ = 0;
            this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
            this.matchPeople_ = 0;
            this.seasonEndTime_ = "";
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.firstRankInfo_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.score_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.rank_);
            if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.win_);
            if ((this.bitField0_ & 0x40) == 64) output.writeInt32(7, this.tie_);
            if ((this.bitField0_ & 0x80) == 128) output.writeInt32(8, this.fail_);
            if ((this.bitField0_ & 0x100) == 256) output.writeInt32(9, this.mvp_);
            if ((this.bitField0_ & 0x200) == 512) output.writeInt32(10, this.totalCanReciveCount_);
            if ((this.bitField0_ & 0x400) == 1024) output.writeInt32(11, this.hasRecivedCount_);
            if ((this.bitField0_ & 0x800) == 2048) output.writeMessage(12, (MessageLite) this.five2FiveMatchTime_);
            if ((this.bitField0_ & 0x1000) == 4096) output.writeInt32(13, this.matchPeople_);
            if ((this.bitField0_ & 0x2000) == 8192) output.writeBytes(14, getSeasonEndTimeBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.firstRankInfo_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.score_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.rank_);
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.win_);
            if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt32Size(7, this.tie_);
            if ((this.bitField0_ & 0x80) == 128) size += CodedOutputStream.computeInt32Size(8, this.fail_);
            if ((this.bitField0_ & 0x100) == 256) size += CodedOutputStream.computeInt32Size(9, this.mvp_);
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt32Size(10, this.totalCanReciveCount_);
            if ((this.bitField0_ & 0x400) == 1024)
                size += CodedOutputStream.computeInt32Size(11, this.hasRecivedCount_);
            if ((this.bitField0_ & 0x800) == 2048)
                size += CodedOutputStream.computeMessageSize(12, (MessageLite) this.five2FiveMatchTime_);
            if ((this.bitField0_ & 0x1000) == 4096) size += CodedOutputStream.computeInt32Size(13, this.matchPeople_);
            if ((this.bitField0_ & 0x2000) == 8192)
                size += CodedOutputStream.computeBytesSize(14, getSeasonEndTimeBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static Five2FiveResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Five2FiveHandler.Five2FiveRankInfo firstRankInfo_;
            private SingleFieldBuilder<Five2FiveHandler.Five2FiveRankInfo, Five2FiveHandler.Five2FiveRankInfo.Builder, Five2FiveHandler.Five2FiveRankInfoOrBuilder> firstRankInfoBuilder_;
            private int score_;
            private int rank_;
            private int win_;
            private int tie_;
            private int fail_;
            private int mvp_;
            private int totalCanReciveCount_;
            private int hasRecivedCount_;
            private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> five2FiveMatchTimeBuilder_;
            private int matchPeople_;
            private Object seasonEndTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.firstRankInfo_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance();
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                this.seasonEndTime_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.firstRankInfo_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance();
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                this.seasonEndTime_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveResponse.alwaysUseFieldBuilders) {
                    getFirstRankInfoFieldBuilder();
                    getFive2FiveMatchTimeFieldBuilder();
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
                if (this.firstRankInfoBuilder_ == null) {
                    this.firstRankInfo_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance();
                } else {
                    this.firstRankInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.rank_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.win_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.tie_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.fail_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.mvp_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.totalCanReciveCount_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.hasRecivedCount_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFF7FF;
                this.matchPeople_ = 0;
                this.bitField0_ &= 0xFFFFEFFF;
                this.seasonEndTime_ = "";
                this.bitField0_ &= 0xFFFFDFFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveResponse build() {
                Five2FiveHandler.Five2FiveResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveResponse buildPartial() {
                Five2FiveHandler.Five2FiveResponse result = new Five2FiveHandler.Five2FiveResponse(this);
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
                if (this.firstRankInfoBuilder_ == null) {
                    result.firstRankInfo_ = this.firstRankInfo_;
                } else {
                    result.firstRankInfo_ = (Five2FiveHandler.Five2FiveRankInfo) this.firstRankInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.score_ = this.score_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.rank_ = this.rank_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.win_ = this.win_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.tie_ = this.tie_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.fail_ = this.fail_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.mvp_ = this.mvp_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x200;
                result.totalCanReciveCount_ = this.totalCanReciveCount_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x400;
                result.hasRecivedCount_ = this.hasRecivedCount_;
                if ((from_bitField0_ & 0x800) == 2048)
                    to_bitField0_ |= 0x800;
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    result.five2FiveMatchTime_ = this.five2FiveMatchTime_;
                } else {
                    result.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.build();
                }
                if ((from_bitField0_ & 0x1000) == 4096)
                    to_bitField0_ |= 0x1000;
                result.matchPeople_ = this.matchPeople_;
                if ((from_bitField0_ & 0x2000) == 8192)
                    to_bitField0_ |= 0x2000;
                result.seasonEndTime_ = this.seasonEndTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveResponse other) {
                if (other == Five2FiveHandler.Five2FiveResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasFirstRankInfo())
                    mergeFirstRankInfo(other.getFirstRankInfo());
                if (other.hasScore())
                    setScore(other.getScore());
                if (other.hasRank())
                    setRank(other.getRank());
                if (other.hasWin())
                    setWin(other.getWin());
                if (other.hasTie())
                    setTie(other.getTie());
                if (other.hasFail())
                    setFail(other.getFail());
                if (other.hasMvp())
                    setMvp(other.getMvp());
                if (other.hasTotalCanReciveCount())
                    setTotalCanReciveCount(other.getTotalCanReciveCount());
                if (other.hasHasRecivedCount())
                    setHasRecivedCount(other.getHasRecivedCount());
                if (other.hasFive2FiveMatchTime())
                    mergeFive2FiveMatchTime(other.getFive2FiveMatchTime());
                if (other.hasMatchPeople())
                    setMatchPeople(other.getMatchPeople());
                if (other.hasSeasonEndTime()) {
                    this.bitField0_ |= 0x2000;
                    this.seasonEndTime_ = other.seasonEndTime_;
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
                Five2FiveHandler.Five2FiveResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveResponse) Five2FiveHandler.Five2FiveResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasFirstRankInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public Five2FiveHandler.Five2FiveRankInfo getFirstRankInfo() {
                if (this.firstRankInfoBuilder_ == null)
                    return this.firstRankInfo_;
                return (Five2FiveHandler.Five2FiveRankInfo) this.firstRankInfoBuilder_.getMessage();
            }

            public Builder setFirstRankInfo(Five2FiveHandler.Five2FiveRankInfo value) {
                if (this.firstRankInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.firstRankInfo_ = value;
                    onChanged();
                } else {
                    this.firstRankInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setFirstRankInfo(Five2FiveHandler.Five2FiveRankInfo.Builder builderForValue) {
                if (this.firstRankInfoBuilder_ == null) {
                    this.firstRankInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.firstRankInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeFirstRankInfo(Five2FiveHandler.Five2FiveRankInfo value) {
                if (this.firstRankInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.firstRankInfo_ != Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance()) {
                        this.firstRankInfo_ = Five2FiveHandler.Five2FiveRankInfo.newBuilder(this.firstRankInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.firstRankInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.firstRankInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearFirstRankInfo() {
                if (this.firstRankInfoBuilder_ == null) {
                    this.firstRankInfo_ = Five2FiveHandler.Five2FiveRankInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.firstRankInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Five2FiveHandler.Five2FiveRankInfo.Builder getFirstRankInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (Five2FiveHandler.Five2FiveRankInfo.Builder) getFirstRankInfoFieldBuilder().getBuilder();
            }

            public Five2FiveHandler.Five2FiveRankInfoOrBuilder getFirstRankInfoOrBuilder() {
                if (this.firstRankInfoBuilder_ != null)
                    return (Five2FiveHandler.Five2FiveRankInfoOrBuilder) this.firstRankInfoBuilder_.getMessageOrBuilder();
                return this.firstRankInfo_;
            }

            private SingleFieldBuilder<Five2FiveHandler.Five2FiveRankInfo, Five2FiveHandler.Five2FiveRankInfo.Builder, Five2FiveHandler.Five2FiveRankInfoOrBuilder> getFirstRankInfoFieldBuilder() {
                if (this.firstRankInfoBuilder_ == null) {
                    this.firstRankInfoBuilder_ = new SingleFieldBuilder(getFirstRankInfo(), getParentForChildren(), isClean());
                    this.firstRankInfo_ = null;
                }
                return this.firstRankInfoBuilder_;
            }

            public boolean hasScore() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.bitField0_ |= 0x8;
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.score_ = 0;
                onChanged();
                return this;
            }

            public boolean hasRank() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getRank() {
                return this.rank_;
            }

            public Builder setRank(int value) {
                this.bitField0_ |= 0x10;
                this.rank_ = value;
                onChanged();
                return this;
            }

            public Builder clearRank() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.rank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasWin() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getWin() {
                return this.win_;
            }

            public Builder setWin(int value) {
                this.bitField0_ |= 0x20;
                this.win_ = value;
                onChanged();
                return this;
            }

            public Builder clearWin() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.win_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTie() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getTie() {
                return this.tie_;
            }

            public Builder setTie(int value) {
                this.bitField0_ |= 0x40;
                this.tie_ = value;
                onChanged();
                return this;
            }

            public Builder clearTie() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.tie_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFail() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getFail() {
                return this.fail_;
            }

            public Builder setFail(int value) {
                this.bitField0_ |= 0x80;
                this.fail_ = value;
                onChanged();
                return this;
            }

            public Builder clearFail() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.fail_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMvp() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getMvp() {
                return this.mvp_;
            }

            public Builder setMvp(int value) {
                this.bitField0_ |= 0x100;
                this.mvp_ = value;
                onChanged();
                return this;
            }

            public Builder clearMvp() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.mvp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTotalCanReciveCount() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getTotalCanReciveCount() {
                return this.totalCanReciveCount_;
            }

            public Builder setTotalCanReciveCount(int value) {
                this.bitField0_ |= 0x200;
                this.totalCanReciveCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalCanReciveCount() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.totalCanReciveCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHasRecivedCount() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public int getHasRecivedCount() {
                return this.hasRecivedCount_;
            }

            public Builder setHasRecivedCount(int value) {
                this.bitField0_ |= 0x400;
                this.hasRecivedCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearHasRecivedCount() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.hasRecivedCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFive2FiveMatchTime() {
                return ((this.bitField0_ & 0x800) == 2048);
            }

            public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null)
                    return this.five2FiveMatchTime_;
                return (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.getMessage();
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.five2FiveMatchTime_ = value;
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime.Builder builderForValue) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = builderForValue.build();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder mergeFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if ((this.bitField0_ & 0x800) == 2048 && this.five2FiveMatchTime_ != Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance()) {
                        this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.newBuilder(this.five2FiveMatchTime_).mergeFrom(value).buildPartial();
                    } else {
                        this.five2FiveMatchTime_ = value;
                    }
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder clearFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFF7FF;
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchTime.Builder getFive2FiveMatchTimeBuilder() {
                this.bitField0_ |= 0x800;
                onChanged();
                return (Five2FiveHandler.Five2FiveMatchTime.Builder) getFive2FiveMatchTimeFieldBuilder().getBuilder();
            }

            public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
                if (this.five2FiveMatchTimeBuilder_ != null)
                    return (Five2FiveHandler.Five2FiveMatchTimeOrBuilder) this.five2FiveMatchTimeBuilder_.getMessageOrBuilder();
                return this.five2FiveMatchTime_;
            }

            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> getFive2FiveMatchTimeFieldBuilder() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTimeBuilder_ = new SingleFieldBuilder(getFive2FiveMatchTime(), getParentForChildren(), isClean());
                    this.five2FiveMatchTime_ = null;
                }
                return this.five2FiveMatchTimeBuilder_;
            }

            public boolean hasMatchPeople() {
                return ((this.bitField0_ & 0x1000) == 4096);
            }

            public int getMatchPeople() {
                return this.matchPeople_;
            }

            public Builder setMatchPeople(int value) {
                this.bitField0_ |= 0x1000;
                this.matchPeople_ = value;
                onChanged();
                return this;
            }

            public Builder clearMatchPeople() {
                this.bitField0_ &= 0xFFFFEFFF;
                this.matchPeople_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSeasonEndTime() {
                return ((this.bitField0_ & 0x2000) == 8192);
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
                this.bitField0_ |= 0x2000;
                this.seasonEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSeasonEndTime() {
                this.bitField0_ &= 0xFFFFDFFF;
                this.seasonEndTime_ = Five2FiveHandler.Five2FiveResponse.getDefaultInstance().getSeasonEndTime();
                onChanged();
                return this;
            }

            public Builder setSeasonEndTimeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2000;
                this.seasonEndTime_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveLookBtlReportRequest extends GeneratedMessage implements Five2FiveLookBtlReportRequestOrBuilder {
        private static final Five2FiveLookBtlReportRequest defaultInstance = new Five2FiveLookBtlReportRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLookBtlReportRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLookBtlReportRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLookBtlReportRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLookBtlReportRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLookBtlReportRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLookBtlReportRequest.class, Builder.class);
        }

        public static Parser<Five2FiveLookBtlReportRequest> PARSER = (Parser<Five2FiveLookBtlReportRequest>) new AbstractParser<Five2FiveLookBtlReportRequest>() {
            public Five2FiveHandler.Five2FiveLookBtlReportRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLookBtlReportRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveLookBtlReportRequest> getParserForType() {
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

        public static Five2FiveLookBtlReportRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLookBtlReportRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLookBtlReportRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveLookBtlReportRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookBtlReportRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLookBtlReportRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLookBtlReportRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLookBtlReportRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveLookBtlReportRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveLookBtlReportRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLookBtlReportRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLookBtlReportRequest build() {
                Five2FiveHandler.Five2FiveLookBtlReportRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLookBtlReportRequest buildPartial() {
                Five2FiveHandler.Five2FiveLookBtlReportRequest result = new Five2FiveHandler.Five2FiveLookBtlReportRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveLookBtlReportRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveLookBtlReportRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLookBtlReportRequest other) {
                if (other == Five2FiveHandler.Five2FiveLookBtlReportRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveLookBtlReportRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookBtlReportRequest) Five2FiveHandler.Five2FiveLookBtlReportRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookBtlReportRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveBtlReport
            extends GeneratedMessage
            implements Five2FiveBtlReportOrBuilder {
        private final UnknownFieldSet unknownFields;


        private Five2FiveBtlReport(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private Five2FiveBtlReport(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static Five2FiveBtlReport getDefaultInstance() {
            return defaultInstance;
        }


        public Five2FiveBtlReport getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private Five2FiveBtlReport(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.status_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.scoreChange_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.killCount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.hurt_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.treatMent_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.createTime_ = bs;
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveBtlReport_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveBtlReport_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveBtlReport.class, Builder.class);
        }


        public static Parser<Five2FiveBtlReport> PARSER = (Parser<Five2FiveBtlReport>) new AbstractParser<Five2FiveBtlReport>() {
            public Five2FiveHandler.Five2FiveBtlReport parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveBtlReport(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int STATUS_FIELD_NUMBER = 1;


        private int status_;


        public static final int SCORECHANGE_FIELD_NUMBER = 2;


        private int scoreChange_;


        public static final int KILLCOUNT_FIELD_NUMBER = 3;


        private int killCount_;


        public static final int HURT_FIELD_NUMBER = 4;


        private int hurt_;


        public static final int TREATMENT_FIELD_NUMBER = 5;


        private int treatMent_;


        public static final int CREATETIME_FIELD_NUMBER = 6;


        private Object createTime_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<Five2FiveBtlReport> getParserForType() {
            return PARSER;
        }


        public boolean hasStatus() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getStatus() {
            return this.status_;
        }


        public boolean hasScoreChange() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getScoreChange() {
            return this.scoreChange_;
        }


        public boolean hasKillCount() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getKillCount() {
            return this.killCount_;
        }


        public boolean hasHurt() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getHurt() {
            return this.hurt_;
        }


        public boolean hasTreatMent() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getTreatMent() {
            return this.treatMent_;
        }


        public boolean hasCreateTime() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public String getCreateTime() {
            Object ref = this.createTime_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.createTime_ = s;
            }
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


        private void initFields() {
            this.status_ = 0;
            this.scoreChange_ = 0;
            this.killCount_ = 0;
            this.hurt_ = 0;
            this.treatMent_ = 0;
            this.createTime_ = "";
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
                output.writeInt32(1, this.status_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.scoreChange_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.killCount_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.hurt_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.treatMent_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getCreateTimeBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.status_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.scoreChange_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.killCount_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.hurt_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.treatMent_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeBytesSize(6, getCreateTimeBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Five2FiveBtlReport parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveBtlReport) PARSER.parseFrom(data);
        }


        private static final Five2FiveBtlReport defaultInstance = new Five2FiveBtlReport(true);

        public static Five2FiveBtlReport parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveBtlReport) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveBtlReport parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveBtlReport) PARSER.parseFrom(data);
        }

        public static Five2FiveBtlReport parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveBtlReport) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveBtlReport parseFrom(InputStream input) throws IOException {
            return (Five2FiveBtlReport) PARSER.parseFrom(input);
        }

        public static Five2FiveBtlReport parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveBtlReport) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveBtlReport parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveBtlReport) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveBtlReport parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveBtlReport) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveBtlReport parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveBtlReport) PARSER.parseFrom(input);
        }

        public static Five2FiveBtlReport parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveBtlReport) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveBtlReport prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveBtlReportOrBuilder {
            private int bitField0_;
            private int status_;
            private int scoreChange_;
            private int killCount_;
            private int hurt_;
            private int treatMent_;
            private Object createTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveBtlReport_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveBtlReport_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveBtlReport.class, Builder.class);
            }

            private Builder() {
                this.createTime_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.createTime_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveBtlReport.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.status_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.scoreChange_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.killCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.hurt_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.treatMent_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.createTime_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveBtlReport_descriptor;
            }

            public Five2FiveHandler.Five2FiveBtlReport getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveBtlReport.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveBtlReport build() {
                Five2FiveHandler.Five2FiveBtlReport result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveBtlReport buildPartial() {
                Five2FiveHandler.Five2FiveBtlReport result = new Five2FiveHandler.Five2FiveBtlReport(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.status_ = this.status_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.scoreChange_ = this.scoreChange_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.killCount_ = this.killCount_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.hurt_ = this.hurt_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.treatMent_ = this.treatMent_;
                if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;
                result.createTime_ = this.createTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveBtlReport)
                    return mergeFrom((Five2FiveHandler.Five2FiveBtlReport) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveBtlReport other) {
                if (other == Five2FiveHandler.Five2FiveBtlReport.getDefaultInstance()) return this;
                if (other.hasStatus()) setStatus(other.getStatus());
                if (other.hasScoreChange()) setScoreChange(other.getScoreChange());
                if (other.hasKillCount()) setKillCount(other.getKillCount());
                if (other.hasHurt()) setHurt(other.getHurt());
                if (other.hasTreatMent()) setTreatMent(other.getTreatMent());
                if (other.hasCreateTime()) {
                    this.bitField0_ |= 0x20;
                    this.createTime_ = other.createTime_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveBtlReport parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveBtlReport) Five2FiveHandler.Five2FiveBtlReport.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveBtlReport) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasStatus() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int value) {
                this.bitField0_ |= 0x1;
                this.status_ = value;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.status_ = 0;
                onChanged();
                return this;
            }

            public boolean hasScoreChange() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getScoreChange() {
                return this.scoreChange_;
            }

            public Builder setScoreChange(int value) {
                this.bitField0_ |= 0x2;
                this.scoreChange_ = value;
                onChanged();
                return this;
            }

            public Builder clearScoreChange() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.scoreChange_ = 0;
                onChanged();
                return this;
            }

            public boolean hasKillCount() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getKillCount() {
                return this.killCount_;
            }

            public Builder setKillCount(int value) {
                this.bitField0_ |= 0x4;
                this.killCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillCount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.killCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHurt() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getHurt() {
                return this.hurt_;
            }

            public Builder setHurt(int value) {
                this.bitField0_ |= 0x8;
                this.hurt_ = value;
                onChanged();
                return this;
            }

            public Builder clearHurt() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.hurt_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTreatMent() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getTreatMent() {
                return this.treatMent_;
            }

            public Builder setTreatMent(int value) {
                this.bitField0_ |= 0x10;
                this.treatMent_ = value;
                onChanged();
                return this;
            }

            public Builder clearTreatMent() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.treatMent_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCreateTime() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getCreateTime() {
                Object ref = this.createTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.createTime_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.createTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCreateTime() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.createTime_ = Five2FiveHandler.Five2FiveBtlReport.getDefaultInstance().getCreateTime();
                onChanged();
                return this;
            }

            public Builder setCreateTimeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.createTime_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveLookBtlReportResponse
            extends GeneratedMessage
            implements Five2FiveLookBtlReportResponseOrBuilder {
        private static final Five2FiveLookBtlReportResponse defaultInstance = new Five2FiveLookBtlReportResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLookBtlReportResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLookBtlReportResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLookBtlReportResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLookBtlReportResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLookBtlReportResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.br_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.br_.add(input.readMessage(Five2FiveHandler.Five2FiveBtlReport.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.br_ = Collections.unmodifiableList(this.br_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLookBtlReportResponse.class, Builder.class);
        }

        public static Parser<Five2FiveLookBtlReportResponse> PARSER = (Parser<Five2FiveLookBtlReportResponse>) new AbstractParser<Five2FiveLookBtlReportResponse>() {
            public Five2FiveHandler.Five2FiveLookBtlReportResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLookBtlReportResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int BR_FIELD_NUMBER = 3;
        private List<Five2FiveHandler.Five2FiveBtlReport> br_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveLookBtlReportResponse> getParserForType() {
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

        public List<Five2FiveHandler.Five2FiveBtlReport> getBrList() {
            return this.br_;
        }

        public List<? extends Five2FiveHandler.Five2FiveBtlReportOrBuilder> getBrOrBuilderList() {
            return (List) this.br_;
        }

        public int getBrCount() {
            return this.br_.size();
        }

        public Five2FiveHandler.Five2FiveBtlReport getBr(int index) {
            return this.br_.get(index);
        }

        public Five2FiveHandler.Five2FiveBtlReportOrBuilder getBrOrBuilder(int index) {
            return this.br_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.br_ = Collections.emptyList();
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
            for (int i = 0; i < this.br_.size(); i++)
                output.writeMessage(3, (MessageLite) this.br_.get(i));
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
            for (int i = 0; i < this.br_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.br_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveLookBtlReportResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLookBtlReportResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLookBtlReportResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveLookBtlReportResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookBtlReportResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLookBtlReportResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLookBtlReportResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<Five2FiveHandler.Five2FiveBtlReport> br_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveBtlReport, Five2FiveHandler.Five2FiveBtlReport.Builder, Five2FiveHandler.Five2FiveBtlReportOrBuilder> brBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLookBtlReportResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.br_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.br_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveLookBtlReportResponse.alwaysUseFieldBuilders)
                    getBrFieldBuilder();
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
                if (this.brBuilder_ == null) {
                    this.br_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.brBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveLookBtlReportResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLookBtlReportResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLookBtlReportResponse build() {
                Five2FiveHandler.Five2FiveLookBtlReportResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLookBtlReportResponse buildPartial() {
                Five2FiveHandler.Five2FiveLookBtlReportResponse result = new Five2FiveHandler.Five2FiveLookBtlReportResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.brBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.br_ = Collections.unmodifiableList(this.br_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.br_ = this.br_;
                } else {
                    result.br_ = this.brBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveLookBtlReportResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveLookBtlReportResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLookBtlReportResponse other) {
                if (other == Five2FiveHandler.Five2FiveLookBtlReportResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.brBuilder_ == null) {
                    if (!other.br_.isEmpty()) {
                        if (this.br_.isEmpty()) {
                            this.br_ = other.br_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureBrIsMutable();
                            this.br_.addAll(other.br_);
                        }
                        onChanged();
                    }
                } else if (!other.br_.isEmpty()) {
                    if (this.brBuilder_.isEmpty()) {
                        this.brBuilder_.dispose();
                        this.brBuilder_ = null;
                        this.br_ = other.br_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.brBuilder_ = Five2FiveHandler.Five2FiveLookBtlReportResponse.alwaysUseFieldBuilders ? getBrFieldBuilder() : null;
                    } else {
                        this.brBuilder_.addAllMessages(other.br_);
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
                Five2FiveHandler.Five2FiveLookBtlReportResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookBtlReportResponse) Five2FiveHandler.Five2FiveLookBtlReportResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookBtlReportResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveLookBtlReportResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureBrIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.br_ = new ArrayList<>(this.br_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Five2FiveHandler.Five2FiveBtlReport> getBrList() {
                if (this.brBuilder_ == null)
                    return Collections.unmodifiableList(this.br_);
                return this.brBuilder_.getMessageList();
            }

            public int getBrCount() {
                if (this.brBuilder_ == null)
                    return this.br_.size();
                return this.brBuilder_.getCount();
            }

            public Five2FiveHandler.Five2FiveBtlReport getBr(int index) {
                if (this.brBuilder_ == null)
                    return this.br_.get(index);
                return (Five2FiveHandler.Five2FiveBtlReport) this.brBuilder_.getMessage(index);
            }

            public Builder setBr(int index, Five2FiveHandler.Five2FiveBtlReport value) {
                if (this.brBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureBrIsMutable();
                    this.br_.set(index, value);
                    onChanged();
                } else {
                    this.brBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setBr(int index, Five2FiveHandler.Five2FiveBtlReport.Builder builderForValue) {
                if (this.brBuilder_ == null) {
                    ensureBrIsMutable();
                    this.br_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.brBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBr(Five2FiveHandler.Five2FiveBtlReport value) {
                if (this.brBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureBrIsMutable();
                    this.br_.add(value);
                    onChanged();
                } else {
                    this.brBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addBr(int index, Five2FiveHandler.Five2FiveBtlReport value) {
                if (this.brBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureBrIsMutable();
                    this.br_.add(index, value);
                    onChanged();
                } else {
                    this.brBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addBr(Five2FiveHandler.Five2FiveBtlReport.Builder builderForValue) {
                if (this.brBuilder_ == null) {
                    ensureBrIsMutable();
                    this.br_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.brBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBr(int index, Five2FiveHandler.Five2FiveBtlReport.Builder builderForValue) {
                if (this.brBuilder_ == null) {
                    ensureBrIsMutable();
                    this.br_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.brBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBr(Iterable<? extends Five2FiveHandler.Five2FiveBtlReport> values) {
                if (this.brBuilder_ == null) {
                    ensureBrIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.br_);
                    onChanged();
                } else {
                    this.brBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBr() {
                if (this.brBuilder_ == null) {
                    this.br_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.brBuilder_.clear();
                }
                return this;
            }

            public Builder removeBr(int index) {
                if (this.brBuilder_ == null) {
                    ensureBrIsMutable();
                    this.br_.remove(index);
                    onChanged();
                } else {
                    this.brBuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FiveBtlReport.Builder getBrBuilder(int index) {
                return (Five2FiveHandler.Five2FiveBtlReport.Builder) getBrFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FiveBtlReportOrBuilder getBrOrBuilder(int index) {
                if (this.brBuilder_ == null)
                    return this.br_.get(index);
                return (Five2FiveHandler.Five2FiveBtlReportOrBuilder) this.brBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FiveBtlReportOrBuilder> getBrOrBuilderList() {
                if (this.brBuilder_ != null)
                    return this.brBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.br_);
            }

            public Five2FiveHandler.Five2FiveBtlReport.Builder addBrBuilder() {
                return (Five2FiveHandler.Five2FiveBtlReport.Builder) getBrFieldBuilder().addBuilder(Five2FiveHandler.Five2FiveBtlReport.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FiveBtlReport.Builder addBrBuilder(int index) {
                return (Five2FiveHandler.Five2FiveBtlReport.Builder) getBrFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FiveBtlReport.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FiveBtlReport.Builder> getBrBuilderList() {
                return getBrFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveBtlReport, Five2FiveHandler.Five2FiveBtlReport.Builder, Five2FiveHandler.Five2FiveBtlReportOrBuilder> getBrFieldBuilder() {
                if (this.brBuilder_ == null) {
                    this.brBuilder_ = new RepeatedFieldBuilder(this.br_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.br_ = null;
                }
                return this.brBuilder_;
            }
        }
    }

    public static final class Five2FiveMatchRequest extends GeneratedMessage implements Five2FiveMatchRequestOrBuilder {
        private static final Five2FiveMatchRequest defaultInstance = new Five2FiveMatchRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.matchOrReMatch_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchRequest.class, Builder.class);
        }

        public static Parser<Five2FiveMatchRequest> PARSER = (Parser<Five2FiveMatchRequest>) new AbstractParser<Five2FiveMatchRequest>() {
            public Five2FiveHandler.Five2FiveMatchRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int MATCHORREMATCH_FIELD_NUMBER = 1;
        private int matchOrReMatch_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasMatchOrReMatch() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getMatchOrReMatch() {
            return this.matchOrReMatch_;
        }

        private void initFields() {
            this.matchOrReMatch_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasMatchOrReMatch()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.matchOrReMatch_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.matchOrReMatch_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveMatchRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveMatchRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveMatchRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveMatchRequestOrBuilder {
            private int bitField0_;
            private int matchOrReMatch_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.matchOrReMatch_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveMatchRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveMatchRequest build() {
                Five2FiveHandler.Five2FiveMatchRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveMatchRequest buildPartial() {
                Five2FiveHandler.Five2FiveMatchRequest result = new Five2FiveHandler.Five2FiveMatchRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.matchOrReMatch_ = this.matchOrReMatch_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchRequest other) {
                if (other == Five2FiveHandler.Five2FiveMatchRequest.getDefaultInstance()) return this;
                if (other.hasMatchOrReMatch()) setMatchOrReMatch(other.getMatchOrReMatch());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasMatchOrReMatch()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchRequest) Five2FiveHandler.Five2FiveMatchRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasMatchOrReMatch() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getMatchOrReMatch() {
                return this.matchOrReMatch_;
            }

            public Builder setMatchOrReMatch(int value) {
                this.bitField0_ |= 0x1;
                this.matchOrReMatch_ = value;
                onChanged();
                return this;
            }

            public Builder clearMatchOrReMatch() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.matchOrReMatch_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class Five2FiveMatchResponse
            extends GeneratedMessage
            implements Five2FiveMatchResponseOrBuilder {
        private static final Five2FiveMatchResponse defaultInstance = new Five2FiveMatchResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    Five2FiveHandler.Five2FiveMatchTime.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.five2FiveMatchTime_.toBuilder();
                            this.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) input.readMessage(Five2FiveHandler.Five2FiveMatchTime.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.five2FiveMatchTime_);
                                this.five2FiveMatchTime_ = subBuilder.buildPartial();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchResponse.class, Builder.class);
        }

        public static Parser<Five2FiveMatchResponse> PARSER = (Parser<Five2FiveMatchResponse>) new AbstractParser<Five2FiveMatchResponse>() {
            public Five2FiveHandler.Five2FiveMatchResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int FIVE2FIVEMATCHTIME_FIELD_NUMBER = 3;
        private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchResponse> getParserForType() {
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

        public boolean hasFive2FiveMatchTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
            return this.five2FiveMatchTime_;
        }

        public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
            return this.five2FiveMatchTime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
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
                output.writeMessage(3, (MessageLite) this.five2FiveMatchTime_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.five2FiveMatchTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveMatchResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveMatchResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveMatchResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveMatchResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> five2FiveMatchTimeBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchResponse.alwaysUseFieldBuilders)
                    getFive2FiveMatchTimeFieldBuilder();
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
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveMatchResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveMatchResponse build() {
                Five2FiveHandler.Five2FiveMatchResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveMatchResponse buildPartial() {
                Five2FiveHandler.Five2FiveMatchResponse result = new Five2FiveHandler.Five2FiveMatchResponse(this);
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
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    result.five2FiveMatchTime_ = this.five2FiveMatchTime_;
                } else {
                    result.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchResponse other) {
                if (other == Five2FiveHandler.Five2FiveMatchResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasFive2FiveMatchTime())
                    mergeFive2FiveMatchTime(other.getFive2FiveMatchTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchResponse) Five2FiveHandler.Five2FiveMatchResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveMatchResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasFive2FiveMatchTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null)
                    return this.five2FiveMatchTime_;
                return (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.getMessage();
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.five2FiveMatchTime_ = value;
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime.Builder builderForValue) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = builderForValue.build();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.five2FiveMatchTime_ != Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance()) {
                        this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.newBuilder(this.five2FiveMatchTime_).mergeFrom(value).buildPartial();
                    } else {
                        this.five2FiveMatchTime_ = value;
                    }
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchTime.Builder getFive2FiveMatchTimeBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (Five2FiveHandler.Five2FiveMatchTime.Builder) getFive2FiveMatchTimeFieldBuilder().getBuilder();
            }

            public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
                if (this.five2FiveMatchTimeBuilder_ != null)
                    return (Five2FiveHandler.Five2FiveMatchTimeOrBuilder) this.five2FiveMatchTimeBuilder_.getMessageOrBuilder();
                return this.five2FiveMatchTime_;
            }

            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> getFive2FiveMatchTimeFieldBuilder() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTimeBuilder_ = new SingleFieldBuilder(getFive2FiveMatchTime(), getParentForChildren(), isClean());
                    this.five2FiveMatchTime_ = null;
                }
                return this.five2FiveMatchTimeBuilder_;
            }
        }
    }

    public static final class Five2FiveRefuseMatchRequest extends GeneratedMessage implements Five2FiveRefuseMatchRequestOrBuilder {
        private static final Five2FiveRefuseMatchRequest defaultInstance = new Five2FiveRefuseMatchRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveRefuseMatchRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveRefuseMatchRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveRefuseMatchRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveRefuseMatchRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveRefuseMatchRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveRefuseMatchRequest.class, Builder.class);
        }

        public static Parser<Five2FiveRefuseMatchRequest> PARSER = (Parser<Five2FiveRefuseMatchRequest>) new AbstractParser<Five2FiveRefuseMatchRequest>() {
            public Five2FiveHandler.Five2FiveRefuseMatchRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveRefuseMatchRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveRefuseMatchRequest> getParserForType() {
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

        public static Five2FiveRefuseMatchRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveRefuseMatchRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveRefuseMatchRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveRefuseMatchRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRefuseMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveRefuseMatchRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveRefuseMatchRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveRefuseMatchRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveRefuseMatchRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveRefuseMatchRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveRefuseMatchRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveRefuseMatchRequest build() {
                Five2FiveHandler.Five2FiveRefuseMatchRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveRefuseMatchRequest buildPartial() {
                Five2FiveHandler.Five2FiveRefuseMatchRequest result = new Five2FiveHandler.Five2FiveRefuseMatchRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveRefuseMatchRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveRefuseMatchRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveRefuseMatchRequest other) {
                if (other == Five2FiveHandler.Five2FiveRefuseMatchRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveRefuseMatchRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveRefuseMatchRequest) Five2FiveHandler.Five2FiveRefuseMatchRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveRefuseMatchRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveRefuseMatchResponse
            extends GeneratedMessage
            implements Five2FiveRefuseMatchResponseOrBuilder {
        private static final Five2FiveRefuseMatchResponse defaultInstance = new Five2FiveRefuseMatchResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveRefuseMatchResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveRefuseMatchResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveRefuseMatchResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveRefuseMatchResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveRefuseMatchResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveRefuseMatchResponse.class, Builder.class);
        }

        public static Parser<Five2FiveRefuseMatchResponse> PARSER = (Parser<Five2FiveRefuseMatchResponse>) new AbstractParser<Five2FiveRefuseMatchResponse>() {
            public Five2FiveHandler.Five2FiveRefuseMatchResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveRefuseMatchResponse(input, extensionRegistry);
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

        public Parser<Five2FiveRefuseMatchResponse> getParserForType() {
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

        public static Five2FiveRefuseMatchResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveRefuseMatchResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveRefuseMatchResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveRefuseMatchResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveRefuseMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveRefuseMatchResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveRefuseMatchResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveRefuseMatchResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveRefuseMatchResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveRefuseMatchResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveRefuseMatchResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveRefuseMatchResponse build() {
                Five2FiveHandler.Five2FiveRefuseMatchResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveRefuseMatchResponse buildPartial() {
                Five2FiveHandler.Five2FiveRefuseMatchResponse result = new Five2FiveHandler.Five2FiveRefuseMatchResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveRefuseMatchResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveRefuseMatchResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveRefuseMatchResponse other) {
                if (other == Five2FiveHandler.Five2FiveRefuseMatchResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveRefuseMatchResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveRefuseMatchResponse) Five2FiveHandler.Five2FiveRefuseMatchResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveRefuseMatchResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveRefuseMatchResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FiveAgreeMatchRequest
            extends GeneratedMessage
            implements Five2FiveAgreeMatchRequestOrBuilder {
        private static final Five2FiveAgreeMatchRequest defaultInstance = new Five2FiveAgreeMatchRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveAgreeMatchRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveAgreeMatchRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveAgreeMatchRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveAgreeMatchRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveAgreeMatchRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveAgreeMatchRequest.class, Builder.class);
        }

        public static Parser<Five2FiveAgreeMatchRequest> PARSER = (Parser<Five2FiveAgreeMatchRequest>) new AbstractParser<Five2FiveAgreeMatchRequest>() {
            public Five2FiveHandler.Five2FiveAgreeMatchRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveAgreeMatchRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveAgreeMatchRequest> getParserForType() {
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

        public static Five2FiveAgreeMatchRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveAgreeMatchRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveAgreeMatchRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveAgreeMatchRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveAgreeMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveAgreeMatchRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveAgreeMatchRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveAgreeMatchRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveAgreeMatchRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveAgreeMatchRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveAgreeMatchRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveAgreeMatchRequest build() {
                Five2FiveHandler.Five2FiveAgreeMatchRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveAgreeMatchRequest buildPartial() {
                Five2FiveHandler.Five2FiveAgreeMatchRequest result = new Five2FiveHandler.Five2FiveAgreeMatchRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveAgreeMatchRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveAgreeMatchRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveAgreeMatchRequest other) {
                if (other == Five2FiveHandler.Five2FiveAgreeMatchRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveAgreeMatchRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveAgreeMatchRequest) Five2FiveHandler.Five2FiveAgreeMatchRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveAgreeMatchRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveAgreeMatchResponse
            extends GeneratedMessage
            implements Five2FiveAgreeMatchResponseOrBuilder {
        private static final Five2FiveAgreeMatchResponse defaultInstance = new Five2FiveAgreeMatchResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveAgreeMatchResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveAgreeMatchResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveAgreeMatchResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveAgreeMatchResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveAgreeMatchResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveAgreeMatchResponse.class, Builder.class);
        }

        public static Parser<Five2FiveAgreeMatchResponse> PARSER = (Parser<Five2FiveAgreeMatchResponse>) new AbstractParser<Five2FiveAgreeMatchResponse>() {
            public Five2FiveHandler.Five2FiveAgreeMatchResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveAgreeMatchResponse(input, extensionRegistry);
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

        public Parser<Five2FiveAgreeMatchResponse> getParserForType() {
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

        public static Five2FiveAgreeMatchResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveAgreeMatchResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveAgreeMatchResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveAgreeMatchResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveAgreeMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveAgreeMatchResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveAgreeMatchResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveAgreeMatchResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveAgreeMatchResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveAgreeMatchResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveAgreeMatchResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveAgreeMatchResponse build() {
                Five2FiveHandler.Five2FiveAgreeMatchResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveAgreeMatchResponse buildPartial() {
                Five2FiveHandler.Five2FiveAgreeMatchResponse result = new Five2FiveHandler.Five2FiveAgreeMatchResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveAgreeMatchResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveAgreeMatchResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveAgreeMatchResponse other) {
                if (other == Five2FiveHandler.Five2FiveAgreeMatchResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveAgreeMatchResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveAgreeMatchResponse) Five2FiveHandler.Five2FiveAgreeMatchResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveAgreeMatchResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveAgreeMatchResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FiveCancelMatchRequest
            extends GeneratedMessage
            implements Five2FiveCancelMatchRequestOrBuilder {
        private static final Five2FiveCancelMatchRequest defaultInstance = new Five2FiveCancelMatchRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveCancelMatchRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveCancelMatchRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveCancelMatchRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveCancelMatchRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveCancelMatchRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveCancelMatchRequest.class, Builder.class);
        }

        public static Parser<Five2FiveCancelMatchRequest> PARSER = (Parser<Five2FiveCancelMatchRequest>) new AbstractParser<Five2FiveCancelMatchRequest>() {
            public Five2FiveHandler.Five2FiveCancelMatchRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveCancelMatchRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveCancelMatchRequest> getParserForType() {
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

        public static Five2FiveCancelMatchRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveCancelMatchRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveCancelMatchRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveCancelMatchRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveCancelMatchRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveCancelMatchRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveCancelMatchRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveCancelMatchRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveCancelMatchRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveCancelMatchRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveCancelMatchRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveCancelMatchRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveCancelMatchRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveCancelMatchRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveCancelMatchRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveCancelMatchRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveCancelMatchRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveCancelMatchRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveCancelMatchRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveCancelMatchRequest build() {
                Five2FiveHandler.Five2FiveCancelMatchRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveCancelMatchRequest buildPartial() {
                Five2FiveHandler.Five2FiveCancelMatchRequest result = new Five2FiveHandler.Five2FiveCancelMatchRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveCancelMatchRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveCancelMatchRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveCancelMatchRequest other) {
                if (other == Five2FiveHandler.Five2FiveCancelMatchRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveCancelMatchRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveCancelMatchRequest) Five2FiveHandler.Five2FiveCancelMatchRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveCancelMatchRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveCancelMatchResponse
            extends GeneratedMessage
            implements Five2FiveCancelMatchResponseOrBuilder {
        private static final Five2FiveCancelMatchResponse defaultInstance = new Five2FiveCancelMatchResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveCancelMatchResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveCancelMatchResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveCancelMatchResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveCancelMatchResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveCancelMatchResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveCancelMatchResponse.class, Builder.class);
        }

        public static Parser<Five2FiveCancelMatchResponse> PARSER = (Parser<Five2FiveCancelMatchResponse>) new AbstractParser<Five2FiveCancelMatchResponse>() {
            public Five2FiveHandler.Five2FiveCancelMatchResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveCancelMatchResponse(input, extensionRegistry);
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

        public Parser<Five2FiveCancelMatchResponse> getParserForType() {
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

        public static Five2FiveCancelMatchResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveCancelMatchResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveCancelMatchResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveCancelMatchResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveCancelMatchResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveCancelMatchResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveCancelMatchResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveCancelMatchResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveCancelMatchResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveCancelMatchResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveCancelMatchResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveCancelMatchResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveCancelMatchResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveCancelMatchResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveCancelMatchResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveCancelMatchResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveCancelMatchResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveCancelMatchResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveCancelMatchResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveCancelMatchResponse build() {
                Five2FiveHandler.Five2FiveCancelMatchResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveCancelMatchResponse buildPartial() {
                Five2FiveHandler.Five2FiveCancelMatchResponse result = new Five2FiveHandler.Five2FiveCancelMatchResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveCancelMatchResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveCancelMatchResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveCancelMatchResponse other) {
                if (other == Five2FiveHandler.Five2FiveCancelMatchResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveCancelMatchResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveCancelMatchResponse) Five2FiveHandler.Five2FiveCancelMatchResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveCancelMatchResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveCancelMatchResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FiveReadyRequest
            extends GeneratedMessage
            implements Five2FiveReadyRequestOrBuilder {
        private static final Five2FiveReadyRequest defaultInstance = new Five2FiveReadyRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveReadyRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveReadyRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveReadyRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveReadyRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveReadyRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.tempTeamId_ = bs;
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveReadyRequest.class, Builder.class);
        }

        public static Parser<Five2FiveReadyRequest> PARSER = (Parser<Five2FiveReadyRequest>) new AbstractParser<Five2FiveReadyRequest>() {
            public Five2FiveHandler.Five2FiveReadyRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveReadyRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TEMPTEAMID_FIELD_NUMBER = 1;
        private Object tempTeamId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveReadyRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasTempTeamId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getTempTeamId() {
            Object ref = this.tempTeamId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.tempTeamId_ = s;
            return s;
        }

        public ByteString getTempTeamIdBytes() {
            Object ref = this.tempTeamId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.tempTeamId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.tempTeamId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasTempTeamId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getTempTeamIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getTempTeamIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveReadyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveReadyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReadyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveReadyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReadyRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveReadyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveReadyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveReadyRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveReadyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReadyRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveReadyRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveReadyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReadyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveReadyRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveReadyRequestOrBuilder {
            private int bitField0_;
            private Object tempTeamId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveReadyRequest.class, Builder.class);
            }

            private Builder() {
                this.tempTeamId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.tempTeamId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveReadyRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.tempTeamId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveReadyRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveReadyRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveReadyRequest build() {
                Five2FiveHandler.Five2FiveReadyRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveReadyRequest buildPartial() {
                Five2FiveHandler.Five2FiveReadyRequest result = new Five2FiveHandler.Five2FiveReadyRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.tempTeamId_ = this.tempTeamId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveReadyRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveReadyRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveReadyRequest other) {
                if (other == Five2FiveHandler.Five2FiveReadyRequest.getDefaultInstance()) return this;
                if (other.hasTempTeamId()) {
                    this.bitField0_ |= 0x1;
                    this.tempTeamId_ = other.tempTeamId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTempTeamId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveReadyRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveReadyRequest) Five2FiveHandler.Five2FiveReadyRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveReadyRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTempTeamId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getTempTeamId() {
                Object ref = this.tempTeamId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.tempTeamId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTempTeamIdBytes() {
                Object ref = this.tempTeamId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.tempTeamId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTempTeamId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.tempTeamId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTempTeamId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.tempTeamId_ = Five2FiveHandler.Five2FiveReadyRequest.getDefaultInstance().getTempTeamId();
                onChanged();
                return this;
            }

            public Builder setTempTeamIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.tempTeamId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveReadyResponse
            extends GeneratedMessage
            implements Five2FiveReadyResponseOrBuilder {
        private static final Five2FiveReadyResponse defaultInstance = new Five2FiveReadyResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveReadyResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveReadyResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveReadyResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveReadyResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveReadyResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveReadyResponse.class, Builder.class);
        }

        public static Parser<Five2FiveReadyResponse> PARSER = (Parser<Five2FiveReadyResponse>) new AbstractParser<Five2FiveReadyResponse>() {
            public Five2FiveHandler.Five2FiveReadyResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveReadyResponse(input, extensionRegistry);
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

        public Parser<Five2FiveReadyResponse> getParserForType() {
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

        public static Five2FiveReadyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveReadyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReadyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveReadyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReadyResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveReadyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveReadyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveReadyResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveReadyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReadyResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveReadyResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveReadyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReadyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveReadyResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveReadyResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveReadyResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveReadyResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReadyResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveReadyResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveReadyResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveReadyResponse build() {
                Five2FiveHandler.Five2FiveReadyResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveReadyResponse buildPartial() {
                Five2FiveHandler.Five2FiveReadyResponse result = new Five2FiveHandler.Five2FiveReadyResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveReadyResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveReadyResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveReadyResponse other) {
                if (other == Five2FiveHandler.Five2FiveReadyResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveReadyResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveReadyResponse) Five2FiveHandler.Five2FiveReadyResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveReadyResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveReadyResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FiveReciveRewardRequest
            extends GeneratedMessage
            implements Five2FiveReciveRewardRequestOrBuilder {
        private static final Five2FiveReciveRewardRequest defaultInstance = new Five2FiveReciveRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveReciveRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveReciveRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveReciveRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveReciveRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveReciveRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveReciveRewardRequest.class, Builder.class);
        }

        public static Parser<Five2FiveReciveRewardRequest> PARSER = (Parser<Five2FiveReciveRewardRequest>) new AbstractParser<Five2FiveReciveRewardRequest>() {
            public Five2FiveHandler.Five2FiveReciveRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveReciveRewardRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveReciveRewardRequest> getParserForType() {
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

        public static Five2FiveReciveRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveReciveRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReciveRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveReciveRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReciveRewardRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveReciveRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveReciveRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveReciveRewardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveReciveRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReciveRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveReciveRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveReciveRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReciveRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveReciveRewardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveReciveRewardRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveReciveRewardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveReciveRewardRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveReciveRewardRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveReciveRewardRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveReciveRewardRequest build() {
                Five2FiveHandler.Five2FiveReciveRewardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveReciveRewardRequest buildPartial() {
                Five2FiveHandler.Five2FiveReciveRewardRequest result = new Five2FiveHandler.Five2FiveReciveRewardRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveReciveRewardRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveReciveRewardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveReciveRewardRequest other) {
                if (other == Five2FiveHandler.Five2FiveReciveRewardRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveReciveRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveReciveRewardRequest) Five2FiveHandler.Five2FiveReciveRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveReciveRewardRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveReciveRewardResponse
            extends GeneratedMessage
            implements Five2FiveReciveRewardResponseOrBuilder {
        private static final Five2FiveReciveRewardResponse defaultInstance = new Five2FiveReciveRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveReciveRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveReciveRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveReciveRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveReciveRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveReciveRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveReciveRewardResponse.class, Builder.class);
        }

        public static Parser<Five2FiveReciveRewardResponse> PARSER = (Parser<Five2FiveReciveRewardResponse>) new AbstractParser<Five2FiveReciveRewardResponse>() {
            public Five2FiveHandler.Five2FiveReciveRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveReciveRewardResponse(input, extensionRegistry);
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

        public Parser<Five2FiveReciveRewardResponse> getParserForType() {
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

        public static Five2FiveReciveRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveReciveRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReciveRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveReciveRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveReciveRewardResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveReciveRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveReciveRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveReciveRewardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveReciveRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReciveRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveReciveRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveReciveRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveReciveRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveReciveRewardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveReciveRewardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveReciveRewardResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveReciveRewardResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveReciveRewardResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveReciveRewardResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveReciveRewardResponse build() {
                Five2FiveHandler.Five2FiveReciveRewardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveReciveRewardResponse buildPartial() {
                Five2FiveHandler.Five2FiveReciveRewardResponse result = new Five2FiveHandler.Five2FiveReciveRewardResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveReciveRewardResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveReciveRewardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveReciveRewardResponse other) {
                if (other == Five2FiveHandler.Five2FiveReciveRewardResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveReciveRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveReciveRewardResponse) Five2FiveHandler.Five2FiveReciveRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveReciveRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveReciveRewardResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FiveLeaveAreaRequest
            extends GeneratedMessage
            implements Five2FiveLeaveAreaRequestOrBuilder {
        private static final Five2FiveLeaveAreaRequest defaultInstance = new Five2FiveLeaveAreaRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLeaveAreaRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLeaveAreaRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLeaveAreaRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLeaveAreaRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLeaveAreaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLeaveAreaRequest.class, Builder.class);
        }

        public static Parser<Five2FiveLeaveAreaRequest> PARSER = (Parser<Five2FiveLeaveAreaRequest>) new AbstractParser<Five2FiveLeaveAreaRequest>() {
            public Five2FiveHandler.Five2FiveLeaveAreaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLeaveAreaRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveLeaveAreaRequest> getParserForType() {
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

        public static Five2FiveLeaveAreaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLeaveAreaRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLeaveAreaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveLeaveAreaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaveAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLeaveAreaRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLeaveAreaRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLeaveAreaRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveLeaveAreaRequest.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveLeaveAreaRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLeaveAreaRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLeaveAreaRequest build() {
                Five2FiveHandler.Five2FiveLeaveAreaRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLeaveAreaRequest buildPartial() {
                Five2FiveHandler.Five2FiveLeaveAreaRequest result = new Five2FiveHandler.Five2FiveLeaveAreaRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveLeaveAreaRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveLeaveAreaRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLeaveAreaRequest other) {
                if (other == Five2FiveHandler.Five2FiveLeaveAreaRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveLeaveAreaRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLeaveAreaRequest) Five2FiveHandler.Five2FiveLeaveAreaRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLeaveAreaRequest) e.getUnfinishedMessage();
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


    public static final class Five2FiveLeaveAreaResponse
            extends GeneratedMessage
            implements Five2FiveLeaveAreaResponseOrBuilder {
        private static final Five2FiveLeaveAreaResponse defaultInstance = new Five2FiveLeaveAreaResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLeaveAreaResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLeaveAreaResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLeaveAreaResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLeaveAreaResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLeaveAreaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLeaveAreaResponse.class, Builder.class);
        }

        public static Parser<Five2FiveLeaveAreaResponse> PARSER = (Parser<Five2FiveLeaveAreaResponse>) new AbstractParser<Five2FiveLeaveAreaResponse>() {
            public Five2FiveHandler.Five2FiveLeaveAreaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLeaveAreaResponse(input, extensionRegistry);
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

        public Parser<Five2FiveLeaveAreaResponse> getParserForType() {
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

        public static Five2FiveLeaveAreaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLeaveAreaResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLeaveAreaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveLeaveAreaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaveAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLeaveAreaResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLeaveAreaResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLeaveAreaResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveLeaveAreaResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveLeaveAreaResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLeaveAreaResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLeaveAreaResponse build() {
                Five2FiveHandler.Five2FiveLeaveAreaResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLeaveAreaResponse buildPartial() {
                Five2FiveHandler.Five2FiveLeaveAreaResponse result = new Five2FiveHandler.Five2FiveLeaveAreaResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveLeaveAreaResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveLeaveAreaResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLeaveAreaResponse other) {
                if (other == Five2FiveHandler.Five2FiveLeaveAreaResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveLeaveAreaResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLeaveAreaResponse) Five2FiveHandler.Five2FiveLeaveAreaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLeaveAreaResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveLeaveAreaResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FivePlayerResultInfo
            extends GeneratedMessage
            implements Five2FivePlayerResultInfoOrBuilder {
        private static final Five2FivePlayerResultInfo defaultInstance = new Five2FivePlayerResultInfo(true);
        private final UnknownFieldSet unknownFields;

        private Five2FivePlayerResultInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FivePlayerResultInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FivePlayerResultInfo getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FivePlayerResultInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FivePlayerResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.killCount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.hurt_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x8;
                            this.treatMent_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x10;
                            this.isMvp_ = input.readInt32();
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.playerName_ = bs;
                            break;
                        case 64:
                            this.bitField0_ |= 0x40;
                            this.playerLevel_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x80;
                            this.playerPro_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x100;
                            this.deadCount_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FivePlayerResultInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FivePlayerResultInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FivePlayerResultInfo.class, Builder.class);
        }

        public static Parser<Five2FivePlayerResultInfo> PARSER = (Parser<Five2FivePlayerResultInfo>) new AbstractParser<Five2FivePlayerResultInfo>() {
            public Five2FiveHandler.Five2FivePlayerResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FivePlayerResultInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        public static final int KILLCOUNT_FIELD_NUMBER = 3;
        private int killCount_;
        public static final int HURT_FIELD_NUMBER = 4;
        private int hurt_;
        public static final int TREATMENT_FIELD_NUMBER = 5;
        private int treatMent_;
        public static final int ISMVP_FIELD_NUMBER = 6;
        private int isMvp_;
        public static final int PLAYERNAME_FIELD_NUMBER = 7;
        private Object playerName_;
        public static final int PLAYERLEVEL_FIELD_NUMBER = 8;
        private int playerLevel_;
        public static final int PLAYERPRO_FIELD_NUMBER = 9;
        private int playerPro_;
        public static final int DEADCOUNT_FIELD_NUMBER = 10;
        private int deadCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FivePlayerResultInfo> getParserForType() {
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

        public boolean hasKillCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getKillCount() {
            return this.killCount_;
        }

        public boolean hasHurt() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getHurt() {
            return this.hurt_;
        }

        public boolean hasTreatMent() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getTreatMent() {
            return this.treatMent_;
        }

        public boolean hasIsMvp() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getIsMvp() {
            return this.isMvp_;
        }

        public boolean hasPlayerName() {
            return ((this.bitField0_ & 0x20) == 32);
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

        public boolean hasPlayerLevel() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getPlayerLevel() {
            return this.playerLevel_;
        }

        public boolean hasPlayerPro() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getPlayerPro() {
            return this.playerPro_;
        }

        public boolean hasDeadCount() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getDeadCount() {
            return this.deadCount_;
        }

        private void initFields() {
            this.playerId_ = "";
            this.killCount_ = 0;
            this.hurt_ = 0;
            this.treatMent_ = 0;
            this.isMvp_ = 0;
            this.playerName_ = "";
            this.playerLevel_ = 0;
            this.playerPro_ = 0;
            this.deadCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasKillCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasHurt()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTreatMent()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsMvp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDeadCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getPlayerIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(3, this.killCount_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(4, this.hurt_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(5, this.treatMent_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(6, this.isMvp_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(7, getPlayerNameBytes());
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(8, this.playerLevel_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(9, this.playerPro_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(10, this.deadCount_);
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
                size += CodedOutputStream.computeInt32Size(3, this.killCount_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(4, this.hurt_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(5, this.treatMent_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(6, this.isMvp_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(7, getPlayerNameBytes());
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(8, this.playerLevel_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(9, this.playerPro_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(10, this.deadCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FivePlayerResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(data);
        }

        public static Five2FivePlayerResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FivePlayerResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(data);
        }

        public static Five2FivePlayerResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FivePlayerResultInfo parseFrom(InputStream input) throws IOException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(input);
        }

        public static Five2FivePlayerResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FivePlayerResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FivePlayerResultInfo) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FivePlayerResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FivePlayerResultInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FivePlayerResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(input);
        }

        public static Five2FivePlayerResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FivePlayerResultInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FivePlayerResultInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder {
            private int bitField0_;
            private Object playerId_;
            private int killCount_;
            private int hurt_;
            private int treatMent_;
            private int isMvp_;
            private Object playerName_;
            private int playerLevel_;
            private int playerPro_;
            private int deadCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FivePlayerResultInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FivePlayerResultInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FivePlayerResultInfo.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FivePlayerResultInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.killCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.hurt_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.treatMent_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.isMvp_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.playerName_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.playerLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.playerPro_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.deadCount_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FivePlayerResultInfo_descriptor;
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo build() {
                Five2FiveHandler.Five2FivePlayerResultInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo buildPartial() {
                Five2FiveHandler.Five2FivePlayerResultInfo result = new Five2FiveHandler.Five2FivePlayerResultInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.playerId_ = this.playerId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.killCount_ = this.killCount_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.hurt_ = this.hurt_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.treatMent_ = this.treatMent_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.isMvp_ = this.isMvp_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.playerName_ = this.playerName_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.playerLevel_ = this.playerLevel_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.playerPro_ = this.playerPro_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.deadCount_ = this.deadCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FivePlayerResultInfo)
                    return mergeFrom((Five2FiveHandler.Five2FivePlayerResultInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FivePlayerResultInfo other) {
                if (other == Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance())
                    return this;
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                if (other.hasKillCount())
                    setKillCount(other.getKillCount());
                if (other.hasHurt())
                    setHurt(other.getHurt());
                if (other.hasTreatMent())
                    setTreatMent(other.getTreatMent());
                if (other.hasIsMvp())
                    setIsMvp(other.getIsMvp());
                if (other.hasPlayerName()) {
                    this.bitField0_ |= 0x20;
                    this.playerName_ = other.playerName_;
                    onChanged();
                }
                if (other.hasPlayerLevel())
                    setPlayerLevel(other.getPlayerLevel());
                if (other.hasPlayerPro())
                    setPlayerPro(other.getPlayerPro());
                if (other.hasDeadCount())
                    setDeadCount(other.getDeadCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPlayerId())
                    return false;
                if (!hasKillCount())
                    return false;
                if (!hasHurt())
                    return false;
                if (!hasTreatMent())
                    return false;
                if (!hasIsMvp())
                    return false;
                if (!hasPlayerName())
                    return false;
                if (!hasPlayerLevel())
                    return false;
                if (!hasPlayerPro())
                    return false;
                if (!hasDeadCount())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FivePlayerResultInfo parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FivePlayerResultInfo) Five2FiveHandler.Five2FivePlayerResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FivePlayerResultInfo) e.getUnfinishedMessage();
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
                this.playerId_ = Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance().getPlayerId();
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

            public boolean hasKillCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getKillCount() {
                return this.killCount_;
            }

            public Builder setKillCount(int value) {
                this.bitField0_ |= 0x2;
                this.killCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.killCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHurt() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getHurt() {
                return this.hurt_;
            }

            public Builder setHurt(int value) {
                this.bitField0_ |= 0x4;
                this.hurt_ = value;
                onChanged();
                return this;
            }

            public Builder clearHurt() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.hurt_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTreatMent() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getTreatMent() {
                return this.treatMent_;
            }

            public Builder setTreatMent(int value) {
                this.bitField0_ |= 0x8;
                this.treatMent_ = value;
                onChanged();
                return this;
            }

            public Builder clearTreatMent() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.treatMent_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsMvp() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getIsMvp() {
                return this.isMvp_;
            }

            public Builder setIsMvp(int value) {
                this.bitField0_ |= 0x10;
                this.isMvp_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsMvp() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.isMvp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPlayerName() {
                return ((this.bitField0_ & 0x20) == 32);
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
                this.bitField0_ |= 0x20;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.playerName_ = Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasPlayerLevel() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getPlayerLevel() {
                return this.playerLevel_;
            }

            public Builder setPlayerLevel(int value) {
                this.bitField0_ |= 0x40;
                this.playerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerLevel() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.playerLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPlayerPro() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getPlayerPro() {
                return this.playerPro_;
            }

            public Builder setPlayerPro(int value) {
                this.bitField0_ |= 0x80;
                this.playerPro_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerPro() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.playerPro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDeadCount() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getDeadCount() {
                return this.deadCount_;
            }

            public Builder setDeadCount(int value) {
                this.bitField0_ |= 0x100;
                this.deadCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeadCount() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.deadCount_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveLookMatchResultRequest extends GeneratedMessage implements Five2FiveLookMatchResultRequestOrBuilder {
        private static final Five2FiveLookMatchResultRequest defaultInstance = new Five2FiveLookMatchResultRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLookMatchResultRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLookMatchResultRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLookMatchResultRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLookMatchResultRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLookMatchResultRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.instanceId_ = bs;
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLookMatchResultRequest.class, Builder.class);
        }

        public static Parser<Five2FiveLookMatchResultRequest> PARSER = (Parser<Five2FiveLookMatchResultRequest>) new AbstractParser<Five2FiveLookMatchResultRequest>() {
            public Five2FiveHandler.Five2FiveLookMatchResultRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLookMatchResultRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int INSTANCEID_FIELD_NUMBER = 1;
        private Object instanceId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveLookMatchResultRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasInstanceId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getInstanceId() {
            Object ref = this.instanceId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.instanceId_ = s;
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

        private void initFields() {
            this.instanceId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasInstanceId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getInstanceIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getInstanceIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveLookMatchResultRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLookMatchResultRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLookMatchResultRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveLookMatchResultRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookMatchResultRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLookMatchResultRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLookMatchResultRequestOrBuilder {
            private int bitField0_;
            private Object instanceId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLookMatchResultRequest.class, Builder.class);
            }

            private Builder() {
                this.instanceId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.instanceId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveLookMatchResultRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.instanceId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveLookMatchResultRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLookMatchResultRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLookMatchResultRequest build() {
                Five2FiveHandler.Five2FiveLookMatchResultRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLookMatchResultRequest buildPartial() {
                Five2FiveHandler.Five2FiveLookMatchResultRequest result = new Five2FiveHandler.Five2FiveLookMatchResultRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.instanceId_ = this.instanceId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveLookMatchResultRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveLookMatchResultRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLookMatchResultRequest other) {
                if (other == Five2FiveHandler.Five2FiveLookMatchResultRequest.getDefaultInstance()) return this;
                if (other.hasInstanceId()) {
                    this.bitField0_ |= 0x1;
                    this.instanceId_ = other.instanceId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasInstanceId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveLookMatchResultRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookMatchResultRequest) Five2FiveHandler.Five2FiveLookMatchResultRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookMatchResultRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasInstanceId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getInstanceId() {
                Object ref = this.instanceId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.instanceId_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.instanceId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstanceId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.instanceId_ = Five2FiveHandler.Five2FiveLookMatchResultRequest.getDefaultInstance().getInstanceId();
                onChanged();
                return this;
            }

            public Builder setInstanceIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.instanceId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class Five2FiveLookMatchResultResponse
            extends GeneratedMessage
            implements Five2FiveLookMatchResultResponseOrBuilder {
        private static final Five2FiveLookMatchResultResponse defaultInstance = new Five2FiveLookMatchResultResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLookMatchResultResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLookMatchResultResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLookMatchResultResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLookMatchResultResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLookMatchResultResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.resultInfoA_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.resultInfoA_.add(input.readMessage(Five2FiveHandler.Five2FivePlayerResultInfo.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.resultInfoB_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.resultInfoB_.add(input.readMessage(Five2FiveHandler.Five2FivePlayerResultInfo.PARSER, extensionRegistry));
                            break;
                        case 40:
                            this.bitField0_ |= 0x4;
                            this.resultA_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.resultInfoA_ = Collections.unmodifiableList(this.resultInfoA_);
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.resultInfoB_ = Collections.unmodifiableList(this.resultInfoB_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLookMatchResultResponse.class, Builder.class);
        }

        public static Parser<Five2FiveLookMatchResultResponse> PARSER = (Parser<Five2FiveLookMatchResultResponse>) new AbstractParser<Five2FiveLookMatchResultResponse>() {
            public Five2FiveHandler.Five2FiveLookMatchResultResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLookMatchResultResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int RESULTINFOA_FIELD_NUMBER = 3;
        private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoA_;
        public static final int RESULTINFOB_FIELD_NUMBER = 4;
        private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoB_;
        public static final int RESULTA_FIELD_NUMBER = 5;
        private int resultA_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveLookMatchResultResponse> getParserForType() {
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

        public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoAList() {
            return this.resultInfoA_;
        }

        static {
            defaultInstance.initFields();
        }

        public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAOrBuilderList() {
            return (List) this.resultInfoA_;
        }

        public int getResultInfoACount() {
            return this.resultInfoA_.size();
        }

        public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoA(int index) {
            return this.resultInfoA_.get(index);
        }

        public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoAOrBuilder(int index) {
            return this.resultInfoA_.get(index);
        }

        public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoBList() {
            return this.resultInfoB_;
        }

        public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBOrBuilderList() {
            return (List) this.resultInfoB_;
        }

        public int getResultInfoBCount() {
            return this.resultInfoB_.size();
        }

        public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoB(int index) {
            return this.resultInfoB_.get(index);
        }

        public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoBOrBuilder(int index) {
            return this.resultInfoB_.get(index);
        }

        public boolean hasResultA() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getResultA() {
            return this.resultA_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.resultInfoA_ = Collections.emptyList();
            this.resultInfoB_ = Collections.emptyList();
            this.resultA_ = 0;
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
            for (i = 0; i < getResultInfoACount(); i++) {
                if (!getResultInfoA(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getResultInfoBCount(); i++) {
                if (!getResultInfoB(i).isInitialized()) {
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
            for (i = 0; i < this.resultInfoA_.size(); i++)
                output.writeMessage(3, (MessageLite) this.resultInfoA_.get(i));
            for (i = 0; i < this.resultInfoB_.size(); i++)
                output.writeMessage(4, (MessageLite) this.resultInfoB_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(5, this.resultA_);
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
            for (i = 0; i < this.resultInfoA_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.resultInfoA_.get(i));
            for (i = 0; i < this.resultInfoB_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.resultInfoB_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(5, this.resultA_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveLookMatchResultResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLookMatchResultResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLookMatchResultResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveLookMatchResultResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLookMatchResultResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLookMatchResultResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLookMatchResultResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoA_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> resultInfoABuilder_;
            private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoB_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> resultInfoBBuilder_;
            private int resultA_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLookMatchResultResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.resultInfoA_ = Collections.emptyList();
                this.resultInfoB_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.resultInfoA_ = Collections.emptyList();
                this.resultInfoB_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveLookMatchResultResponse.alwaysUseFieldBuilders) {
                    getResultInfoAFieldBuilder();
                    getResultInfoBFieldBuilder();
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
                if (this.resultInfoABuilder_ == null) {
                    this.resultInfoA_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.resultInfoABuilder_.clear();
                }
                if (this.resultInfoBBuilder_ == null) {
                    this.resultInfoB_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.resultInfoBBuilder_.clear();
                }
                this.resultA_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveLookMatchResultResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLookMatchResultResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLookMatchResultResponse build() {
                Five2FiveHandler.Five2FiveLookMatchResultResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLookMatchResultResponse buildPartial() {
                Five2FiveHandler.Five2FiveLookMatchResultResponse result = new Five2FiveHandler.Five2FiveLookMatchResultResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.resultInfoABuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.resultInfoA_ = Collections.unmodifiableList(this.resultInfoA_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.resultInfoA_ = this.resultInfoA_;
                } else {
                    result.resultInfoA_ = this.resultInfoABuilder_.build();
                }
                if (this.resultInfoBBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.resultInfoB_ = Collections.unmodifiableList(this.resultInfoB_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.resultInfoB_ = this.resultInfoB_;
                } else {
                    result.resultInfoB_ = this.resultInfoBBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x4;
                result.resultA_ = this.resultA_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveLookMatchResultResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveLookMatchResultResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLookMatchResultResponse other) {
                if (other == Five2FiveHandler.Five2FiveLookMatchResultResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.resultInfoABuilder_ == null) {
                    if (!other.resultInfoA_.isEmpty()) {
                        if (this.resultInfoA_.isEmpty()) {
                            this.resultInfoA_ = other.resultInfoA_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureResultInfoAIsMutable();
                            this.resultInfoA_.addAll(other.resultInfoA_);
                        }
                        onChanged();
                    }
                } else if (!other.resultInfoA_.isEmpty()) {
                    if (this.resultInfoABuilder_.isEmpty()) {
                        this.resultInfoABuilder_.dispose();
                        this.resultInfoABuilder_ = null;
                        this.resultInfoA_ = other.resultInfoA_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.resultInfoABuilder_ = Five2FiveHandler.Five2FiveLookMatchResultResponse.alwaysUseFieldBuilders ? getResultInfoAFieldBuilder() : null;
                    } else {
                        this.resultInfoABuilder_.addAllMessages(other.resultInfoA_);
                    }
                }
                if (this.resultInfoBBuilder_ == null) {
                    if (!other.resultInfoB_.isEmpty()) {
                        if (this.resultInfoB_.isEmpty()) {
                            this.resultInfoB_ = other.resultInfoB_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureResultInfoBIsMutable();
                            this.resultInfoB_.addAll(other.resultInfoB_);
                        }
                        onChanged();
                    }
                } else if (!other.resultInfoB_.isEmpty()) {
                    if (this.resultInfoBBuilder_.isEmpty()) {
                        this.resultInfoBBuilder_.dispose();
                        this.resultInfoBBuilder_ = null;
                        this.resultInfoB_ = other.resultInfoB_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.resultInfoBBuilder_ = Five2FiveHandler.Five2FiveLookMatchResultResponse.alwaysUseFieldBuilders ? getResultInfoBFieldBuilder() : null;
                    } else {
                        this.resultInfoBBuilder_.addAllMessages(other.resultInfoB_);
                    }
                }
                if (other.hasResultA())
                    setResultA(other.getResultA());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                int i;
                for (i = 0; i < getResultInfoACount(); i++) {
                    if (!getResultInfoA(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getResultInfoBCount(); i++) {
                    if (!getResultInfoB(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveLookMatchResultResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookMatchResultResponse) Five2FiveHandler.Five2FiveLookMatchResultResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLookMatchResultResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveLookMatchResultResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureResultInfoAIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.resultInfoA_ = new ArrayList<>(this.resultInfoA_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoAList() {
                if (this.resultInfoABuilder_ == null)
                    return Collections.unmodifiableList(this.resultInfoA_);
                return this.resultInfoABuilder_.getMessageList();
            }

            public int getResultInfoACount() {
                if (this.resultInfoABuilder_ == null)
                    return this.resultInfoA_.size();
                return this.resultInfoABuilder_.getCount();
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoA(int index) {
                if (this.resultInfoABuilder_ == null)
                    return this.resultInfoA_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfo) this.resultInfoABuilder_.getMessage(index);
            }

            public Builder setResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.set(index, value);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoABuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoA(Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(value);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(index, value);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addResultInfoA(Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllResultInfoA(Iterable<? extends Five2FiveHandler.Five2FivePlayerResultInfo> values) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.resultInfoA_);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearResultInfoA() {
                if (this.resultInfoABuilder_ == null) {
                    this.resultInfoA_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.resultInfoABuilder_.clear();
                }
                return this;
            }

            public Builder removeResultInfoA(int index) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.remove(index);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder getResultInfoABuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoAFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoAOrBuilder(int index) {
                if (this.resultInfoABuilder_ == null)
                    return this.resultInfoA_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder) this.resultInfoABuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAOrBuilderList() {
                if (this.resultInfoABuilder_ != null)
                    return this.resultInfoABuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.resultInfoA_);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoABuilder() {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoAFieldBuilder().addBuilder(Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoABuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoAFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo.Builder> getResultInfoABuilderList() {
                return getResultInfoAFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAFieldBuilder() {
                if (this.resultInfoABuilder_ == null) {
                    this.resultInfoABuilder_ = new RepeatedFieldBuilder(this.resultInfoA_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.resultInfoA_ = null;
                }
                return this.resultInfoABuilder_;
            }

            private void ensureResultInfoBIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.resultInfoB_ = new ArrayList<>(this.resultInfoB_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoBList() {
                if (this.resultInfoBBuilder_ == null)
                    return Collections.unmodifiableList(this.resultInfoB_);
                return this.resultInfoBBuilder_.getMessageList();
            }

            public int getResultInfoBCount() {
                if (this.resultInfoBBuilder_ == null)
                    return this.resultInfoB_.size();
                return this.resultInfoBBuilder_.getCount();
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoB(int index) {
                if (this.resultInfoBBuilder_ == null)
                    return this.resultInfoB_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfo) this.resultInfoBBuilder_.getMessage(index);
            }

            public Builder setResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.set(index, value);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoB(Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(value);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(index, value);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addResultInfoB(Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllResultInfoB(Iterable<? extends Five2FiveHandler.Five2FivePlayerResultInfo> values) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.resultInfoB_);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearResultInfoB() {
                if (this.resultInfoBBuilder_ == null) {
                    this.resultInfoB_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.clear();
                }
                return this;
            }

            public Builder removeResultInfoB(int index) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.remove(index);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder getResultInfoBBuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoBFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoBOrBuilder(int index) {
                if (this.resultInfoBBuilder_ == null)
                    return this.resultInfoB_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder) this.resultInfoBBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBOrBuilderList() {
                if (this.resultInfoBBuilder_ != null)
                    return this.resultInfoBBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.resultInfoB_);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoBBuilder() {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoBFieldBuilder().addBuilder(Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoBBuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoBFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo.Builder> getResultInfoBBuilderList() {
                return getResultInfoBFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBFieldBuilder() {
                if (this.resultInfoBBuilder_ == null) {
                    this.resultInfoBBuilder_ = new RepeatedFieldBuilder(this.resultInfoB_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.resultInfoB_ = null;
                }
                return this.resultInfoBBuilder_;
            }

            public boolean hasResultA() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getResultA() {
                return this.resultA_;
            }

            public Builder setResultA(int value) {
                this.bitField0_ |= 0x10;
                this.resultA_ = value;
                onChanged();
                return this;
            }

            public Builder clearResultA() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.resultA_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveShardMatchResultRequest extends GeneratedMessage implements Five2FiveShardMatchResultRequestOrBuilder {
        private static final Five2FiveShardMatchResultRequest defaultInstance = new Five2FiveShardMatchResultRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveShardMatchResultRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveShardMatchResultRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveShardMatchResultRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveShardMatchResultRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveShardMatchResultRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.instanceId_ = bs;
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveShardMatchResultRequest.class, Builder.class);
        }

        public static Parser<Five2FiveShardMatchResultRequest> PARSER = (Parser<Five2FiveShardMatchResultRequest>) new AbstractParser<Five2FiveShardMatchResultRequest>() {
            public Five2FiveHandler.Five2FiveShardMatchResultRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveShardMatchResultRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int INSTANCEID_FIELD_NUMBER = 1;
        private Object instanceId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveShardMatchResultRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasInstanceId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getInstanceId() {
            Object ref = this.instanceId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.instanceId_ = s;
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

        private void initFields() {
            this.instanceId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasInstanceId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getInstanceIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getInstanceIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveShardMatchResultRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveShardMatchResultRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveShardMatchResultRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveShardMatchResultRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveShardMatchResultRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveShardMatchResultRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveShardMatchResultRequestOrBuilder {
            private int bitField0_;
            private Object instanceId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveShardMatchResultRequest.class, Builder.class);
            }

            private Builder() {
                this.instanceId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.instanceId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveShardMatchResultRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.instanceId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveShardMatchResultRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveShardMatchResultRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveShardMatchResultRequest build() {
                Five2FiveHandler.Five2FiveShardMatchResultRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveShardMatchResultRequest buildPartial() {
                Five2FiveHandler.Five2FiveShardMatchResultRequest result = new Five2FiveHandler.Five2FiveShardMatchResultRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.instanceId_ = this.instanceId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveShardMatchResultRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveShardMatchResultRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveShardMatchResultRequest other) {
                if (other == Five2FiveHandler.Five2FiveShardMatchResultRequest.getDefaultInstance()) return this;
                if (other.hasInstanceId()) {
                    this.bitField0_ |= 0x1;
                    this.instanceId_ = other.instanceId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasInstanceId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveShardMatchResultRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveShardMatchResultRequest) Five2FiveHandler.Five2FiveShardMatchResultRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveShardMatchResultRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasInstanceId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getInstanceId() {
                Object ref = this.instanceId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.instanceId_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.instanceId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstanceId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.instanceId_ = Five2FiveHandler.Five2FiveShardMatchResultRequest.getDefaultInstance().getInstanceId();
                onChanged();
                return this;
            }

            public Builder setInstanceIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.instanceId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class Five2FiveShardMatchResultResponse
            extends GeneratedMessage
            implements Five2FiveShardMatchResultResponseOrBuilder {
        private static final Five2FiveShardMatchResultResponse defaultInstance = new Five2FiveShardMatchResultResponse(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveShardMatchResultResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveShardMatchResultResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveShardMatchResultResponse getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveShardMatchResultResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveShardMatchResultResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveShardMatchResultResponse.class, Builder.class);
        }

        public static Parser<Five2FiveShardMatchResultResponse> PARSER = (Parser<Five2FiveShardMatchResultResponse>) new AbstractParser<Five2FiveShardMatchResultResponse>() {
            public Five2FiveHandler.Five2FiveShardMatchResultResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveShardMatchResultResponse(input, extensionRegistry);
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

        public Parser<Five2FiveShardMatchResultResponse> getParserForType() {
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

        public static Five2FiveShardMatchResultResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(data);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(InputStream input) throws IOException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveShardMatchResultResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveShardMatchResultResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(input);
        }

        public static Five2FiveShardMatchResultResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveShardMatchResultResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveShardMatchResultResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveShardMatchResultResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveShardMatchResultResponse.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveShardMatchResultResponse.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_descriptor;
            }

            public Five2FiveHandler.Five2FiveShardMatchResultResponse getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveShardMatchResultResponse.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveShardMatchResultResponse build() {
                Five2FiveHandler.Five2FiveShardMatchResultResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveShardMatchResultResponse buildPartial() {
                Five2FiveHandler.Five2FiveShardMatchResultResponse result = new Five2FiveHandler.Five2FiveShardMatchResultResponse(this);
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
                if (other instanceof Five2FiveHandler.Five2FiveShardMatchResultResponse)
                    return mergeFrom((Five2FiveHandler.Five2FiveShardMatchResultResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveShardMatchResultResponse other) {
                if (other == Five2FiveHandler.Five2FiveShardMatchResultResponse.getDefaultInstance()) return this;
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
                Five2FiveHandler.Five2FiveShardMatchResultResponse parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveShardMatchResultResponse) Five2FiveHandler.Five2FiveShardMatchResultResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveShardMatchResultResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Five2FiveHandler.Five2FiveShardMatchResultResponse.getDefaultInstance().getS2CMsg();
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


    public static final class Five2FiveTeamChangeContinueRequest
            extends GeneratedMessage
            implements Five2FiveTeamChangeContinueRequestOrBuilder {
        private static final Five2FiveTeamChangeContinueRequest defaultInstance = new Five2FiveTeamChangeContinueRequest(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveTeamChangeContinueRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveTeamChangeContinueRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveTeamChangeContinueRequest getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveTeamChangeContinueRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveTeamChangeContinueRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.choice_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveTeamChangeContinueRequest.class, Builder.class);
        }

        public static Parser<Five2FiveTeamChangeContinueRequest> PARSER = (Parser<Five2FiveTeamChangeContinueRequest>) new AbstractParser<Five2FiveTeamChangeContinueRequest>() {
            public Five2FiveHandler.Five2FiveTeamChangeContinueRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveTeamChangeContinueRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int CHOICE_FIELD_NUMBER = 1;
        private int choice_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveTeamChangeContinueRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasChoice() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getChoice() {
            return this.choice_;
        }

        private void initFields() {
            this.choice_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasChoice()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.choice_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.choice_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(data);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(InputStream input) throws IOException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveTeamChangeContinueRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveTeamChangeContinueRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(input);
        }

        public static Five2FiveTeamChangeContinueRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveTeamChangeContinueRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveTeamChangeContinueRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveTeamChangeContinueRequestOrBuilder {
            private int bitField0_;
            private int choice_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveTeamChangeContinueRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveTeamChangeContinueRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.choice_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_descriptor;
            }

            public Five2FiveHandler.Five2FiveTeamChangeContinueRequest getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveTeamChangeContinueRequest.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveTeamChangeContinueRequest build() {
                Five2FiveHandler.Five2FiveTeamChangeContinueRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveTeamChangeContinueRequest buildPartial() {
                Five2FiveHandler.Five2FiveTeamChangeContinueRequest result = new Five2FiveHandler.Five2FiveTeamChangeContinueRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.choice_ = this.choice_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveTeamChangeContinueRequest)
                    return mergeFrom((Five2FiveHandler.Five2FiveTeamChangeContinueRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveTeamChangeContinueRequest other) {
                if (other == Five2FiveHandler.Five2FiveTeamChangeContinueRequest.getDefaultInstance()) return this;
                if (other.hasChoice()) setChoice(other.getChoice());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasChoice()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveTeamChangeContinueRequest parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveTeamChangeContinueRequest) Five2FiveHandler.Five2FiveTeamChangeContinueRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveTeamChangeContinueRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasChoice() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getChoice() {
                return this.choice_;
            }

            public Builder setChoice(int value) {
                this.bitField0_ |= 0x1;
                this.choice_ = value;
                onChanged();
                return this;
            }

            public Builder clearChoice() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.choice_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveMatchMemberInfo
            extends GeneratedMessage
            implements Five2FiveMatchMemberInfoOrBuilder {
        private static final Five2FiveMatchMemberInfo defaultInstance = new Five2FiveMatchMemberInfo(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchMemberInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchMemberInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchMemberInfo getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchMemberInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchMemberInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.playerPro_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.playerLvl_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.playerName_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.readyStatus_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchMemberInfo.class, Builder.class);
        }

        public static Parser<Five2FiveMatchMemberInfo> PARSER = (Parser<Five2FiveMatchMemberInfo>) new AbstractParser<Five2FiveMatchMemberInfo>() {
            public Five2FiveHandler.Five2FiveMatchMemberInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchMemberInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        public static final int PLAYERPRO_FIELD_NUMBER = 2;
        private int playerPro_;
        public static final int PLAYERLVL_FIELD_NUMBER = 3;
        private int playerLvl_;
        public static final int PLAYERNAME_FIELD_NUMBER = 4;
        private Object playerName_;
        public static final int READYSTATUS_FIELD_NUMBER = 5;
        private int readyStatus_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchMemberInfo> getParserForType() {
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

        public boolean hasPlayerPro() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getPlayerPro() {
            return this.playerPro_;
        }


        public boolean hasPlayerLvl() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getPlayerLvl() {
            return this.playerLvl_;
        }


        public boolean hasPlayerName() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getPlayerName() {
            Object ref = this.playerName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.playerName_ = s;
            }
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


        public boolean hasReadyStatus() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getReadyStatus() {
            return this.readyStatus_;
        }


        private void initFields() {
            this.playerId_ = "";
            this.playerPro_ = 0;
            this.playerLvl_ = 0;
            this.playerName_ = "";
            this.readyStatus_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerLvl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasReadyStatus()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.playerPro_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.playerLvl_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getPlayerNameBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.readyStatus_);
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
                size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.playerPro_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.playerLvl_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getPlayerNameBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.readyStatus_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Five2FiveMatchMemberInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(data);
        }


        public static Five2FiveMatchMemberInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Five2FiveMatchMemberInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(data);
        }


        public static Five2FiveMatchMemberInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Five2FiveMatchMemberInfo parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(input);
        }


        public static Five2FiveMatchMemberInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Five2FiveMatchMemberInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchMemberInfo) PARSER.parseDelimitedFrom(input);
        }


        public static Five2FiveMatchMemberInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchMemberInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Five2FiveMatchMemberInfo parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(input);
        }


        public static Five2FiveMatchMemberInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchMemberInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Five2FiveMatchMemberInfo prototype) {
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
                implements Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder {
            private int bitField0_;

            private Object playerId_;

            private int playerPro_;

            private int playerLvl_;

            private Object playerName_;

            private int readyStatus_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchMemberInfo.class, Builder.class);
            }


            private Builder() {
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchMemberInfo.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerPro_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerLvl_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.playerName_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.readyStatus_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_descriptor;
            }


            public Five2FiveHandler.Five2FiveMatchMemberInfo getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance();
            }


            public Five2FiveHandler.Five2FiveMatchMemberInfo build() {
                Five2FiveHandler.Five2FiveMatchMemberInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Five2FiveHandler.Five2FiveMatchMemberInfo buildPartial() {
                Five2FiveHandler.Five2FiveMatchMemberInfo result = new Five2FiveHandler.Five2FiveMatchMemberInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.playerId_ = this.playerId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.playerPro_ = this.playerPro_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.playerLvl_ = this.playerLvl_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.playerName_ = this.playerName_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.readyStatus_ = this.readyStatus_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchMemberInfo) {
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchMemberInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchMemberInfo other) {
                if (other == Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                if (other.hasPlayerPro()) {
                    setPlayerPro(other.getPlayerPro());
                }
                if (other.hasPlayerLvl()) {
                    setPlayerLvl(other.getPlayerLvl());
                }
                if (other.hasPlayerName()) {
                    this.bitField0_ |= 0x8;
                    this.playerName_ = other.playerName_;
                    onChanged();
                }
                if (other.hasReadyStatus()) {
                    setReadyStatus(other.getReadyStatus());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasPlayerId()) {
                    return false;
                }
                if (!hasPlayerPro()) {
                    return false;
                }
                if (!hasPlayerLvl()) {
                    return false;
                }
                if (!hasPlayerName()) {
                    return false;
                }
                if (!hasReadyStatus()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchMemberInfo parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchMemberInfo) Five2FiveHandler.Five2FiveMatchMemberInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchMemberInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
                    if (bs.isValidUtf8()) {
                        this.playerId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }


            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }


            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }


            public boolean hasPlayerPro() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getPlayerPro() {
                return this.playerPro_;
            }


            public Builder setPlayerPro(int value) {
                this.bitField0_ |= 0x2;
                this.playerPro_ = value;
                onChanged();
                return this;
            }


            public Builder clearPlayerPro() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerPro_ = 0;
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

            public boolean hasPlayerName() {
                return ((this.bitField0_ & 0x8) == 8);
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
                this.bitField0_ |= 0x8;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.playerName_ = Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasReadyStatus() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getReadyStatus() {
                return this.readyStatus_;
            }

            public Builder setReadyStatus(int value) {
                this.bitField0_ |= 0x10;
                this.readyStatus_ = value;
                onChanged();
                return this;
            }

            public Builder clearReadyStatus() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.readyStatus_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveApplyMatchPush
            extends GeneratedMessage
            implements Five2FiveApplyMatchPushOrBuilder {
        private final UnknownFieldSet unknownFields;

        private Five2FiveApplyMatchPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveApplyMatchPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveApplyMatchPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveApplyMatchPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveApplyMatchPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.five2FiveMatchMemberInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.five2FiveMatchMemberInfo_.add(input.readMessage(Five2FiveHandler.Five2FiveMatchMemberInfo.PARSER, extensionRegistry));
                            break;
                        case 16:
                            this.bitField0_ |= 0x1;
                            this.waitResponseTimeSec_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) {
                    this.five2FiveMatchMemberInfo_ = Collections.unmodifiableList(this.five2FiveMatchMemberInfo_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveApplyMatchPush.class, Builder.class);
        }

        public static Parser<Five2FiveApplyMatchPush> PARSER = (Parser<Five2FiveApplyMatchPush>) new AbstractParser<Five2FiveApplyMatchPush>() {
            public Five2FiveHandler.Five2FiveApplyMatchPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveApplyMatchPush(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int FIVE2FIVEMATCHMEMBERINFO_FIELD_NUMBER = 1;
        private List<Five2FiveHandler.Five2FiveMatchMemberInfo> five2FiveMatchMemberInfo_;
        public static final int WAITRESPONSETIMESEC_FIELD_NUMBER = 2;
        private int waitResponseTimeSec_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveApplyMatchPush> getParserForType() {
            return PARSER;
        }

        public List<Five2FiveHandler.Five2FiveMatchMemberInfo> getFive2FiveMatchMemberInfoList() {
            return this.five2FiveMatchMemberInfo_;
        }

        public List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getFive2FiveMatchMemberInfoOrBuilderList() {
            return (List) this.five2FiveMatchMemberInfo_;
        }

        public int getFive2FiveMatchMemberInfoCount() {
            return this.five2FiveMatchMemberInfo_.size();
        }

        public Five2FiveHandler.Five2FiveMatchMemberInfo getFive2FiveMatchMemberInfo(int index) {
            return this.five2FiveMatchMemberInfo_.get(index);
        }

        public Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getFive2FiveMatchMemberInfoOrBuilder(int index) {
            return this.five2FiveMatchMemberInfo_.get(index);
        }

        public boolean hasWaitResponseTimeSec() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getWaitResponseTimeSec() {
            return this.waitResponseTimeSec_;
        }

        private void initFields() {
            this.five2FiveMatchMemberInfo_ = Collections.emptyList();
            this.waitResponseTimeSec_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasWaitResponseTimeSec()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getFive2FiveMatchMemberInfoCount(); i++) {
                if (!getFive2FiveMatchMemberInfo(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.five2FiveMatchMemberInfo_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.five2FiveMatchMemberInfo_.get(i));
            }
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(2, this.waitResponseTimeSec_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.five2FiveMatchMemberInfo_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.five2FiveMatchMemberInfo_.get(i));
            }
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeInt32Size(2, this.waitResponseTimeSec_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveApplyMatchPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(data);
        }

        public static Five2FiveApplyMatchPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveApplyMatchPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(data);
        }

        public static Five2FiveApplyMatchPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveApplyMatchPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(input);
        }

        private static final Five2FiveApplyMatchPush defaultInstance = new Five2FiveApplyMatchPush(true);

        public static Five2FiveApplyMatchPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveApplyMatchPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveApplyMatchPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveApplyMatchPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveApplyMatchPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveApplyMatchPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(input);
        }

        public static Five2FiveApplyMatchPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveApplyMatchPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveApplyMatchPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveApplyMatchPushOrBuilder {
            private int bitField0_;
            private List<Five2FiveHandler.Five2FiveMatchMemberInfo> five2FiveMatchMemberInfo_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveMatchMemberInfo, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder, Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> five2FiveMatchMemberInfoBuilder_;
            private int waitResponseTimeSec_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveApplyMatchPush.class, Builder.class);
            }

            private Builder() {
                this.five2FiveMatchMemberInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.five2FiveMatchMemberInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveApplyMatchPush.alwaysUseFieldBuilders)
                    getFive2FiveMatchMemberInfoFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    this.five2FiveMatchMemberInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.clear();
                }
                this.waitResponseTimeSec_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveApplyMatchPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveApplyMatchPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveApplyMatchPush build() {
                Five2FiveHandler.Five2FiveApplyMatchPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveApplyMatchPush buildPartial() {
                Five2FiveHandler.Five2FiveApplyMatchPush result = new Five2FiveHandler.Five2FiveApplyMatchPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.five2FiveMatchMemberInfo_ = Collections.unmodifiableList(this.five2FiveMatchMemberInfo_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.five2FiveMatchMemberInfo_ = this.five2FiveMatchMemberInfo_;
                } else {
                    result.five2FiveMatchMemberInfo_ = this.five2FiveMatchMemberInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x1;
                result.waitResponseTimeSec_ = this.waitResponseTimeSec_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveApplyMatchPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveApplyMatchPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveApplyMatchPush other) {
                if (other == Five2FiveHandler.Five2FiveApplyMatchPush.getDefaultInstance()) return this;
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    if (!other.five2FiveMatchMemberInfo_.isEmpty()) {
                        if (this.five2FiveMatchMemberInfo_.isEmpty()) {
                            this.five2FiveMatchMemberInfo_ = other.five2FiveMatchMemberInfo_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureFive2FiveMatchMemberInfoIsMutable();
                            this.five2FiveMatchMemberInfo_.addAll(other.five2FiveMatchMemberInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.five2FiveMatchMemberInfo_.isEmpty()) {
                    if (this.five2FiveMatchMemberInfoBuilder_.isEmpty()) {
                        this.five2FiveMatchMemberInfoBuilder_.dispose();
                        this.five2FiveMatchMemberInfoBuilder_ = null;
                        this.five2FiveMatchMemberInfo_ = other.five2FiveMatchMemberInfo_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.five2FiveMatchMemberInfoBuilder_ = Five2FiveHandler.Five2FiveApplyMatchPush.alwaysUseFieldBuilders ? getFive2FiveMatchMemberInfoFieldBuilder() : null;
                    } else {
                        this.five2FiveMatchMemberInfoBuilder_.addAllMessages(other.five2FiveMatchMemberInfo_);
                    }
                }
                if (other.hasWaitResponseTimeSec()) setWaitResponseTimeSec(other.getWaitResponseTimeSec());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasWaitResponseTimeSec()) return false;
                for (int i = 0; i < getFive2FiveMatchMemberInfoCount(); i++) {
                    if (!getFive2FiveMatchMemberInfo(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveApplyMatchPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveApplyMatchPush) Five2FiveHandler.Five2FiveApplyMatchPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveApplyMatchPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureFive2FiveMatchMemberInfoIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.five2FiveMatchMemberInfo_ = new ArrayList<>(this.five2FiveMatchMemberInfo_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<Five2FiveHandler.Five2FiveMatchMemberInfo> getFive2FiveMatchMemberInfoList() {
                if (this.five2FiveMatchMemberInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.five2FiveMatchMemberInfo_);
                return this.five2FiveMatchMemberInfoBuilder_.getMessageList();
            }

            public int getFive2FiveMatchMemberInfoCount() {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) return this.five2FiveMatchMemberInfo_.size();
                return this.five2FiveMatchMemberInfoBuilder_.getCount();
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo getFive2FiveMatchMemberInfo(int index) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) return this.five2FiveMatchMemberInfo_.get(index);
                return (Five2FiveHandler.Five2FiveMatchMemberInfo) this.five2FiveMatchMemberInfoBuilder_.getMessage(index);
            }

            public Builder setFive2FiveMatchMemberInfo(int index, Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.set(index, value);
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setFive2FiveMatchMemberInfo(int index, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFive2FiveMatchMemberInfo(Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.add(value);
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addFive2FiveMatchMemberInfo(int index, Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.add(index, value);
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addFive2FiveMatchMemberInfo(Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFive2FiveMatchMemberInfo(int index, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFive2FiveMatchMemberInfo(Iterable<? extends Five2FiveHandler.Five2FiveMatchMemberInfo> values) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.five2FiveMatchMemberInfo_);
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFive2FiveMatchMemberInfo() {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    this.five2FiveMatchMemberInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeFive2FiveMatchMemberInfo(int index) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    ensureFive2FiveMatchMemberInfoIsMutable();
                    this.five2FiveMatchMemberInfo_.remove(index);
                    onChanged();
                } else {
                    this.five2FiveMatchMemberInfoBuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder getFive2FiveMatchMemberInfoBuilder(int index) {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getFive2FiveMatchMemberInfoFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getFive2FiveMatchMemberInfoOrBuilder(int index) {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) return this.five2FiveMatchMemberInfo_.get(index);
                return (Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder) this.five2FiveMatchMemberInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getFive2FiveMatchMemberInfoOrBuilderList() {
                if (this.five2FiveMatchMemberInfoBuilder_ != null)
                    return this.five2FiveMatchMemberInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.five2FiveMatchMemberInfo_);
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder addFive2FiveMatchMemberInfoBuilder() {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getFive2FiveMatchMemberInfoFieldBuilder().addBuilder(Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder addFive2FiveMatchMemberInfoBuilder(int index) {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getFive2FiveMatchMemberInfoFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FiveMatchMemberInfo.Builder> getFive2FiveMatchMemberInfoBuilderList() {
                return getFive2FiveMatchMemberInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveMatchMemberInfo, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder, Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getFive2FiveMatchMemberInfoFieldBuilder() {
                if (this.five2FiveMatchMemberInfoBuilder_ == null) {
                    this.five2FiveMatchMemberInfoBuilder_ = new RepeatedFieldBuilder(this.five2FiveMatchMemberInfo_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.five2FiveMatchMemberInfo_ = null;
                }
                return this.five2FiveMatchMemberInfoBuilder_;
            }

            public boolean hasWaitResponseTimeSec() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getWaitResponseTimeSec() {
                return this.waitResponseTimeSec_;
            }

            public Builder setWaitResponseTimeSec(int value) {
                this.bitField0_ |= 0x2;
                this.waitResponseTimeSec_ = value;
                onChanged();
                return this;
            }

            public Builder clearWaitResponseTimeSec() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.waitResponseTimeSec_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveMatchMemberInfoPush
            extends GeneratedMessage
            implements Five2FiveMatchMemberInfoPushOrBuilder {
        private static final Five2FiveMatchMemberInfoPush defaultInstance = new Five2FiveMatchMemberInfoPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchMemberInfoPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchMemberInfoPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchMemberInfoPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchMemberInfoPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchMemberInfoPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.tempTeamId_ = bs;
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.matchTeamInfoA_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.matchTeamInfoA_.add(input.readMessage(Five2FiveHandler.Five2FiveMatchMemberInfo.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.matchTeamInfoB_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.matchTeamInfoB_.add(input.readMessage(Five2FiveHandler.Five2FiveMatchMemberInfo.PARSER, extensionRegistry));
                            break;
                        case 40:
                            this.bitField0_ |= 0x4;
                            this.waitResponseTimeSec_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.matchTeamInfoA_ = Collections.unmodifiableList(this.matchTeamInfoA_);
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.matchTeamInfoB_ = Collections.unmodifiableList(this.matchTeamInfoB_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchMemberInfoPush.class, Builder.class);
        }

        public static Parser<Five2FiveMatchMemberInfoPush> PARSER = (Parser<Five2FiveMatchMemberInfoPush>) new AbstractParser<Five2FiveMatchMemberInfoPush>() {
            public Five2FiveHandler.Five2FiveMatchMemberInfoPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchMemberInfoPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int TEMPTEAMID_FIELD_NUMBER = 2;
        private Object tempTeamId_;
        public static final int MATCHTEAMINFOA_FIELD_NUMBER = 3;
        private List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchTeamInfoA_;
        public static final int MATCHTEAMINFOB_FIELD_NUMBER = 4;
        private List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchTeamInfoB_;
        public static final int WAITRESPONSETIMESEC_FIELD_NUMBER = 5;
        private int waitResponseTimeSec_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchMemberInfoPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasTempTeamId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getTempTeamId() {
            Object ref = this.tempTeamId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.tempTeamId_ = s;
            return s;
        }

        public ByteString getTempTeamIdBytes() {
            Object ref = this.tempTeamId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.tempTeamId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public List<Five2FiveHandler.Five2FiveMatchMemberInfo> getMatchTeamInfoAList() {
            return this.matchTeamInfoA_;
        }

        static {
            defaultInstance.initFields();
        }

        public List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoAOrBuilderList() {
            return (List) this.matchTeamInfoA_;
        }

        public int getMatchTeamInfoACount() {
            return this.matchTeamInfoA_.size();
        }

        public Five2FiveHandler.Five2FiveMatchMemberInfo getMatchTeamInfoA(int index) {
            return this.matchTeamInfoA_.get(index);
        }

        public Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getMatchTeamInfoAOrBuilder(int index) {
            return this.matchTeamInfoA_.get(index);
        }

        public List<Five2FiveHandler.Five2FiveMatchMemberInfo> getMatchTeamInfoBList() {
            return this.matchTeamInfoB_;
        }

        public List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoBOrBuilderList() {
            return (List) this.matchTeamInfoB_;
        }

        public int getMatchTeamInfoBCount() {
            return this.matchTeamInfoB_.size();
        }

        public Five2FiveHandler.Five2FiveMatchMemberInfo getMatchTeamInfoB(int index) {
            return this.matchTeamInfoB_.get(index);
        }

        public Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getMatchTeamInfoBOrBuilder(int index) {
            return this.matchTeamInfoB_.get(index);
        }

        public boolean hasWaitResponseTimeSec() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getWaitResponseTimeSec() {
            return this.waitResponseTimeSec_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.tempTeamId_ = "";
            this.matchTeamInfoA_ = Collections.emptyList();
            this.matchTeamInfoB_ = Collections.emptyList();
            this.waitResponseTimeSec_ = 0;
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
            if (!hasTempTeamId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWaitResponseTimeSec()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getMatchTeamInfoACount(); i++) {
                if (!getMatchTeamInfoA(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getMatchTeamInfoBCount(); i++) {
                if (!getMatchTeamInfoB(i).isInitialized()) {
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
                output.writeBytes(2, getTempTeamIdBytes());
            int i;
            for (i = 0; i < this.matchTeamInfoA_.size(); i++)
                output.writeMessage(3, (MessageLite) this.matchTeamInfoA_.get(i));
            for (i = 0; i < this.matchTeamInfoB_.size(); i++)
                output.writeMessage(4, (MessageLite) this.matchTeamInfoB_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(5, this.waitResponseTimeSec_);
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
                size += CodedOutputStream.computeBytesSize(2, getTempTeamIdBytes());
            int i;
            for (i = 0; i < this.matchTeamInfoA_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.matchTeamInfoA_.get(i));
            for (i = 0; i < this.matchTeamInfoB_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.matchTeamInfoB_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(5, this.waitResponseTimeSec_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchMemberInfoPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveMatchMemberInfoPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchMemberInfoPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchMemberInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveMatchMemberInfoPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveMatchMemberInfoPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object tempTeamId_;
            private List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchTeamInfoA_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveMatchMemberInfo, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder, Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> matchTeamInfoABuilder_;
            private List<Five2FiveHandler.Five2FiveMatchMemberInfo> matchTeamInfoB_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveMatchMemberInfo, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder, Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> matchTeamInfoBBuilder_;
            private int waitResponseTimeSec_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchMemberInfoPush.class, Builder.class);
            }

            private Builder() {
                this.tempTeamId_ = "";
                this.matchTeamInfoA_ = Collections.emptyList();
                this.matchTeamInfoB_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.tempTeamId_ = "";
                this.matchTeamInfoA_ = Collections.emptyList();
                this.matchTeamInfoB_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchMemberInfoPush.alwaysUseFieldBuilders) {
                    getMatchTeamInfoAFieldBuilder();
                    getMatchTeamInfoBFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.tempTeamId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.matchTeamInfoABuilder_ == null) {
                    this.matchTeamInfoA_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.matchTeamInfoABuilder_.clear();
                }
                if (this.matchTeamInfoBBuilder_ == null) {
                    this.matchTeamInfoB_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.matchTeamInfoBBuilder_.clear();
                }
                this.waitResponseTimeSec_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfoPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchMemberInfoPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfoPush build() {
                Five2FiveHandler.Five2FiveMatchMemberInfoPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfoPush buildPartial() {
                Five2FiveHandler.Five2FiveMatchMemberInfoPush result = new Five2FiveHandler.Five2FiveMatchMemberInfoPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.tempTeamId_ = this.tempTeamId_;
                if (this.matchTeamInfoABuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.matchTeamInfoA_ = Collections.unmodifiableList(this.matchTeamInfoA_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.matchTeamInfoA_ = this.matchTeamInfoA_;
                } else {
                    result.matchTeamInfoA_ = this.matchTeamInfoABuilder_.build();
                }
                if (this.matchTeamInfoBBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.matchTeamInfoB_ = Collections.unmodifiableList(this.matchTeamInfoB_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.matchTeamInfoB_ = this.matchTeamInfoB_;
                } else {
                    result.matchTeamInfoB_ = this.matchTeamInfoBBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x4;
                result.waitResponseTimeSec_ = this.waitResponseTimeSec_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchMemberInfoPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchMemberInfoPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchMemberInfoPush other) {
                if (other == Five2FiveHandler.Five2FiveMatchMemberInfoPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasTempTeamId()) {
                    this.bitField0_ |= 0x2;
                    this.tempTeamId_ = other.tempTeamId_;
                    onChanged();
                }
                if (this.matchTeamInfoABuilder_ == null) {
                    if (!other.matchTeamInfoA_.isEmpty()) {
                        if (this.matchTeamInfoA_.isEmpty()) {
                            this.matchTeamInfoA_ = other.matchTeamInfoA_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureMatchTeamInfoAIsMutable();
                            this.matchTeamInfoA_.addAll(other.matchTeamInfoA_);
                        }
                        onChanged();
                    }
                } else if (!other.matchTeamInfoA_.isEmpty()) {
                    if (this.matchTeamInfoABuilder_.isEmpty()) {
                        this.matchTeamInfoABuilder_.dispose();
                        this.matchTeamInfoABuilder_ = null;
                        this.matchTeamInfoA_ = other.matchTeamInfoA_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.matchTeamInfoABuilder_ = Five2FiveHandler.Five2FiveMatchMemberInfoPush.alwaysUseFieldBuilders ? getMatchTeamInfoAFieldBuilder() : null;
                    } else {
                        this.matchTeamInfoABuilder_.addAllMessages(other.matchTeamInfoA_);
                    }
                }
                if (this.matchTeamInfoBBuilder_ == null) {
                    if (!other.matchTeamInfoB_.isEmpty()) {
                        if (this.matchTeamInfoB_.isEmpty()) {
                            this.matchTeamInfoB_ = other.matchTeamInfoB_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureMatchTeamInfoBIsMutable();
                            this.matchTeamInfoB_.addAll(other.matchTeamInfoB_);
                        }
                        onChanged();
                    }
                } else if (!other.matchTeamInfoB_.isEmpty()) {
                    if (this.matchTeamInfoBBuilder_.isEmpty()) {
                        this.matchTeamInfoBBuilder_.dispose();
                        this.matchTeamInfoBBuilder_ = null;
                        this.matchTeamInfoB_ = other.matchTeamInfoB_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.matchTeamInfoBBuilder_ = Five2FiveHandler.Five2FiveMatchMemberInfoPush.alwaysUseFieldBuilders ? getMatchTeamInfoBFieldBuilder() : null;
                    } else {
                        this.matchTeamInfoBBuilder_.addAllMessages(other.matchTeamInfoB_);
                    }
                }
                if (other.hasWaitResponseTimeSec())
                    setWaitResponseTimeSec(other.getWaitResponseTimeSec());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasTempTeamId())
                    return false;
                if (!hasWaitResponseTimeSec())
                    return false;
                int i;
                for (i = 0; i < getMatchTeamInfoACount(); i++) {
                    if (!getMatchTeamInfoA(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getMatchTeamInfoBCount(); i++) {
                    if (!getMatchTeamInfoB(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchMemberInfoPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchMemberInfoPush) Five2FiveHandler.Five2FiveMatchMemberInfoPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchMemberInfoPush) e.getUnfinishedMessage();
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

            public boolean hasTempTeamId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getTempTeamId() {
                Object ref = this.tempTeamId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.tempTeamId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTempTeamIdBytes() {
                Object ref = this.tempTeamId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.tempTeamId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTempTeamId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.tempTeamId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTempTeamId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.tempTeamId_ = Five2FiveHandler.Five2FiveMatchMemberInfoPush.getDefaultInstance().getTempTeamId();
                onChanged();
                return this;
            }

            public Builder setTempTeamIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.tempTeamId_ = value;
                onChanged();
                return this;
            }

            private void ensureMatchTeamInfoAIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.matchTeamInfoA_ = new ArrayList<>(this.matchTeamInfoA_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Five2FiveHandler.Five2FiveMatchMemberInfo> getMatchTeamInfoAList() {
                if (this.matchTeamInfoABuilder_ == null)
                    return Collections.unmodifiableList(this.matchTeamInfoA_);
                return this.matchTeamInfoABuilder_.getMessageList();
            }

            public int getMatchTeamInfoACount() {
                if (this.matchTeamInfoABuilder_ == null)
                    return this.matchTeamInfoA_.size();
                return this.matchTeamInfoABuilder_.getCount();
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo getMatchTeamInfoA(int index) {
                if (this.matchTeamInfoABuilder_ == null)
                    return this.matchTeamInfoA_.get(index);
                return (Five2FiveHandler.Five2FiveMatchMemberInfo) this.matchTeamInfoABuilder_.getMessage(index);
            }

            public Builder setMatchTeamInfoA(int index, Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.matchTeamInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.set(index, value);
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMatchTeamInfoA(int index, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.matchTeamInfoABuilder_ == null) {
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMatchTeamInfoA(Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.matchTeamInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.add(value);
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMatchTeamInfoA(int index, Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.matchTeamInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.add(index, value);
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMatchTeamInfoA(Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.matchTeamInfoABuilder_ == null) {
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMatchTeamInfoA(int index, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.matchTeamInfoABuilder_ == null) {
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMatchTeamInfoA(Iterable<? extends Five2FiveHandler.Five2FiveMatchMemberInfo> values) {
                if (this.matchTeamInfoABuilder_ == null) {
                    ensureMatchTeamInfoAIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.matchTeamInfoA_);
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMatchTeamInfoA() {
                if (this.matchTeamInfoABuilder_ == null) {
                    this.matchTeamInfoA_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.clear();
                }
                return this;
            }

            public Builder removeMatchTeamInfoA(int index) {
                if (this.matchTeamInfoABuilder_ == null) {
                    ensureMatchTeamInfoAIsMutable();
                    this.matchTeamInfoA_.remove(index);
                    onChanged();
                } else {
                    this.matchTeamInfoABuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder getMatchTeamInfoABuilder(int index) {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getMatchTeamInfoAFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getMatchTeamInfoAOrBuilder(int index) {
                if (this.matchTeamInfoABuilder_ == null)
                    return this.matchTeamInfoA_.get(index);
                return (Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder) this.matchTeamInfoABuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoAOrBuilderList() {
                if (this.matchTeamInfoABuilder_ != null)
                    return this.matchTeamInfoABuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.matchTeamInfoA_);
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder addMatchTeamInfoABuilder() {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getMatchTeamInfoAFieldBuilder().addBuilder(Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder addMatchTeamInfoABuilder(int index) {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getMatchTeamInfoAFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FiveMatchMemberInfo.Builder> getMatchTeamInfoABuilderList() {
                return getMatchTeamInfoAFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveMatchMemberInfo, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder, Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoAFieldBuilder() {
                if (this.matchTeamInfoABuilder_ == null) {
                    this.matchTeamInfoABuilder_ = new RepeatedFieldBuilder(this.matchTeamInfoA_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.matchTeamInfoA_ = null;
                }
                return this.matchTeamInfoABuilder_;
            }

            private void ensureMatchTeamInfoBIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.matchTeamInfoB_ = new ArrayList<>(this.matchTeamInfoB_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<Five2FiveHandler.Five2FiveMatchMemberInfo> getMatchTeamInfoBList() {
                if (this.matchTeamInfoBBuilder_ == null)
                    return Collections.unmodifiableList(this.matchTeamInfoB_);
                return this.matchTeamInfoBBuilder_.getMessageList();
            }

            public int getMatchTeamInfoBCount() {
                if (this.matchTeamInfoBBuilder_ == null)
                    return this.matchTeamInfoB_.size();
                return this.matchTeamInfoBBuilder_.getCount();
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo getMatchTeamInfoB(int index) {
                if (this.matchTeamInfoBBuilder_ == null)
                    return this.matchTeamInfoB_.get(index);
                return (Five2FiveHandler.Five2FiveMatchMemberInfo) this.matchTeamInfoBBuilder_.getMessage(index);
            }

            public Builder setMatchTeamInfoB(int index, Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.set(index, value);
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMatchTeamInfoB(int index, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMatchTeamInfoB(Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.add(value);
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMatchTeamInfoB(int index, Five2FiveHandler.Five2FiveMatchMemberInfo value) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.add(index, value);
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMatchTeamInfoB(Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMatchTeamInfoB(int index, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder builderForValue) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMatchTeamInfoB(Iterable<? extends Five2FiveHandler.Five2FiveMatchMemberInfo> values) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    ensureMatchTeamInfoBIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.matchTeamInfoB_);
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMatchTeamInfoB() {
                if (this.matchTeamInfoBBuilder_ == null) {
                    this.matchTeamInfoB_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.clear();
                }
                return this;
            }

            public Builder removeMatchTeamInfoB(int index) {
                if (this.matchTeamInfoBBuilder_ == null) {
                    ensureMatchTeamInfoBIsMutable();
                    this.matchTeamInfoB_.remove(index);
                    onChanged();
                } else {
                    this.matchTeamInfoBBuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder getMatchTeamInfoBBuilder(int index) {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getMatchTeamInfoBFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getMatchTeamInfoBOrBuilder(int index) {
                if (this.matchTeamInfoBBuilder_ == null)
                    return this.matchTeamInfoB_.get(index);
                return (Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder) this.matchTeamInfoBBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoBOrBuilderList() {
                if (this.matchTeamInfoBBuilder_ != null)
                    return this.matchTeamInfoBBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.matchTeamInfoB_);
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder addMatchTeamInfoBBuilder() {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getMatchTeamInfoBFieldBuilder().addBuilder(Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FiveMatchMemberInfo.Builder addMatchTeamInfoBBuilder(int index) {
                return (Five2FiveHandler.Five2FiveMatchMemberInfo.Builder) getMatchTeamInfoBFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FiveMatchMemberInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FiveMatchMemberInfo.Builder> getMatchTeamInfoBBuilderList() {
                return getMatchTeamInfoBFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FiveMatchMemberInfo, Five2FiveHandler.Five2FiveMatchMemberInfo.Builder, Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoBFieldBuilder() {
                if (this.matchTeamInfoBBuilder_ == null) {
                    this.matchTeamInfoBBuilder_ = new RepeatedFieldBuilder(this.matchTeamInfoB_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.matchTeamInfoB_ = null;
                }
                return this.matchTeamInfoBBuilder_;
            }

            public boolean hasWaitResponseTimeSec() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getWaitResponseTimeSec() {
                return this.waitResponseTimeSec_;
            }

            public Builder setWaitResponseTimeSec(int value) {
                this.bitField0_ |= 0x10;
                this.waitResponseTimeSec_ = value;
                onChanged();
                return this;
            }

            public Builder clearWaitResponseTimeSec() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.waitResponseTimeSec_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveMemberChoicePush extends GeneratedMessage implements Five2FiveMemberChoicePushOrBuilder {
        private static final Five2FiveMemberChoicePush defaultInstance = new Five2FiveMemberChoicePush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMemberChoicePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMemberChoicePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMemberChoicePush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMemberChoicePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMemberChoicePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.agreeOrReady_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.playerId_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.choice_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMemberChoicePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMemberChoicePush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMemberChoicePush.class, Builder.class);
        }

        public static Parser<Five2FiveMemberChoicePush> PARSER = (Parser<Five2FiveMemberChoicePush>) new AbstractParser<Five2FiveMemberChoicePush>() {
            public Five2FiveHandler.Five2FiveMemberChoicePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMemberChoicePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int AGREEORREADY_FIELD_NUMBER = 2;
        private int agreeOrReady_;
        public static final int PLAYERID_FIELD_NUMBER = 3;
        private Object playerId_;
        public static final int CHOICE_FIELD_NUMBER = 4;
        private int choice_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMemberChoicePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasAgreeOrReady() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getAgreeOrReady() {
            return this.agreeOrReady_;
        }


        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.playerId_ = s;
            }
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


        public boolean hasChoice() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getChoice() {
            return this.choice_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.agreeOrReady_ = 0;
            this.playerId_ = "";
            this.choice_ = 0;
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
            if (!hasAgreeOrReady()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasChoice()) {
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
                output.writeInt32(2, this.agreeOrReady_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.choice_);
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
                size += CodedOutputStream.computeInt32Size(2, this.agreeOrReady_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.choice_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Five2FiveMemberChoicePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(data);
        }


        public static Five2FiveMemberChoicePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Five2FiveMemberChoicePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(data);
        }


        public static Five2FiveMemberChoicePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Five2FiveMemberChoicePush parseFrom(InputStream input) throws IOException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(input);
        }


        public static Five2FiveMemberChoicePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Five2FiveMemberChoicePush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMemberChoicePush) PARSER.parseDelimitedFrom(input);
        }


        public static Five2FiveMemberChoicePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMemberChoicePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Five2FiveMemberChoicePush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(input);
        }


        public static Five2FiveMemberChoicePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMemberChoicePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Five2FiveMemberChoicePush prototype) {
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
                implements Five2FiveHandler.Five2FiveMemberChoicePushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private int agreeOrReady_;


            private Object playerId_;


            private int choice_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMemberChoicePush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMemberChoicePush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMemberChoicePush.class, Builder.class);
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
                if (Five2FiveHandler.Five2FiveMemberChoicePush.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.agreeOrReady_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.choice_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMemberChoicePush_descriptor;
            }


            public Five2FiveHandler.Five2FiveMemberChoicePush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMemberChoicePush.getDefaultInstance();
            }


            public Five2FiveHandler.Five2FiveMemberChoicePush build() {
                Five2FiveHandler.Five2FiveMemberChoicePush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Five2FiveHandler.Five2FiveMemberChoicePush buildPartial() {
                Five2FiveHandler.Five2FiveMemberChoicePush result = new Five2FiveHandler.Five2FiveMemberChoicePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.agreeOrReady_ = this.agreeOrReady_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.playerId_ = this.playerId_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.choice_ = this.choice_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMemberChoicePush) {
                    return mergeFrom((Five2FiveHandler.Five2FiveMemberChoicePush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Five2FiveHandler.Five2FiveMemberChoicePush other) {
                if (other == Five2FiveHandler.Five2FiveMemberChoicePush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasAgreeOrReady()) {
                    setAgreeOrReady(other.getAgreeOrReady());
                }
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x4;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                if (other.hasChoice()) {
                    setChoice(other.getChoice());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasAgreeOrReady()) {
                    return false;
                }
                if (!hasPlayerId()) {
                    return false;
                }
                if (!hasChoice()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMemberChoicePush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMemberChoicePush) Five2FiveHandler.Five2FiveMemberChoicePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMemberChoicePush) e.getUnfinishedMessage();
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


            public boolean hasAgreeOrReady() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getAgreeOrReady() {
                return this.agreeOrReady_;
            }


            public Builder setAgreeOrReady(int value) {
                this.bitField0_ |= 0x2;
                this.agreeOrReady_ = value;
                onChanged();
                return this;
            }


            public Builder clearAgreeOrReady() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.agreeOrReady_ = 0;
                onChanged();
                return this;
            }


            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getPlayerId() {
                Object ref = this.playerId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.playerId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.playerId_ = value;
                onChanged();
                return this;
            }


            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.playerId_ = Five2FiveHandler.Five2FiveMemberChoicePush.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }


            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.playerId_ = value;
                onChanged();
                return this;
            }


            public boolean hasChoice() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getChoice() {
                return this.choice_;
            }


            public Builder setChoice(int value) {
                this.bitField0_ |= 0x8;
                this.choice_ = value;
                onChanged();
                return this;
            }


            public Builder clearChoice() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.choice_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class Five2FiveGameResult
            extends GeneratedMessage
            implements Five2FiveGameResultOrBuilder {
        private final UnknownFieldSet unknownFields;


        private Five2FiveGameResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private Five2FiveGameResult(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static Five2FiveGameResult getDefaultInstance() {
            return defaultInstance;
        }


        public Five2FiveGameResult getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private Five2FiveGameResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.mvpCount_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.rankChange_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.instanceId_ = bs;
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.currRank_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveGameResult_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveGameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveGameResult.class, Builder.class);
        }


        public static Parser<Five2FiveGameResult> PARSER = (Parser<Five2FiveGameResult>) new AbstractParser<Five2FiveGameResult>() {
            public Five2FiveHandler.Five2FiveGameResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveGameResult(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int RESULT_FIELD_NUMBER = 1;


        private int result_;


        public static final int NEWSCORE_FIELD_NUMBER = 2;


        private int newScore_;


        public static final int CURRSCORE_FIELD_NUMBER = 3;


        private int currScore_;


        public static final int MVPCOUNT_FIELD_NUMBER = 4;


        private int mvpCount_;


        public static final int RANKCHANGE_FIELD_NUMBER = 5;


        private int rankChange_;


        public static final int INSTANCEID_FIELD_NUMBER = 6;


        private Object instanceId_;


        public static final int CURRRANK_FIELD_NUMBER = 7;


        private int currRank_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<Five2FiveGameResult> getParserForType() {
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


        public int getNewScore() {
            return this.newScore_;
        }


        public boolean hasCurrScore() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getCurrScore() {
            return this.currScore_;
        }


        public boolean hasMvpCount() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getMvpCount() {
            return this.mvpCount_;
        }


        public boolean hasRankChange() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getRankChange() {
            return this.rankChange_;
        }


        public boolean hasInstanceId() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public String getInstanceId() {
            Object ref = this.instanceId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.instanceId_ = s;
            }
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


        public boolean hasCurrRank() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public int getCurrRank() {
            return this.currRank_;
        }


        private void initFields() {
            this.result_ = 0;
            this.newScore_ = 0;
            this.currScore_ = 0;
            this.mvpCount_ = 0;
            this.rankChange_ = 0;
            this.instanceId_ = "";
            this.currRank_ = 0;
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
            if (!hasMvpCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRankChange()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasInstanceId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrRank()) {
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
                output.writeInt32(4, this.mvpCount_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.rankChange_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getInstanceIdBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.currRank_);
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
                size += CodedOutputStream.computeInt32Size(4, this.mvpCount_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.rankChange_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeBytesSize(6, getInstanceIdBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(7, this.currRank_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        private static final Five2FiveGameResult defaultInstance = new Five2FiveGameResult(true);

        public static Five2FiveGameResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveGameResult) PARSER.parseFrom(data);
        }

        public static Five2FiveGameResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveGameResult) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveGameResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveGameResult) PARSER.parseFrom(data);
        }

        public static Five2FiveGameResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveGameResult) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveGameResult parseFrom(InputStream input) throws IOException {
            return (Five2FiveGameResult) PARSER.parseFrom(input);
        }

        public static Five2FiveGameResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveGameResult) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveGameResult parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveGameResult) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveGameResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveGameResult) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveGameResult parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveGameResult) PARSER.parseFrom(input);
        }

        public static Five2FiveGameResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveGameResult) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveGameResult prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveGameResultOrBuilder {
            private int bitField0_;
            private int result_;
            private int newScore_;
            private int currScore_;
            private int mvpCount_;
            private int rankChange_;
            private Object instanceId_;
            private int currRank_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveGameResult_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveGameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveGameResult.class, Builder.class);
            }

            private Builder() {
                this.instanceId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.instanceId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveGameResult.alwaysUseFieldBuilders) ;
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
                this.mvpCount_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.rankChange_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.instanceId_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.currRank_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveGameResult_descriptor;
            }

            public Five2FiveHandler.Five2FiveGameResult getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveGameResult.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveGameResult build() {
                Five2FiveHandler.Five2FiveGameResult result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveGameResult buildPartial() {
                Five2FiveHandler.Five2FiveGameResult result = new Five2FiveHandler.Five2FiveGameResult(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.result_ = this.result_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.newScore_ = this.newScore_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.currScore_ = this.currScore_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.mvpCount_ = this.mvpCount_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.rankChange_ = this.rankChange_;
                if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;
                result.instanceId_ = this.instanceId_;
                if ((from_bitField0_ & 0x40) == 64) to_bitField0_ |= 0x40;
                result.currRank_ = this.currRank_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveGameResult)
                    return mergeFrom((Five2FiveHandler.Five2FiveGameResult) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveGameResult other) {
                if (other == Five2FiveHandler.Five2FiveGameResult.getDefaultInstance()) return this;
                if (other.hasResult()) setResult(other.getResult());
                if (other.hasNewScore()) setNewScore(other.getNewScore());
                if (other.hasCurrScore()) setCurrScore(other.getCurrScore());
                if (other.hasMvpCount()) setMvpCount(other.getMvpCount());
                if (other.hasRankChange()) setRankChange(other.getRankChange());
                if (other.hasInstanceId()) {
                    this.bitField0_ |= 0x20;
                    this.instanceId_ = other.instanceId_;
                    onChanged();
                }
                if (other.hasCurrRank()) setCurrRank(other.getCurrRank());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasResult()) return false;
                if (!hasNewScore()) return false;
                if (!hasCurrScore()) return false;
                if (!hasMvpCount()) return false;
                if (!hasRankChange()) return false;
                if (!hasInstanceId()) return false;
                if (!hasCurrRank()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveGameResult parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveGameResult) Five2FiveHandler.Five2FiveGameResult.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveGameResult) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
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

            public boolean hasMvpCount() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getMvpCount() {
                return this.mvpCount_;
            }

            public Builder setMvpCount(int value) {
                this.bitField0_ |= 0x8;
                this.mvpCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearMvpCount() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.mvpCount_ = 0;
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

            public boolean hasInstanceId() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getInstanceId() {
                Object ref = this.instanceId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.instanceId_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.instanceId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstanceId() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.instanceId_ = Five2FiveHandler.Five2FiveGameResult.getDefaultInstance().getInstanceId();
                onChanged();
                return this;
            }

            public Builder setInstanceIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.instanceId_ = value;
                onChanged();
                return this;
            }

            public boolean hasCurrRank() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getCurrRank() {
                return this.currRank_;
            }

            public Builder setCurrRank(int value) {
                this.bitField0_ |= 0x40;
                this.currRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrRank() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.currRank_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveOnGameEndPush
            extends GeneratedMessage
            implements Five2FiveOnGameEndPushOrBuilder {
        private static final Five2FiveOnGameEndPush defaultInstance = new Five2FiveOnGameEndPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveOnGameEndPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveOnGameEndPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveOnGameEndPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveOnGameEndPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveOnGameEndPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    Five2FiveHandler.Five2FiveGameResult.Builder subBuilder;
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
                            this.s2CGameResult_ = (Five2FiveHandler.Five2FiveGameResult) input.readMessage(Five2FiveHandler.Five2FiveGameResult.PARSER, extensionRegistry);
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
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.resultInfoA_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.resultInfoA_.add(input.readMessage(Five2FiveHandler.Five2FivePlayerResultInfo.PARSER, extensionRegistry));
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.resultInfoB_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.resultInfoB_.add(input.readMessage(Five2FiveHandler.Five2FivePlayerResultInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.resultInfoA_ = Collections.unmodifiableList(this.resultInfoA_);
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.resultInfoB_ = Collections.unmodifiableList(this.resultInfoB_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnGameEndPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnGameEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveOnGameEndPush.class, Builder.class);
        }

        public static Parser<Five2FiveOnGameEndPush> PARSER = (Parser<Five2FiveOnGameEndPush>) new AbstractParser<Five2FiveOnGameEndPush>() {
            public Five2FiveHandler.Five2FiveOnGameEndPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveOnGameEndPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_GAMERESULT_FIELD_NUMBER = 2;
        private Five2FiveHandler.Five2FiveGameResult s2CGameResult_;
        public static final int S2C_GAMEOVERTIME_FIELD_NUMBER = 3;
        private int s2CGameOverTime_;
        public static final int RESULTINFOA_FIELD_NUMBER = 4;
        private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoA_;
        public static final int RESULTINFOB_FIELD_NUMBER = 5;
        private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoB_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveOnGameEndPush> getParserForType() {
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

        public Five2FiveHandler.Five2FiveGameResult getS2CGameResult() {
            return this.s2CGameResult_;
        }

        public Five2FiveHandler.Five2FiveGameResultOrBuilder getS2CGameResultOrBuilder() {
            return this.s2CGameResult_;
        }

        public boolean hasS2CGameOverTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CGameOverTime() {
            return this.s2CGameOverTime_;
        }

        public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoAList() {
            return this.resultInfoA_;
        }

        public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAOrBuilderList() {
            return (List) this.resultInfoA_;
        }

        public int getResultInfoACount() {
            return this.resultInfoA_.size();
        }

        public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoA(int index) {
            return this.resultInfoA_.get(index);
        }

        public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoAOrBuilder(int index) {
            return this.resultInfoA_.get(index);
        }

        public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoBList() {
            return this.resultInfoB_;
        }

        public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBOrBuilderList() {
            return (List) this.resultInfoB_;
        }

        public int getResultInfoBCount() {
            return this.resultInfoB_.size();
        }

        public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoB(int index) {
            return this.resultInfoB_.get(index);
        }

        public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoBOrBuilder(int index) {
            return this.resultInfoB_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CGameResult_ = Five2FiveHandler.Five2FiveGameResult.getDefaultInstance();
            this.s2CGameOverTime_ = 0;
            this.resultInfoA_ = Collections.emptyList();
            this.resultInfoB_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            int i;
            for (i = 0; i < getResultInfoACount(); i++) {
                if (!getResultInfoA(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getResultInfoBCount(); i++) {
                if (!getResultInfoB(i).isInitialized()) {
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
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.s2CGameResult_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CGameOverTime_);
            int i;
            for (i = 0; i < this.resultInfoA_.size(); i++)
                output.writeMessage(4, (MessageLite) this.resultInfoA_.get(i));
            for (i = 0; i < this.resultInfoB_.size(); i++)
                output.writeMessage(5, (MessageLite) this.resultInfoB_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CGameResult_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CGameOverTime_);
            int i;
            for (i = 0; i < this.resultInfoA_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.resultInfoA_.get(i));
            for (i = 0; i < this.resultInfoB_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.resultInfoB_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        static {
            defaultInstance.initFields();
        }

        public static Five2FiveOnGameEndPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(data);
        }

        public static Five2FiveOnGameEndPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveOnGameEndPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(data);
        }

        public static Five2FiveOnGameEndPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveOnGameEndPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(input);
        }

        public static Five2FiveOnGameEndPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveOnGameEndPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveOnGameEndPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveOnGameEndPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnGameEndPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveOnGameEndPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(input);
        }

        public static Five2FiveOnGameEndPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnGameEndPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveOnGameEndPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveOnGameEndPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Five2FiveHandler.Five2FiveGameResult s2CGameResult_;
            private SingleFieldBuilder<Five2FiveHandler.Five2FiveGameResult, Five2FiveHandler.Five2FiveGameResult.Builder, Five2FiveHandler.Five2FiveGameResultOrBuilder> s2CGameResultBuilder_;
            private int s2CGameOverTime_;
            private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoA_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> resultInfoABuilder_;
            private List<Five2FiveHandler.Five2FivePlayerResultInfo> resultInfoB_;
            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> resultInfoBBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnGameEndPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnGameEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveOnGameEndPush.class, Builder.class);
            }

            private Builder() {
                this.s2CGameResult_ = Five2FiveHandler.Five2FiveGameResult.getDefaultInstance();
                this.resultInfoA_ = Collections.emptyList();
                this.resultInfoB_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CGameResult_ = Five2FiveHandler.Five2FiveGameResult.getDefaultInstance();
                this.resultInfoA_ = Collections.emptyList();
                this.resultInfoB_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveOnGameEndPush.alwaysUseFieldBuilders) {
                    getS2CGameResultFieldBuilder();
                    getResultInfoAFieldBuilder();
                    getResultInfoBFieldBuilder();
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
                    this.s2CGameResult_ = Five2FiveHandler.Five2FiveGameResult.getDefaultInstance();
                } else {
                    this.s2CGameResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CGameOverTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.resultInfoABuilder_ == null) {
                    this.resultInfoA_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.resultInfoABuilder_.clear();
                }
                if (this.resultInfoBBuilder_ == null) {
                    this.resultInfoB_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.resultInfoBBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnGameEndPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveOnGameEndPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveOnGameEndPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveOnGameEndPush build() {
                Five2FiveHandler.Five2FiveOnGameEndPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveOnGameEndPush buildPartial() {
                Five2FiveHandler.Five2FiveOnGameEndPush result = new Five2FiveHandler.Five2FiveOnGameEndPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                if (this.s2CGameResultBuilder_ == null) {
                    result.s2CGameResult_ = this.s2CGameResult_;
                } else {
                    result.s2CGameResult_ = (Five2FiveHandler.Five2FiveGameResult) this.s2CGameResultBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.s2CGameOverTime_ = this.s2CGameOverTime_;
                if (this.resultInfoABuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.resultInfoA_ = Collections.unmodifiableList(this.resultInfoA_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.resultInfoA_ = this.resultInfoA_;
                } else {
                    result.resultInfoA_ = this.resultInfoABuilder_.build();
                }
                if (this.resultInfoBBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.resultInfoB_ = Collections.unmodifiableList(this.resultInfoB_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.resultInfoB_ = this.resultInfoB_;
                } else {
                    result.resultInfoB_ = this.resultInfoBBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveOnGameEndPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveOnGameEndPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveOnGameEndPush other) {
                if (other == Five2FiveHandler.Five2FiveOnGameEndPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CGameResult())
                    mergeS2CGameResult(other.getS2CGameResult());
                if (other.hasS2CGameOverTime())
                    setS2CGameOverTime(other.getS2CGameOverTime());
                if (this.resultInfoABuilder_ == null) {
                    if (!other.resultInfoA_.isEmpty()) {
                        if (this.resultInfoA_.isEmpty()) {
                            this.resultInfoA_ = other.resultInfoA_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureResultInfoAIsMutable();
                            this.resultInfoA_.addAll(other.resultInfoA_);
                        }
                        onChanged();
                    }
                } else if (!other.resultInfoA_.isEmpty()) {
                    if (this.resultInfoABuilder_.isEmpty()) {
                        this.resultInfoABuilder_.dispose();
                        this.resultInfoABuilder_ = null;
                        this.resultInfoA_ = other.resultInfoA_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.resultInfoABuilder_ = Five2FiveHandler.Five2FiveOnGameEndPush.alwaysUseFieldBuilders ? getResultInfoAFieldBuilder() : null;
                    } else {
                        this.resultInfoABuilder_.addAllMessages(other.resultInfoA_);
                    }
                }
                if (this.resultInfoBBuilder_ == null) {
                    if (!other.resultInfoB_.isEmpty()) {
                        if (this.resultInfoB_.isEmpty()) {
                            this.resultInfoB_ = other.resultInfoB_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureResultInfoBIsMutable();
                            this.resultInfoB_.addAll(other.resultInfoB_);
                        }
                        onChanged();
                    }
                } else if (!other.resultInfoB_.isEmpty()) {
                    if (this.resultInfoBBuilder_.isEmpty()) {
                        this.resultInfoBBuilder_.dispose();
                        this.resultInfoBBuilder_ = null;
                        this.resultInfoB_ = other.resultInfoB_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.resultInfoBBuilder_ = Five2FiveHandler.Five2FiveOnGameEndPush.alwaysUseFieldBuilders ? getResultInfoBFieldBuilder() : null;
                    } else {
                        this.resultInfoBBuilder_.addAllMessages(other.resultInfoB_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CGameResult())
                    return false;
                if (!hasS2CGameOverTime())
                    return false;
                if (!getS2CGameResult().isInitialized())
                    return false;
                int i;
                for (i = 0; i < getResultInfoACount(); i++) {
                    if (!getResultInfoA(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getResultInfoBCount(); i++) {
                    if (!getResultInfoB(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveOnGameEndPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveOnGameEndPush) Five2FiveHandler.Five2FiveOnGameEndPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveOnGameEndPush) e.getUnfinishedMessage();
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

            public boolean hasS2CGameResult() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Five2FiveHandler.Five2FiveGameResult getS2CGameResult() {
                if (this.s2CGameResultBuilder_ == null)
                    return this.s2CGameResult_;
                return (Five2FiveHandler.Five2FiveGameResult) this.s2CGameResultBuilder_.getMessage();
            }

            public Builder setS2CGameResult(Five2FiveHandler.Five2FiveGameResult value) {
                if (this.s2CGameResultBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CGameResult_ = value;
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setS2CGameResult(Five2FiveHandler.Five2FiveGameResult.Builder builderForValue) {
                if (this.s2CGameResultBuilder_ == null) {
                    this.s2CGameResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeS2CGameResult(Five2FiveHandler.Five2FiveGameResult value) {
                if (this.s2CGameResultBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.s2CGameResult_ != Five2FiveHandler.Five2FiveGameResult.getDefaultInstance()) {
                        this.s2CGameResult_ = Five2FiveHandler.Five2FiveGameResult.newBuilder(this.s2CGameResult_).mergeFrom(value).buildPartial();
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
                    this.s2CGameResult_ = Five2FiveHandler.Five2FiveGameResult.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Five2FiveHandler.Five2FiveGameResult.Builder getS2CGameResultBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (Five2FiveHandler.Five2FiveGameResult.Builder) getS2CGameResultFieldBuilder().getBuilder();
            }

            public Five2FiveHandler.Five2FiveGameResultOrBuilder getS2CGameResultOrBuilder() {
                if (this.s2CGameResultBuilder_ != null)
                    return (Five2FiveHandler.Five2FiveGameResultOrBuilder) this.s2CGameResultBuilder_.getMessageOrBuilder();
                return this.s2CGameResult_;
            }

            private SingleFieldBuilder<Five2FiveHandler.Five2FiveGameResult, Five2FiveHandler.Five2FiveGameResult.Builder, Five2FiveHandler.Five2FiveGameResultOrBuilder> getS2CGameResultFieldBuilder() {
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

            private void ensureResultInfoAIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.resultInfoA_ = new ArrayList<>(this.resultInfoA_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoAList() {
                if (this.resultInfoABuilder_ == null)
                    return Collections.unmodifiableList(this.resultInfoA_);
                return this.resultInfoABuilder_.getMessageList();
            }

            public int getResultInfoACount() {
                if (this.resultInfoABuilder_ == null)
                    return this.resultInfoA_.size();
                return this.resultInfoABuilder_.getCount();
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoA(int index) {
                if (this.resultInfoABuilder_ == null)
                    return this.resultInfoA_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfo) this.resultInfoABuilder_.getMessage(index);
            }

            public Builder setResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.set(index, value);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoABuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoA(Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(value);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoABuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(index, value);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addResultInfoA(Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoA(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllResultInfoA(Iterable<? extends Five2FiveHandler.Five2FivePlayerResultInfo> values) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.resultInfoA_);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearResultInfoA() {
                if (this.resultInfoABuilder_ == null) {
                    this.resultInfoA_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.resultInfoABuilder_.clear();
                }
                return this;
            }

            public Builder removeResultInfoA(int index) {
                if (this.resultInfoABuilder_ == null) {
                    ensureResultInfoAIsMutable();
                    this.resultInfoA_.remove(index);
                    onChanged();
                } else {
                    this.resultInfoABuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder getResultInfoABuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoAFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoAOrBuilder(int index) {
                if (this.resultInfoABuilder_ == null)
                    return this.resultInfoA_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder) this.resultInfoABuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAOrBuilderList() {
                if (this.resultInfoABuilder_ != null)
                    return this.resultInfoABuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.resultInfoA_);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoABuilder() {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoAFieldBuilder().addBuilder(Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoABuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoAFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo.Builder> getResultInfoABuilderList() {
                return getResultInfoAFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAFieldBuilder() {
                if (this.resultInfoABuilder_ == null) {
                    this.resultInfoABuilder_ = new RepeatedFieldBuilder(this.resultInfoA_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.resultInfoA_ = null;
                }
                return this.resultInfoABuilder_;
            }

            private void ensureResultInfoBIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.resultInfoB_ = new ArrayList<>(this.resultInfoB_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoBList() {
                if (this.resultInfoBBuilder_ == null)
                    return Collections.unmodifiableList(this.resultInfoB_);
                return this.resultInfoBBuilder_.getMessageList();
            }

            public int getResultInfoBCount() {
                if (this.resultInfoBBuilder_ == null)
                    return this.resultInfoB_.size();
                return this.resultInfoBBuilder_.getCount();
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoB(int index) {
                if (this.resultInfoBBuilder_ == null)
                    return this.resultInfoB_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfo) this.resultInfoBBuilder_.getMessage(index);
            }

            public Builder setResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.set(index, value);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoB(Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(value);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo value) {
                if (this.resultInfoBBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(index, value);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addResultInfoB(Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addResultInfoB(int index, Five2FiveHandler.Five2FivePlayerResultInfo.Builder builderForValue) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllResultInfoB(Iterable<? extends Five2FiveHandler.Five2FivePlayerResultInfo> values) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.resultInfoB_);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearResultInfoB() {
                if (this.resultInfoBBuilder_ == null) {
                    this.resultInfoB_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.clear();
                }
                return this;
            }

            public Builder removeResultInfoB(int index) {
                if (this.resultInfoBBuilder_ == null) {
                    ensureResultInfoBIsMutable();
                    this.resultInfoB_.remove(index);
                    onChanged();
                } else {
                    this.resultInfoBBuilder_.remove(index);
                }
                return this;
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder getResultInfoBBuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoBFieldBuilder().getBuilder(index);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoBOrBuilder(int index) {
                if (this.resultInfoBBuilder_ == null)
                    return this.resultInfoB_.get(index);
                return (Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder) this.resultInfoBBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBOrBuilderList() {
                if (this.resultInfoBBuilder_ != null)
                    return this.resultInfoBBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.resultInfoB_);
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoBBuilder() {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoBFieldBuilder().addBuilder(Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public Five2FiveHandler.Five2FivePlayerResultInfo.Builder addResultInfoBBuilder(int index) {
                return (Five2FiveHandler.Five2FivePlayerResultInfo.Builder) getResultInfoBFieldBuilder().addBuilder(index, Five2FiveHandler.Five2FivePlayerResultInfo.getDefaultInstance());
            }

            public List<Five2FiveHandler.Five2FivePlayerResultInfo.Builder> getResultInfoBBuilderList() {
                return getResultInfoBFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Five2FiveHandler.Five2FivePlayerResultInfo, Five2FiveHandler.Five2FivePlayerResultInfo.Builder, Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBFieldBuilder() {
                if (this.resultInfoBBuilder_ == null) {
                    this.resultInfoBBuilder_ = new RepeatedFieldBuilder(this.resultInfoB_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.resultInfoB_ = null;
                }
                return this.resultInfoBBuilder_;
            }
        }
    }

    public static final class Five2FiveOnNewRewardPush extends GeneratedMessage implements Five2FiveOnNewRewardPushOrBuilder {
        private static final Five2FiveOnNewRewardPush defaultInstance = new Five2FiveOnNewRewardPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveOnNewRewardPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveOnNewRewardPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveOnNewRewardPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveOnNewRewardPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveOnNewRewardPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveOnNewRewardPush.class, Builder.class);
        }

        public static Parser<Five2FiveOnNewRewardPush> PARSER = (Parser<Five2FiveOnNewRewardPush>) new AbstractParser<Five2FiveOnNewRewardPush>() {
            public Five2FiveHandler.Five2FiveOnNewRewardPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveOnNewRewardPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveOnNewRewardPush> getParserForType() {
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

        public static Five2FiveOnNewRewardPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(data);
        }

        public static Five2FiveOnNewRewardPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveOnNewRewardPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(data);
        }

        public static Five2FiveOnNewRewardPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveOnNewRewardPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(input);
        }

        public static Five2FiveOnNewRewardPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveOnNewRewardPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveOnNewRewardPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveOnNewRewardPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnNewRewardPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveOnNewRewardPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(input);
        }

        public static Five2FiveOnNewRewardPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnNewRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveOnNewRewardPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveOnNewRewardPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveOnNewRewardPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveOnNewRewardPush.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveOnNewRewardPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveOnNewRewardPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveOnNewRewardPush build() {
                Five2FiveHandler.Five2FiveOnNewRewardPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveOnNewRewardPush buildPartial() {
                Five2FiveHandler.Five2FiveOnNewRewardPush result = new Five2FiveHandler.Five2FiveOnNewRewardPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveOnNewRewardPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveOnNewRewardPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveOnNewRewardPush other) {
                if (other == Five2FiveHandler.Five2FiveOnNewRewardPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveOnNewRewardPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveOnNewRewardPush) Five2FiveHandler.Five2FiveOnNewRewardPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveOnNewRewardPush) e.getUnfinishedMessage();
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


    public static final class Five2FiveOnNoRewardPush
            extends GeneratedMessage
            implements Five2FiveOnNoRewardPushOrBuilder {
        private static final Five2FiveOnNoRewardPush defaultInstance = new Five2FiveOnNoRewardPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveOnNoRewardPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveOnNoRewardPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveOnNoRewardPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveOnNoRewardPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveOnNoRewardPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveOnNoRewardPush.class, Builder.class);
        }

        public static Parser<Five2FiveOnNoRewardPush> PARSER = (Parser<Five2FiveOnNoRewardPush>) new AbstractParser<Five2FiveOnNoRewardPush>() {
            public Five2FiveHandler.Five2FiveOnNoRewardPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveOnNoRewardPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveOnNoRewardPush> getParserForType() {
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

        public static Five2FiveOnNoRewardPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(data);
        }

        public static Five2FiveOnNoRewardPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveOnNoRewardPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(data);
        }

        public static Five2FiveOnNoRewardPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveOnNoRewardPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(input);
        }

        public static Five2FiveOnNoRewardPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveOnNoRewardPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveOnNoRewardPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveOnNoRewardPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnNoRewardPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveOnNoRewardPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(input);
        }

        public static Five2FiveOnNoRewardPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveOnNoRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveOnNoRewardPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveOnNoRewardPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveOnNoRewardPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveOnNoRewardPush.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveOnNoRewardPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveOnNoRewardPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveOnNoRewardPush build() {
                Five2FiveHandler.Five2FiveOnNoRewardPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveOnNoRewardPush buildPartial() {
                Five2FiveHandler.Five2FiveOnNoRewardPush result = new Five2FiveHandler.Five2FiveOnNoRewardPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveOnNoRewardPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveOnNoRewardPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveOnNoRewardPush other) {
                if (other == Five2FiveHandler.Five2FiveOnNoRewardPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveOnNoRewardPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveOnNoRewardPush) Five2FiveHandler.Five2FiveOnNoRewardPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveOnNoRewardPush) e.getUnfinishedMessage();
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


    public static final class Five2FiveMatchFailedPush
            extends GeneratedMessage
            implements Five2FiveMatchFailedPushOrBuilder {
        private static final Five2FiveMatchFailedPush defaultInstance = new Five2FiveMatchFailedPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchFailedPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchFailedPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchFailedPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchFailedPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchFailedPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    Five2FiveHandler.Five2FiveMatchTime.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.five2FiveMatchTime_.toBuilder();
                            this.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) input.readMessage(Five2FiveHandler.Five2FiveMatchTime.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.five2FiveMatchTime_);
                                this.five2FiveMatchTime_ = subBuilder.buildPartial();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchFailedPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchFailedPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchFailedPush.class, Builder.class);
        }

        public static Parser<Five2FiveMatchFailedPush> PARSER = (Parser<Five2FiveMatchFailedPush>) new AbstractParser<Five2FiveMatchFailedPush>() {
            public Five2FiveHandler.Five2FiveMatchFailedPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchFailedPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int FIVE2FIVEMATCHTIME_FIELD_NUMBER = 2;
        private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchFailedPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasFive2FiveMatchTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
            return this.five2FiveMatchTime_;
        }

        public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
            return this.five2FiveMatchTime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
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
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.five2FiveMatchTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.five2FiveMatchTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveMatchFailedPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchFailedPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchFailedPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchFailedPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchFailedPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchFailedPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchFailedPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchFailedPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveMatchFailedPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchFailedPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchFailedPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchFailedPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchFailedPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveMatchFailedPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveMatchFailedPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> five2FiveMatchTimeBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchFailedPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchFailedPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchFailedPush.class, Builder.class);
            }

            private Builder() {
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchFailedPush.alwaysUseFieldBuilders)
                    getFive2FiveMatchTimeFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchFailedPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveMatchFailedPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchFailedPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveMatchFailedPush build() {
                Five2FiveHandler.Five2FiveMatchFailedPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveMatchFailedPush buildPartial() {
                Five2FiveHandler.Five2FiveMatchFailedPush result = new Five2FiveHandler.Five2FiveMatchFailedPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    result.five2FiveMatchTime_ = this.five2FiveMatchTime_;
                } else {
                    result.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchFailedPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchFailedPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchFailedPush other) {
                if (other == Five2FiveHandler.Five2FiveMatchFailedPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasFive2FiveMatchTime()) mergeFive2FiveMatchTime(other.getFive2FiveMatchTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchFailedPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchFailedPush) Five2FiveHandler.Five2FiveMatchFailedPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchFailedPush) e.getUnfinishedMessage();
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

            public boolean hasFive2FiveMatchTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null) return this.five2FiveMatchTime_;
                return (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.getMessage();
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.five2FiveMatchTime_ = value;
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime.Builder builderForValue) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = builderForValue.build();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.five2FiveMatchTime_ != Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance()) {
                        this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.newBuilder(this.five2FiveMatchTime_).mergeFrom(value).buildPartial();
                    } else {
                        this.five2FiveMatchTime_ = value;
                    }
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchTime.Builder getFive2FiveMatchTimeBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (Five2FiveHandler.Five2FiveMatchTime.Builder) getFive2FiveMatchTimeFieldBuilder().getBuilder();
            }

            public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
                if (this.five2FiveMatchTimeBuilder_ != null)
                    return (Five2FiveHandler.Five2FiveMatchTimeOrBuilder) this.five2FiveMatchTimeBuilder_.getMessageOrBuilder();
                return this.five2FiveMatchTime_;
            }

            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> getFive2FiveMatchTimeFieldBuilder() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTimeBuilder_ = new SingleFieldBuilder(getFive2FiveMatchTime(), getParentForChildren(), isClean());
                    this.five2FiveMatchTime_ = null;
                }
                return this.five2FiveMatchTimeBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveIndexInfo
            extends GeneratedMessage
            implements Five2FiveIndexInfoOrBuilder {
        private static final Five2FiveIndexInfo defaultInstance = new Five2FiveIndexInfo(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveIndexInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveIndexInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveIndexInfo getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveIndexInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveIndexInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveIndexInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveIndexInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveIndexInfo.class, Builder.class);
        }

        public static Parser<Five2FiveIndexInfo> PARSER = (Parser<Five2FiveIndexInfo>) new AbstractParser<Five2FiveIndexInfo>() {
            public Five2FiveHandler.Five2FiveIndexInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveIndexInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        public static final int PLAYERNAME_FIELD_NUMBER = 2;
        private Object playerName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveIndexInfo> getParserForType() {
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
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.playerName_ = s;
            }
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


        private void initFields() {
            this.playerId_ = "";
            this.playerName_ = "";
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
                output.writeBytes(1, getPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getPlayerNameBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getPlayerNameBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Five2FiveIndexInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(data);
        }


        public static Five2FiveIndexInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Five2FiveIndexInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(data);
        }


        public static Five2FiveIndexInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Five2FiveIndexInfo parseFrom(InputStream input) throws IOException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(input);
        }


        public static Five2FiveIndexInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Five2FiveIndexInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveIndexInfo) PARSER.parseDelimitedFrom(input);
        }


        public static Five2FiveIndexInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveIndexInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Five2FiveIndexInfo parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(input);
        }


        public static Five2FiveIndexInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveIndexInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Five2FiveIndexInfo prototype) {
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
                implements Five2FiveHandler.Five2FiveIndexInfoOrBuilder {
            private int bitField0_;

            private Object playerId_;

            private Object playerName_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveIndexInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveIndexInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveIndexInfo.class, Builder.class);
            }


            private Builder() {
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                this.playerName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveIndexInfo.alwaysUseFieldBuilders) ;
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
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveIndexInfo_descriptor;
            }

            public Five2FiveHandler.Five2FiveIndexInfo getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveIndexInfo.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveIndexInfo build() {
                Five2FiveHandler.Five2FiveIndexInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public Five2FiveHandler.Five2FiveIndexInfo buildPartial() {
                Five2FiveHandler.Five2FiveIndexInfo result = new Five2FiveHandler.Five2FiveIndexInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.playerId_ = this.playerId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.playerName_ = this.playerName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveIndexInfo) {
                    return mergeFrom((Five2FiveHandler.Five2FiveIndexInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveIndexInfo other) {
                if (other == Five2FiveHandler.Five2FiveIndexInfo.getDefaultInstance()) {
                    return this;
                }
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
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveIndexInfo parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveIndexInfo) Five2FiveHandler.Five2FiveIndexInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveIndexInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
                    if (bs.isValidUtf8()) {
                        this.playerId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = Five2FiveHandler.Five2FiveIndexInfo.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
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
                this.bitField0_ |= 0x2;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerName_ = Five2FiveHandler.Five2FiveIndexInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.playerName_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class Five2FiveLeaderCancelMatchPush
            extends GeneratedMessage
            implements Five2FiveLeaderCancelMatchPushOrBuilder {
        private static final Five2FiveLeaderCancelMatchPush defaultInstance = new Five2FiveLeaderCancelMatchPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveLeaderCancelMatchPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveLeaderCancelMatchPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveLeaderCancelMatchPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveLeaderCancelMatchPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveLeaderCancelMatchPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveLeaderCancelMatchPush.class, Builder.class);
        }

        public static Parser<Five2FiveLeaderCancelMatchPush> PARSER = (Parser<Five2FiveLeaderCancelMatchPush>) new AbstractParser<Five2FiveLeaderCancelMatchPush>() {
            public Five2FiveHandler.Five2FiveLeaderCancelMatchPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveLeaderCancelMatchPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveLeaderCancelMatchPush> getParserForType() {
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

        public static Five2FiveLeaderCancelMatchPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(data);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(data);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(input);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveLeaderCancelMatchPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveLeaderCancelMatchPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(input);
        }

        public static Five2FiveLeaderCancelMatchPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveLeaderCancelMatchPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveLeaderCancelMatchPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveLeaderCancelMatchPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveLeaderCancelMatchPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveLeaderCancelMatchPush.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveLeaderCancelMatchPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveLeaderCancelMatchPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveLeaderCancelMatchPush build() {
                Five2FiveHandler.Five2FiveLeaderCancelMatchPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveLeaderCancelMatchPush buildPartial() {
                Five2FiveHandler.Five2FiveLeaderCancelMatchPush result = new Five2FiveHandler.Five2FiveLeaderCancelMatchPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveLeaderCancelMatchPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveLeaderCancelMatchPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveLeaderCancelMatchPush other) {
                if (other == Five2FiveHandler.Five2FiveLeaderCancelMatchPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveLeaderCancelMatchPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveLeaderCancelMatchPush) Five2FiveHandler.Five2FiveLeaderCancelMatchPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveLeaderCancelMatchPush) e.getUnfinishedMessage();
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


    public static final class Five2FiveTeamChangePush
            extends GeneratedMessage
            implements Five2FiveTeamChangePushOrBuilder {
        private static final Five2FiveTeamChangePush defaultInstance = new Five2FiveTeamChangePush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveTeamChangePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveTeamChangePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveTeamChangePush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveTeamChangePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveTeamChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveTeamChangePush.class, Builder.class);
        }

        public static Parser<Five2FiveTeamChangePush> PARSER = (Parser<Five2FiveTeamChangePush>) new AbstractParser<Five2FiveTeamChangePush>() {
            public Five2FiveHandler.Five2FiveTeamChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveTeamChangePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveTeamChangePush> getParserForType() {
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

        public static Five2FiveTeamChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(data);
        }

        public static Five2FiveTeamChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveTeamChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(data);
        }

        public static Five2FiveTeamChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveTeamChangePush parseFrom(InputStream input) throws IOException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(input);
        }

        public static Five2FiveTeamChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveTeamChangePush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveTeamChangePush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveTeamChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveTeamChangePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveTeamChangePush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(input);
        }

        public static Five2FiveTeamChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveTeamChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveTeamChangePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveTeamChangePushOrBuilder {
            private int bitField0_;
            private int s2CCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveTeamChangePush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveTeamChangePush.alwaysUseFieldBuilders) ;
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
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveTeamChangePush_descriptor;
            }

            public Five2FiveHandler.Five2FiveTeamChangePush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveTeamChangePush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveTeamChangePush build() {
                Five2FiveHandler.Five2FiveTeamChangePush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveTeamChangePush buildPartial() {
                Five2FiveHandler.Five2FiveTeamChangePush result = new Five2FiveHandler.Five2FiveTeamChangePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveTeamChangePush)
                    return mergeFrom((Five2FiveHandler.Five2FiveTeamChangePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveTeamChangePush other) {
                if (other == Five2FiveHandler.Five2FiveTeamChangePush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveTeamChangePush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveTeamChangePush) Five2FiveHandler.Five2FiveTeamChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveTeamChangePush) e.getUnfinishedMessage();
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


    public static final class Five2FiveMatchPoolChangePush
            extends GeneratedMessage
            implements Five2FiveMatchPoolChangePushOrBuilder {
        private static final Five2FiveMatchPoolChangePush defaultInstance = new Five2FiveMatchPoolChangePush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveMatchPoolChangePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveMatchPoolChangePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveMatchPoolChangePush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveMatchPoolChangePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveMatchPoolChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.preNumber_ = input.readInt32();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveMatchPoolChangePush.class, Builder.class);
        }

        public static Parser<Five2FiveMatchPoolChangePush> PARSER = (Parser<Five2FiveMatchPoolChangePush>) new AbstractParser<Five2FiveMatchPoolChangePush>() {
            public Five2FiveHandler.Five2FiveMatchPoolChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveMatchPoolChangePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int PRE_NUMBER_FIELD_NUMBER = 2;
        private int preNumber_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveMatchPoolChangePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasPreNumber() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getPreNumber() {
            return this.preNumber_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.preNumber_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPreNumber()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.preNumber_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.preNumber_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveMatchPoolChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(data);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(InputStream input) throws IOException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchPoolChangePush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveMatchPoolChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(input);
        }

        public static Five2FiveMatchPoolChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveMatchPoolChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveMatchPoolChangePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveMatchPoolChangePushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int preNumber_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveMatchPoolChangePush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveMatchPoolChangePush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.preNumber_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_descriptor;
            }

            public Five2FiveHandler.Five2FiveMatchPoolChangePush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveMatchPoolChangePush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveMatchPoolChangePush build() {
                Five2FiveHandler.Five2FiveMatchPoolChangePush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveMatchPoolChangePush buildPartial() {
                Five2FiveHandler.Five2FiveMatchPoolChangePush result = new Five2FiveHandler.Five2FiveMatchPoolChangePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.preNumber_ = this.preNumber_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveMatchPoolChangePush)
                    return mergeFrom((Five2FiveHandler.Five2FiveMatchPoolChangePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveMatchPoolChangePush other) {
                if (other == Five2FiveHandler.Five2FiveMatchPoolChangePush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasPreNumber()) setPreNumber(other.getPreNumber());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (!hasPreNumber()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveMatchPoolChangePush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchPoolChangePush) Five2FiveHandler.Five2FiveMatchPoolChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveMatchPoolChangePush) e.getUnfinishedMessage();
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

            public boolean hasPreNumber() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getPreNumber() {
                return this.preNumber_;
            }

            public Builder setPreNumber(int value) {
                this.bitField0_ |= 0x2;
                this.preNumber_ = value;
                onChanged();
                return this;
            }

            public Builder clearPreNumber() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.preNumber_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Five2FiveApplyMatchResultPush
            extends GeneratedMessage
            implements Five2FiveApplyMatchResultPushOrBuilder {
        private static final Five2FiveApplyMatchResultPush defaultInstance = new Five2FiveApplyMatchResultPush(true);
        private final UnknownFieldSet unknownFields;

        private Five2FiveApplyMatchResultPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Five2FiveApplyMatchResultPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Five2FiveApplyMatchResultPush getDefaultInstance() {
            return defaultInstance;
        }

        public Five2FiveApplyMatchResultPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Five2FiveApplyMatchResultPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    Five2FiveHandler.Five2FiveMatchTime.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.five2FiveMatchTime_.toBuilder();
                            this.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) input.readMessage(Five2FiveHandler.Five2FiveMatchTime.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.five2FiveMatchTime_);
                                this.five2FiveMatchTime_ = subBuilder.buildPartial();
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
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveApplyMatchResultPush.class, Builder.class);
        }

        public static Parser<Five2FiveApplyMatchResultPush> PARSER = (Parser<Five2FiveApplyMatchResultPush>) new AbstractParser<Five2FiveApplyMatchResultPush>() {
            public Five2FiveHandler.Five2FiveApplyMatchResultPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Five2FiveHandler.Five2FiveApplyMatchResultPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int FIVE2FIVEMATCHTIME_FIELD_NUMBER = 2;
        private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Five2FiveApplyMatchResultPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasFive2FiveMatchTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
            return this.five2FiveMatchTime_;
        }

        public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
            return this.five2FiveMatchTime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
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
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.five2FiveMatchTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.five2FiveMatchTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Five2FiveApplyMatchResultPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(data);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(data);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(InputStream input) throws IOException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(input);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Five2FiveApplyMatchResultPush parseDelimitedFrom(InputStream input) throws IOException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseDelimitedFrom(input);
        }

        public static Five2FiveApplyMatchResultPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(CodedInputStream input) throws IOException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(input);
        }

        public static Five2FiveApplyMatchResultPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Five2FiveApplyMatchResultPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Five2FiveApplyMatchResultPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Five2FiveHandler.Five2FiveApplyMatchResultPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Five2FiveHandler.Five2FiveMatchTime five2FiveMatchTime_;
            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> five2FiveMatchTimeBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(Five2FiveHandler.Five2FiveApplyMatchResultPush.class, Builder.class);
            }

            private Builder() {
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Five2FiveHandler.Five2FiveApplyMatchResultPush.alwaysUseFieldBuilders)
                    getFive2FiveMatchTimeFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Five2FiveHandler.internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_descriptor;
            }

            public Five2FiveHandler.Five2FiveApplyMatchResultPush getDefaultInstanceForType() {
                return Five2FiveHandler.Five2FiveApplyMatchResultPush.getDefaultInstance();
            }

            public Five2FiveHandler.Five2FiveApplyMatchResultPush build() {
                Five2FiveHandler.Five2FiveApplyMatchResultPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Five2FiveHandler.Five2FiveApplyMatchResultPush buildPartial() {
                Five2FiveHandler.Five2FiveApplyMatchResultPush result = new Five2FiveHandler.Five2FiveApplyMatchResultPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    result.five2FiveMatchTime_ = this.five2FiveMatchTime_;
                } else {
                    result.five2FiveMatchTime_ = (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Five2FiveHandler.Five2FiveApplyMatchResultPush)
                    return mergeFrom((Five2FiveHandler.Five2FiveApplyMatchResultPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Five2FiveHandler.Five2FiveApplyMatchResultPush other) {
                if (other == Five2FiveHandler.Five2FiveApplyMatchResultPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasFive2FiveMatchTime()) mergeFive2FiveMatchTime(other.getFive2FiveMatchTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Five2FiveHandler.Five2FiveApplyMatchResultPush parsedMessage = null;
                try {
                    parsedMessage = (Five2FiveHandler.Five2FiveApplyMatchResultPush) Five2FiveHandler.Five2FiveApplyMatchResultPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Five2FiveHandler.Five2FiveApplyMatchResultPush) e.getUnfinishedMessage();
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

            public boolean hasFive2FiveMatchTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null) return this.five2FiveMatchTime_;
                return (Five2FiveHandler.Five2FiveMatchTime) this.five2FiveMatchTimeBuilder_.getMessage();
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.five2FiveMatchTime_ = value;
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime.Builder builderForValue) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = builderForValue.build();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeFive2FiveMatchTime(Five2FiveHandler.Five2FiveMatchTime value) {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.five2FiveMatchTime_ != Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance()) {
                        this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.newBuilder(this.five2FiveMatchTime_).mergeFrom(value).buildPartial();
                    } else {
                        this.five2FiveMatchTime_ = value;
                    }
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearFive2FiveMatchTime() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTime_ = Five2FiveHandler.Five2FiveMatchTime.getDefaultInstance();
                    onChanged();
                } else {
                    this.five2FiveMatchTimeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Five2FiveHandler.Five2FiveMatchTime.Builder getFive2FiveMatchTimeBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (Five2FiveHandler.Five2FiveMatchTime.Builder) getFive2FiveMatchTimeFieldBuilder().getBuilder();
            }

            public Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder() {
                if (this.five2FiveMatchTimeBuilder_ != null)
                    return (Five2FiveHandler.Five2FiveMatchTimeOrBuilder) this.five2FiveMatchTimeBuilder_.getMessageOrBuilder();
                return this.five2FiveMatchTime_;
            }

            private SingleFieldBuilder<Five2FiveHandler.Five2FiveMatchTime, Five2FiveHandler.Five2FiveMatchTime.Builder, Five2FiveHandler.Five2FiveMatchTimeOrBuilder> getFive2FiveMatchTimeFieldBuilder() {
                if (this.five2FiveMatchTimeBuilder_ == null) {
                    this.five2FiveMatchTimeBuilder_ = new SingleFieldBuilder(getFive2FiveMatchTime(), getParentForChildren(), isClean());
                    this.five2FiveMatchTime_ = null;
                }
                return this.five2FiveMatchTimeBuilder_;
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
        String[] descriptorData = {"\n\026five2FiveHandler.proto\022\020pomelo.five2five\032\fcommon.proto\"\022\n\020Five2FiveRequest\"\001\n\021Five2FiveRankInfo\022\020\n\bplayerId\030\001 \001(\t\022\022\n\nplayerName\030\002 \001(\t\022\021\n\tplayerLvl\030\003 \001(\005\022\013\n\003pro\030\004 \001(\005\022\023\n\013playerUpLvl\030\005 \001(\005\022\030\n\020playerFightPower\030\006 \001(\005\022\r\n\005score\030\007 \001(\005\"<\n\022Five2FiveMatchTime\022\023\n\013avgWaitTime\030\001 \001(\005\022\021\n\tmatchTime\030\002 \001(\005\"è\002\n\021Five2FiveResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022:\n\rfirstRankInfo\030\003 \001(\0132#.pomelo.five2five.Five2Fiv", "eRankInfo\022\r\n\005score\030\004 \001(\005\022\f\n\004rank\030\005 \001(\005\022\013\n\003win\030\006 \001(\005\022\013\n\003tie\030\007 \001(\005\022\f\n\004fail\030\b \001(\005\022\013\n\003mvp\030\t \001(\005\022\033\n\023totalCanReciveCount\030\n \001(\005\022\027\n\017hasRecivedCount\030\013 \001(\005\022@\n\022five2FiveMatchTime\030\f \001(\0132$.pomelo.five2five.Five2FiveMatchTime\022\023\n\013matchPeople\030\r \001(\005\022\025\n\rseasonEndTime\030\016 \001(\t\"\037\n\035Five2FiveLookBtlReportRequest\"\001\n\022Five2FiveBtlReport\022\016\n\006status\030\001 \001(\005\022\023\n\013scoreChange\030\002 \001(\005\022\021\n\tkillCount\030\003 \001(\005\022\f\n\004hurt\030\004 \001(\005\022\021\n\ttreatMent\030\005 \001(\005", "\022\022\n\ncreateTime\030\006 \001(\t\"u\n\036Five2FiveLookBtlReportResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0220\n\002br\030\003 \003(\0132$.pomelo.five2five.Five2FiveBtlReport\"/\n\025Five2FiveMatchRequest\022\026\n\016matchOrReMatch\030\001 \002(\005\"}\n\026Five2FiveMatchResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022@\n\022five2FiveMatchTime\030\003 \001(\0132$.pomelo.five2five.Five2FiveMatchTime\"\035\n\033Five2FiveRefuseMatchRequest\"A\n\034Five2FiveRefuseMatchResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007", "s2c_msg\030\002 \001(\t\"\034\n\032Five2FiveAgreeMatchRequest\"@\n\033Five2FiveAgreeMatchResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\035\n\033Five2FiveCancelMatchRequest\"A\n\034Five2FiveCancelMatchResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"+\n\025Five2FiveReadyRequest\022\022\n\ntempTeamId\030\001 \002(\t\";\n\026Five2FiveReadyResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\036\n\034Five2FiveReciveRewardRequest\"B\n\035Five2FiveReciveRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007", "s2c_msg\030\002 \001(\t\"\033\n\031Five2FiveLeaveAreaRequest\"?\n\032Five2FiveLeaveAreaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"¿\001\n\031Five2FivePlayerResultInfo\022\020\n\bplayerId\030\001 \002(\t\022\021\n\tkillCount\030\003 \002(\005\022\f\n\004hurt\030\004 \002(\005\022\021\n\ttreatMent\030\005 \002(\005\022\r\n\005isMvp\030\006 \002(\005\022\022\n\nplayerName\030\007 \002(\t\022\023\n\013playerLevel\030\b \002(\005\022\021\n\tplayerPro\030\t \002(\005\022\021\n\tdeadCount\030\n \002(\005\"5\n\037Five2FiveLookMatchResultRequest\022\022\n\ninstanceId\030\001 \002(\t\"Ú\001\n Five2FiveLookMatchResultResponse\022\020\n\bs2c", "_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022@\n\013resultInfoA\030\003 \003(\0132+.pomelo.five2five.Five2FivePlayerResultInfo\022@\n\013resultInfoB\030\004 \003(\0132+.pomelo.five2five.Five2FivePlayerResultInfo\022\017\n\007resultA\030\005 \001(\005\"6\n Five2FiveShardMatchResultRequest\022\022\n\ninstanceId\030\001 \002(\t\"F\n!Five2FiveShardMatchResultResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"4\n\"Five2FiveTeamChangeContinueRequest\022\016\n\006choice\030\001 \002(\005\"{\n\030Five2FiveMatchMemberInfo\022\020\n\bplayerId\030", "\001 \002(\t\022\021\n\tplayerPro\030\002 \002(\005\022\021\n\tplayerLvl\030\003 \002(\005\022\022\n\nplayerName\030\004 \002(\t\022\023\n\013readyStatus\030\005 \002(\005\"\001\n\027Five2FiveApplyMatchPush\022L\n\030five2FiveMatchMemberInfo\030\001 \003(\0132*.pomelo.five2five.Five2FiveMatchMemberInfo\022\033\n\023waitResponseTimeSec\030\002 \002(\005\"é\001\n\034Five2FiveMatchMemberInfoPush\022\020\n\bs2c_code\030\001 \002(\005\022\022\n\ntempTeamId\030\002 \002(\t\022B\n\016matchTeamInfoA\030\003 \003(\0132*.pomelo.five2five.Five2FiveMatchMemberInfo\022B\n\016matchTeamInfoB\030\004 \003(\0132*.pomelo.five2fiv", "e.Five2FiveMatchMemberInfo\022\033\n\023waitResponseTimeSec\030\005 \002(\005\"e\n\031Five2FiveMemberChoicePush\022\020\n\bs2c_code\030\001 \002(\005\022\024\n\fagreeOrReady\030\002 \002(\005\022\020\n\bplayerId\030\003 \002(\t\022\016\n\006choice\030\004 \002(\005\"\001\n\023Five2FiveGameResult\022\016\n\006result\030\001 \002(\005\022\020\n\bnewScore\030\002 \002(\005\022\021\n\tcurrScore\030\003 \002(\005\022\020\n\bmvpCount\030\004 \002(\005\022\022\n\nrankChange\030\005 \002(\005\022\022\n\ninstanceId\030\006 \002(\t\022\020\n\bcurrRank\030\007 \002(\005\"\002\n\026Five2FiveOnGameEndPush\022\020\n\bs2c_code\030\001 \002(\005\022=\n\016s2c_gameResult\030\002 \002(\0132%.pomelo.five2five.", "Five2FiveGameResult\022\030\n\020s2c_gameOverTime\030\003 \002(\005\022@\n\013resultInfoA\030\004 \003(\0132+.pomelo.five2five.Five2FivePlayerResultInfo\022@\n\013resultInfoB\030\005 \003(\0132+.pomelo.five2five.Five2FivePlayerResultInfo\",\n\030Five2FiveOnNewRewardPush\022\020\n\bs2c_code\030\001 \002(\005\"+\n\027Five2FiveOnNoRewardPush\022\020\n\bs2c_code\030\001 \002(\005\"n\n\030Five2FiveMatchFailedPush\022\020\n\bs2c_code\030\001 \002(\005\022@\n\022five2FiveMatchTime\030\002 \001(\0132$.pomelo.five2five.Five2FiveMatchTime\":\n\022Five2FiveIndexIn", "fo\022\020\n\bplayerId\030\001 \001(\t\022\022\n\nplayerName\030\002 \001(\t\"2\n\036Five2FiveLeaderCancelMatchPush\022\020\n\bs2c_code\030\001 \002(\005\"+\n\027Five2FiveTeamChangePush\022\020\n\bs2c_code\030\001 \002(\005\"D\n\034Five2FiveMatchPoolChangePush\022\020\n\bs2c_code\030\001 \002(\005\022\022\n\npre_number\030\002 \002(\005\"s\n\035Five2FiveApplyMatchResultPush\022\020\n\bs2c_code\030\001 \002(\005\022@\n\022five2FiveMatchTime\030\002 \001(\0132$.pomelo.five2five.Five2FiveMatchTime2Õ\n\n\020five2FiveHandler\022[\n\020five2FiveRequest\022\".pomelo.five2five.Five2FiveReques", "t\032#.pomelo.five2five.Five2FiveResponse\022\001\n\035five2FiveLookBtlReportRequest\022/.pomelo.five2five.Five2FiveLookBtlReportRequest\0320.pomelo.five2five.Five2FiveLookBtlReportResponse\022j\n\025five2FiveMatchRequest\022'.pomelo.five2five.Five2FiveMatchRequest\032(.pomelo.five2five.Five2FiveMatchResponse\022|\n\033five2FiveRefuseMatchRequest\022-.pomelo.five2five.Five2FiveRefuseMatchRequest\032..pomelo.five2five.Five2FiveRefuseMatchRes", "ponse\022y\n\032five2FiveAgreeMatchRequest\022,.pomelo.five2five.Five2FiveAgreeMatchRequest\032-.pomelo.five2five.Five2FiveAgreeMatchResponse\022|\n\033five2FiveCancelMatchRequest\022-.pomelo.five2five.Five2FiveCancelMatchRequest\032..pomelo.five2five.Five2FiveCancelMatchResponse\022j\n\025five2FiveReadyRequest\022'.pomelo.five2five.Five2FiveReadyRequest\032(.pomelo.five2five.Five2FiveReadyResponse\022v\n\031five2FiveLeaveAreaRequest\022+.pomelo", ".five2five.Five2FiveLeaveAreaRequest\032,.pomelo.five2five.Five2FiveLeaveAreaResponse\022\n\034five2FiveReciveRewardRequest\022..pomelo.five2five.Five2FiveReciveRewardRequest\032/.pomelo.five2five.Five2FiveReciveRewardResponse\022\001\n\037five2FiveLookMatchResultRequest\0221.pomelo.five2five.Five2FiveLookMatchResultRequest\0322.pomelo.five2five.Five2FiveLookMatchResultResponse\022\001\n five2FiveShardMatchResultRequest\0222.pomelo.fiv", "e2five.Five2FiveShardMatchResultRequest\0323.pomelo.five2five.Five2FiveShardMatchResultResponse2ß\007\n\rfive2FivePush\022R\n\027five2FiveApplyMatchPush\022).pomelo.five2five.Five2FiveApplyMatchPush\032\f.pomelo.Void\022\\\n\034five2FiveMatchMemberInfoPush\022..pomelo.five2five.Five2FiveMatchMemberInfoPush\032\f.pomelo.Void\022V\n\031five2FiveMemberChoicePush\022+.pomelo.five2five.Five2FiveMemberChoicePush\032\f.pomelo.Void\022P\n\026five2FiveOnGameEndPu", "sh\022(.pomelo.five2five.Five2FiveOnGameEndPush\032\f.pomelo.Void\022T\n\030five2FiveOnNewRewardPush\022*.pomelo.five2five.Five2FiveOnNewRewardPush\032\f.pomelo.Void\022R\n\027five2FiveOnNoRewardPush\022).pomelo.five2five.Five2FiveOnNoRewardPush\032\f.pomelo.Void\022T\n\030five2FiveMatchFailedPush\022*.pomelo.five2five.Five2FiveMatchFailedPush\032\f.pomelo.Void\022`\n\036five2FiveLeaderCancelMatchPush\0220.pomelo.five2five.Five2FiveLeaderCancelMatchPush\032\f", ".pomelo.Void\022R\n\027five2FiveTeamChangePush\022).pomelo.five2five.Five2FiveTeamChangePush\032\f.pomelo.Void\022\\\n\034five2FiveMatchPoolChangePush\022..pomelo.five2five.Five2FiveMatchPoolChangePush\032\f.pomelo.Void\022^\n\035five2FiveApplyMatchResultPush\022/.pomelo.five2five.Five2FiveApplyMatchResultPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                Five2FiveHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveRankInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveRankInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveRankInfo_descriptor, new String[]{"PlayerId", "PlayerName", "PlayerLvl", "Pro", "PlayerUpLvl", "PlayerFightPower", "Score"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchTime_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchTime_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchTime_descriptor, new String[]{"AvgWaitTime", "MatchTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "FirstRankInfo", "Score", "Rank", "Win", "Tie", "Fail", "Mvp", "TotalCanReciveCount", "HasRecivedCount", "Five2FiveMatchTime", "MatchPeople", "SeasonEndTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLookBtlReportRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveBtlReport_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveBtlReport_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveBtlReport_descriptor, new String[]{"Status", "ScoreChange", "KillCount", "Hurt", "TreatMent", "CreateTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLookBtlReportResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Br"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchRequest_descriptor, new String[]{"MatchOrReMatch"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Five2FiveMatchTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveRefuseMatchRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveRefuseMatchResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveAgreeMatchRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveAgreeMatchResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveCancelMatchRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveCancelMatchResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveReadyRequest_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveReadyRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveReadyRequest_descriptor, new String[]{"TempTeamId"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveReadyResponse_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveReadyResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveReadyResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_descriptor = getDescriptor().getMessageTypes().get(17);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveReciveRewardRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_descriptor = getDescriptor().getMessageTypes().get(18);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveReciveRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_descriptor = getDescriptor().getMessageTypes().get(19);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLeaveAreaRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_descriptor = getDescriptor().getMessageTypes().get(20);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLeaveAreaResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FivePlayerResultInfo_descriptor = getDescriptor().getMessageTypes().get(21);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FivePlayerResultInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FivePlayerResultInfo_descriptor, new String[]{"PlayerId", "KillCount", "Hurt", "TreatMent", "IsMvp", "PlayerName", "PlayerLevel", "PlayerPro", "DeadCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_descriptor = getDescriptor().getMessageTypes().get(22);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLookMatchResultRequest_descriptor, new String[]{"InstanceId"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_descriptor = getDescriptor().getMessageTypes().get(23);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLookMatchResultResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "ResultInfoA", "ResultInfoB", "ResultA"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_descriptor = getDescriptor().getMessageTypes().get(24);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveShardMatchResultRequest_descriptor, new String[]{"InstanceId"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_descriptor = getDescriptor().getMessageTypes().get(25);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveShardMatchResultResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_descriptor = getDescriptor().getMessageTypes().get(26);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveTeamChangeContinueRequest_descriptor, new String[]{"Choice"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_descriptor = getDescriptor().getMessageTypes().get(27);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchMemberInfo_descriptor, new String[]{"PlayerId", "PlayerPro", "PlayerLvl", "PlayerName", "ReadyStatus"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveApplyMatchPush_descriptor = getDescriptor().getMessageTypes().get(28);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveApplyMatchPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveApplyMatchPush_descriptor, new String[]{"Five2FiveMatchMemberInfo", "WaitResponseTimeSec"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_descriptor = getDescriptor().getMessageTypes().get(29);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchMemberInfoPush_descriptor, new String[]{"S2CCode", "TempTeamId", "MatchTeamInfoA", "MatchTeamInfoB", "WaitResponseTimeSec"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMemberChoicePush_descriptor = getDescriptor().getMessageTypes().get(30);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMemberChoicePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMemberChoicePush_descriptor, new String[]{"S2CCode", "AgreeOrReady", "PlayerId", "Choice"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveGameResult_descriptor = getDescriptor().getMessageTypes().get(31);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveGameResult_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveGameResult_descriptor, new String[]{"Result", "NewScore", "CurrScore", "MvpCount", "RankChange", "InstanceId", "CurrRank"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveOnGameEndPush_descriptor = getDescriptor().getMessageTypes().get(32);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveOnGameEndPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveOnGameEndPush_descriptor, new String[]{"S2CCode", "S2CGameResult", "S2CGameOverTime", "ResultInfoA", "ResultInfoB"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_descriptor = getDescriptor().getMessageTypes().get(33);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveOnNewRewardPush_descriptor, new String[]{"S2CCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_descriptor = getDescriptor().getMessageTypes().get(34);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveOnNoRewardPush_descriptor, new String[]{"S2CCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchFailedPush_descriptor = getDescriptor().getMessageTypes().get(35);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchFailedPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchFailedPush_descriptor, new String[]{"S2CCode", "Five2FiveMatchTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveIndexInfo_descriptor = getDescriptor().getMessageTypes().get(36);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveIndexInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveIndexInfo_descriptor, new String[]{"PlayerId", "PlayerName"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_descriptor = getDescriptor().getMessageTypes().get(37);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveLeaderCancelMatchPush_descriptor, new String[]{"S2CCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveTeamChangePush_descriptor = getDescriptor().getMessageTypes().get(38);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveTeamChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveTeamChangePush_descriptor, new String[]{"S2CCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_descriptor = getDescriptor().getMessageTypes().get(39);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveMatchPoolChangePush_descriptor, new String[]{"S2CCode", "PreNumber"});


    private static final Descriptors.Descriptor internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_descriptor = getDescriptor().getMessageTypes().get(40);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_five2five_Five2FiveApplyMatchResultPush_descriptor, new String[]{"S2CCode", "Five2FiveMatchTime"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface Five2FiveApplyMatchResultPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder();
    }

    public static interface Five2FiveMatchPoolChangePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasPreNumber();

        int getPreNumber();
    }

    public static interface Five2FiveTeamChangePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface Five2FiveLeaderCancelMatchPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface Five2FiveIndexInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();

        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();
    }

    public static interface Five2FiveMatchFailedPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder();
    }

    public static interface Five2FiveOnNoRewardPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface Five2FiveOnNewRewardPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface Five2FiveOnGameEndPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CGameResult();

        Five2FiveHandler.Five2FiveGameResult getS2CGameResult();

        Five2FiveHandler.Five2FiveGameResultOrBuilder getS2CGameResultOrBuilder();

        boolean hasS2CGameOverTime();

        int getS2CGameOverTime();

        List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoAList();

        Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoA(int param1Int);

        int getResultInfoACount();

        List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAOrBuilderList();

        Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoAOrBuilder(int param1Int);

        List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoBList();

        Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoB(int param1Int);

        int getResultInfoBCount();

        List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBOrBuilderList();

        Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoBOrBuilder(int param1Int);
    }

    public static interface Five2FiveGameResultOrBuilder extends MessageOrBuilder {
        boolean hasResult();

        int getResult();

        boolean hasNewScore();

        int getNewScore();

        boolean hasCurrScore();

        int getCurrScore();

        boolean hasMvpCount();

        int getMvpCount();

        boolean hasRankChange();

        int getRankChange();

        boolean hasInstanceId();

        String getInstanceId();

        ByteString getInstanceIdBytes();

        boolean hasCurrRank();

        int getCurrRank();
    }

    public static interface Five2FiveMemberChoicePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasAgreeOrReady();

        int getAgreeOrReady();

        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();

        boolean hasChoice();

        int getChoice();
    }

    public static interface Five2FiveMatchMemberInfoPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasTempTeamId();

        String getTempTeamId();

        ByteString getTempTeamIdBytes();

        List<Five2FiveHandler.Five2FiveMatchMemberInfo> getMatchTeamInfoAList();

        Five2FiveHandler.Five2FiveMatchMemberInfo getMatchTeamInfoA(int param1Int);

        int getMatchTeamInfoACount();

        List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoAOrBuilderList();

        Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getMatchTeamInfoAOrBuilder(int param1Int);

        List<Five2FiveHandler.Five2FiveMatchMemberInfo> getMatchTeamInfoBList();

        Five2FiveHandler.Five2FiveMatchMemberInfo getMatchTeamInfoB(int param1Int);

        int getMatchTeamInfoBCount();

        List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getMatchTeamInfoBOrBuilderList();

        Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getMatchTeamInfoBOrBuilder(int param1Int);

        boolean hasWaitResponseTimeSec();

        int getWaitResponseTimeSec();
    }

    public static interface Five2FiveApplyMatchPushOrBuilder extends MessageOrBuilder {
        List<Five2FiveHandler.Five2FiveMatchMemberInfo> getFive2FiveMatchMemberInfoList();

        Five2FiveHandler.Five2FiveMatchMemberInfo getFive2FiveMatchMemberInfo(int param1Int);

        int getFive2FiveMatchMemberInfoCount();

        List<? extends Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder> getFive2FiveMatchMemberInfoOrBuilderList();

        Five2FiveHandler.Five2FiveMatchMemberInfoOrBuilder getFive2FiveMatchMemberInfoOrBuilder(int param1Int);

        boolean hasWaitResponseTimeSec();

        int getWaitResponseTimeSec();
    }

    public static interface Five2FiveMatchMemberInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();

        boolean hasPlayerPro();

        int getPlayerPro();

        boolean hasPlayerLvl();

        int getPlayerLvl();

        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();

        boolean hasReadyStatus();

        int getReadyStatus();
    }

    public static interface Five2FiveTeamChangeContinueRequestOrBuilder extends MessageOrBuilder {
        boolean hasChoice();

        int getChoice();
    }

    public static interface Five2FiveShardMatchResultResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveShardMatchResultRequestOrBuilder extends MessageOrBuilder {
        boolean hasInstanceId();

        String getInstanceId();

        ByteString getInstanceIdBytes();
    }

    public static interface Five2FiveLookMatchResultResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoAList();

        Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoA(int param1Int);

        int getResultInfoACount();

        List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoAOrBuilderList();

        Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoAOrBuilder(int param1Int);

        List<Five2FiveHandler.Five2FivePlayerResultInfo> getResultInfoBList();

        Five2FiveHandler.Five2FivePlayerResultInfo getResultInfoB(int param1Int);

        int getResultInfoBCount();

        List<? extends Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder> getResultInfoBOrBuilderList();

        Five2FiveHandler.Five2FivePlayerResultInfoOrBuilder getResultInfoBOrBuilder(int param1Int);

        boolean hasResultA();

        int getResultA();
    }

    public static interface Five2FiveLookMatchResultRequestOrBuilder extends MessageOrBuilder {
        boolean hasInstanceId();

        String getInstanceId();

        ByteString getInstanceIdBytes();
    }

    public static interface Five2FivePlayerResultInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();

        boolean hasKillCount();

        int getKillCount();

        boolean hasHurt();

        int getHurt();

        boolean hasTreatMent();

        int getTreatMent();

        boolean hasIsMvp();

        int getIsMvp();

        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();

        boolean hasPlayerLevel();

        int getPlayerLevel();

        boolean hasPlayerPro();

        int getPlayerPro();

        boolean hasDeadCount();

        int getDeadCount();
    }

    public static interface Five2FiveLeaveAreaResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveLeaveAreaRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface Five2FiveReciveRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveReciveRewardRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface Five2FiveReadyResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveReadyRequestOrBuilder extends MessageOrBuilder {
        boolean hasTempTeamId();

        String getTempTeamId();

        ByteString getTempTeamIdBytes();
    }

    public static interface Five2FiveCancelMatchResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveCancelMatchRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface Five2FiveAgreeMatchResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveAgreeMatchRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface Five2FiveRefuseMatchResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface Five2FiveRefuseMatchRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface Five2FiveMatchResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder();
    }

    public static interface Five2FiveMatchRequestOrBuilder extends MessageOrBuilder {
        boolean hasMatchOrReMatch();

        int getMatchOrReMatch();
    }

    public static interface Five2FiveLookBtlReportResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<Five2FiveHandler.Five2FiveBtlReport> getBrList();

        Five2FiveHandler.Five2FiveBtlReport getBr(int param1Int);

        int getBrCount();

        List<? extends Five2FiveHandler.Five2FiveBtlReportOrBuilder> getBrOrBuilderList();

        Five2FiveHandler.Five2FiveBtlReportOrBuilder getBrOrBuilder(int param1Int);
    }

    public static interface Five2FiveBtlReportOrBuilder extends MessageOrBuilder {
        boolean hasStatus();

        int getStatus();

        boolean hasScoreChange();

        int getScoreChange();

        boolean hasKillCount();

        int getKillCount();

        boolean hasHurt();

        int getHurt();

        boolean hasTreatMent();

        int getTreatMent();

        boolean hasCreateTime();

        String getCreateTime();

        ByteString getCreateTimeBytes();
    }

    public static interface Five2FiveLookBtlReportRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface Five2FiveResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasFirstRankInfo();

        Five2FiveHandler.Five2FiveRankInfo getFirstRankInfo();

        Five2FiveHandler.Five2FiveRankInfoOrBuilder getFirstRankInfoOrBuilder();

        boolean hasScore();

        int getScore();

        boolean hasRank();

        int getRank();

        boolean hasWin();

        int getWin();

        boolean hasTie();

        int getTie();

        boolean hasFail();

        int getFail();

        boolean hasMvp();

        int getMvp();

        boolean hasTotalCanReciveCount();

        int getTotalCanReciveCount();

        boolean hasHasRecivedCount();

        int getHasRecivedCount();

        boolean hasFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTime getFive2FiveMatchTime();

        Five2FiveHandler.Five2FiveMatchTimeOrBuilder getFive2FiveMatchTimeOrBuilder();

        boolean hasMatchPeople();

        int getMatchPeople();

        boolean hasSeasonEndTime();

        String getSeasonEndTime();

        ByteString getSeasonEndTimeBytes();
    }

    public static interface Five2FiveMatchTimeOrBuilder extends MessageOrBuilder {
        boolean hasAvgWaitTime();

        int getAvgWaitTime();

        boolean hasMatchTime();

        int getMatchTime();
    }

    public static interface Five2FiveRankInfoOrBuilder extends MessageOrBuilder {
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

        boolean hasPlayerFightPower();

        int getPlayerFightPower();

        boolean hasScore();

        int getScore();
    }

    public static interface Five2FiveRequestOrBuilder extends MessageOrBuilder {
    }
}


