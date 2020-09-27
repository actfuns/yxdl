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
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class IntergalMallHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class IntergalMallItem
            extends GeneratedMessage
            implements IntergalMallItemOrBuilder {
        private final UnknownFieldSet unknownFields;

        private IntergalMallItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private IntergalMallItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static IntergalMallItem getDefaultInstance() {
            return defaultInstance;
        }

        public IntergalMallItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IntergalMallItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.id_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.code_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.lastcount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.countdown_ = input.readInt64();
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
            return IntergalMallHandler.internal_static_pomelo_area_IntergalMallItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return IntergalMallHandler.internal_static_pomelo_area_IntergalMallItem_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallItem.class, Builder.class);
        }

        public static Parser<IntergalMallItem> PARSER = (Parser<IntergalMallItem>) new AbstractParser<IntergalMallItem>() {
            public IntergalMallHandler.IntergalMallItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IntergalMallHandler.IntergalMallItem(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int CODE_FIELD_NUMBER = 2;
        private Object code_;
        public static final int LASTCOUNT_FIELD_NUMBER = 3;
        private int lastcount_;
        public static final int COUNTDOWN_FIELD_NUMBER = 4;
        private long countdown_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<IntergalMallItem> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getCode() {
            Object ref = this.code_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.code_ = s;
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

        public boolean hasLastcount() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getLastcount() {
            return this.lastcount_;
        }

        public boolean hasCountdown() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public long getCountdown() {
            return this.countdown_;
        }

        private void initFields() {
            this.id_ = 0;
            this.code_ = "";
            this.lastcount_ = 0;
            this.countdown_ = 0L;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getCodeBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.lastcount_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt64(4, this.countdown_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getCodeBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.lastcount_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt64Size(4, this.countdown_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static IntergalMallItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IntergalMallItem) PARSER.parseFrom(data);
        }

        public static IntergalMallItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IntergalMallItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static IntergalMallItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IntergalMallItem) PARSER.parseFrom(data);
        }

        public static IntergalMallItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IntergalMallItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static IntergalMallItem parseFrom(InputStream input) throws IOException {
            return (IntergalMallItem) PARSER.parseFrom(input);
        }

        public static IntergalMallItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IntergalMallItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static IntergalMallItem parseDelimitedFrom(InputStream input) throws IOException {
            return (IntergalMallItem) PARSER.parseDelimitedFrom(input);
        }

        public static IntergalMallItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IntergalMallItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static IntergalMallItem parseFrom(CodedInputStream input) throws IOException {
            return (IntergalMallItem) PARSER.parseFrom(input);
        }

        public static IntergalMallItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IntergalMallItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(IntergalMallItem prototype) {
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
                implements IntergalMallHandler.IntergalMallItemOrBuilder {
            private int bitField0_;
            private int id_;
            private Object code_;
            private int lastcount_;
            private long countdown_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IntergalMallHandler.internal_static_pomelo_area_IntergalMallItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return IntergalMallHandler.internal_static_pomelo_area_IntergalMallItem_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallHandler.IntergalMallItem.class, Builder.class);
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
                if (IntergalMallHandler.IntergalMallItem.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.code_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.lastcount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.countdown_ = 0L;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return IntergalMallHandler.internal_static_pomelo_area_IntergalMallItem_descriptor;
            }

            public IntergalMallHandler.IntergalMallItem getDefaultInstanceForType() {
                return IntergalMallHandler.IntergalMallItem.getDefaultInstance();
            }

            public IntergalMallHandler.IntergalMallItem build() {
                IntergalMallHandler.IntergalMallItem result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public IntergalMallHandler.IntergalMallItem buildPartial() {
                IntergalMallHandler.IntergalMallItem result = new IntergalMallHandler.IntergalMallItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.code_ = this.code_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.lastcount_ = this.lastcount_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.countdown_ = this.countdown_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof IntergalMallHandler.IntergalMallItem)
                    return mergeFrom((IntergalMallHandler.IntergalMallItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IntergalMallHandler.IntergalMallItem other) {
                if (other == IntergalMallHandler.IntergalMallItem.getDefaultInstance())
                    return this;
                if (other.hasId())
                    setId(other.getId());
                if (other.hasCode()) {
                    this.bitField0_ |= 0x2;
                    this.code_ = other.code_;
                    onChanged();
                }
                if (other.hasLastcount())
                    setLastcount(other.getLastcount());
                if (other.hasCountdown())
                    setCountdown(other.getCountdown());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                IntergalMallHandler.IntergalMallItem parsedMessage = null;
                try {
                    parsedMessage = (IntergalMallHandler.IntergalMallItem) IntergalMallHandler.IntergalMallItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (IntergalMallHandler.IntergalMallItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
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

            public boolean hasCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getCode() {
                Object ref = this.code_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.code_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.code_ = value;
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.code_ = IntergalMallHandler.IntergalMallItem.getDefaultInstance().getCode();
                onChanged();
                return this;
            }

            public Builder setCodeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.code_ = value;
                onChanged();
                return this;
            }

            public boolean hasLastcount() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getLastcount() {
                return this.lastcount_;
            }

            public Builder setLastcount(int value) {
                this.bitField0_ |= 0x4;
                this.lastcount_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastcount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.lastcount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCountdown() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public long getCountdown() {
                return this.countdown_;
            }

            public Builder setCountdown(long value) {
                this.bitField0_ |= 0x8;
                this.countdown_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountdown() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.countdown_ = 0L;
                onChanged();
                return this;
            }
        }

        private static final IntergalMallItem defaultInstance = new IntergalMallItem(true);

        static {
            defaultInstance.initFields();
        }
    }


    public static final class IntergalMallTab
            extends GeneratedMessage
            implements IntergalMallTabOrBuilder {
        private static final IntergalMallTab defaultInstance = new IntergalMallTab(true);
        private final UnknownFieldSet unknownFields;

        private IntergalMallTab(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private IntergalMallTab(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static IntergalMallTab getDefaultInstance() {
            return defaultInstance;
        }

        public IntergalMallTab getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IntergalMallTab(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.tabId_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.items_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.items_.add(input.readMessage(IntergalMallHandler.IntergalMallItem.PARSER, extensionRegistry));
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.currencyNum_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.items_ = Collections.unmodifiableList(this.items_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IntergalMallHandler.internal_static_pomelo_area_IntergalMallTab_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return IntergalMallHandler.internal_static_pomelo_area_IntergalMallTab_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallTab.class, Builder.class);
        }

        public static Parser<IntergalMallTab> PARSER = (Parser<IntergalMallTab>) new AbstractParser<IntergalMallTab>() {
            public IntergalMallHandler.IntergalMallTab parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IntergalMallHandler.IntergalMallTab(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TABID_FIELD_NUMBER = 1;
        private int tabId_;
        public static final int ITEMS_FIELD_NUMBER = 2;
        private List<IntergalMallHandler.IntergalMallItem> items_;
        public static final int CURRENCYNUM_FIELD_NUMBER = 3;
        private int currencyNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<IntergalMallTab> getParserForType() {
            return PARSER;
        }

        public boolean hasTabId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTabId() {
            return this.tabId_;
        }

        public List<IntergalMallHandler.IntergalMallItem> getItemsList() {
            return this.items_;
        }

        public List<? extends IntergalMallHandler.IntergalMallItemOrBuilder> getItemsOrBuilderList() {
            return (List) this.items_;
        }

        static {
            defaultInstance.initFields();
        }

        public int getItemsCount() {
            return this.items_.size();
        }

        public IntergalMallHandler.IntergalMallItem getItems(int index) {
            return this.items_.get(index);
        }

        public IntergalMallHandler.IntergalMallItemOrBuilder getItemsOrBuilder(int index) {
            return this.items_.get(index);
        }

        public boolean hasCurrencyNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getCurrencyNum() {
            return this.currencyNum_;
        }

        private void initFields() {
            this.tabId_ = 0;
            this.items_ = Collections.emptyList();
            this.currencyNum_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasTabId()) {
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
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.tabId_);
            for (int i = 0; i < this.items_.size(); i++)
                output.writeMessage(2, (MessageLite) this.items_.get(i));
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(3, this.currencyNum_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.tabId_);
            for (int i = 0; i < this.items_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.items_.get(i));
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(3, this.currencyNum_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static IntergalMallTab parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IntergalMallTab) PARSER.parseFrom(data);
        }

        public static IntergalMallTab parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IntergalMallTab) PARSER.parseFrom(data, extensionRegistry);
        }

        public static IntergalMallTab parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IntergalMallTab) PARSER.parseFrom(data);
        }

        public static IntergalMallTab parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IntergalMallTab) PARSER.parseFrom(data, extensionRegistry);
        }

        public static IntergalMallTab parseFrom(InputStream input) throws IOException {
            return (IntergalMallTab) PARSER.parseFrom(input);
        }

        public static IntergalMallTab parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IntergalMallTab) PARSER.parseFrom(input, extensionRegistry);
        }

        public static IntergalMallTab parseDelimitedFrom(InputStream input) throws IOException {
            return (IntergalMallTab) PARSER.parseDelimitedFrom(input);
        }

        public static IntergalMallTab parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IntergalMallTab) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static IntergalMallTab parseFrom(CodedInputStream input) throws IOException {
            return (IntergalMallTab) PARSER.parseFrom(input);
        }

        public static IntergalMallTab parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IntergalMallTab) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(IntergalMallTab prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements IntergalMallHandler.IntergalMallTabOrBuilder {
            private int bitField0_;
            private int tabId_;
            private List<IntergalMallHandler.IntergalMallItem> items_;
            private RepeatedFieldBuilder<IntergalMallHandler.IntergalMallItem, IntergalMallHandler.IntergalMallItem.Builder, IntergalMallHandler.IntergalMallItemOrBuilder> itemsBuilder_;
            private int currencyNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IntergalMallHandler.internal_static_pomelo_area_IntergalMallTab_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return IntergalMallHandler.internal_static_pomelo_area_IntergalMallTab_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallHandler.IntergalMallTab.class, Builder.class);
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
                if (IntergalMallHandler.IntergalMallTab.alwaysUseFieldBuilders)
                    getItemsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.tabId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.itemsBuilder_.clear();
                }
                this.currencyNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return IntergalMallHandler.internal_static_pomelo_area_IntergalMallTab_descriptor;
            }

            public IntergalMallHandler.IntergalMallTab getDefaultInstanceForType() {
                return IntergalMallHandler.IntergalMallTab.getDefaultInstance();
            }

            public IntergalMallHandler.IntergalMallTab build() {
                IntergalMallHandler.IntergalMallTab result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public IntergalMallHandler.IntergalMallTab buildPartial() {
                IntergalMallHandler.IntergalMallTab result = new IntergalMallHandler.IntergalMallTab(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.tabId_ = this.tabId_;
                if (this.itemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.items_ = Collections.unmodifiableList(this.items_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.items_ = this.items_;
                } else {
                    result.items_ = this.itemsBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x2;
                result.currencyNum_ = this.currencyNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof IntergalMallHandler.IntergalMallTab)
                    return mergeFrom((IntergalMallHandler.IntergalMallTab) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IntergalMallHandler.IntergalMallTab other) {
                if (other == IntergalMallHandler.IntergalMallTab.getDefaultInstance())
                    return this;
                if (other.hasTabId())
                    setTabId(other.getTabId());
                if (this.itemsBuilder_ == null) {
                    if (!other.items_.isEmpty()) {
                        if (this.items_.isEmpty()) {
                            this.items_ = other.items_;
                            this.bitField0_ &= 0xFFFFFFFD;
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
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.itemsBuilder_ = IntergalMallHandler.IntergalMallTab.alwaysUseFieldBuilders ? getItemsFieldBuilder() : null;
                    } else {
                        this.itemsBuilder_.addAllMessages(other.items_);
                    }
                }
                if (other.hasCurrencyNum())
                    setCurrencyNum(other.getCurrencyNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTabId())
                    return false;
                for (int i = 0; i < getItemsCount(); i++) {
                    if (!getItems(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                IntergalMallHandler.IntergalMallTab parsedMessage = null;
                try {
                    parsedMessage = (IntergalMallHandler.IntergalMallTab) IntergalMallHandler.IntergalMallTab.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (IntergalMallHandler.IntergalMallTab) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTabId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTabId() {
                return this.tabId_;
            }

            public Builder setTabId(int value) {
                this.bitField0_ |= 0x1;
                this.tabId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTabId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.tabId_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.items_ = new ArrayList<>(this.items_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<IntergalMallHandler.IntergalMallItem> getItemsList() {
                if (this.itemsBuilder_ == null)
                    return Collections.unmodifiableList(this.items_);
                return this.itemsBuilder_.getMessageList();
            }

            public int getItemsCount() {
                if (this.itemsBuilder_ == null)
                    return this.items_.size();
                return this.itemsBuilder_.getCount();
            }

            public IntergalMallHandler.IntergalMallItem getItems(int index) {
                if (this.itemsBuilder_ == null)
                    return this.items_.get(index);
                return (IntergalMallHandler.IntergalMallItem) this.itemsBuilder_.getMessage(index);
            }

            public Builder setItems(int index, IntergalMallHandler.IntergalMallItem value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.set(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setItems(int index, IntergalMallHandler.IntergalMallItem.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItems(IntergalMallHandler.IntergalMallItem value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.add(value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addItems(int index, IntergalMallHandler.IntergalMallItem value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.add(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addItems(IntergalMallHandler.IntergalMallItem.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItems(int index, IntergalMallHandler.IntergalMallItem.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItems(Iterable<? extends IntergalMallHandler.IntergalMallItem> values) {
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
                    this.bitField0_ &= 0xFFFFFFFD;
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

            public IntergalMallHandler.IntergalMallItem.Builder getItemsBuilder(int index) {
                return (IntergalMallHandler.IntergalMallItem.Builder) getItemsFieldBuilder().getBuilder(index);
            }

            public IntergalMallHandler.IntergalMallItemOrBuilder getItemsOrBuilder(int index) {
                if (this.itemsBuilder_ == null)
                    return this.items_.get(index);
                return (IntergalMallHandler.IntergalMallItemOrBuilder) this.itemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends IntergalMallHandler.IntergalMallItemOrBuilder> getItemsOrBuilderList() {
                if (this.itemsBuilder_ != null)
                    return this.itemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.items_);
            }

            public IntergalMallHandler.IntergalMallItem.Builder addItemsBuilder() {
                return (IntergalMallHandler.IntergalMallItem.Builder) getItemsFieldBuilder().addBuilder(IntergalMallHandler.IntergalMallItem.getDefaultInstance());
            }

            public IntergalMallHandler.IntergalMallItem.Builder addItemsBuilder(int index) {
                return (IntergalMallHandler.IntergalMallItem.Builder) getItemsFieldBuilder().addBuilder(index, IntergalMallHandler.IntergalMallItem.getDefaultInstance());
            }

            public List<IntergalMallHandler.IntergalMallItem.Builder> getItemsBuilderList() {
                return getItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<IntergalMallHandler.IntergalMallItem, IntergalMallHandler.IntergalMallItem.Builder, IntergalMallHandler.IntergalMallItemOrBuilder> getItemsFieldBuilder() {
                if (this.itemsBuilder_ == null) {
                    this.itemsBuilder_ = new RepeatedFieldBuilder(this.items_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.items_ = null;
                }
                return this.itemsBuilder_;
            }

            public boolean hasCurrencyNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getCurrencyNum() {
                return this.currencyNum_;
            }

            public Builder setCurrencyNum(int value) {
                this.bitField0_ |= 0x4;
                this.currencyNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrencyNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.currencyNum_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetIntergalMallListRequest extends GeneratedMessage implements GetIntergalMallListRequestOrBuilder {
        private static final GetIntergalMallListRequest defaultInstance = new GetIntergalMallListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetIntergalMallListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetIntergalMallListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetIntergalMallListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetIntergalMallListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetIntergalMallListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SType_ = input.readInt32();
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
            return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetIntergalMallListRequest.class, Builder.class);
        }

        public static Parser<GetIntergalMallListRequest> PARSER = (Parser<GetIntergalMallListRequest>) new AbstractParser<GetIntergalMallListRequest>() {
            public IntergalMallHandler.GetIntergalMallListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IntergalMallHandler.GetIntergalMallListRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetIntergalMallListRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SType() {
            return this.c2SType_;
        }

        private void initFields() {
            this.c2SType_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetIntergalMallListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(data);
        }


        public static GetIntergalMallListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetIntergalMallListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(data);
        }


        public static GetIntergalMallListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetIntergalMallListRequest parseFrom(InputStream input) throws IOException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(input);
        }


        public static GetIntergalMallListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetIntergalMallListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetIntergalMallListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetIntergalMallListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetIntergalMallListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetIntergalMallListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(input);
        }


        public static GetIntergalMallListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetIntergalMallListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetIntergalMallListRequest prototype) {
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
                implements IntergalMallHandler.GetIntergalMallListRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallHandler.GetIntergalMallListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (IntergalMallHandler.GetIntergalMallListRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListRequest_descriptor;
            }


            public IntergalMallHandler.GetIntergalMallListRequest getDefaultInstanceForType() {
                return IntergalMallHandler.GetIntergalMallListRequest.getDefaultInstance();
            }


            public IntergalMallHandler.GetIntergalMallListRequest build() {
                IntergalMallHandler.GetIntergalMallListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public IntergalMallHandler.GetIntergalMallListRequest buildPartial() {
                IntergalMallHandler.GetIntergalMallListRequest result = new IntergalMallHandler.GetIntergalMallListRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof IntergalMallHandler.GetIntergalMallListRequest) {
                    return mergeFrom((IntergalMallHandler.GetIntergalMallListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(IntergalMallHandler.GetIntergalMallListRequest other) {
                if (other == IntergalMallHandler.GetIntergalMallListRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                IntergalMallHandler.GetIntergalMallListRequest parsedMessage = null;
                try {
                    parsedMessage = (IntergalMallHandler.GetIntergalMallListRequest) IntergalMallHandler.GetIntergalMallListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (IntergalMallHandler.GetIntergalMallListRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SType() {
                return this.c2SType_;
            }


            public Builder setC2SType(int value) {
                this.bitField0_ |= 0x1;
                this.c2SType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SType_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetIntergalMallListResponse
            extends GeneratedMessage
            implements GetIntergalMallListResponseOrBuilder {
        private static final GetIntergalMallListResponse defaultInstance = new GetIntergalMallListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetIntergalMallListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetIntergalMallListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetIntergalMallListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetIntergalMallListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetIntergalMallListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CTabitems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CTabitems_.add(input.readMessage(IntergalMallHandler.IntergalMallTab.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CTabitems_ = Collections.unmodifiableList(this.s2CTabitems_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetIntergalMallListResponse.class, Builder.class);
        }

        public static Parser<GetIntergalMallListResponse> PARSER = (Parser<GetIntergalMallListResponse>) new AbstractParser<GetIntergalMallListResponse>() {
            public IntergalMallHandler.GetIntergalMallListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IntergalMallHandler.GetIntergalMallListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TABITEMS_FIELD_NUMBER = 3;
        private List<IntergalMallHandler.IntergalMallTab> s2CTabitems_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetIntergalMallListResponse> getParserForType() {
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


        public List<IntergalMallHandler.IntergalMallTab> getS2CTabitemsList() {
            return this.s2CTabitems_;
        }


        public List<? extends IntergalMallHandler.IntergalMallTabOrBuilder> getS2CTabitemsOrBuilderList() {
            return (List) this.s2CTabitems_;
        }


        public int getS2CTabitemsCount() {
            return this.s2CTabitems_.size();
        }


        public IntergalMallHandler.IntergalMallTab getS2CTabitems(int index) {
            return this.s2CTabitems_.get(index);
        }


        public IntergalMallHandler.IntergalMallTabOrBuilder getS2CTabitemsOrBuilder(int index) {
            return this.s2CTabitems_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CTabitems_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CTabitemsCount(); i++) {
                if (!getS2CTabitems(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CTabitems_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CTabitems_.get(i));
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
            for (int i = 0; i < this.s2CTabitems_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CTabitems_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetIntergalMallListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(data);
        }


        public static GetIntergalMallListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetIntergalMallListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(data);
        }


        public static GetIntergalMallListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetIntergalMallListResponse parseFrom(InputStream input) throws IOException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(input);
        }


        public static GetIntergalMallListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetIntergalMallListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetIntergalMallListResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetIntergalMallListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetIntergalMallListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetIntergalMallListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(input);
        }


        public static GetIntergalMallListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetIntergalMallListResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetIntergalMallListResponse prototype) {
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
                implements IntergalMallHandler.GetIntergalMallListResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;

            private List<IntergalMallHandler.IntergalMallTab> s2CTabitems_;

            private RepeatedFieldBuilder<IntergalMallHandler.IntergalMallTab, IntergalMallHandler.IntergalMallTab.Builder, IntergalMallHandler.IntergalMallTabOrBuilder> s2CTabitemsBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallHandler.GetIntergalMallListResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CTabitems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CTabitems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (IntergalMallHandler.GetIntergalMallListResponse.alwaysUseFieldBuilders) {
                    getS2CTabitemsFieldBuilder();
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
                if (this.s2CTabitemsBuilder_ == null) {
                    this.s2CTabitems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CTabitemsBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return IntergalMallHandler.internal_static_pomelo_area_GetIntergalMallListResponse_descriptor;
            }


            public IntergalMallHandler.GetIntergalMallListResponse getDefaultInstanceForType() {
                return IntergalMallHandler.GetIntergalMallListResponse.getDefaultInstance();
            }


            public IntergalMallHandler.GetIntergalMallListResponse build() {
                IntergalMallHandler.GetIntergalMallListResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public IntergalMallHandler.GetIntergalMallListResponse buildPartial() {
                IntergalMallHandler.GetIntergalMallListResponse result = new IntergalMallHandler.GetIntergalMallListResponse(this);
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
                if (this.s2CTabitemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CTabitems_ = Collections.unmodifiableList(this.s2CTabitems_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CTabitems_ = this.s2CTabitems_;
                } else {
                    result.s2CTabitems_ = this.s2CTabitemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof IntergalMallHandler.GetIntergalMallListResponse) {
                    return mergeFrom((IntergalMallHandler.GetIntergalMallListResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IntergalMallHandler.GetIntergalMallListResponse other) {
                if (other == IntergalMallHandler.GetIntergalMallListResponse.getDefaultInstance()) {
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
                if (this.s2CTabitemsBuilder_ == null) {
                    if (!other.s2CTabitems_.isEmpty()) {
                        if (this.s2CTabitems_.isEmpty()) {
                            this.s2CTabitems_ = other.s2CTabitems_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CTabitemsIsMutable();
                            this.s2CTabitems_.addAll(other.s2CTabitems_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CTabitems_.isEmpty()) {
                    if (this.s2CTabitemsBuilder_.isEmpty()) {
                        this.s2CTabitemsBuilder_.dispose();
                        this.s2CTabitemsBuilder_ = null;
                        this.s2CTabitems_ = other.s2CTabitems_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CTabitemsBuilder_ = IntergalMallHandler.GetIntergalMallListResponse.alwaysUseFieldBuilders ? getS2CTabitemsFieldBuilder() : null;
                    } else {
                        this.s2CTabitemsBuilder_.addAllMessages(other.s2CTabitems_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CTabitemsCount(); i++) {
                    if (!getS2CTabitems(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                IntergalMallHandler.GetIntergalMallListResponse parsedMessage = null;
                try {
                    parsedMessage = (IntergalMallHandler.GetIntergalMallListResponse) IntergalMallHandler.GetIntergalMallListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (IntergalMallHandler.GetIntergalMallListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = IntergalMallHandler.GetIntergalMallListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CTabitemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CTabitems_ = new ArrayList<>(this.s2CTabitems_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<IntergalMallHandler.IntergalMallTab> getS2CTabitemsList() {
                if (this.s2CTabitemsBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CTabitems_);
                }
                return this.s2CTabitemsBuilder_.getMessageList();
            }

            public int getS2CTabitemsCount() {
                if (this.s2CTabitemsBuilder_ == null) {
                    return this.s2CTabitems_.size();
                }
                return this.s2CTabitemsBuilder_.getCount();
            }

            public IntergalMallHandler.IntergalMallTab getS2CTabitems(int index) {
                if (this.s2CTabitemsBuilder_ == null) {
                    return this.s2CTabitems_.get(index);
                }
                return (IntergalMallHandler.IntergalMallTab) this.s2CTabitemsBuilder_.getMessage(index);
            }

            public Builder setS2CTabitems(int index, IntergalMallHandler.IntergalMallTab value) {
                if (this.s2CTabitemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.set(index, value);
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CTabitems(int index, IntergalMallHandler.IntergalMallTab.Builder builderForValue) {
                if (this.s2CTabitemsBuilder_ == null) {
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTabitems(IntergalMallHandler.IntergalMallTab value) {
                if (this.s2CTabitemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.add(value);
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CTabitems(int index, IntergalMallHandler.IntergalMallTab value) {
                if (this.s2CTabitemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.add(index, value);
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CTabitems(IntergalMallHandler.IntergalMallTab.Builder builderForValue) {
                if (this.s2CTabitemsBuilder_ == null) {
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTabitems(int index, IntergalMallHandler.IntergalMallTab.Builder builderForValue) {
                if (this.s2CTabitemsBuilder_ == null) {
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CTabitems(Iterable<? extends IntergalMallHandler.IntergalMallTab> values) {
                if (this.s2CTabitemsBuilder_ == null) {
                    ensureS2CTabitemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CTabitems_);
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CTabitems() {
                if (this.s2CTabitemsBuilder_ == null) {
                    this.s2CTabitems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CTabitems(int index) {
                if (this.s2CTabitemsBuilder_ == null) {
                    ensureS2CTabitemsIsMutable();
                    this.s2CTabitems_.remove(index);
                    onChanged();
                } else {
                    this.s2CTabitemsBuilder_.remove(index);
                }
                return this;
            }

            public IntergalMallHandler.IntergalMallTab.Builder getS2CTabitemsBuilder(int index) {
                return (IntergalMallHandler.IntergalMallTab.Builder) getS2CTabitemsFieldBuilder().getBuilder(index);
            }

            public IntergalMallHandler.IntergalMallTabOrBuilder getS2CTabitemsOrBuilder(int index) {
                if (this.s2CTabitemsBuilder_ == null) {
                    return this.s2CTabitems_.get(index);
                }
                return (IntergalMallHandler.IntergalMallTabOrBuilder) this.s2CTabitemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends IntergalMallHandler.IntergalMallTabOrBuilder> getS2CTabitemsOrBuilderList() {
                if (this.s2CTabitemsBuilder_ != null) {
                    return this.s2CTabitemsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CTabitems_);
            }

            public IntergalMallHandler.IntergalMallTab.Builder addS2CTabitemsBuilder() {
                return (IntergalMallHandler.IntergalMallTab.Builder) getS2CTabitemsFieldBuilder().addBuilder(IntergalMallHandler.IntergalMallTab.getDefaultInstance());
            }

            public IntergalMallHandler.IntergalMallTab.Builder addS2CTabitemsBuilder(int index) {
                return (IntergalMallHandler.IntergalMallTab.Builder) getS2CTabitemsFieldBuilder().addBuilder(index, IntergalMallHandler.IntergalMallTab.getDefaultInstance());
            }

            public List<IntergalMallHandler.IntergalMallTab.Builder> getS2CTabitemsBuilderList() {
                return getS2CTabitemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<IntergalMallHandler.IntergalMallTab, IntergalMallHandler.IntergalMallTab.Builder, IntergalMallHandler.IntergalMallTabOrBuilder> getS2CTabitemsFieldBuilder() {
                if (this.s2CTabitemsBuilder_ == null) {
                    this.s2CTabitemsBuilder_ = new RepeatedFieldBuilder(this.s2CTabitems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CTabitems_ = null;
                }
                return this.s2CTabitemsBuilder_;
            }
        }
    }

    public static final class BuyIntergalItemRequest
            extends GeneratedMessage
            implements BuyIntergalItemRequestOrBuilder {
        private static final BuyIntergalItemRequest defaultInstance = new BuyIntergalItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyIntergalItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyIntergalItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyIntergalItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyIntergalItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyIntergalItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SType_ = input.readInt32();
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
            return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyIntergalItemRequest.class, Builder.class);
        }

        public static Parser<BuyIntergalItemRequest> PARSER = (Parser<BuyIntergalItemRequest>) new AbstractParser<BuyIntergalItemRequest>() {
            public IntergalMallHandler.BuyIntergalItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IntergalMallHandler.BuyIntergalItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        public static final int C2S_ITEMID_FIELD_NUMBER = 2;
        private int c2SItemId_;
        public static final int C2S_NUM_FIELD_NUMBER = 3;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyIntergalItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SType() {
            return this.c2SType_;
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
            this.c2SType_ = 0;
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
            if (!hasC2SItemId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SType_);
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


        public static BuyIntergalItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(data);
        }


        public static BuyIntergalItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyIntergalItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(data);
        }


        public static BuyIntergalItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyIntergalItemRequest parseFrom(InputStream input) throws IOException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(input);
        }


        public static BuyIntergalItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyIntergalItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyIntergalItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BuyIntergalItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyIntergalItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyIntergalItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(input);
        }


        public static BuyIntergalItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyIntergalItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyIntergalItemRequest prototype) {
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
                implements IntergalMallHandler.BuyIntergalItemRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            private int c2SItemId_;


            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallHandler.BuyIntergalItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (IntergalMallHandler.BuyIntergalItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SType_ = 0;
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
                return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemRequest_descriptor;
            }


            public IntergalMallHandler.BuyIntergalItemRequest getDefaultInstanceForType() {
                return IntergalMallHandler.BuyIntergalItemRequest.getDefaultInstance();
            }


            public IntergalMallHandler.BuyIntergalItemRequest build() {
                IntergalMallHandler.BuyIntergalItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public IntergalMallHandler.BuyIntergalItemRequest buildPartial() {
                IntergalMallHandler.BuyIntergalItemRequest result = new IntergalMallHandler.BuyIntergalItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SType_ = this.c2SType_;
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
                if (other instanceof IntergalMallHandler.BuyIntergalItemRequest) {
                    return mergeFrom((IntergalMallHandler.BuyIntergalItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(IntergalMallHandler.BuyIntergalItemRequest other) {
                if (other == IntergalMallHandler.BuyIntergalItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
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
                if (!hasC2SItemId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                IntergalMallHandler.BuyIntergalItemRequest parsedMessage = null;
                try {
                    parsedMessage = (IntergalMallHandler.BuyIntergalItemRequest) IntergalMallHandler.BuyIntergalItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (IntergalMallHandler.BuyIntergalItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SType() {
                return this.c2SType_;
            }


            public Builder setC2SType(int value) {
                this.bitField0_ |= 0x1;
                this.c2SType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SType_ = 0;
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


    public static final class BuyIntergalItemResponse
            extends GeneratedMessage
            implements BuyIntergalItemResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private BuyIntergalItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private BuyIntergalItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static BuyIntergalItemResponse getDefaultInstance() {
            return defaultInstance;
        }


        public BuyIntergalItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private BuyIntergalItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.lastcount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.currencyNum_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.totalNum_ = input.readInt32();
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
            return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyIntergalItemResponse.class, Builder.class);
        }


        public static Parser<BuyIntergalItemResponse> PARSER = (Parser<BuyIntergalItemResponse>) new AbstractParser<BuyIntergalItemResponse>() {
            public IntergalMallHandler.BuyIntergalItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IntergalMallHandler.BuyIntergalItemResponse(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_MSG_FIELD_NUMBER = 2;


        private Object s2CMsg_;


        public static final int LASTCOUNT_FIELD_NUMBER = 3;


        private int lastcount_;


        public static final int CURRENCYNUM_FIELD_NUMBER = 4;


        private int currencyNum_;


        public static final int TOTAL_NUM_FIELD_NUMBER = 5;


        private int totalNum_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<BuyIntergalItemResponse> getParserForType() {
            return PARSER;
        }


        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getS2CCode() {
            return this.s2CCode_;
        }


        private static final BuyIntergalItemResponse defaultInstance = new BuyIntergalItemResponse(true);

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

        public boolean hasLastcount() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getLastcount() {
            return this.lastcount_;
        }

        public boolean hasCurrencyNum() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getCurrencyNum() {
            return this.currencyNum_;
        }

        public boolean hasTotalNum() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getTotalNum() {
            return this.totalNum_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.lastcount_ = 0;
            this.currencyNum_ = 0;
            this.totalNum_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.lastcount_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.currencyNum_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.totalNum_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.lastcount_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.currencyNum_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.totalNum_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuyIntergalItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(data);
        }

        public static BuyIntergalItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyIntergalItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(data);
        }

        public static BuyIntergalItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyIntergalItemResponse parseFrom(InputStream input) throws IOException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(input);
        }

        public static BuyIntergalItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyIntergalItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyIntergalItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BuyIntergalItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyIntergalItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyIntergalItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(input);
        }

        public static BuyIntergalItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyIntergalItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyIntergalItemResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements IntergalMallHandler.BuyIntergalItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int lastcount_;
            private int currencyNum_;
            private int totalNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(IntergalMallHandler.BuyIntergalItemResponse.class, Builder.class);
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
                if (IntergalMallHandler.BuyIntergalItemResponse.alwaysUseFieldBuilders) ;
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
                this.lastcount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.currencyNum_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.totalNum_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return IntergalMallHandler.internal_static_pomelo_area_BuyIntergalItemResponse_descriptor;
            }

            public IntergalMallHandler.BuyIntergalItemResponse getDefaultInstanceForType() {
                return IntergalMallHandler.BuyIntergalItemResponse.getDefaultInstance();
            }

            public IntergalMallHandler.BuyIntergalItemResponse build() {
                IntergalMallHandler.BuyIntergalItemResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public IntergalMallHandler.BuyIntergalItemResponse buildPartial() {
                IntergalMallHandler.BuyIntergalItemResponse result = new IntergalMallHandler.BuyIntergalItemResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.lastcount_ = this.lastcount_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.currencyNum_ = this.currencyNum_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.totalNum_ = this.totalNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof IntergalMallHandler.BuyIntergalItemResponse)
                    return mergeFrom((IntergalMallHandler.BuyIntergalItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IntergalMallHandler.BuyIntergalItemResponse other) {
                if (other == IntergalMallHandler.BuyIntergalItemResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasLastcount()) setLastcount(other.getLastcount());
                if (other.hasCurrencyNum()) setCurrencyNum(other.getCurrencyNum());
                if (other.hasTotalNum()) setTotalNum(other.getTotalNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                IntergalMallHandler.BuyIntergalItemResponse parsedMessage = null;
                try {
                    parsedMessage = (IntergalMallHandler.BuyIntergalItemResponse) IntergalMallHandler.BuyIntergalItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (IntergalMallHandler.BuyIntergalItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = IntergalMallHandler.BuyIntergalItemResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasLastcount() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getLastcount() {
                return this.lastcount_;
            }

            public Builder setLastcount(int value) {
                this.bitField0_ |= 0x4;
                this.lastcount_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastcount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.lastcount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurrencyNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getCurrencyNum() {
                return this.currencyNum_;
            }

            public Builder setCurrencyNum(int value) {
                this.bitField0_ |= 0x8;
                this.currencyNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrencyNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.currencyNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTotalNum() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getTotalNum() {
                return this.totalNum_;
            }

            public Builder setTotalNum(int value) {
                this.bitField0_ |= 0x10;
                this.totalNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalNum() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.totalNum_ = 0;
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
        String[] descriptorData = {"\n\031intergalMallHandler.proto\022\013pomelo.area\"R\n\020IntergalMallItem\022\n\n\002id\030\001 \002(\005\022\f\n\004code\030\002 \002(\t\022\021\n\tlastcount\030\003 \001(\005\022\021\n\tcountdown\030\004 \001(\003\"c\n\017IntergalMallTab\022\r\n\005tabId\030\001 \002(\005\022,\n\005items\030\002 \003(\0132\035.pomelo.area.IntergalMallItem\022\023\n\013currencyNum\030\003 \001(\005\".\n\032GetIntergalMallListRequest\022\020\n\bc2s_type\030\001 \001(\005\"t\n\033GetIntergalMallListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0222\n\fs2c_tabitems\030\003 \003(\0132\034.pomelo.area.IntergalMallTab\"O\n\026BuyIn", "tergalItemRequest\022\020\n\bc2s_type\030\001 \001(\005\022\022\n\nc2s_itemId\030\002 \002(\005\022\017\n\007c2s_num\030\003 \001(\005\"w\n\027BuyIntergalItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\tlastcount\030\003 \001(\005\022\023\n\013currencyNum\030\004 \001(\005\022\021\n\ttotal_num\030\005 \001(\0052ì\001\n\023intergalMallHandler\022p\n\033getMallScoreItemListRequest\022'.pomelo.area.GetIntergalMallListRequest\032(.pomelo.area.GetIntergalMallListResponse\022c\n\026buyIntergalItemRequest\022#.pomelo.area.BuyIntergalItemRequest\032$.pom", "elo.area.BuyIntergalItemResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                IntergalMallHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_IntergalMallItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_IntergalMallItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_IntergalMallItem_descriptor, new String[]{"Id", "Code", "Lastcount", "Countdown"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_IntergalMallTab_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_IntergalMallTab_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_IntergalMallTab_descriptor, new String[]{"TabId", "Items", "CurrencyNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetIntergalMallListRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetIntergalMallListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetIntergalMallListRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetIntergalMallListResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetIntergalMallListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetIntergalMallListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CTabitems"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyIntergalItemRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyIntergalItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyIntergalItemRequest_descriptor, new String[]{"C2SType", "C2SItemId", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyIntergalItemResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyIntergalItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyIntergalItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Lastcount", "CurrencyNum", "TotalNum"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface BuyIntergalItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasLastcount();

        int getLastcount();

        boolean hasCurrencyNum();

        int getCurrencyNum();

        boolean hasTotalNum();

        int getTotalNum();
    }

    public static interface BuyIntergalItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();

        boolean hasC2SItemId();

        int getC2SItemId();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface GetIntergalMallListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<IntergalMallHandler.IntergalMallTab> getS2CTabitemsList();

        IntergalMallHandler.IntergalMallTab getS2CTabitems(int param1Int);

        int getS2CTabitemsCount();

        List<? extends IntergalMallHandler.IntergalMallTabOrBuilder> getS2CTabitemsOrBuilderList();

        IntergalMallHandler.IntergalMallTabOrBuilder getS2CTabitemsOrBuilder(int param1Int);
    }

    public static interface GetIntergalMallListRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }

    public static interface IntergalMallTabOrBuilder extends MessageOrBuilder {
        boolean hasTabId();

        int getTabId();

        List<IntergalMallHandler.IntergalMallItem> getItemsList();

        IntergalMallHandler.IntergalMallItem getItems(int param1Int);

        int getItemsCount();

        List<? extends IntergalMallHandler.IntergalMallItemOrBuilder> getItemsOrBuilderList();

        IntergalMallHandler.IntergalMallItemOrBuilder getItemsOrBuilder(int param1Int);

        boolean hasCurrencyNum();

        int getCurrencyNum();
    }

    public static interface IntergalMallItemOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasCode();

        String getCode();

        ByteString getCodeBytes();

        boolean hasLastcount();

        int getLastcount();

        boolean hasCountdown();

        long getCountdown();
    }
}


