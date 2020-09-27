package pomelo.sevengoal;

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


public final class SevenGoalHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
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
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.taskId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.finishedNum_ = input.readInt32();
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
            return SevenGoalHandler.internal_static_pomelo_sevengoal_TaskInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_TaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskInfo.class, Builder.class);
        }

        public static Parser<TaskInfo> PARSER = (Parser<TaskInfo>) new AbstractParser<TaskInfo>() {
            public SevenGoalHandler.TaskInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SevenGoalHandler.TaskInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int taskId_;
        public static final int FINISHEDNUM_FIELD_NUMBER = 2;
        private int finishedNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TaskInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasTaskId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTaskId() {
            return this.taskId_;
        }

        public boolean hasFinishedNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getFinishedNum() {
            return this.finishedNum_;
        }


        private void initFields() {
            this.taskId_ = 0;
            this.finishedNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasTaskId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFinishedNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.taskId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.finishedNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.taskId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.finishedNum_);
            }
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


        public static final class Builder
                extends GeneratedMessage.Builder<Builder>
                implements SevenGoalHandler.TaskInfoOrBuilder {
            private int bitField0_;


            private int taskId_;


            private int finishedNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_TaskInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_TaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SevenGoalHandler.TaskInfo.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SevenGoalHandler.TaskInfo.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.taskId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.finishedNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_TaskInfo_descriptor;
            }


            public SevenGoalHandler.TaskInfo getDefaultInstanceForType() {
                return SevenGoalHandler.TaskInfo.getDefaultInstance();
            }


            public SevenGoalHandler.TaskInfo build() {
                SevenGoalHandler.TaskInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SevenGoalHandler.TaskInfo buildPartial() {
                SevenGoalHandler.TaskInfo result = new SevenGoalHandler.TaskInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.taskId_ = this.taskId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.finishedNum_ = this.finishedNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SevenGoalHandler.TaskInfo) {
                    return mergeFrom((SevenGoalHandler.TaskInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SevenGoalHandler.TaskInfo other) {
                if (other == SevenGoalHandler.TaskInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTaskId()) {
                    setTaskId(other.getTaskId());
                }
                if (other.hasFinishedNum()) {
                    setFinishedNum(other.getFinishedNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasTaskId()) {
                    return false;
                }
                if (!hasFinishedNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SevenGoalHandler.TaskInfo parsedMessage = null;
                try {
                    parsedMessage = (SevenGoalHandler.TaskInfo) SevenGoalHandler.TaskInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SevenGoalHandler.TaskInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasTaskId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getTaskId() {
                return this.taskId_;
            }


            public Builder setTaskId(int value) {
                this.bitField0_ |= 0x1;
                this.taskId_ = value;
                onChanged();
                return this;
            }


            public Builder clearTaskId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.taskId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasFinishedNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getFinishedNum() {
                return this.finishedNum_;
            }


            public Builder setFinishedNum(int value) {
                this.bitField0_ |= 0x2;
                this.finishedNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearFinishedNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.finishedNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class DayInfo
            extends GeneratedMessage
            implements DayInfoOrBuilder {
        private static final DayInfo defaultInstance = new DayInfo(true);
        private final UnknownFieldSet unknownFields;

        private DayInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DayInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DayInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DayInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DayInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.dayId_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.taskInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.taskInfo_.add(input.readMessage(SevenGoalHandler.TaskInfo.PARSER, extensionRegistry));
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.fetched_ = input.readBool();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.taskInfo_ = Collections.unmodifiableList(this.taskInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_DayInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_DayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DayInfo.class, Builder.class);
        }

        public static Parser<DayInfo> PARSER = (Parser<DayInfo>) new AbstractParser<DayInfo>() {
            public SevenGoalHandler.DayInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SevenGoalHandler.DayInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int DAYID_FIELD_NUMBER = 1;
        private int dayId_;
        public static final int TASKINFO_FIELD_NUMBER = 2;
        private List<SevenGoalHandler.TaskInfo> taskInfo_;
        public static final int FETCHED_FIELD_NUMBER = 3;
        private boolean fetched_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DayInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasDayId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getDayId() {
            return this.dayId_;
        }

        public List<SevenGoalHandler.TaskInfo> getTaskInfoList() {
            return this.taskInfo_;
        }

        public List<? extends SevenGoalHandler.TaskInfoOrBuilder> getTaskInfoOrBuilderList() {
            return (List) this.taskInfo_;
        }

        static {
            defaultInstance.initFields();
        }

        public int getTaskInfoCount() {
            return this.taskInfo_.size();
        }

        public SevenGoalHandler.TaskInfo getTaskInfo(int index) {
            return this.taskInfo_.get(index);
        }

        public SevenGoalHandler.TaskInfoOrBuilder getTaskInfoOrBuilder(int index) {
            return this.taskInfo_.get(index);
        }

        public boolean hasFetched() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public boolean getFetched() {
            return this.fetched_;
        }

        private void initFields() {
            this.dayId_ = 0;
            this.taskInfo_ = Collections.emptyList();
            this.fetched_ = false;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasDayId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFetched()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getTaskInfoCount(); i++) {
                if (!getTaskInfo(i).isInitialized()) {
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
                output.writeInt32(1, this.dayId_);
            for (int i = 0; i < this.taskInfo_.size(); i++)
                output.writeMessage(2, (MessageLite) this.taskInfo_.get(i));
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBool(3, this.fetched_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.dayId_);
            for (int i = 0; i < this.taskInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.taskInfo_.get(i));
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBoolSize(3, this.fetched_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DayInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DayInfo) PARSER.parseFrom(data);
        }

        public static DayInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DayInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DayInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DayInfo) PARSER.parseFrom(data);
        }

        public static DayInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DayInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DayInfo parseFrom(InputStream input) throws IOException {
            return (DayInfo) PARSER.parseFrom(input);
        }

        public static DayInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DayInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DayInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DayInfo) PARSER.parseDelimitedFrom(input);
        }

        public static DayInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DayInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DayInfo parseFrom(CodedInputStream input) throws IOException {
            return (DayInfo) PARSER.parseFrom(input);
        }

        public static DayInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DayInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DayInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SevenGoalHandler.DayInfoOrBuilder {
            private int bitField0_;
            private int dayId_;
            private List<SevenGoalHandler.TaskInfo> taskInfo_;
            private RepeatedFieldBuilder<SevenGoalHandler.TaskInfo, SevenGoalHandler.TaskInfo.Builder, SevenGoalHandler.TaskInfoOrBuilder> taskInfoBuilder_;
            private boolean fetched_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_DayInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_DayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SevenGoalHandler.DayInfo.class, Builder.class);
            }

            private Builder() {
                this.taskInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.taskInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SevenGoalHandler.DayInfo.alwaysUseFieldBuilders)
                    getTaskInfoFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.dayId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.taskInfoBuilder_ == null) {
                    this.taskInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.taskInfoBuilder_.clear();
                }
                this.fetched_ = false;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_DayInfo_descriptor;
            }

            public SevenGoalHandler.DayInfo getDefaultInstanceForType() {
                return SevenGoalHandler.DayInfo.getDefaultInstance();
            }

            public SevenGoalHandler.DayInfo build() {
                SevenGoalHandler.DayInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SevenGoalHandler.DayInfo buildPartial() {
                SevenGoalHandler.DayInfo result = new SevenGoalHandler.DayInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.dayId_ = this.dayId_;
                if (this.taskInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.taskInfo_ = Collections.unmodifiableList(this.taskInfo_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.taskInfo_ = this.taskInfo_;
                } else {
                    result.taskInfo_ = this.taskInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x2;
                result.fetched_ = this.fetched_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SevenGoalHandler.DayInfo)
                    return mergeFrom((SevenGoalHandler.DayInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SevenGoalHandler.DayInfo other) {
                if (other == SevenGoalHandler.DayInfo.getDefaultInstance())
                    return this;
                if (other.hasDayId())
                    setDayId(other.getDayId());
                if (this.taskInfoBuilder_ == null) {
                    if (!other.taskInfo_.isEmpty()) {
                        if (this.taskInfo_.isEmpty()) {
                            this.taskInfo_ = other.taskInfo_;
                            this.bitField0_ &= 0xFFFFFFFD;
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
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.taskInfoBuilder_ = SevenGoalHandler.DayInfo.alwaysUseFieldBuilders ? getTaskInfoFieldBuilder() : null;
                    } else {
                        this.taskInfoBuilder_.addAllMessages(other.taskInfo_);
                    }
                }
                if (other.hasFetched())
                    setFetched(other.getFetched());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasDayId())
                    return false;
                if (!hasFetched())
                    return false;
                for (int i = 0; i < getTaskInfoCount(); i++) {
                    if (!getTaskInfo(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SevenGoalHandler.DayInfo parsedMessage = null;
                try {
                    parsedMessage = (SevenGoalHandler.DayInfo) SevenGoalHandler.DayInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SevenGoalHandler.DayInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasDayId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getDayId() {
                return this.dayId_;
            }

            public Builder setDayId(int value) {
                this.bitField0_ |= 0x1;
                this.dayId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.dayId_ = 0;
                onChanged();
                return this;
            }

            private void ensureTaskInfoIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.taskInfo_ = new ArrayList<>(this.taskInfo_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<SevenGoalHandler.TaskInfo> getTaskInfoList() {
                if (this.taskInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.taskInfo_);
                return this.taskInfoBuilder_.getMessageList();
            }

            public int getTaskInfoCount() {
                if (this.taskInfoBuilder_ == null)
                    return this.taskInfo_.size();
                return this.taskInfoBuilder_.getCount();
            }

            public SevenGoalHandler.TaskInfo getTaskInfo(int index) {
                if (this.taskInfoBuilder_ == null)
                    return this.taskInfo_.get(index);
                return (SevenGoalHandler.TaskInfo) this.taskInfoBuilder_.getMessage(index);
            }

            public Builder setTaskInfo(int index, SevenGoalHandler.TaskInfo value) {
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

            public Builder setTaskInfo(int index, SevenGoalHandler.TaskInfo.Builder builderForValue) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTaskInfo(SevenGoalHandler.TaskInfo value) {
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

            public Builder addTaskInfo(int index, SevenGoalHandler.TaskInfo value) {
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

            public Builder addTaskInfo(SevenGoalHandler.TaskInfo.Builder builderForValue) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTaskInfo(int index, SevenGoalHandler.TaskInfo.Builder builderForValue) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTaskInfo(Iterable<? extends SevenGoalHandler.TaskInfo> values) {
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
                    this.bitField0_ &= 0xFFFFFFFD;
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

            public SevenGoalHandler.TaskInfo.Builder getTaskInfoBuilder(int index) {
                return (SevenGoalHandler.TaskInfo.Builder) getTaskInfoFieldBuilder().getBuilder(index);
            }

            public SevenGoalHandler.TaskInfoOrBuilder getTaskInfoOrBuilder(int index) {
                if (this.taskInfoBuilder_ == null)
                    return this.taskInfo_.get(index);
                return (SevenGoalHandler.TaskInfoOrBuilder) this.taskInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SevenGoalHandler.TaskInfoOrBuilder> getTaskInfoOrBuilderList() {
                if (this.taskInfoBuilder_ != null)
                    return this.taskInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.taskInfo_);
            }

            public SevenGoalHandler.TaskInfo.Builder addTaskInfoBuilder() {
                return (SevenGoalHandler.TaskInfo.Builder) getTaskInfoFieldBuilder().addBuilder(SevenGoalHandler.TaskInfo.getDefaultInstance());
            }

            public SevenGoalHandler.TaskInfo.Builder addTaskInfoBuilder(int index) {
                return (SevenGoalHandler.TaskInfo.Builder) getTaskInfoFieldBuilder().addBuilder(index, SevenGoalHandler.TaskInfo.getDefaultInstance());
            }

            public List<SevenGoalHandler.TaskInfo.Builder> getTaskInfoBuilderList() {
                return getTaskInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SevenGoalHandler.TaskInfo, SevenGoalHandler.TaskInfo.Builder, SevenGoalHandler.TaskInfoOrBuilder> getTaskInfoFieldBuilder() {
                if (this.taskInfoBuilder_ == null) {
                    this.taskInfoBuilder_ = new RepeatedFieldBuilder(this.taskInfo_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.taskInfo_ = null;
                }
                return this.taskInfoBuilder_;
            }

            public boolean hasFetched() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public boolean getFetched() {
                return this.fetched_;
            }

            public Builder setFetched(boolean value) {
                this.bitField0_ |= 0x4;
                this.fetched_ = value;
                onChanged();
                return this;
            }

            public Builder clearFetched() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.fetched_ = false;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetSevenGoalRequest extends GeneratedMessage implements GetSevenGoalRequestOrBuilder {
        private static final GetSevenGoalRequest defaultInstance = new GetSevenGoalRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetSevenGoalRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetSevenGoalRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetSevenGoalRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetSevenGoalRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetSevenGoalRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSevenGoalRequest.class, Builder.class);
        }

        public static Parser<GetSevenGoalRequest> PARSER = (Parser<GetSevenGoalRequest>) new AbstractParser<GetSevenGoalRequest>() {
            public SevenGoalHandler.GetSevenGoalRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SevenGoalHandler.GetSevenGoalRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetSevenGoalRequest> getParserForType() {
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

        public static GetSevenGoalRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetSevenGoalRequest) PARSER.parseFrom(data);
        }

        public static GetSevenGoalRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSevenGoalRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSevenGoalRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetSevenGoalRequest) PARSER.parseFrom(data);
        }

        public static GetSevenGoalRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSevenGoalRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSevenGoalRequest parseFrom(InputStream input) throws IOException {
            return (GetSevenGoalRequest) PARSER.parseFrom(input);
        }

        public static GetSevenGoalRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSevenGoalRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetSevenGoalRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetSevenGoalRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetSevenGoalRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSevenGoalRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetSevenGoalRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetSevenGoalRequest) PARSER.parseFrom(input);
        }

        public static GetSevenGoalRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSevenGoalRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetSevenGoalRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SevenGoalHandler.GetSevenGoalRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SevenGoalHandler.GetSevenGoalRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SevenGoalHandler.GetSevenGoalRequest.alwaysUseFieldBuilders) ;
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
                return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalRequest_descriptor;
            }

            public SevenGoalHandler.GetSevenGoalRequest getDefaultInstanceForType() {
                return SevenGoalHandler.GetSevenGoalRequest.getDefaultInstance();
            }

            public SevenGoalHandler.GetSevenGoalRequest build() {
                SevenGoalHandler.GetSevenGoalRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SevenGoalHandler.GetSevenGoalRequest buildPartial() {
                SevenGoalHandler.GetSevenGoalRequest result = new SevenGoalHandler.GetSevenGoalRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SevenGoalHandler.GetSevenGoalRequest)
                    return mergeFrom((SevenGoalHandler.GetSevenGoalRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SevenGoalHandler.GetSevenGoalRequest other) {
                if (other == SevenGoalHandler.GetSevenGoalRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SevenGoalHandler.GetSevenGoalRequest parsedMessage = null;
                try {
                    parsedMessage = (SevenGoalHandler.GetSevenGoalRequest) SevenGoalHandler.GetSevenGoalRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SevenGoalHandler.GetSevenGoalRequest) e.getUnfinishedMessage();
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


    public static final class GetSevenGoalResponse
            extends GeneratedMessage
            implements GetSevenGoalResponseOrBuilder {
        private static final GetSevenGoalResponse defaultInstance = new GetSevenGoalResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetSevenGoalResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetSevenGoalResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetSevenGoalResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetSevenGoalResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetSevenGoalResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.dayInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.dayInfo_.add(input.readMessage(SevenGoalHandler.DayInfo.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.currentDayId_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.startTimestamp_ = bs;
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.endTimestamp_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.dayInfo_ = Collections.unmodifiableList(this.dayInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSevenGoalResponse.class, Builder.class);
        }

        public static Parser<GetSevenGoalResponse> PARSER = (Parser<GetSevenGoalResponse>) new AbstractParser<GetSevenGoalResponse>() {
            public SevenGoalHandler.GetSevenGoalResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SevenGoalHandler.GetSevenGoalResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int DAYINFO_FIELD_NUMBER = 3;
        private List<SevenGoalHandler.DayInfo> dayInfo_;
        public static final int CURRENTDAYID_FIELD_NUMBER = 4;
        private int currentDayId_;
        public static final int STARTTIMESTAMP_FIELD_NUMBER = 5;
        private Object startTimestamp_;
        public static final int ENDTIMESTAMP_FIELD_NUMBER = 6;
        private Object endTimestamp_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetSevenGoalResponse> getParserForType() {
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

        public List<SevenGoalHandler.DayInfo> getDayInfoList() {
            return this.dayInfo_;
        }

        public List<? extends SevenGoalHandler.DayInfoOrBuilder> getDayInfoOrBuilderList() {
            return (List) this.dayInfo_;
        }

        public int getDayInfoCount() {
            return this.dayInfo_.size();
        }

        public SevenGoalHandler.DayInfo getDayInfo(int index) {
            return this.dayInfo_.get(index);
        }

        public SevenGoalHandler.DayInfoOrBuilder getDayInfoOrBuilder(int index) {
            return this.dayInfo_.get(index);
        }

        public boolean hasCurrentDayId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getCurrentDayId() {
            return this.currentDayId_;
        }

        public boolean hasStartTimestamp() {
            return ((this.bitField0_ & 0x8) == 8);
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
            return ((this.bitField0_ & 0x10) == 16);
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
            this.dayInfo_ = Collections.emptyList();
            this.currentDayId_ = 0;
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
            for (int i = 0; i < getDayInfoCount(); i++) {
                if (!getDayInfo(i).isInitialized()) {
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
            for (int i = 0; i < this.dayInfo_.size(); i++) output.writeMessage(3, (MessageLite) this.dayInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(4, this.currentDayId_);
            if ((this.bitField0_ & 0x8) == 8) output.writeBytes(5, getStartTimestampBytes());
            if ((this.bitField0_ & 0x10) == 16) output.writeBytes(6, getEndTimestampBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.dayInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.dayInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(4, this.currentDayId_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(5, getStartTimestampBytes());
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeBytesSize(6, getEndTimestampBytes());
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

        public static GetSevenGoalResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetSevenGoalResponse) PARSER.parseFrom(data);
        }

        public static GetSevenGoalResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSevenGoalResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSevenGoalResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetSevenGoalResponse) PARSER.parseFrom(data);
        }

        public static GetSevenGoalResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSevenGoalResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSevenGoalResponse parseFrom(InputStream input) throws IOException {
            return (GetSevenGoalResponse) PARSER.parseFrom(input);
        }

        public static GetSevenGoalResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSevenGoalResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetSevenGoalResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetSevenGoalResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetSevenGoalResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSevenGoalResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetSevenGoalResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetSevenGoalResponse) PARSER.parseFrom(input);
        }

        public static GetSevenGoalResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSevenGoalResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetSevenGoalResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SevenGoalHandler.GetSevenGoalResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<SevenGoalHandler.DayInfo> dayInfo_;
            private RepeatedFieldBuilder<SevenGoalHandler.DayInfo, SevenGoalHandler.DayInfo.Builder, SevenGoalHandler.DayInfoOrBuilder> dayInfoBuilder_;
            private int currentDayId_;
            private Object startTimestamp_;
            private Object endTimestamp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SevenGoalHandler.GetSevenGoalResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.dayInfo_ = Collections.emptyList();
                this.startTimestamp_ = "";
                this.endTimestamp_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.dayInfo_ = Collections.emptyList();
                this.startTimestamp_ = "";
                this.endTimestamp_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SevenGoalHandler.GetSevenGoalResponse.alwaysUseFieldBuilders)
                    getDayInfoFieldBuilder();
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
                if (this.dayInfoBuilder_ == null) {
                    this.dayInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.dayInfoBuilder_.clear();
                }
                this.currentDayId_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.startTimestamp_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.endTimestamp_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_GetSevenGoalResponse_descriptor;
            }

            public SevenGoalHandler.GetSevenGoalResponse getDefaultInstanceForType() {
                return SevenGoalHandler.GetSevenGoalResponse.getDefaultInstance();
            }

            public SevenGoalHandler.GetSevenGoalResponse build() {
                SevenGoalHandler.GetSevenGoalResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SevenGoalHandler.GetSevenGoalResponse buildPartial() {
                SevenGoalHandler.GetSevenGoalResponse result = new SevenGoalHandler.GetSevenGoalResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.dayInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.dayInfo_ = Collections.unmodifiableList(this.dayInfo_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.dayInfo_ = this.dayInfo_;
                } else {
                    result.dayInfo_ = this.dayInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                result.currentDayId_ = this.currentDayId_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x8;
                result.startTimestamp_ = this.startTimestamp_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x10;
                result.endTimestamp_ = this.endTimestamp_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SevenGoalHandler.GetSevenGoalResponse)
                    return mergeFrom((SevenGoalHandler.GetSevenGoalResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SevenGoalHandler.GetSevenGoalResponse other) {
                if (other == SevenGoalHandler.GetSevenGoalResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.dayInfoBuilder_ == null) {
                    if (!other.dayInfo_.isEmpty()) {
                        if (this.dayInfo_.isEmpty()) {
                            this.dayInfo_ = other.dayInfo_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDayInfoIsMutable();
                            this.dayInfo_.addAll(other.dayInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.dayInfo_.isEmpty()) {
                    if (this.dayInfoBuilder_.isEmpty()) {
                        this.dayInfoBuilder_.dispose();
                        this.dayInfoBuilder_ = null;
                        this.dayInfo_ = other.dayInfo_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.dayInfoBuilder_ = SevenGoalHandler.GetSevenGoalResponse.alwaysUseFieldBuilders ? getDayInfoFieldBuilder() : null;
                    } else {
                        this.dayInfoBuilder_.addAllMessages(other.dayInfo_);
                    }
                }
                if (other.hasCurrentDayId())
                    setCurrentDayId(other.getCurrentDayId());
                if (other.hasStartTimestamp()) {
                    this.bitField0_ |= 0x10;
                    this.startTimestamp_ = other.startTimestamp_;
                    onChanged();
                }
                if (other.hasEndTimestamp()) {
                    this.bitField0_ |= 0x20;
                    this.endTimestamp_ = other.endTimestamp_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getDayInfoCount(); i++) {
                    if (!getDayInfo(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SevenGoalHandler.GetSevenGoalResponse parsedMessage = null;
                try {
                    parsedMessage = (SevenGoalHandler.GetSevenGoalResponse) SevenGoalHandler.GetSevenGoalResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SevenGoalHandler.GetSevenGoalResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SevenGoalHandler.GetSevenGoalResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureDayInfoIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.dayInfo_ = new ArrayList<>(this.dayInfo_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<SevenGoalHandler.DayInfo> getDayInfoList() {
                if (this.dayInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.dayInfo_);
                return this.dayInfoBuilder_.getMessageList();
            }

            public int getDayInfoCount() {
                if (this.dayInfoBuilder_ == null)
                    return this.dayInfo_.size();
                return this.dayInfoBuilder_.getCount();
            }

            public SevenGoalHandler.DayInfo getDayInfo(int index) {
                if (this.dayInfoBuilder_ == null)
                    return this.dayInfo_.get(index);
                return (SevenGoalHandler.DayInfo) this.dayInfoBuilder_.getMessage(index);
            }

            public Builder setDayInfo(int index, SevenGoalHandler.DayInfo value) {
                if (this.dayInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDayInfoIsMutable();
                    this.dayInfo_.set(index, value);
                    onChanged();
                } else {
                    this.dayInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setDayInfo(int index, SevenGoalHandler.DayInfo.Builder builderForValue) {
                if (this.dayInfoBuilder_ == null) {
                    ensureDayInfoIsMutable();
                    this.dayInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dayInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDayInfo(SevenGoalHandler.DayInfo value) {
                if (this.dayInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDayInfoIsMutable();
                    this.dayInfo_.add(value);
                    onChanged();
                } else {
                    this.dayInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addDayInfo(int index, SevenGoalHandler.DayInfo value) {
                if (this.dayInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDayInfoIsMutable();
                    this.dayInfo_.add(index, value);
                    onChanged();
                } else {
                    this.dayInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addDayInfo(SevenGoalHandler.DayInfo.Builder builderForValue) {
                if (this.dayInfoBuilder_ == null) {
                    ensureDayInfoIsMutable();
                    this.dayInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dayInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDayInfo(int index, SevenGoalHandler.DayInfo.Builder builderForValue) {
                if (this.dayInfoBuilder_ == null) {
                    ensureDayInfoIsMutable();
                    this.dayInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dayInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDayInfo(Iterable<? extends SevenGoalHandler.DayInfo> values) {
                if (this.dayInfoBuilder_ == null) {
                    ensureDayInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.dayInfo_);
                    onChanged();
                } else {
                    this.dayInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDayInfo() {
                if (this.dayInfoBuilder_ == null) {
                    this.dayInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.dayInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeDayInfo(int index) {
                if (this.dayInfoBuilder_ == null) {
                    ensureDayInfoIsMutable();
                    this.dayInfo_.remove(index);
                    onChanged();
                } else {
                    this.dayInfoBuilder_.remove(index);
                }
                return this;
            }

            public SevenGoalHandler.DayInfo.Builder getDayInfoBuilder(int index) {
                return (SevenGoalHandler.DayInfo.Builder) getDayInfoFieldBuilder().getBuilder(index);
            }

            public SevenGoalHandler.DayInfoOrBuilder getDayInfoOrBuilder(int index) {
                if (this.dayInfoBuilder_ == null)
                    return this.dayInfo_.get(index);
                return (SevenGoalHandler.DayInfoOrBuilder) this.dayInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SevenGoalHandler.DayInfoOrBuilder> getDayInfoOrBuilderList() {
                if (this.dayInfoBuilder_ != null)
                    return this.dayInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.dayInfo_);
            }

            public SevenGoalHandler.DayInfo.Builder addDayInfoBuilder() {
                return (SevenGoalHandler.DayInfo.Builder) getDayInfoFieldBuilder().addBuilder(SevenGoalHandler.DayInfo.getDefaultInstance());
            }

            public SevenGoalHandler.DayInfo.Builder addDayInfoBuilder(int index) {
                return (SevenGoalHandler.DayInfo.Builder) getDayInfoFieldBuilder().addBuilder(index, SevenGoalHandler.DayInfo.getDefaultInstance());
            }

            public List<SevenGoalHandler.DayInfo.Builder> getDayInfoBuilderList() {
                return getDayInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SevenGoalHandler.DayInfo, SevenGoalHandler.DayInfo.Builder, SevenGoalHandler.DayInfoOrBuilder> getDayInfoFieldBuilder() {
                if (this.dayInfoBuilder_ == null) {
                    this.dayInfoBuilder_ = new RepeatedFieldBuilder(this.dayInfo_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.dayInfo_ = null;
                }
                return this.dayInfoBuilder_;
            }

            public boolean hasCurrentDayId() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getCurrentDayId() {
                return this.currentDayId_;
            }

            public Builder setCurrentDayId(int value) {
                this.bitField0_ |= 0x8;
                this.currentDayId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrentDayId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.currentDayId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStartTimestamp() {
                return ((this.bitField0_ & 0x10) == 16);
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
                this.bitField0_ |= 0x10;
                this.startTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTimestamp() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.startTimestamp_ = SevenGoalHandler.GetSevenGoalResponse.getDefaultInstance().getStartTimestamp();
                onChanged();
                return this;
            }

            public Builder setStartTimestampBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.startTimestamp_ = value;
                onChanged();
                return this;
            }

            public boolean hasEndTimestamp() {
                return ((this.bitField0_ & 0x20) == 32);
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
                this.bitField0_ |= 0x20;
                this.endTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTimestamp() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.endTimestamp_ = SevenGoalHandler.GetSevenGoalResponse.getDefaultInstance().getEndTimestamp();
                onChanged();
                return this;
            }

            public Builder setEndTimestampBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.endTimestamp_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class FetchAwardRequest extends GeneratedMessage implements FetchAwardRequestOrBuilder {
        private static final FetchAwardRequest defaultInstance = new FetchAwardRequest(true);
        private final UnknownFieldSet unknownFields;

        private FetchAwardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FetchAwardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FetchAwardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public FetchAwardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FetchAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FetchAwardRequest.class, Builder.class);
        }

        public static Parser<FetchAwardRequest> PARSER = (Parser<FetchAwardRequest>) new AbstractParser<FetchAwardRequest>() {
            public SevenGoalHandler.FetchAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SevenGoalHandler.FetchAwardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FetchAwardRequest> getParserForType() {
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

        public static FetchAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FetchAwardRequest) PARSER.parseFrom(data);
        }

        public static FetchAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchAwardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FetchAwardRequest) PARSER.parseFrom(data);
        }

        public static FetchAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchAwardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchAwardRequest parseFrom(InputStream input) throws IOException {
            return (FetchAwardRequest) PARSER.parseFrom(input);
        }

        public static FetchAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchAwardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FetchAwardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (FetchAwardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static FetchAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchAwardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FetchAwardRequest parseFrom(CodedInputStream input) throws IOException {
            return (FetchAwardRequest) PARSER.parseFrom(input);
        }

        public static FetchAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchAwardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FetchAwardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SevenGoalHandler.FetchAwardRequestOrBuilder {
            private int bitField0_;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SevenGoalHandler.FetchAwardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SevenGoalHandler.FetchAwardRequest.alwaysUseFieldBuilders) ;
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
                return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardRequest_descriptor;
            }

            public SevenGoalHandler.FetchAwardRequest getDefaultInstanceForType() {
                return SevenGoalHandler.FetchAwardRequest.getDefaultInstance();
            }

            public SevenGoalHandler.FetchAwardRequest build() {
                SevenGoalHandler.FetchAwardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SevenGoalHandler.FetchAwardRequest buildPartial() {
                SevenGoalHandler.FetchAwardRequest result = new SevenGoalHandler.FetchAwardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SevenGoalHandler.FetchAwardRequest)
                    return mergeFrom((SevenGoalHandler.FetchAwardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SevenGoalHandler.FetchAwardRequest other) {
                if (other == SevenGoalHandler.FetchAwardRequest.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SevenGoalHandler.FetchAwardRequest parsedMessage = null;
                try {
                    parsedMessage = (SevenGoalHandler.FetchAwardRequest) SevenGoalHandler.FetchAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SevenGoalHandler.FetchAwardRequest) e.getUnfinishedMessage();
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


    public static final class FetchAwardResponse
            extends GeneratedMessage
            implements FetchAwardResponseOrBuilder {
        private static final FetchAwardResponse defaultInstance = new FetchAwardResponse(true);
        private final UnknownFieldSet unknownFields;

        private FetchAwardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FetchAwardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FetchAwardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public FetchAwardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FetchAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FetchAwardResponse.class, Builder.class);
        }

        public static Parser<FetchAwardResponse> PARSER = (Parser<FetchAwardResponse>) new AbstractParser<FetchAwardResponse>() {
            public SevenGoalHandler.FetchAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SevenGoalHandler.FetchAwardResponse(input, extensionRegistry);
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

        public Parser<FetchAwardResponse> getParserForType() {
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

        public static FetchAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FetchAwardResponse) PARSER.parseFrom(data);
        }

        public static FetchAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchAwardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FetchAwardResponse) PARSER.parseFrom(data);
        }

        public static FetchAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchAwardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchAwardResponse parseFrom(InputStream input) throws IOException {
            return (FetchAwardResponse) PARSER.parseFrom(input);
        }

        public static FetchAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchAwardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FetchAwardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (FetchAwardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static FetchAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchAwardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FetchAwardResponse parseFrom(CodedInputStream input) throws IOException {
            return (FetchAwardResponse) PARSER.parseFrom(input);
        }

        public static FetchAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchAwardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FetchAwardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SevenGoalHandler.FetchAwardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SevenGoalHandler.FetchAwardResponse.class, Builder.class);
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
                if (SevenGoalHandler.FetchAwardResponse.alwaysUseFieldBuilders) ;
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
                return SevenGoalHandler.internal_static_pomelo_sevengoal_FetchAwardResponse_descriptor;
            }

            public SevenGoalHandler.FetchAwardResponse getDefaultInstanceForType() {
                return SevenGoalHandler.FetchAwardResponse.getDefaultInstance();
            }

            public SevenGoalHandler.FetchAwardResponse build() {
                SevenGoalHandler.FetchAwardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SevenGoalHandler.FetchAwardResponse buildPartial() {
                SevenGoalHandler.FetchAwardResponse result = new SevenGoalHandler.FetchAwardResponse(this);
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
                if (other instanceof SevenGoalHandler.FetchAwardResponse)
                    return mergeFrom((SevenGoalHandler.FetchAwardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SevenGoalHandler.FetchAwardResponse other) {
                if (other == SevenGoalHandler.FetchAwardResponse.getDefaultInstance()) return this;
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
                SevenGoalHandler.FetchAwardResponse parsedMessage = null;
                try {
                    parsedMessage = (SevenGoalHandler.FetchAwardResponse) SevenGoalHandler.FetchAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SevenGoalHandler.FetchAwardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SevenGoalHandler.FetchAwardResponse.getDefaultInstance().getS2CMsg();
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
        String[] descriptorData = {"\n\026sevenGoalHandler.proto\022\020pomelo.sevengoal\"/\n\bTaskInfo\022\016\n\006taskId\030\001 \002(\005\022\023\n\013finishedNum\030\002 \002(\005\"W\n\007DayInfo\022\r\n\005dayId\030\001 \002(\005\022,\n\btaskInfo\030\002 \003(\0132\032.pomelo.sevengoal.TaskInfo\022\017\n\007fetched\030\003 \002(\b\"\025\n\023GetSevenGoalRequest\"©\001\n\024GetSevenGoalResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\007dayInfo\030\003 \003(\0132\031.pomelo.sevengoal.DayInfo\022\024\n\fcurrentDayId\030\004 \001(\005\022\026\n\016startTimestamp\030\005 \001(\t\022\024\n\fendTimestamp\030\006 \001(\t\"\037\n\021FetchAwardRequest\022\n\n\002", "id\030\001 \002(\005\"7\n\022FetchAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2Ø\001\n\020sevenGoalHandler\022d\n\023getSevenGoalRequest\022%.pomelo.sevengoal.GetSevenGoalRequest\032&.pomelo.sevengoal.GetSevenGoalResponse\022^\n\021fetchAwardRequest\022#.pomelo.sevengoal.FetchAwardRequest\032$.pomelo.sevengoal.FetchAwardResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                SevenGoalHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_sevengoal_TaskInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_sevengoal_TaskInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_sevengoal_TaskInfo_descriptor, new String[]{"TaskId", "FinishedNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_sevengoal_DayInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_sevengoal_DayInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_sevengoal_DayInfo_descriptor, new String[]{"DayId", "TaskInfo", "Fetched"});


    private static final Descriptors.Descriptor internal_static_pomelo_sevengoal_GetSevenGoalRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_sevengoal_GetSevenGoalRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_sevengoal_GetSevenGoalRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_sevengoal_GetSevenGoalResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_sevengoal_GetSevenGoalResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_sevengoal_GetSevenGoalResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "DayInfo", "CurrentDayId", "StartTimestamp", "EndTimestamp"});


    private static final Descriptors.Descriptor internal_static_pomelo_sevengoal_FetchAwardRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_sevengoal_FetchAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_sevengoal_FetchAwardRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_sevengoal_FetchAwardResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_sevengoal_FetchAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_sevengoal_FetchAwardResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface FetchAwardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface FetchAwardRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface GetSevenGoalResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<SevenGoalHandler.DayInfo> getDayInfoList();

        SevenGoalHandler.DayInfo getDayInfo(int param1Int);

        int getDayInfoCount();

        List<? extends SevenGoalHandler.DayInfoOrBuilder> getDayInfoOrBuilderList();

        SevenGoalHandler.DayInfoOrBuilder getDayInfoOrBuilder(int param1Int);

        boolean hasCurrentDayId();

        int getCurrentDayId();

        boolean hasStartTimestamp();

        String getStartTimestamp();

        ByteString getStartTimestampBytes();

        boolean hasEndTimestamp();

        String getEndTimestamp();

        ByteString getEndTimestampBytes();
    }

    public static interface GetSevenGoalRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface DayInfoOrBuilder extends MessageOrBuilder {
        boolean hasDayId();

        int getDayId();

        List<SevenGoalHandler.TaskInfo> getTaskInfoList();

        SevenGoalHandler.TaskInfo getTaskInfo(int param1Int);

        int getTaskInfoCount();

        List<? extends SevenGoalHandler.TaskInfoOrBuilder> getTaskInfoOrBuilderList();

        SevenGoalHandler.TaskInfoOrBuilder getTaskInfoOrBuilder(int param1Int);

        boolean hasFetched();

        boolean getFetched();
    }

    public static interface TaskInfoOrBuilder extends MessageOrBuilder {
        boolean hasTaskId();

        int getTaskId();

        boolean hasFinishedNum();

        int getFinishedNum();
    }
}


