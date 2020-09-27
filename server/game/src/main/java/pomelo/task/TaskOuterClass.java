package pomelo.task;

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


public final class TaskOuterClass {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Task
            extends GeneratedMessage
            implements TaskOrBuilder {
        private static final Task defaultInstance = new Task(true);
        private final UnknownFieldSet unknownFields;

        private Task(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Task(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Task getDefaultInstance() {
            return defaultInstance;
        }

        public Task getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Task(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 0x1;
                            this.templateId_ = input.readInt32();
                            break;
                        case 16:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.progress_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.progress_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 18:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x2) != 2 && input.getBytesUntilLimit() > 0) {
                                this.progress_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.progress_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.state_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.leftTime_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.progress_ = Collections.unmodifiableList(this.progress_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TaskOuterClass.internal_static_pomelo_task_Task_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskOuterClass.internal_static_pomelo_task_Task_fieldAccessorTable.ensureFieldAccessorsInitialized(Task.class, Builder.class);
        }

        public static Parser<Task> PARSER = (Parser<Task>) new AbstractParser<Task>() {
            public TaskOuterClass.Task parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskOuterClass.Task(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TEMPLATEID_FIELD_NUMBER = 1;
        private int templateId_;
        public static final int PROGRESS_FIELD_NUMBER = 2;
        private List<Integer> progress_;
        public static final int STATE_FIELD_NUMBER = 3;
        private int state_;
        public static final int LEFTTIME_FIELD_NUMBER = 4;
        private int leftTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Task> getParserForType() {
            return PARSER;
        }

        public boolean hasTemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTemplateId() {
            return this.templateId_;
        }

        public List<Integer> getProgressList() {
            return this.progress_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getProgressCount() {
            return this.progress_.size();
        }


        public int getProgress(int index) {
            return ((Integer) this.progress_.get(index)).intValue();
        }


        public boolean hasState() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getState() {
            return this.state_;
        }


        public boolean hasLeftTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getLeftTime() {
            return this.leftTime_;
        }


        private void initFields() {
            this.templateId_ = 0;
            this.progress_ = Collections.emptyList();
            this.state_ = 0;
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
            if (!hasTemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasState()) {
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
                output.writeInt32(1, this.templateId_);
            }
            for (int i = 0; i < this.progress_.size(); i++) {
                output.writeInt32(2, ((Integer) this.progress_.get(i)).intValue());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(3, this.state_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
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
                size += CodedOutputStream.computeInt32Size(1, this.templateId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.progress_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.progress_.get(i)).intValue());
            }
            size += dataSize;
            size += 1 * getProgressList().size();
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(3, this.state_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.leftTime_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Task parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Task) PARSER.parseFrom(data);
        }


        public static Task parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Task) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Task parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Task) PARSER.parseFrom(data);
        }


        public static Task parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Task) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Task parseFrom(InputStream input) throws IOException {
            return (Task) PARSER.parseFrom(input);
        }


        public static Task parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Task) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Task parseDelimitedFrom(InputStream input) throws IOException {
            return (Task) PARSER.parseDelimitedFrom(input);
        }


        public static Task parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Task) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Task parseFrom(CodedInputStream input) throws IOException {
            return (Task) PARSER.parseFrom(input);
        }


