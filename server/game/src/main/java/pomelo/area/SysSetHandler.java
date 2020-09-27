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
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;


public final class SysSetHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
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
            return SysSetHandler.internal_static_pomelo_area_SetData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SysSetHandler.internal_static_pomelo_area_SetData_fieldAccessorTable.ensureFieldAccessorsInitialized(SetData.class, Builder.class);
        }

        public static Parser<SetData> PARSER = (Parser<SetData>) new AbstractParser<SetData>() {
            public SysSetHandler.SetData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SysSetHandler.SetData(input, extensionRegistry);
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

        static {
            defaultInstance.initFields();
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
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.recvMailSet_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.teamInviteSet_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.recvStrangerMsgSet_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.recvAddFriendSet_);
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
                size += CodedOutputStream.computeInt32Size(1, this.recvMailSet_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.teamInviteSet_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.recvStrangerMsgSet_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.recvAddFriendSet_);
            }
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


        public static final class Builder
                extends GeneratedMessage.Builder<Builder>
                implements SysSetHandler.SetDataOrBuilder {
            private int bitField0_;


            private int recvMailSet_;


            private int teamInviteSet_;


            private int recvStrangerMsgSet_;


            private int recvAddFriendSet_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SysSetHandler.internal_static_pomelo_area_SetData_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SysSetHandler.internal_static_pomelo_area_SetData_fieldAccessorTable.ensureFieldAccessorsInitialized(SysSetHandler.SetData.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SysSetHandler.SetData.alwaysUseFieldBuilders) ;
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
                return SysSetHandler.internal_static_pomelo_area_SetData_descriptor;
            }


            public SysSetHandler.SetData getDefaultInstanceForType() {
                return SysSetHandler.SetData.getDefaultInstance();
            }


            public SysSetHandler.SetData build() {
                SysSetHandler.SetData result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SysSetHandler.SetData buildPartial() {
                SysSetHandler.SetData result = new SysSetHandler.SetData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.recvMailSet_ = this.recvMailSet_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.teamInviteSet_ = this.teamInviteSet_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.recvStrangerMsgSet_ = this.recvStrangerMsgSet_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.recvAddFriendSet_ = this.recvAddFriendSet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SysSetHandler.SetData) {
                    return mergeFrom((SysSetHandler.SetData) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SysSetHandler.SetData other) {
                if (other == SysSetHandler.SetData.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRecvMailSet()) {
                    setRecvMailSet(other.getRecvMailSet());
                }
                if (other.hasTeamInviteSet()) {
                    setTeamInviteSet(other.getTeamInviteSet());
                }
                if (other.hasRecvStrangerMsgSet()) {
                    setRecvStrangerMsgSet(other.getRecvStrangerMsgSet());
                }
                if (other.hasRecvAddFriendSet()) {
                    setRecvAddFriendSet(other.getRecvAddFriendSet());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasRecvMailSet()) {
                    return false;
                }
                if (!hasTeamInviteSet()) {
                    return false;
                }
                if (!hasRecvStrangerMsgSet()) {
                    return false;
                }
                if (!hasRecvAddFriendSet()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SysSetHandler.SetData parsedMessage = null;
                try {
                    parsedMessage = (SysSetHandler.SetData) SysSetHandler.SetData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SysSetHandler.SetData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
    }


    public static final class ChangeSysSetRequest
            extends GeneratedMessage
            implements ChangeSysSetRequestOrBuilder {
        private static final ChangeSysSetRequest defaultInstance = new ChangeSysSetRequest(true);
        private final UnknownFieldSet unknownFields;

        private ChangeSysSetRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ChangeSysSetRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ChangeSysSetRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ChangeSysSetRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeSysSetRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    SysSetHandler.SetData.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.c2SSetData_.toBuilder();
                            this.c2SSetData_ = (SysSetHandler.SetData) input.readMessage(SysSetHandler.SetData.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.c2SSetData_);
                                this.c2SSetData_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
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
            return SysSetHandler.internal_static_pomelo_area_ChangeSysSetRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SysSetHandler.internal_static_pomelo_area_ChangeSysSetRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeSysSetRequest.class, Builder.class);
        }

        public static Parser<ChangeSysSetRequest> PARSER = (Parser<ChangeSysSetRequest>) new AbstractParser<ChangeSysSetRequest>() {
            public SysSetHandler.ChangeSysSetRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SysSetHandler.ChangeSysSetRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_SETDATA_FIELD_NUMBER = 1;
        private SysSetHandler.SetData c2SSetData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ChangeSysSetRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SSetData() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public SysSetHandler.SetData getC2SSetData() {
            return this.c2SSetData_;
        }

        public SysSetHandler.SetDataOrBuilder getC2SSetDataOrBuilder() {
            return this.c2SSetData_;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SSetData_ = SysSetHandler.SetData.getDefaultInstance();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SSetData()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getC2SSetData().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeMessage(1, (MessageLite) this.c2SSetData_);
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
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.c2SSetData_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ChangeSysSetRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangeSysSetRequest) PARSER.parseFrom(data);
        }


        public static ChangeSysSetRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeSysSetRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ChangeSysSetRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangeSysSetRequest) PARSER.parseFrom(data);
        }


        public static ChangeSysSetRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeSysSetRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ChangeSysSetRequest parseFrom(InputStream input) throws IOException {
            return (ChangeSysSetRequest) PARSER.parseFrom(input);
        }


        public static ChangeSysSetRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeSysSetRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ChangeSysSetRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeSysSetRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ChangeSysSetRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeSysSetRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ChangeSysSetRequest parseFrom(CodedInputStream input) throws IOException {
            return (ChangeSysSetRequest) PARSER.parseFrom(input);
        }


        public static ChangeSysSetRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeSysSetRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ChangeSysSetRequest prototype) {
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
                implements SysSetHandler.ChangeSysSetRequestOrBuilder {
            private int bitField0_;


            private SysSetHandler.SetData c2SSetData_;


            private SingleFieldBuilder<SysSetHandler.SetData, SysSetHandler.SetData.Builder, SysSetHandler.SetDataOrBuilder> c2SSetDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SysSetHandler.internal_static_pomelo_area_ChangeSysSetRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SysSetHandler.internal_static_pomelo_area_ChangeSysSetRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SysSetHandler.ChangeSysSetRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SSetData_ = SysSetHandler.SetData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SSetData_ = SysSetHandler.SetData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SysSetHandler.ChangeSysSetRequest.alwaysUseFieldBuilders) {
                    getC2SSetDataFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                if (this.c2SSetDataBuilder_ == null) {
                    this.c2SSetData_ = SysSetHandler.SetData.getDefaultInstance();
                } else {
                    this.c2SSetDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SysSetHandler.internal_static_pomelo_area_ChangeSysSetRequest_descriptor;
            }


            public SysSetHandler.ChangeSysSetRequest getDefaultInstanceForType() {
                return SysSetHandler.ChangeSysSetRequest.getDefaultInstance();
            }


            public SysSetHandler.ChangeSysSetRequest build() {
                SysSetHandler.ChangeSysSetRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SysSetHandler.ChangeSysSetRequest buildPartial() {
                SysSetHandler.ChangeSysSetRequest result = new SysSetHandler.ChangeSysSetRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                if (this.c2SSetDataBuilder_ == null) {
                    result.c2SSetData_ = this.c2SSetData_;
                } else {
                    result.c2SSetData_ = (SysSetHandler.SetData) this.c2SSetDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SysSetHandler.ChangeSysSetRequest) {
                    return mergeFrom((SysSetHandler.ChangeSysSetRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SysSetHandler.ChangeSysSetRequest other) {
                if (other == SysSetHandler.ChangeSysSetRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SSetData()) {
                    mergeC2SSetData(other.getC2SSetData());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SSetData()) {
                    return false;
                }
                if (!getC2SSetData().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SysSetHandler.ChangeSysSetRequest parsedMessage = null;
                try {
                    parsedMessage = (SysSetHandler.ChangeSysSetRequest) SysSetHandler.ChangeSysSetRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SysSetHandler.ChangeSysSetRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SSetData() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public SysSetHandler.SetData getC2SSetData() {
                if (this.c2SSetDataBuilder_ == null) {
                    return this.c2SSetData_;
                }
                return (SysSetHandler.SetData) this.c2SSetDataBuilder_.getMessage();
            }


            public Builder setC2SSetData(SysSetHandler.SetData value) {
                if (this.c2SSetDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.c2SSetData_ = value;
                    onChanged();
                } else {
                    this.c2SSetDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder setC2SSetData(SysSetHandler.SetData.Builder builderForValue) {
                if (this.c2SSetDataBuilder_ == null) {
                    this.c2SSetData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.c2SSetDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder mergeC2SSetData(SysSetHandler.SetData value) {
                if (this.c2SSetDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.c2SSetData_ != SysSetHandler.SetData.getDefaultInstance()) {
                        this.c2SSetData_ = SysSetHandler.SetData.newBuilder(this.c2SSetData_).mergeFrom(value).buildPartial();
                    } else {
                        this.c2SSetData_ = value;
                    }
                    onChanged();
                } else {
                    this.c2SSetDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder clearC2SSetData() {
                if (this.c2SSetDataBuilder_ == null) {
                    this.c2SSetData_ = SysSetHandler.SetData.getDefaultInstance();
                    onChanged();
                } else {
                    this.c2SSetDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public SysSetHandler.SetData.Builder getC2SSetDataBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (SysSetHandler.SetData.Builder) getC2SSetDataFieldBuilder().getBuilder();
            }


            public SysSetHandler.SetDataOrBuilder getC2SSetDataOrBuilder() {
                if (this.c2SSetDataBuilder_ != null) {
                    return (SysSetHandler.SetDataOrBuilder) this.c2SSetDataBuilder_.getMessageOrBuilder();
                }
                return this.c2SSetData_;
            }


            private SingleFieldBuilder<SysSetHandler.SetData, SysSetHandler.SetData.Builder, SysSetHandler.SetDataOrBuilder> getC2SSetDataFieldBuilder() {
                if (this.c2SSetDataBuilder_ == null) {
                    this.c2SSetDataBuilder_ = new SingleFieldBuilder(getC2SSetData(), getParentForChildren(), isClean());
                    this.c2SSetData_ = null;
                }
                return this.c2SSetDataBuilder_;
            }
        }
    }


    public static final class ChangeSysSetResponse
            extends GeneratedMessage
            implements ChangeSysSetResponseOrBuilder {
        private static final ChangeSysSetResponse defaultInstance = new ChangeSysSetResponse(true);
        private final UnknownFieldSet unknownFields;

        private ChangeSysSetResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ChangeSysSetResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ChangeSysSetResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ChangeSysSetResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeSysSetResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SysSetHandler.internal_static_pomelo_area_ChangeSysSetResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SysSetHandler.internal_static_pomelo_area_ChangeSysSetResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeSysSetResponse.class, Builder.class);
        }

        public static Parser<ChangeSysSetResponse> PARSER = (Parser<ChangeSysSetResponse>) new AbstractParser<ChangeSysSetResponse>() {
            public SysSetHandler.ChangeSysSetResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SysSetHandler.ChangeSysSetResponse(input, extensionRegistry);
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

        public Parser<ChangeSysSetResponse> getParserForType() {
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

        public static ChangeSysSetResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangeSysSetResponse) PARSER.parseFrom(data);
        }

        public static ChangeSysSetResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeSysSetResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeSysSetResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangeSysSetResponse) PARSER.parseFrom(data);
        }

        public static ChangeSysSetResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeSysSetResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeSysSetResponse parseFrom(InputStream input) throws IOException {
            return (ChangeSysSetResponse) PARSER.parseFrom(input);
        }

        public static ChangeSysSetResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeSysSetResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ChangeSysSetResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeSysSetResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ChangeSysSetResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeSysSetResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ChangeSysSetResponse parseFrom(CodedInputStream input) throws IOException {
            return (ChangeSysSetResponse) PARSER.parseFrom(input);
        }

        public static ChangeSysSetResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeSysSetResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        static {
            defaultInstance.initFields();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ChangeSysSetResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SysSetHandler.ChangeSysSetResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SysSetHandler.internal_static_pomelo_area_ChangeSysSetResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SysSetHandler.internal_static_pomelo_area_ChangeSysSetResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SysSetHandler.ChangeSysSetResponse.class, Builder.class);
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
                if (SysSetHandler.ChangeSysSetResponse.alwaysUseFieldBuilders) ;
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
                return SysSetHandler.internal_static_pomelo_area_ChangeSysSetResponse_descriptor;
            }

            public SysSetHandler.ChangeSysSetResponse getDefaultInstanceForType() {
                return SysSetHandler.ChangeSysSetResponse.getDefaultInstance();
            }

            public SysSetHandler.ChangeSysSetResponse build() {
                SysSetHandler.ChangeSysSetResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SysSetHandler.ChangeSysSetResponse buildPartial() {
                SysSetHandler.ChangeSysSetResponse result = new SysSetHandler.ChangeSysSetResponse(this);
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
                if (other instanceof SysSetHandler.ChangeSysSetResponse)
                    return mergeFrom((SysSetHandler.ChangeSysSetResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SysSetHandler.ChangeSysSetResponse other) {
                if (other == SysSetHandler.ChangeSysSetResponse.getDefaultInstance()) return this;
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
                SysSetHandler.ChangeSysSetResponse parsedMessage = null;
                try {
                    parsedMessage = (SysSetHandler.ChangeSysSetResponse) SysSetHandler.ChangeSysSetResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SysSetHandler.ChangeSysSetResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SysSetHandler.ChangeSysSetResponse.getDefaultInstance().getS2CMsg();
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
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\023sysSetHandler.proto\022\013pomelo.area\"k\n\007SetData\022\023\n\013recvMailSet\030\001 \002(\005\022\025\n\rteamInviteSet\030\002 \002(\005\022\032\n\022recvStrangerMsgSet\030\003 \002(\005\022\030\n\020recvAddFriendSet\030\004 \002(\005\"@\n\023ChangeSysSetRequest\022)\n\013c2s_setData\030\001 \002(\0132\024.pomelo.area.SetData\"9\n\024ChangeSysSetResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2k\n\rsysSetHandler\022Z\n\023changeSysSetRequest\022 .pomelo.area.ChangeSysSetRequest\032!.pomelo.area.ChangeSysSetResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                SysSetHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_SetData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetData_descriptor, new String[]{"RecvMailSet", "TeamInviteSet", "RecvStrangerMsgSet", "RecvAddFriendSet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ChangeSysSetRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChangeSysSetRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChangeSysSetRequest_descriptor, new String[]{"C2SSetData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ChangeSysSetResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChangeSysSetResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChangeSysSetResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface ChangeSysSetResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface ChangeSysSetRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SSetData();

        SysSetHandler.SetData getC2SSetData();

        SysSetHandler.SetDataOrBuilder getC2SSetDataOrBuilder();
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
}