        public static Task parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Task) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Task prototype) {
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
                implements TaskOuterClass.TaskOrBuilder {
            private int bitField0_;


            private int templateId_;


            private List<Integer> progress_;


            private int state_;


            private int leftTime_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskOuterClass.internal_static_pomelo_task_Task_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskOuterClass.internal_static_pomelo_task_Task_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskOuterClass.Task.class, Builder.class);
            }


            private Builder() {
                this.progress_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.progress_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TaskOuterClass.Task.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.templateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.progress_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.leftTime_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskOuterClass.internal_static_pomelo_task_Task_descriptor;
            }


            public TaskOuterClass.Task getDefaultInstanceForType() {
                return TaskOuterClass.Task.getDefaultInstance();
            }


            public TaskOuterClass.Task build() {
                TaskOuterClass.Task result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskOuterClass.Task buildPartial() {
                TaskOuterClass.Task result = new TaskOuterClass.Task(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.templateId_ = this.templateId_;
                if ((this.bitField0_ & 0x2) == 2) {
                    this.progress_ = Collections.unmodifiableList(this.progress_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.progress_ = this.progress_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x2;
                }
                result.state_ = this.state_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.leftTime_ = this.leftTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskOuterClass.Task) {
                    return mergeFrom((TaskOuterClass.Task) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskOuterClass.Task other) {
                if (other == TaskOuterClass.Task.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTemplateId()) {
                    setTemplateId(other.getTemplateId());
                }
                if (!other.progress_.isEmpty()) {
                    if (this.progress_.isEmpty()) {
                        this.progress_ = other.progress_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        ensureProgressIsMutable();
                        this.progress_.addAll(other.progress_);
                    }
                    onChanged();
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                if (other.hasLeftTime()) {
                    setLeftTime(other.getLeftTime());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasTemplateId()) {
                    return false;
                }
                if (!hasState()) {
                    return false;
                }
                if (!hasLeftTime()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskOuterClass.Task parsedMessage = null;
                try {
                    parsedMessage = (TaskOuterClass.Task) TaskOuterClass.Task.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskOuterClass.Task) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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


            private void ensureProgressIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.progress_ = new ArrayList<>(this.progress_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<Integer> getProgressList() {
                return Collections.unmodifiableList(this.progress_);
            }


            public int getProgressCount() {
                return this.progress_.size();
            }


            public int getProgress(int index) {
                return ((Integer) this.progress_.get(index)).intValue();
            }


            public Builder setProgress(int index, int value) {
                ensureProgressIsMutable();
                this.progress_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addProgress(int value) {
                ensureProgressIsMutable();
                this.progress_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addAllProgress(Iterable<? extends Integer> values) {
                ensureProgressIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.progress_);
                onChanged();
                return this;
            }


            public Builder clearProgress() {
                this.progress_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                onChanged();
                return this;
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


    public static final class Tasks
            extends GeneratedMessage
            implements TasksOrBuilder {
        private static final Tasks defaultInstance = new Tasks(true);
        private final UnknownFieldSet unknownFields;

        private Tasks(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Tasks(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Tasks getDefaultInstance() {
            return defaultInstance;
        }

        public Tasks getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Tasks(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.taskList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.taskList_.add(input.readMessage(TaskOuterClass.Task.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.taskList_ = Collections.unmodifiableList(this.taskList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TaskOuterClass.internal_static_pomelo_task_Tasks_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskOuterClass.internal_static_pomelo_task_Tasks_fieldAccessorTable.ensureFieldAccessorsInitialized(Tasks.class, Builder.class);
        }

        public static Parser<Tasks> PARSER = (Parser<Tasks>) new AbstractParser<Tasks>() {
            public TaskOuterClass.Tasks parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskOuterClass.Tasks(input, extensionRegistry);
            }
        };
        public static final int TASKLIST_FIELD_NUMBER = 1;
        private List<TaskOuterClass.Task> taskList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Tasks> getParserForType() {
            return PARSER;
        }

        public List<TaskOuterClass.Task> getTaskListList() {
            return this.taskList_;
        }

        public List<? extends TaskOuterClass.TaskOrBuilder> getTaskListOrBuilderList() {
            return (List) this.taskList_;
        }

        public int getTaskListCount() {
            return this.taskList_.size();
        }

        public TaskOuterClass.Task getTaskList(int index) {
            return this.taskList_.get(index);
        }

        public TaskOuterClass.TaskOrBuilder getTaskListOrBuilder(int index) {
            return this.taskList_.get(index);
        }

        private void initFields() {
            this.taskList_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            for (int i = 0; i < getTaskListCount(); i++) {
                if (!getTaskList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.taskList_.size(); i++) output.writeMessage(1, (MessageLite) this.taskList_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            for (int i = 0; i < this.taskList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.taskList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Tasks parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Tasks) PARSER.parseFrom(data);
        }

        public static Tasks parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Tasks) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Tasks parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Tasks) PARSER.parseFrom(data);
        }

        public static Tasks parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Tasks) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Tasks parseFrom(InputStream input) throws IOException {
            return (Tasks) PARSER.parseFrom(input);
        }

        public static Tasks parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Tasks) PARSER.parseFrom(input, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static Tasks parseDelimitedFrom(InputStream input) throws IOException {
            return (Tasks) PARSER.parseDelimitedFrom(input);
        }

        public static Tasks parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Tasks) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Tasks parseFrom(CodedInputStream input) throws IOException {
            return (Tasks) PARSER.parseFrom(input);
        }

        public static Tasks parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Tasks) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Tasks prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskOuterClass.TasksOrBuilder {
            private int bitField0_;
            private List<TaskOuterClass.Task> taskList_;
            private RepeatedFieldBuilder<TaskOuterClass.Task, TaskOuterClass.Task.Builder, TaskOuterClass.TaskOrBuilder> taskListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskOuterClass.internal_static_pomelo_task_Tasks_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskOuterClass.internal_static_pomelo_task_Tasks_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskOuterClass.Tasks.class, Builder.class);
            }

            private Builder() {
                this.taskList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.taskList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskOuterClass.Tasks.alwaysUseFieldBuilders) getTaskListFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.taskListBuilder_ == null) {
                    this.taskList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.taskListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskOuterClass.internal_static_pomelo_task_Tasks_descriptor;
            }

            public TaskOuterClass.Tasks getDefaultInstanceForType() {
                return TaskOuterClass.Tasks.getDefaultInstance();
            }

            public TaskOuterClass.Tasks build() {
                TaskOuterClass.Tasks result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskOuterClass.Tasks buildPartial() {
                TaskOuterClass.Tasks result = new TaskOuterClass.Tasks(this);
                int from_bitField0_ = this.bitField0_;
                if (this.taskListBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.taskList_ = Collections.unmodifiableList(this.taskList_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.taskList_ = this.taskList_;
                } else {
                    result.taskList_ = this.taskListBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskOuterClass.Tasks) return mergeFrom((TaskOuterClass.Tasks) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskOuterClass.Tasks other) {
                if (other == TaskOuterClass.Tasks.getDefaultInstance()) return this;
                if (this.taskListBuilder_ == null) {
                    if (!other.taskList_.isEmpty()) {
                        if (this.taskList_.isEmpty()) {
                            this.taskList_ = other.taskList_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureTaskListIsMutable();
                            this.taskList_.addAll(other.taskList_);
                        }
                        onChanged();
                    }
                } else if (!other.taskList_.isEmpty()) {
                    if (this.taskListBuilder_.isEmpty()) {
                        this.taskListBuilder_.dispose();
                        this.taskListBuilder_ = null;
                        this.taskList_ = other.taskList_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.taskListBuilder_ = TaskOuterClass.Tasks.alwaysUseFieldBuilders ? getTaskListFieldBuilder() : null;
                    } else {
                        this.taskListBuilder_.addAllMessages(other.taskList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getTaskListCount(); i++) {
                    if (!getTaskList(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskOuterClass.Tasks parsedMessage = null;
                try {
                    parsedMessage = (TaskOuterClass.Tasks) TaskOuterClass.Tasks.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskOuterClass.Tasks) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureTaskListIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.taskList_ = new ArrayList<>(this.taskList_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<TaskOuterClass.Task> getTaskListList() {
                if (this.taskListBuilder_ == null) return Collections.unmodifiableList(this.taskList_);
                return this.taskListBuilder_.getMessageList();
            }

            public int getTaskListCount() {
                if (this.taskListBuilder_ == null) return this.taskList_.size();
                return this.taskListBuilder_.getCount();
            }

            public TaskOuterClass.Task getTaskList(int index) {
                if (this.taskListBuilder_ == null) return this.taskList_.get(index);
                return (TaskOuterClass.Task) this.taskListBuilder_.getMessage(index);
            }

            public Builder setTaskList(int index, TaskOuterClass.Task value) {
                if (this.taskListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureTaskListIsMutable();
                    this.taskList_.set(index, value);
                    onChanged();
                } else {
                    this.taskListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setTaskList(int index, TaskOuterClass.Task.Builder builderForValue) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTaskList(TaskOuterClass.Task value) {
                if (this.taskListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureTaskListIsMutable();
                    this.taskList_.add(value);
                    onChanged();
                } else {
                    this.taskListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addTaskList(int index, TaskOuterClass.Task value) {
                if (this.taskListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureTaskListIsMutable();
                    this.taskList_.add(index, value);
                    onChanged();
                } else {
                    this.taskListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addTaskList(TaskOuterClass.Task.Builder builderForValue) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.taskListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTaskList(int index, TaskOuterClass.Task.Builder builderForValue) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTaskList(Iterable<? extends TaskOuterClass.Task> values) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.taskList_);
                    onChanged();
                } else {
                    this.taskListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTaskList() {
                if (this.taskListBuilder_ == null) {
                    this.taskList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.taskListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTaskList(int index) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.remove(index);
                    onChanged();
                } else {
                    this.taskListBuilder_.remove(index);
                }
                return this;
            }

            public TaskOuterClass.Task.Builder getTaskListBuilder(int index) {
                return (TaskOuterClass.Task.Builder) getTaskListFieldBuilder().getBuilder(index);
            }

            public TaskOuterClass.TaskOrBuilder getTaskListOrBuilder(int index) {
                if (this.taskListBuilder_ == null) return this.taskList_.get(index);
                return (TaskOuterClass.TaskOrBuilder) this.taskListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends TaskOuterClass.TaskOrBuilder> getTaskListOrBuilderList() {
                if (this.taskListBuilder_ != null) return this.taskListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.taskList_);
            }

            public TaskOuterClass.Task.Builder addTaskListBuilder() {
                return (TaskOuterClass.Task.Builder) getTaskListFieldBuilder().addBuilder(TaskOuterClass.Task.getDefaultInstance());
            }

            public TaskOuterClass.Task.Builder addTaskListBuilder(int index) {
                return (TaskOuterClass.Task.Builder) getTaskListFieldBuilder().addBuilder(index, TaskOuterClass.Task.getDefaultInstance());
            }

            public List<TaskOuterClass.Task.Builder> getTaskListBuilderList() {
                return getTaskListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<TaskOuterClass.Task, TaskOuterClass.Task.Builder, TaskOuterClass.TaskOrBuilder> getTaskListFieldBuilder() {
                if (this.taskListBuilder_ == null) {
                    this.taskListBuilder_ = new RepeatedFieldBuilder(this.taskList_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.taskList_ = null;
                }
                return this.taskListBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\ntask.proto\022\013pomelo.task\"M\n\004Task\022\022\n\ntemplateId\030\001 \002(\005\022\020\n\bprogress\030\002 \003(\005\022\r\n\005state\030\003 \002(\005\022\020\n\bleftTime\030\004 \002(\005\",\n\005Tasks\022#\n\btaskList\030\001 \003(\0132\021.pomelo.task.Task"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                TaskOuterClass.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_task_Task_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_task_Task_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_task_Task_descriptor, new String[]{"TemplateId", "Progress", "State", "LeftTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_task_Tasks_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_task_Tasks_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_task_Tasks_descriptor, new String[]{"TaskList"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface TasksOrBuilder extends MessageOrBuilder {
        List<TaskOuterClass.Task> getTaskListList();

        TaskOuterClass.Task getTaskList(int param1Int);

        int getTaskListCount();

        List<? extends TaskOuterClass.TaskOrBuilder> getTaskListOrBuilderList();

        TaskOuterClass.TaskOrBuilder getTaskListOrBuilder(int param1Int);
    }

    public static interface TaskOrBuilder extends MessageOrBuilder {
        boolean hasTemplateId();

        int getTemplateId();

        List<Integer> getProgressList();

        int getProgressCount();

        int getProgress(int param1Int);

        boolean hasState();

        int getState();

        boolean hasLeftTime();

        int getLeftTime();
    }
}


