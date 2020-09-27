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


public final class GuildBlessHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class BlessItem
            extends GeneratedMessage
            implements BlessItemOrBuilder {
        private static final BlessItem defaultInstance = new BlessItem(true);
        private final UnknownFieldSet unknownFields;

        private BlessItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BlessItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BlessItem getDefaultInstance() {
            return defaultInstance;
        }

        public BlessItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlessItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.item_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.item_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.item_ = Collections.unmodifiableList(this.item_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessItem_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessItem.class, Builder.class);
        }

        public static Parser<BlessItem> PARSER = (Parser<BlessItem>) new AbstractParser<BlessItem>() {
            public GuildBlessHandler.BlessItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.BlessItem(input, extensionRegistry);
            }
        };
        public static final int ITEM_FIELD_NUMBER = 1;
        private List<ItemOuterClass.MiniItem> item_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BlessItem> getParserForType() {
            return PARSER;
        }

        public List<ItemOuterClass.MiniItem> getItemList() {
            return this.item_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemOrBuilderList() {
            return (List) this.item_;
        }

        public int getItemCount() {
            return this.item_.size();
        }

        public ItemOuterClass.MiniItem getItem(int index) {
            return this.item_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.item_.get(index);
        }

        static {
            defaultInstance.initFields();
        }

        private void initFields() {
            this.item_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            for (int i = 0; i < getItemCount(); i++) {
                if (!getItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.item_.size(); i++)
                output.writeMessage(1, (MessageLite) this.item_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            for (int i = 0; i < this.item_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.item_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BlessItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BlessItem) PARSER.parseFrom(data);
        }

        public static BlessItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BlessItem) PARSER.parseFrom(data);
        }

        public static BlessItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessItem parseFrom(InputStream input) throws IOException {
            return (BlessItem) PARSER.parseFrom(input);
        }

        public static BlessItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BlessItem parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessItem) PARSER.parseDelimitedFrom(input);
        }

        public static BlessItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BlessItem parseFrom(CodedInputStream input) throws IOException {
            return (BlessItem) PARSER.parseFrom(input);
        }

        public static BlessItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BlessItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBlessHandler.BlessItemOrBuilder {
            private int bitField0_;
            private List<ItemOuterClass.MiniItem> item_;
            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessItem_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.BlessItem.class, Builder.class);
            }

            private Builder() {
                this.item_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.item_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.BlessItem.alwaysUseFieldBuilders)
                    getItemFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.itemBuilder_ == null) {
                    this.item_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.itemBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessItem_descriptor;
            }

            public GuildBlessHandler.BlessItem getDefaultInstanceForType() {
                return GuildBlessHandler.BlessItem.getDefaultInstance();
            }

            public GuildBlessHandler.BlessItem build() {
                GuildBlessHandler.BlessItem result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBlessHandler.BlessItem buildPartial() {
                GuildBlessHandler.BlessItem result = new GuildBlessHandler.BlessItem(this);
                int from_bitField0_ = this.bitField0_;
                if (this.itemBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.item_ = Collections.unmodifiableList(this.item_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.item_ = this.item_;
                } else {
                    result.item_ = this.itemBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.BlessItem)
                    return mergeFrom((GuildBlessHandler.BlessItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBlessHandler.BlessItem other) {
                if (other == GuildBlessHandler.BlessItem.getDefaultInstance())
                    return this;
                if (this.itemBuilder_ == null) {
                    if (!other.item_.isEmpty()) {
                        if (this.item_.isEmpty()) {
                            this.item_ = other.item_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureItemIsMutable();
                            this.item_.addAll(other.item_);
                        }
                        onChanged();
                    }
                } else if (!other.item_.isEmpty()) {
                    if (this.itemBuilder_.isEmpty()) {
                        this.itemBuilder_.dispose();
                        this.itemBuilder_ = null;
                        this.item_ = other.item_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.itemBuilder_ = GuildBlessHandler.BlessItem.alwaysUseFieldBuilders ? getItemFieldBuilder() : null;
                    } else {
                        this.itemBuilder_.addAllMessages(other.item_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getItemCount(); i++) {
                    if (!getItem(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.BlessItem parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.BlessItem) GuildBlessHandler.BlessItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.BlessItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureItemIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.item_ = new ArrayList<>(this.item_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<ItemOuterClass.MiniItem> getItemList() {
                if (this.itemBuilder_ == null)
                    return Collections.unmodifiableList(this.item_);
                return this.itemBuilder_.getMessageList();
            }

            public int getItemCount() {
                if (this.itemBuilder_ == null)
                    return this.item_.size();
                return this.itemBuilder_.getCount();
            }

            public ItemOuterClass.MiniItem getItem(int index) {
                if (this.itemBuilder_ == null)
                    return this.item_.get(index);
                return (ItemOuterClass.MiniItem) this.itemBuilder_.getMessage(index);
            }

            public Builder setItem(int index, ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemIsMutable();
                    this.item_.set(index, value);
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemIsMutable();
                    this.item_.add(value);
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addItem(int index, ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemIsMutable();
                    this.item_.add(index, value);
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllItem(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.item_);
                    onChanged();
                } else {
                    this.itemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.itemBuilder_.clear();
                }
                return this;
            }

            public Builder removeItem(int index) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.remove(index);
                    onChanged();
                } else {
                    this.itemBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder(int index) {
                if (this.itemBuilder_ == null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.item_.get(index);
                return (ItemOuterClass.MiniItemOrBuilder) this.itemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemOrBuilderList() {
                if (this.itemBuilder_ != null)
                    return this.itemBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.item_);
            }

            public ItemOuterClass.MiniItem.Builder addItemBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public ItemOuterClass.MiniItem.Builder addItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public List<ItemOuterClass.MiniItem.Builder> getItemBuilderList() {
                return getItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new RepeatedFieldBuilder(this.item_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }
        }
    }

    public static final class GetMyBlessInfoRequest extends GeneratedMessage implements GetMyBlessInfoRequestOrBuilder {
        private static final GetMyBlessInfoRequest defaultInstance = new GetMyBlessInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMyBlessInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMyBlessInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMyBlessInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMyBlessInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMyBlessInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMyBlessInfoRequest.class, Builder.class);
        }

        public static Parser<GetMyBlessInfoRequest> PARSER = (Parser<GetMyBlessInfoRequest>) new AbstractParser<GetMyBlessInfoRequest>() {
            public GuildBlessHandler.GetMyBlessInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.GetMyBlessInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMyBlessInfoRequest> getParserForType() {
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

        static {
            defaultInstance.initFields();
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMyBlessInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(data);
        }


        public static GetMyBlessInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMyBlessInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(data);
        }


        public static GetMyBlessInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMyBlessInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(input);
        }


        public static GetMyBlessInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMyBlessInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMyBlessInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetMyBlessInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMyBlessInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMyBlessInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(input);
        }


        public static GetMyBlessInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMyBlessInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMyBlessInfoRequest prototype) {
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
                implements GuildBlessHandler.GetMyBlessInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.GetMyBlessInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.GetMyBlessInfoRequest.alwaysUseFieldBuilders) ;
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
                return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoRequest_descriptor;
            }


            public GuildBlessHandler.GetMyBlessInfoRequest getDefaultInstanceForType() {
                return GuildBlessHandler.GetMyBlessInfoRequest.getDefaultInstance();
            }


            public GuildBlessHandler.GetMyBlessInfoRequest build() {
                GuildBlessHandler.GetMyBlessInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.GetMyBlessInfoRequest buildPartial() {
                GuildBlessHandler.GetMyBlessInfoRequest result = new GuildBlessHandler.GetMyBlessInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.GetMyBlessInfoRequest) {
                    return mergeFrom((GuildBlessHandler.GetMyBlessInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.GetMyBlessInfoRequest other) {
                if (other == GuildBlessHandler.GetMyBlessInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.GetMyBlessInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.GetMyBlessInfoRequest) GuildBlessHandler.GetMyBlessInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.GetMyBlessInfoRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
        }
    }


    public static final class BlessActionRequest
            extends GeneratedMessage
            implements BlessActionRequestOrBuilder {
        private static final BlessActionRequest defaultInstance = new BlessActionRequest(true);
        private final UnknownFieldSet unknownFields;

        private BlessActionRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BlessActionRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BlessActionRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BlessActionRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlessActionRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBlessHandler.internal_static_pomelo_area_BlessActionRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessActionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessActionRequest.class, Builder.class);
        }

        public static Parser<BlessActionRequest> PARSER = (Parser<BlessActionRequest>) new AbstractParser<BlessActionRequest>() {
            public GuildBlessHandler.BlessActionRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.BlessActionRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BlessActionRequest> getParserForType() {
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
                output.writeInt32(1, this.id_);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BlessActionRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BlessActionRequest) PARSER.parseFrom(data);
        }


        public static BlessActionRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessActionRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BlessActionRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BlessActionRequest) PARSER.parseFrom(data);
        }


        public static BlessActionRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessActionRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BlessActionRequest parseFrom(InputStream input) throws IOException {
            return (BlessActionRequest) PARSER.parseFrom(input);
        }


        public static BlessActionRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessActionRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BlessActionRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessActionRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BlessActionRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessActionRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BlessActionRequest parseFrom(CodedInputStream input) throws IOException {
            return (BlessActionRequest) PARSER.parseFrom(input);
        }


        public static BlessActionRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessActionRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BlessActionRequest prototype) {
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
                implements GuildBlessHandler.BlessActionRequestOrBuilder {
            private int bitField0_;


            private int id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessActionRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessActionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.BlessActionRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.BlessActionRequest.alwaysUseFieldBuilders) ;
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
                return GuildBlessHandler.internal_static_pomelo_area_BlessActionRequest_descriptor;
            }


            public GuildBlessHandler.BlessActionRequest getDefaultInstanceForType() {
                return GuildBlessHandler.BlessActionRequest.getDefaultInstance();
            }


            public GuildBlessHandler.BlessActionRequest build() {
                GuildBlessHandler.BlessActionRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.BlessActionRequest buildPartial() {
                GuildBlessHandler.BlessActionRequest result = new GuildBlessHandler.BlessActionRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.BlessActionRequest) {
                    return mergeFrom((GuildBlessHandler.BlessActionRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.BlessActionRequest other) {
                if (other == GuildBlessHandler.BlessActionRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.BlessActionRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.BlessActionRequest) GuildBlessHandler.BlessActionRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.BlessActionRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
    }


    public static final class ReceiveBlessGiftRequest
            extends GeneratedMessage
            implements ReceiveBlessGiftRequestOrBuilder {
        private static final ReceiveBlessGiftRequest defaultInstance = new ReceiveBlessGiftRequest(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveBlessGiftRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveBlessGiftRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveBlessGiftRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveBlessGiftRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveBlessGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveBlessGiftRequest.class, Builder.class);
        }

        public static Parser<ReceiveBlessGiftRequest> PARSER = (Parser<ReceiveBlessGiftRequest>) new AbstractParser<ReceiveBlessGiftRequest>() {
            public GuildBlessHandler.ReceiveBlessGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.ReceiveBlessGiftRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int INDEX_FIELD_NUMBER = 1;
        private int index_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReceiveBlessGiftRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getIndex() {
            return this.index_;
        }

        private void initFields() {
            this.index_ = 0;
        }

        static {
            defaultInstance.initFields();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.index_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.index_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ReceiveBlessGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(data);
        }

        public static ReceiveBlessGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReceiveBlessGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(data);
        }

        public static ReceiveBlessGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReceiveBlessGiftRequest parseFrom(InputStream input) throws IOException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(input);
        }

        public static ReceiveBlessGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ReceiveBlessGiftRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveBlessGiftRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ReceiveBlessGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveBlessGiftRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ReceiveBlessGiftRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(input);
        }

        public static ReceiveBlessGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveBlessGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ReceiveBlessGiftRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBlessHandler.ReceiveBlessGiftRequestOrBuilder {
            private int bitField0_;
            private int index_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.ReceiveBlessGiftRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.ReceiveBlessGiftRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.index_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftRequest_descriptor;
            }

            public GuildBlessHandler.ReceiveBlessGiftRequest getDefaultInstanceForType() {
                return GuildBlessHandler.ReceiveBlessGiftRequest.getDefaultInstance();
            }

            public GuildBlessHandler.ReceiveBlessGiftRequest build() {
                GuildBlessHandler.ReceiveBlessGiftRequest result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBlessHandler.ReceiveBlessGiftRequest buildPartial() {
                GuildBlessHandler.ReceiveBlessGiftRequest result = new GuildBlessHandler.ReceiveBlessGiftRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.index_ = this.index_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.ReceiveBlessGiftRequest)
                    return mergeFrom((GuildBlessHandler.ReceiveBlessGiftRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBlessHandler.ReceiveBlessGiftRequest other) {
                if (other == GuildBlessHandler.ReceiveBlessGiftRequest.getDefaultInstance())
                    return this;
                if (other.hasIndex())
                    setIndex(other.getIndex());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIndex())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.ReceiveBlessGiftRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.ReceiveBlessGiftRequest) GuildBlessHandler.ReceiveBlessGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.ReceiveBlessGiftRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
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
        }
    }

    public static final class UpgradeBlessRequest extends GeneratedMessage implements UpgradeBlessRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private UpgradeBlessRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeBlessRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeBlessRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeBlessRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeBlessRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                    if (!parseUnknownField(input, unknownFields, extensionRegistry, tag))
                        done = true;
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
            return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeBlessRequest.class, Builder.class);
        }

        public static Parser<UpgradeBlessRequest> PARSER = (Parser<UpgradeBlessRequest>) new AbstractParser<UpgradeBlessRequest>() {
            public GuildBlessHandler.UpgradeBlessRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.UpgradeBlessRequest(input, extensionRegistry);
            }
        };

        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeBlessRequest> getParserForType() {
            return PARSER;
        }

        private void initFields() {
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
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        private static final UpgradeBlessRequest defaultInstance = new UpgradeBlessRequest(true);

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static UpgradeBlessRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeBlessRequest) PARSER.parseFrom(data);
        }

        public static UpgradeBlessRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeBlessRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeBlessRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeBlessRequest) PARSER.parseFrom(data);
        }

        public static UpgradeBlessRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeBlessRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeBlessRequest parseFrom(InputStream input) throws IOException {
            return (UpgradeBlessRequest) PARSER.parseFrom(input);
        }

        public static UpgradeBlessRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeBlessRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeBlessRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeBlessRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeBlessRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeBlessRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeBlessRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeBlessRequest) PARSER.parseFrom(input);
        }

        public static UpgradeBlessRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeBlessRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeBlessRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBlessHandler.UpgradeBlessRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.UpgradeBlessRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.UpgradeBlessRequest.alwaysUseFieldBuilders) ;
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
                return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessRequest_descriptor;
            }

            public GuildBlessHandler.UpgradeBlessRequest getDefaultInstanceForType() {
                return GuildBlessHandler.UpgradeBlessRequest.getDefaultInstance();
            }

            public GuildBlessHandler.UpgradeBlessRequest build() {
                GuildBlessHandler.UpgradeBlessRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBlessHandler.UpgradeBlessRequest buildPartial() {
                GuildBlessHandler.UpgradeBlessRequest result = new GuildBlessHandler.UpgradeBlessRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.UpgradeBlessRequest)
                    return mergeFrom((GuildBlessHandler.UpgradeBlessRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBlessHandler.UpgradeBlessRequest other) {
                if (other == GuildBlessHandler.UpgradeBlessRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.UpgradeBlessRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.UpgradeBlessRequest) GuildBlessHandler.UpgradeBlessRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.UpgradeBlessRequest) e.getUnfinishedMessage();
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


    public static final class MyBlessInfo
            extends GeneratedMessage
            implements MyBlessInfoOrBuilder {
        private static final MyBlessInfo defaultInstance = new MyBlessInfo(true);
        private final UnknownFieldSet unknownFields;

        private MyBlessInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MyBlessInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MyBlessInfo getDefaultInstance() {
            return defaultInstance;
        }

        public MyBlessInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MyBlessInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blessCount_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.blessAttrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.blessAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry));
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.buffTime_ = input.readInt32();
                            break;
                        case 32:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.receiveState_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.receiveState_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 34:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x8) != 8 && input.getBytesUntilLimit() > 0) {
                                this.receiveState_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.receiveState_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.itemList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.itemList_.add(input.readMessage(GuildBlessHandler.BlessItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.blessAttrs_ = Collections.unmodifiableList(this.blessAttrs_);
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.receiveState_ = Collections.unmodifiableList(this.receiveState_);
                if ((mutable_bitField0_ & 0x10) == 16) this.itemList_ = Collections.unmodifiableList(this.itemList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildBlessHandler.internal_static_pomelo_area_MyBlessInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_MyBlessInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MyBlessInfo.class, Builder.class);
        }

        public static Parser<MyBlessInfo> PARSER = (Parser<MyBlessInfo>) new AbstractParser<MyBlessInfo>() {
            public GuildBlessHandler.MyBlessInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.MyBlessInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLESSCOUNT_FIELD_NUMBER = 1;
        private int blessCount_;
        public static final int BLESSATTRS_FIELD_NUMBER = 2;
        private List<Common.AttributeBase> blessAttrs_;
        public static final int BUFFTIME_FIELD_NUMBER = 3;
        private int buffTime_;
        public static final int RECEIVESTATE_FIELD_NUMBER = 4;
        private List<Integer> receiveState_;
        public static final int ITEMLIST_FIELD_NUMBER = 5;
        private List<GuildBlessHandler.BlessItem> itemList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MyBlessInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasBlessCount() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlessCount() {
            return this.blessCount_;
        }

        public List<Common.AttributeBase> getBlessAttrsList() {
            return this.blessAttrs_;
        }

        public List<? extends Common.AttributeBaseOrBuilder> getBlessAttrsOrBuilderList() {
            return (List) this.blessAttrs_;
        }

        public int getBlessAttrsCount() {
            return this.blessAttrs_.size();
        }

        public Common.AttributeBase getBlessAttrs(int index) {
            return this.blessAttrs_.get(index);
        }

        static {
            defaultInstance.initFields();
        }

        public Common.AttributeBaseOrBuilder getBlessAttrsOrBuilder(int index) {
            return (Common.AttributeBaseOrBuilder) this.blessAttrs_.get(index);
        }

        public boolean hasBuffTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getBuffTime() {
            return this.buffTime_;
        }

        public List<Integer> getReceiveStateList() {
            return this.receiveState_;
        }

        public int getReceiveStateCount() {
            return this.receiveState_.size();
        }

        public int getReceiveState(int index) {
            return ((Integer) this.receiveState_.get(index)).intValue();
        }

        public List<GuildBlessHandler.BlessItem> getItemListList() {
            return this.itemList_;
        }

        public List<? extends GuildBlessHandler.BlessItemOrBuilder> getItemListOrBuilderList() {
            return (List) this.itemList_;
        }

        public int getItemListCount() {
            return this.itemList_.size();
        }

        public GuildBlessHandler.BlessItem getItemList(int index) {
            return this.itemList_.get(index);
        }

        public GuildBlessHandler.BlessItemOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        private void initFields() {
            this.blessCount_ = 0;
            this.blessAttrs_ = Collections.emptyList();
            this.buffTime_ = 0;
            this.receiveState_ = Collections.emptyList();
            this.itemList_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            int i;
            for (i = 0; i < getBlessAttrsCount(); i++) {
                if (!getBlessAttrs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getItemListCount(); i++) {
                if (!getItemList(i).isInitialized()) {
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
                output.writeInt32(1, this.blessCount_);
            int i;
            for (i = 0; i < this.blessAttrs_.size(); i++)
                output.writeMessage(2, (MessageLite) this.blessAttrs_.get(i));
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(3, this.buffTime_);
            for (i = 0; i < this.receiveState_.size(); i++)
                output.writeInt32(4, ((Integer) this.receiveState_.get(i)).intValue());
            for (i = 0; i < this.itemList_.size(); i++)
                output.writeMessage(5, (MessageLite) this.itemList_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.blessCount_);
            for (int j = 0; j < this.blessAttrs_.size(); j++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.blessAttrs_.get(j));
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(3, this.buffTime_);
            int dataSize = 0;
            for (int k = 0; k < this.receiveState_.size(); k++)
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.receiveState_.get(k)).intValue());
            size += dataSize;
            size += 1 * getReceiveStateList().size();
            for (int i = 0; i < this.itemList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.itemList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MyBlessInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MyBlessInfo) PARSER.parseFrom(data);
        }

        public static MyBlessInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyBlessInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyBlessInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MyBlessInfo) PARSER.parseFrom(data);
        }

        public static MyBlessInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyBlessInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyBlessInfo parseFrom(InputStream input) throws IOException {
            return (MyBlessInfo) PARSER.parseFrom(input);
        }

        public static MyBlessInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyBlessInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MyBlessInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MyBlessInfo) PARSER.parseDelimitedFrom(input);
        }

        public static MyBlessInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyBlessInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MyBlessInfo parseFrom(CodedInputStream input) throws IOException {
            return (MyBlessInfo) PARSER.parseFrom(input);
        }

        public static MyBlessInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyBlessInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MyBlessInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBlessHandler.MyBlessInfoOrBuilder {
            private int bitField0_;
            private int blessCount_;
            private List<Common.AttributeBase> blessAttrs_;
            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> blessAttrsBuilder_;
            private int buffTime_;
            private List<Integer> receiveState_;
            private List<GuildBlessHandler.BlessItem> itemList_;
            private RepeatedFieldBuilder<GuildBlessHandler.BlessItem, GuildBlessHandler.BlessItem.Builder, GuildBlessHandler.BlessItemOrBuilder> itemListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_MyBlessInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_MyBlessInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.MyBlessInfo.class, Builder.class);
            }

            private Builder() {
                this.blessAttrs_ = Collections.emptyList();
                this.receiveState_ = Collections.emptyList();
                this.itemList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.blessAttrs_ = Collections.emptyList();
                this.receiveState_ = Collections.emptyList();
                this.itemList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.MyBlessInfo.alwaysUseFieldBuilders) {
                    getBlessAttrsFieldBuilder();
                    getItemListFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blessCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.blessAttrsBuilder_ == null) {
                    this.blessAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.blessAttrsBuilder_.clear();
                }
                this.buffTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.receiveState_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_MyBlessInfo_descriptor;
            }

            public GuildBlessHandler.MyBlessInfo getDefaultInstanceForType() {
                return GuildBlessHandler.MyBlessInfo.getDefaultInstance();
            }

            public GuildBlessHandler.MyBlessInfo build() {
                GuildBlessHandler.MyBlessInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBlessHandler.MyBlessInfo buildPartial() {
                GuildBlessHandler.MyBlessInfo result = new GuildBlessHandler.MyBlessInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.blessCount_ = this.blessCount_;
                if (this.blessAttrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.blessAttrs_ = Collections.unmodifiableList(this.blessAttrs_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.blessAttrs_ = this.blessAttrs_;
                } else {
                    result.blessAttrs_ = this.blessAttrsBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x2;
                result.buffTime_ = this.buffTime_;
                if ((this.bitField0_ & 0x8) == 8) {
                    this.receiveState_ = Collections.unmodifiableList(this.receiveState_);
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result.receiveState_ = this.receiveState_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.MyBlessInfo)
                    return mergeFrom((GuildBlessHandler.MyBlessInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBlessHandler.MyBlessInfo other) {
                if (other == GuildBlessHandler.MyBlessInfo.getDefaultInstance())
                    return this;
                if (other.hasBlessCount())
                    setBlessCount(other.getBlessCount());
                if (this.blessAttrsBuilder_ == null) {
                    if (!other.blessAttrs_.isEmpty()) {
                        if (this.blessAttrs_.isEmpty()) {
                            this.blessAttrs_ = other.blessAttrs_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureBlessAttrsIsMutable();
                            this.blessAttrs_.addAll(other.blessAttrs_);
                        }
                        onChanged();
                    }
                } else if (!other.blessAttrs_.isEmpty()) {
                    if (this.blessAttrsBuilder_.isEmpty()) {
                        this.blessAttrsBuilder_.dispose();
                        this.blessAttrsBuilder_ = null;
                        this.blessAttrs_ = other.blessAttrs_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.blessAttrsBuilder_ = GuildBlessHandler.MyBlessInfo.alwaysUseFieldBuilders ? getBlessAttrsFieldBuilder() : null;
                    } else {
                        this.blessAttrsBuilder_.addAllMessages(other.blessAttrs_);
                    }
                }
                if (other.hasBuffTime())
                    setBuffTime(other.getBuffTime());
                if (!other.receiveState_.isEmpty()) {
                    if (this.receiveState_.isEmpty()) {
                        this.receiveState_ = other.receiveState_;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        ensureReceiveStateIsMutable();
                        this.receiveState_.addAll(other.receiveState_);
                    }
                    onChanged();
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.itemListBuilder_ = GuildBlessHandler.MyBlessInfo.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getBlessAttrsCount(); i++) {
                    if (!getBlessAttrs(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getItemListCount(); i++) {
                    if (!getItemList(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.MyBlessInfo parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.MyBlessInfo) GuildBlessHandler.MyBlessInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.MyBlessInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlessCount() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlessCount() {
                return this.blessCount_;
            }

            public Builder setBlessCount(int value) {
                this.bitField0_ |= 0x1;
                this.blessCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlessCount() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blessCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureBlessAttrsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.blessAttrs_ = new ArrayList<>(this.blessAttrs_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<Common.AttributeBase> getBlessAttrsList() {
                if (this.blessAttrsBuilder_ == null)
                    return Collections.unmodifiableList(this.blessAttrs_);
                return this.blessAttrsBuilder_.getMessageList();
            }

            public int getBlessAttrsCount() {
                if (this.blessAttrsBuilder_ == null)
                    return this.blessAttrs_.size();
                return this.blessAttrsBuilder_.getCount();
            }

            public Common.AttributeBase getBlessAttrs(int index) {
                if (this.blessAttrsBuilder_ == null)
                    return this.blessAttrs_.get(index);
                return (Common.AttributeBase) this.blessAttrsBuilder_.getMessage(index);
            }

            public Builder setBlessAttrs(int index, Common.AttributeBase value) {
                if (this.blessAttrsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.set(index, value);
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setBlessAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.blessAttrsBuilder_ == null) {
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addBlessAttrs(Common.AttributeBase value) {
                if (this.blessAttrsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.add(value);
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addBlessAttrs(int index, Common.AttributeBase value) {
                if (this.blessAttrsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.add(index, value);
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addBlessAttrs(Common.AttributeBase.Builder builderForValue) {
                if (this.blessAttrsBuilder_ == null) {
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addBlessAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.blessAttrsBuilder_ == null) {
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllBlessAttrs(Iterable<? extends Common.AttributeBase> values) {
                if (this.blessAttrsBuilder_ == null) {
                    ensureBlessAttrsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.blessAttrs_);
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBlessAttrs() {
                if (this.blessAttrsBuilder_ == null) {
                    this.blessAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.clear();
                }
                return this;
            }

            public Builder removeBlessAttrs(int index) {
                if (this.blessAttrsBuilder_ == null) {
                    ensureBlessAttrsIsMutable();
                    this.blessAttrs_.remove(index);
                    onChanged();
                } else {
                    this.blessAttrsBuilder_.remove(index);
                }
                return this;
            }

            public Common.AttributeBase.Builder getBlessAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getBlessAttrsFieldBuilder().getBuilder(index);
            }

            public Common.AttributeBaseOrBuilder getBlessAttrsOrBuilder(int index) {
                if (this.blessAttrsBuilder_ == null)
                    return (Common.AttributeBaseOrBuilder) this.blessAttrs_.get(index);
                return (Common.AttributeBaseOrBuilder) this.blessAttrsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AttributeBaseOrBuilder> getBlessAttrsOrBuilderList() {
                if (this.blessAttrsBuilder_ != null)
                    return this.blessAttrsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.blessAttrs_);
            }

            public Common.AttributeBase.Builder addBlessAttrsBuilder() {
                return (Common.AttributeBase.Builder) getBlessAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }

            public Common.AttributeBase.Builder addBlessAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getBlessAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }

            public List<Common.AttributeBase.Builder> getBlessAttrsBuilderList() {
                return getBlessAttrsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getBlessAttrsFieldBuilder() {
                if (this.blessAttrsBuilder_ == null) {
                    this.blessAttrsBuilder_ = new RepeatedFieldBuilder(this.blessAttrs_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.blessAttrs_ = null;
                }
                return this.blessAttrsBuilder_;
            }

            public boolean hasBuffTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getBuffTime() {
                return this.buffTime_;
            }

            public Builder setBuffTime(int value) {
                this.bitField0_ |= 0x4;
                this.buffTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuffTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.buffTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureReceiveStateIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.receiveState_ = new ArrayList<>(this.receiveState_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<Integer> getReceiveStateList() {
                return Collections.unmodifiableList(this.receiveState_);
            }

            public int getReceiveStateCount() {
                return this.receiveState_.size();
            }

            public int getReceiveState(int index) {
                return ((Integer) this.receiveState_.get(index)).intValue();
            }

            public Builder setReceiveState(int index, int value) {
                ensureReceiveStateIsMutable();
                this.receiveState_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addReceiveState(int value) {
                ensureReceiveStateIsMutable();
                this.receiveState_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllReceiveState(Iterable<? extends Integer> values) {
                ensureReceiveStateIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.receiveState_);
                onChanged();
                return this;
            }

            public Builder clearReceiveState() {
                this.receiveState_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFF7;
                onChanged();
                return this;
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.itemList_ = new ArrayList<>(this.itemList_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<GuildBlessHandler.BlessItem> getItemListList() {
                if (this.itemListBuilder_ == null)
                    return Collections.unmodifiableList(this.itemList_);
                return this.itemListBuilder_.getMessageList();
            }

            public int getItemListCount() {
                if (this.itemListBuilder_ == null)
                    return this.itemList_.size();
                return this.itemListBuilder_.getCount();
            }

            public GuildBlessHandler.BlessItem getItemList(int index) {
                if (this.itemListBuilder_ == null)
                    return this.itemList_.get(index);
                return (GuildBlessHandler.BlessItem) this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, GuildBlessHandler.BlessItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setItemList(int index, GuildBlessHandler.BlessItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(GuildBlessHandler.BlessItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addItemList(int index, GuildBlessHandler.BlessItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addItemList(GuildBlessHandler.BlessItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, GuildBlessHandler.BlessItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends GuildBlessHandler.BlessItem> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }

            public GuildBlessHandler.BlessItem.Builder getItemListBuilder(int index) {
                return (GuildBlessHandler.BlessItem.Builder) getItemListFieldBuilder().getBuilder(index);
            }

            public GuildBlessHandler.BlessItemOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null)
                    return this.itemList_.get(index);
                return (GuildBlessHandler.BlessItemOrBuilder) this.itemListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildBlessHandler.BlessItemOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null)
                    return this.itemListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.itemList_);
            }

            public GuildBlessHandler.BlessItem.Builder addItemListBuilder() {
                return (GuildBlessHandler.BlessItem.Builder) getItemListFieldBuilder().addBuilder(GuildBlessHandler.BlessItem.getDefaultInstance());
            }

            public GuildBlessHandler.BlessItem.Builder addItemListBuilder(int index) {
                return (GuildBlessHandler.BlessItem.Builder) getItemListFieldBuilder().addBuilder(index, GuildBlessHandler.BlessItem.getDefaultInstance());
            }

            public List<GuildBlessHandler.BlessItem.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildBlessHandler.BlessItem, GuildBlessHandler.BlessItem.Builder, GuildBlessHandler.BlessItemOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilder(this.itemList_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }
        }
    }

    public static final class GetMyBlessInfoResponse extends GeneratedMessage implements GetMyBlessInfoResponseOrBuilder {
        private static final GetMyBlessInfoResponse defaultInstance = new GetMyBlessInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMyBlessInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMyBlessInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMyBlessInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMyBlessInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMyBlessInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildBlessHandler.MyBlessInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CBlessInfo_.toBuilder();
                            this.s2CBlessInfo_ = (GuildBlessHandler.MyBlessInfo) input.readMessage(GuildBlessHandler.MyBlessInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CBlessInfo_);
                                this.s2CBlessInfo_ = subBuilder.buildPartial();
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
            return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMyBlessInfoResponse.class, Builder.class);
        }

        public static Parser<GetMyBlessInfoResponse> PARSER = (Parser<GetMyBlessInfoResponse>) new AbstractParser<GetMyBlessInfoResponse>() {
            public GuildBlessHandler.GetMyBlessInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.GetMyBlessInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_BLESSINFO_FIELD_NUMBER = 3;
        private GuildBlessHandler.MyBlessInfo s2CBlessInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMyBlessInfoResponse> getParserForType() {
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


        public boolean hasS2CBlessInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public GuildBlessHandler.MyBlessInfo getS2CBlessInfo() {
            return this.s2CBlessInfo_;
        }


        public GuildBlessHandler.MyBlessInfoOrBuilder getS2CBlessInfoOrBuilder() {
            return this.s2CBlessInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CBlessInfo_ = GuildBlessHandler.MyBlessInfo.getDefaultInstance();
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
            if (hasS2CBlessInfo() && !getS2CBlessInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CBlessInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CBlessInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMyBlessInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(data);
        }


        public static GetMyBlessInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMyBlessInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(data);
        }


        public static GetMyBlessInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMyBlessInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(input);
        }


        public static GetMyBlessInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMyBlessInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMyBlessInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetMyBlessInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMyBlessInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMyBlessInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(input);
        }


        public static GetMyBlessInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMyBlessInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMyBlessInfoResponse prototype) {
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
                implements GuildBlessHandler.GetMyBlessInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private GuildBlessHandler.MyBlessInfo s2CBlessInfo_;


            private SingleFieldBuilder<GuildBlessHandler.MyBlessInfo, GuildBlessHandler.MyBlessInfo.Builder, GuildBlessHandler.MyBlessInfoOrBuilder> s2CBlessInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.GetMyBlessInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBlessInfo_ = GuildBlessHandler.MyBlessInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBlessInfo_ = GuildBlessHandler.MyBlessInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.GetMyBlessInfoResponse.alwaysUseFieldBuilders) {
                    getS2CBlessInfoFieldBuilder();
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
                if (this.s2CBlessInfoBuilder_ == null) {
                    this.s2CBlessInfo_ = GuildBlessHandler.MyBlessInfo.getDefaultInstance();
                } else {
                    this.s2CBlessInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_GetMyBlessInfoResponse_descriptor;
            }


            public GuildBlessHandler.GetMyBlessInfoResponse getDefaultInstanceForType() {
                return GuildBlessHandler.GetMyBlessInfoResponse.getDefaultInstance();
            }


            public GuildBlessHandler.GetMyBlessInfoResponse build() {
                GuildBlessHandler.GetMyBlessInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.GetMyBlessInfoResponse buildPartial() {
                GuildBlessHandler.GetMyBlessInfoResponse result = new GuildBlessHandler.GetMyBlessInfoResponse(this);
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
                if (this.s2CBlessInfoBuilder_ == null) {
                    result.s2CBlessInfo_ = this.s2CBlessInfo_;
                } else {
                    result.s2CBlessInfo_ = (GuildBlessHandler.MyBlessInfo) this.s2CBlessInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.GetMyBlessInfoResponse) {
                    return mergeFrom((GuildBlessHandler.GetMyBlessInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.GetMyBlessInfoResponse other) {
                if (other == GuildBlessHandler.GetMyBlessInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CBlessInfo()) {
                    mergeS2CBlessInfo(other.getS2CBlessInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CBlessInfo() && !getS2CBlessInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.GetMyBlessInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.GetMyBlessInfoResponse) GuildBlessHandler.GetMyBlessInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.GetMyBlessInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBlessHandler.GetMyBlessInfoResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CBlessInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public GuildBlessHandler.MyBlessInfo getS2CBlessInfo() {
                if (this.s2CBlessInfoBuilder_ == null) {
                    return this.s2CBlessInfo_;
                }
                return (GuildBlessHandler.MyBlessInfo) this.s2CBlessInfoBuilder_.getMessage();
            }


            public Builder setS2CBlessInfo(GuildBlessHandler.MyBlessInfo value) {
                if (this.s2CBlessInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CBlessInfo_ = value;
                    onChanged();
                } else {
                    this.s2CBlessInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CBlessInfo(GuildBlessHandler.MyBlessInfo.Builder builderForValue) {
                if (this.s2CBlessInfoBuilder_ == null) {
                    this.s2CBlessInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CBlessInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CBlessInfo(GuildBlessHandler.MyBlessInfo value) {
                if (this.s2CBlessInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CBlessInfo_ != GuildBlessHandler.MyBlessInfo.getDefaultInstance()) {
                        this.s2CBlessInfo_ = GuildBlessHandler.MyBlessInfo.newBuilder(this.s2CBlessInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CBlessInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CBlessInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CBlessInfo() {
                if (this.s2CBlessInfoBuilder_ == null) {
                    this.s2CBlessInfo_ = GuildBlessHandler.MyBlessInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CBlessInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public GuildBlessHandler.MyBlessInfo.Builder getS2CBlessInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildBlessHandler.MyBlessInfo.Builder) getS2CBlessInfoFieldBuilder().getBuilder();
            }


            public GuildBlessHandler.MyBlessInfoOrBuilder getS2CBlessInfoOrBuilder() {
                if (this.s2CBlessInfoBuilder_ != null) {
                    return (GuildBlessHandler.MyBlessInfoOrBuilder) this.s2CBlessInfoBuilder_.getMessageOrBuilder();
                }
                return this.s2CBlessInfo_;
            }


            private SingleFieldBuilder<GuildBlessHandler.MyBlessInfo, GuildBlessHandler.MyBlessInfo.Builder, GuildBlessHandler.MyBlessInfoOrBuilder> getS2CBlessInfoFieldBuilder() {
                if (this.s2CBlessInfoBuilder_ == null) {
                    this.s2CBlessInfoBuilder_ = new SingleFieldBuilder(getS2CBlessInfo(), getParentForChildren(), isClean());
                    this.s2CBlessInfo_ = null;
                }
                return this.s2CBlessInfoBuilder_;
            }
        }
    }


    public static final class BlessResult
            extends GeneratedMessage
            implements BlessResultOrBuilder {
        private static final BlessResult defaultInstance = new BlessResult(true);
        private final UnknownFieldSet unknownFields;

        private BlessResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BlessResult(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BlessResult getDefaultInstance() {
            return defaultInstance;
        }

        public BlessResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlessResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blessCount_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.blessValue_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.id_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.finishNum_ = input.readInt32();
                            break;
                        case 40:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.finishState_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.finishState_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 42:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x10) != 16 && input.getBytesUntilLimit() > 0) {
                                this.finishState_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.finishState_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.finishState_ = Collections.unmodifiableList(this.finishState_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessResult_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessResult_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessResult.class, Builder.class);
        }

        public static Parser<BlessResult> PARSER = (Parser<BlessResult>) new AbstractParser<BlessResult>() {
            public GuildBlessHandler.BlessResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.BlessResult(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLESSCOUNT_FIELD_NUMBER = 1;
        private int blessCount_;
        public static final int BLESSVALUE_FIELD_NUMBER = 2;
        private int blessValue_;
        public static final int ID_FIELD_NUMBER = 3;
        private int id_;
        public static final int FINISHNUM_FIELD_NUMBER = 4;
        private int finishNum_;
        public static final int FINISHSTATE_FIELD_NUMBER = 5;
        private List<Integer> finishState_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BlessResult> getParserForType() {
            return PARSER;
        }

        public boolean hasBlessCount() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlessCount() {
            return this.blessCount_;
        }

        public boolean hasBlessValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getBlessValue() {
            return this.blessValue_;
        }


        public boolean hasId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getId() {
            return this.id_;
        }


        public boolean hasFinishNum() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getFinishNum() {
            return this.finishNum_;
        }


        public List<Integer> getFinishStateList() {
            return this.finishState_;
        }


        public int getFinishStateCount() {
            return this.finishState_.size();
        }


        public int getFinishState(int index) {
            return ((Integer) this.finishState_.get(index)).intValue();
        }


        private void initFields() {
            this.blessCount_ = 0;
            this.blessValue_ = 0;
            this.id_ = 0;
            this.finishNum_ = 0;
            this.finishState_ = Collections.emptyList();
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
                output.writeInt32(1, this.blessCount_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.blessValue_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.id_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.finishNum_);
            }
            for (int i = 0; i < this.finishState_.size(); i++) {
                output.writeInt32(5, ((Integer) this.finishState_.get(i)).intValue());
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
                size += CodedOutputStream.computeInt32Size(1, this.blessCount_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.blessValue_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.id_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.finishNum_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.finishState_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.finishState_.get(i)).intValue());
            }
            size += dataSize;
            size += 1 * getFinishStateList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BlessResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BlessResult) PARSER.parseFrom(data);
        }


        public static BlessResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BlessResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BlessResult) PARSER.parseFrom(data);
        }


        public static BlessResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BlessResult parseFrom(InputStream input) throws IOException {
            return (BlessResult) PARSER.parseFrom(input);
        }


        public static BlessResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BlessResult parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessResult) PARSER.parseDelimitedFrom(input);
        }


        public static BlessResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessResult) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BlessResult parseFrom(CodedInputStream input) throws IOException {
            return (BlessResult) PARSER.parseFrom(input);
        }


        public static BlessResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BlessResult prototype) {
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
                implements GuildBlessHandler.BlessResultOrBuilder {
            private int bitField0_;


            private int blessCount_;


            private int blessValue_;


            private int id_;


            private int finishNum_;


            private List<Integer> finishState_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessResult_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.BlessResult.class, Builder.class);
            }


            private Builder() {
                this.finishState_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.finishState_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.BlessResult.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.blessCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.blessValue_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.finishNum_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.finishState_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessResult_descriptor;
            }


            public GuildBlessHandler.BlessResult getDefaultInstanceForType() {
                return GuildBlessHandler.BlessResult.getDefaultInstance();
            }


            public GuildBlessHandler.BlessResult build() {
                GuildBlessHandler.BlessResult result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.BlessResult buildPartial() {
                GuildBlessHandler.BlessResult result = new GuildBlessHandler.BlessResult(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.blessCount_ = this.blessCount_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.blessValue_ = this.blessValue_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.finishNum_ = this.finishNum_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.finishState_ = Collections.unmodifiableList(this.finishState_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.finishState_ = this.finishState_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.BlessResult) {
                    return mergeFrom((GuildBlessHandler.BlessResult) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.BlessResult other) {
                if (other == GuildBlessHandler.BlessResult.getDefaultInstance()) {
                    return this;
                }
                if (other.hasBlessCount()) {
                    setBlessCount(other.getBlessCount());
                }
                if (other.hasBlessValue()) {
                    setBlessValue(other.getBlessValue());
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasFinishNum()) {
                    setFinishNum(other.getFinishNum());
                }
                if (!other.finishState_.isEmpty()) {
                    if (this.finishState_.isEmpty()) {
                        this.finishState_ = other.finishState_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        ensureFinishStateIsMutable();
                        this.finishState_.addAll(other.finishState_);
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
                GuildBlessHandler.BlessResult parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.BlessResult) GuildBlessHandler.BlessResult.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.BlessResult) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasBlessCount() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getBlessCount() {
                return this.blessCount_;
            }


            public Builder setBlessCount(int value) {
                this.bitField0_ |= 0x1;
                this.blessCount_ = value;
                onChanged();
                return this;
            }


            public Builder clearBlessCount() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blessCount_ = 0;
                onChanged();
                return this;
            }


            public boolean hasBlessValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getBlessValue() {
                return this.blessValue_;
            }


            public Builder setBlessValue(int value) {
                this.bitField0_ |= 0x2;
                this.blessValue_ = value;
                onChanged();
                return this;
            }


            public Builder clearBlessValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.blessValue_ = 0;
                onChanged();
                return this;
            }


            public boolean hasId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getId() {
                return this.id_;
            }


            public Builder setId(int value) {
                this.bitField0_ |= 0x4;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.id_ = 0;
                onChanged();
                return this;
            }


            public boolean hasFinishNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getFinishNum() {
                return this.finishNum_;
            }


            public Builder setFinishNum(int value) {
                this.bitField0_ |= 0x8;
                this.finishNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearFinishNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.finishNum_ = 0;
                onChanged();
                return this;
            }


            private void ensureFinishStateIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.finishState_ = new ArrayList<>(this.finishState_);
                    this.bitField0_ |= 0x10;
                }
            }


            public List<Integer> getFinishStateList() {
                return Collections.unmodifiableList(this.finishState_);
            }


            public int getFinishStateCount() {
                return this.finishState_.size();
            }


            public int getFinishState(int index) {
                return ((Integer) this.finishState_.get(index)).intValue();
            }


            public Builder setFinishState(int index, int value) {
                ensureFinishStateIsMutable();
                this.finishState_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addFinishState(int value) {
                ensureFinishStateIsMutable();
                this.finishState_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addAllFinishState(Iterable<? extends Integer> values) {
                ensureFinishStateIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.finishState_);
                onChanged();
                return this;
            }


            public Builder clearFinishState() {
                this.finishState_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                onChanged();
                return this;
            }
        }
    }


    public static final class BlessActionResponse
            extends GeneratedMessage
            implements BlessActionResponseOrBuilder {
        private static final BlessActionResponse defaultInstance = new BlessActionResponse(true);
        private final UnknownFieldSet unknownFields;

        private BlessActionResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BlessActionResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BlessActionResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BlessActionResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlessActionResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildBlessHandler.BlessResult.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CResult_.toBuilder();
                            this.s2CResult_ = (GuildBlessHandler.BlessResult) input.readMessage(GuildBlessHandler.BlessResult.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CResult_);
                                this.s2CResult_ = subBuilder.buildPartial();
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
            return GuildBlessHandler.internal_static_pomelo_area_BlessActionResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessActionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessActionResponse.class, Builder.class);
        }

        public static Parser<BlessActionResponse> PARSER = (Parser<BlessActionResponse>) new AbstractParser<BlessActionResponse>() {
            public GuildBlessHandler.BlessActionResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.BlessActionResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_RESULT_FIELD_NUMBER = 3;
        private GuildBlessHandler.BlessResult s2CResult_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BlessActionResponse> getParserForType() {
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

        public boolean hasS2CResult() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public GuildBlessHandler.BlessResult getS2CResult() {
            return this.s2CResult_;
        }

        public GuildBlessHandler.BlessResultOrBuilder getS2CResultOrBuilder() {
            return this.s2CResult_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CResult_ = GuildBlessHandler.BlessResult.getDefaultInstance();
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
                output.writeMessage(3, (MessageLite) this.s2CResult_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CResult_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BlessActionResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BlessActionResponse) PARSER.parseFrom(data);
        }

        public static BlessActionResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessActionResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessActionResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BlessActionResponse) PARSER.parseFrom(data);
        }

        public static BlessActionResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessActionResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessActionResponse parseFrom(InputStream input) throws IOException {
            return (BlessActionResponse) PARSER.parseFrom(input);
        }

        public static BlessActionResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessActionResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BlessActionResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessActionResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BlessActionResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessActionResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BlessActionResponse parseFrom(CodedInputStream input) throws IOException {
            return (BlessActionResponse) PARSER.parseFrom(input);
        }

        public static BlessActionResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessActionResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BlessActionResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBlessHandler.BlessActionResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private GuildBlessHandler.BlessResult s2CResult_;
            private SingleFieldBuilder<GuildBlessHandler.BlessResult, GuildBlessHandler.BlessResult.Builder, GuildBlessHandler.BlessResultOrBuilder> s2CResultBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessActionResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessActionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.BlessActionResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CResult_ = GuildBlessHandler.BlessResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CResult_ = GuildBlessHandler.BlessResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.BlessActionResponse.alwaysUseFieldBuilders)
                    getS2CResultFieldBuilder();
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
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResult_ = GuildBlessHandler.BlessResult.getDefaultInstance();
                } else {
                    this.s2CResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessActionResponse_descriptor;
            }

            public GuildBlessHandler.BlessActionResponse getDefaultInstanceForType() {
                return GuildBlessHandler.BlessActionResponse.getDefaultInstance();
            }

            public GuildBlessHandler.BlessActionResponse build() {
                GuildBlessHandler.BlessActionResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBlessHandler.BlessActionResponse buildPartial() {
                GuildBlessHandler.BlessActionResponse result = new GuildBlessHandler.BlessActionResponse(this);
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
                if (this.s2CResultBuilder_ == null) {
                    result.s2CResult_ = this.s2CResult_;
                } else {
                    result.s2CResult_ = (GuildBlessHandler.BlessResult) this.s2CResultBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.BlessActionResponse)
                    return mergeFrom((GuildBlessHandler.BlessActionResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBlessHandler.BlessActionResponse other) {
                if (other == GuildBlessHandler.BlessActionResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CResult())
                    mergeS2CResult(other.getS2CResult());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.BlessActionResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.BlessActionResponse) GuildBlessHandler.BlessActionResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.BlessActionResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBlessHandler.BlessActionResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CResult() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public GuildBlessHandler.BlessResult getS2CResult() {
                if (this.s2CResultBuilder_ == null)
                    return this.s2CResult_;
                return (GuildBlessHandler.BlessResult) this.s2CResultBuilder_.getMessage();
            }

            public Builder setS2CResult(GuildBlessHandler.BlessResult value) {
                if (this.s2CResultBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CResult_ = value;
                    onChanged();
                } else {
                    this.s2CResultBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CResult(GuildBlessHandler.BlessResult.Builder builderForValue) {
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CResultBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CResult(GuildBlessHandler.BlessResult value) {
                if (this.s2CResultBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CResult_ != GuildBlessHandler.BlessResult.getDefaultInstance()) {
                        this.s2CResult_ = GuildBlessHandler.BlessResult.newBuilder(this.s2CResult_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CResult_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CResultBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CResult() {
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResult_ = GuildBlessHandler.BlessResult.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public GuildBlessHandler.BlessResult.Builder getS2CResultBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildBlessHandler.BlessResult.Builder) getS2CResultFieldBuilder().getBuilder();
            }

            public GuildBlessHandler.BlessResultOrBuilder getS2CResultOrBuilder() {
                if (this.s2CResultBuilder_ != null)
                    return (GuildBlessHandler.BlessResultOrBuilder) this.s2CResultBuilder_.getMessageOrBuilder();
                return this.s2CResult_;
            }

            private SingleFieldBuilder<GuildBlessHandler.BlessResult, GuildBlessHandler.BlessResult.Builder, GuildBlessHandler.BlessResultOrBuilder> getS2CResultFieldBuilder() {
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResultBuilder_ = new SingleFieldBuilder(getS2CResult(), getParentForChildren(), isClean());
                    this.s2CResult_ = null;
                }
                return this.s2CResultBuilder_;
            }
        }
    }

    public static final class ReceiveResult extends GeneratedMessage implements ReceiveResultOrBuilder {
        private static final ReceiveResult defaultInstance = new ReceiveResult(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveResult(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveResult getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.receiveState_ = input.readInt32();
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
            return GuildBlessHandler.internal_static_pomelo_area_ReceiveResult_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_ReceiveResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveResult.class, Builder.class);
        }

        public static Parser<ReceiveResult> PARSER = (Parser<ReceiveResult>) new AbstractParser<ReceiveResult>() {
            public GuildBlessHandler.ReceiveResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.ReceiveResult(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RECEIVESTATE_FIELD_NUMBER = 1;
        private int receiveState_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReceiveResult> getParserForType() {
            return PARSER;
        }

        public boolean hasReceiveState() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getReceiveState() {
            return this.receiveState_;
        }

        private void initFields() {
            this.receiveState_ = 0;
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
                output.writeInt32(1, this.receiveState_);
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
                size += CodedOutputStream.computeInt32Size(1, this.receiveState_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ReceiveResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveResult) PARSER.parseFrom(data);
        }


        public static ReceiveResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveResult) PARSER.parseFrom(data);
        }


        public static ReceiveResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveResult parseFrom(InputStream input) throws IOException {
            return (ReceiveResult) PARSER.parseFrom(input);
        }


        public static ReceiveResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ReceiveResult parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveResult) PARSER.parseDelimitedFrom(input);
        }


        public static ReceiveResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveResult) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ReceiveResult parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveResult) PARSER.parseFrom(input);
        }


        public static ReceiveResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ReceiveResult prototype) {
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
                implements GuildBlessHandler.ReceiveResultOrBuilder {
            private int bitField0_;


            private int receiveState_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveResult_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.ReceiveResult.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.ReceiveResult.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.receiveState_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveResult_descriptor;
            }


            public GuildBlessHandler.ReceiveResult getDefaultInstanceForType() {
                return GuildBlessHandler.ReceiveResult.getDefaultInstance();
            }


            public GuildBlessHandler.ReceiveResult build() {
                GuildBlessHandler.ReceiveResult result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.ReceiveResult buildPartial() {
                GuildBlessHandler.ReceiveResult result = new GuildBlessHandler.ReceiveResult(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.receiveState_ = this.receiveState_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.ReceiveResult) {
                    return mergeFrom((GuildBlessHandler.ReceiveResult) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.ReceiveResult other) {
                if (other == GuildBlessHandler.ReceiveResult.getDefaultInstance()) {
                    return this;
                }
                if (other.hasReceiveState()) {
                    setReceiveState(other.getReceiveState());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBlessHandler.ReceiveResult parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.ReceiveResult) GuildBlessHandler.ReceiveResult.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.ReceiveResult) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasReceiveState() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getReceiveState() {
                return this.receiveState_;
            }


            public Builder setReceiveState(int value) {
                this.bitField0_ |= 0x1;
                this.receiveState_ = value;
                onChanged();
                return this;
            }


            public Builder clearReceiveState() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.receiveState_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ReceiveBlessGiftResponse
            extends GeneratedMessage
            implements ReceiveBlessGiftResponseOrBuilder {
        private static final ReceiveBlessGiftResponse defaultInstance = new ReceiveBlessGiftResponse(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveBlessGiftResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveBlessGiftResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveBlessGiftResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveBlessGiftResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveBlessGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildBlessHandler.ReceiveResult.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CResult_.toBuilder();
                            this.s2CResult_ = (GuildBlessHandler.ReceiveResult) input.readMessage(GuildBlessHandler.ReceiveResult.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CResult_);
                                this.s2CResult_ = subBuilder.buildPartial();
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
            return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveBlessGiftResponse.class, Builder.class);
        }

        public static Parser<ReceiveBlessGiftResponse> PARSER = (Parser<ReceiveBlessGiftResponse>) new AbstractParser<ReceiveBlessGiftResponse>() {
            public GuildBlessHandler.ReceiveBlessGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.ReceiveBlessGiftResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_RESULT_FIELD_NUMBER = 3;
        private GuildBlessHandler.ReceiveResult s2CResult_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReceiveBlessGiftResponse> getParserForType() {
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


        public boolean hasS2CResult() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public GuildBlessHandler.ReceiveResult getS2CResult() {
            return this.s2CResult_;
        }


        public GuildBlessHandler.ReceiveResultOrBuilder getS2CResultOrBuilder() {
            return this.s2CResult_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CResult_ = GuildBlessHandler.ReceiveResult.getDefaultInstance();
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
                output.writeMessage(3, (MessageLite) this.s2CResult_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CResult_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ReceiveBlessGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(data);
        }


        public static ReceiveBlessGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveBlessGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(data);
        }


        public static ReceiveBlessGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveBlessGiftResponse parseFrom(InputStream input) throws IOException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(input);
        }


        public static ReceiveBlessGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ReceiveBlessGiftResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveBlessGiftResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ReceiveBlessGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveBlessGiftResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ReceiveBlessGiftResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(input);
        }


        public static ReceiveBlessGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveBlessGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ReceiveBlessGiftResponse prototype) {
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
                implements GuildBlessHandler.ReceiveBlessGiftResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private GuildBlessHandler.ReceiveResult s2CResult_;


            private SingleFieldBuilder<GuildBlessHandler.ReceiveResult, GuildBlessHandler.ReceiveResult.Builder, GuildBlessHandler.ReceiveResultOrBuilder> s2CResultBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.ReceiveBlessGiftResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CResult_ = GuildBlessHandler.ReceiveResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CResult_ = GuildBlessHandler.ReceiveResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.ReceiveBlessGiftResponse.alwaysUseFieldBuilders) {
                    getS2CResultFieldBuilder();
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
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResult_ = GuildBlessHandler.ReceiveResult.getDefaultInstance();
                } else {
                    this.s2CResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_ReceiveBlessGiftResponse_descriptor;
            }


            public GuildBlessHandler.ReceiveBlessGiftResponse getDefaultInstanceForType() {
                return GuildBlessHandler.ReceiveBlessGiftResponse.getDefaultInstance();
            }


            public GuildBlessHandler.ReceiveBlessGiftResponse build() {
                GuildBlessHandler.ReceiveBlessGiftResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.ReceiveBlessGiftResponse buildPartial() {
                GuildBlessHandler.ReceiveBlessGiftResponse result = new GuildBlessHandler.ReceiveBlessGiftResponse(this);
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
                if (this.s2CResultBuilder_ == null) {
                    result.s2CResult_ = this.s2CResult_;
                } else {
                    result.s2CResult_ = (GuildBlessHandler.ReceiveResult) this.s2CResultBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.ReceiveBlessGiftResponse) {
                    return mergeFrom((GuildBlessHandler.ReceiveBlessGiftResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.ReceiveBlessGiftResponse other) {
                if (other == GuildBlessHandler.ReceiveBlessGiftResponse.getDefaultInstance()) {
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
                if (other.hasS2CResult()) {
                    mergeS2CResult(other.getS2CResult());
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
                GuildBlessHandler.ReceiveBlessGiftResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.ReceiveBlessGiftResponse) GuildBlessHandler.ReceiveBlessGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.ReceiveBlessGiftResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBlessHandler.ReceiveBlessGiftResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CResult() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public GuildBlessHandler.ReceiveResult getS2CResult() {
                if (this.s2CResultBuilder_ == null) {
                    return this.s2CResult_;
                }
                return (GuildBlessHandler.ReceiveResult) this.s2CResultBuilder_.getMessage();
            }


            public Builder setS2CResult(GuildBlessHandler.ReceiveResult value) {
                if (this.s2CResultBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CResult_ = value;
                    onChanged();
                } else {
                    this.s2CResultBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CResult(GuildBlessHandler.ReceiveResult.Builder builderForValue) {
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CResultBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CResult(GuildBlessHandler.ReceiveResult value) {
                if (this.s2CResultBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CResult_ != GuildBlessHandler.ReceiveResult.getDefaultInstance()) {
                        this.s2CResult_ = GuildBlessHandler.ReceiveResult.newBuilder(this.s2CResult_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CResult_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CResultBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CResult() {
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResult_ = GuildBlessHandler.ReceiveResult.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public GuildBlessHandler.ReceiveResult.Builder getS2CResultBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildBlessHandler.ReceiveResult.Builder) getS2CResultFieldBuilder().getBuilder();
            }


            public GuildBlessHandler.ReceiveResultOrBuilder getS2CResultOrBuilder() {
                if (this.s2CResultBuilder_ != null) {
                    return (GuildBlessHandler.ReceiveResultOrBuilder) this.s2CResultBuilder_.getMessageOrBuilder();
                }
                return this.s2CResult_;
            }


            private SingleFieldBuilder<GuildBlessHandler.ReceiveResult, GuildBlessHandler.ReceiveResult.Builder, GuildBlessHandler.ReceiveResultOrBuilder> getS2CResultFieldBuilder() {
                if (this.s2CResultBuilder_ == null) {
                    this.s2CResultBuilder_ = new SingleFieldBuilder(getS2CResult(), getParentForChildren(), isClean());
                    this.s2CResult_ = null;
                }
                return this.s2CResultBuilder_;
            }
        }
    }


    public static final class UpgradeBlessResponse
            extends GeneratedMessage
            implements UpgradeBlessResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private UpgradeBlessResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private UpgradeBlessResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static UpgradeBlessResponse getDefaultInstance() {
            return defaultInstance;
        }


        public UpgradeBlessResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private UpgradeBlessResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CLevel_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CFund_ = input.readInt32();
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
            return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeBlessResponse.class, Builder.class);
        }


        public static Parser<UpgradeBlessResponse> PARSER = (Parser<UpgradeBlessResponse>) new AbstractParser<UpgradeBlessResponse>() {
            public GuildBlessHandler.UpgradeBlessResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.UpgradeBlessResponse(input, extensionRegistry);
            }
        };


        private int bitField0_;

        public static final int S2C_CODE_FIELD_NUMBER = 1;

        private int s2CCode_;

        public static final int S2C_MSG_FIELD_NUMBER = 2;

        private Object s2CMsg_;

        public static final int S2C_LEVEL_FIELD_NUMBER = 3;

        private int s2CLevel_;

        public static final int S2C_FUND_FIELD_NUMBER = 4;

        private int s2CFund_;

        private byte memoizedIsInitialized;

        private int memoizedSerializedSize;

        private static final long serialVersionUID = 0L;


        public Parser<UpgradeBlessResponse> getParserForType() {
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


        private static final UpgradeBlessResponse defaultInstance = new UpgradeBlessResponse(true);

        public ByteString getS2CMsgBytes() {
            Object ref = this.s2CMsg_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CMsg_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasS2CLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CLevel() {
            return this.s2CLevel_;
        }

        public boolean hasS2CFund() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CFund() {
            return this.s2CFund_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLevel_ = 0;
            this.s2CFund_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CLevel_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CFund_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CLevel_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CFund_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static UpgradeBlessResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeBlessResponse) PARSER.parseFrom(data);
        }

        public static UpgradeBlessResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeBlessResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeBlessResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeBlessResponse) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }


        public static UpgradeBlessResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeBlessResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeBlessResponse parseFrom(InputStream input) throws IOException {
            return (UpgradeBlessResponse) PARSER.parseFrom(input);
        }


        public static UpgradeBlessResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeBlessResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpgradeBlessResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeBlessResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UpgradeBlessResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeBlessResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpgradeBlessResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeBlessResponse) PARSER.parseFrom(input);
        }


        public static UpgradeBlessResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeBlessResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpgradeBlessResponse prototype) {
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
                implements GuildBlessHandler.UpgradeBlessResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2CLevel_;


            private int s2CFund_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.UpgradeBlessResponse.class, Builder.class);
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
                if (GuildBlessHandler.UpgradeBlessResponse.alwaysUseFieldBuilders) ;
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
                this.s2CLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CFund_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_UpgradeBlessResponse_descriptor;
            }


            public GuildBlessHandler.UpgradeBlessResponse getDefaultInstanceForType() {
                return GuildBlessHandler.UpgradeBlessResponse.getDefaultInstance();
            }


            public GuildBlessHandler.UpgradeBlessResponse build() {
                GuildBlessHandler.UpgradeBlessResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBlessHandler.UpgradeBlessResponse buildPartial() {
                GuildBlessHandler.UpgradeBlessResponse result = new GuildBlessHandler.UpgradeBlessResponse(this);
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
                result.s2CLevel_ = this.s2CLevel_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CFund_ = this.s2CFund_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.UpgradeBlessResponse) {
                    return mergeFrom((GuildBlessHandler.UpgradeBlessResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBlessHandler.UpgradeBlessResponse other) {
                if (other == GuildBlessHandler.UpgradeBlessResponse.getDefaultInstance()) {
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
                if (other.hasS2CLevel()) {
                    setS2CLevel(other.getS2CLevel());
                }
                if (other.hasS2CFund()) {
                    setS2CFund(other.getS2CFund());
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
                GuildBlessHandler.UpgradeBlessResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.UpgradeBlessResponse) GuildBlessHandler.UpgradeBlessResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.UpgradeBlessResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBlessHandler.UpgradeBlessResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CLevel() {
                return this.s2CLevel_;
            }


            public Builder setS2CLevel(int value) {
                this.bitField0_ |= 0x4;
                this.s2CLevel_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CLevel_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CFund() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CFund() {
                return this.s2CFund_;
            }


            public Builder setS2CFund(int value) {
                this.bitField0_ |= 0x8;
                this.s2CFund_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CFund() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CFund_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BlessRefreshPush
            extends GeneratedMessage
            implements BlessRefreshPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private BlessRefreshPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private BlessRefreshPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static BlessRefreshPush getDefaultInstance() {
            return defaultInstance;
        }


        public BlessRefreshPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private BlessRefreshPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    int length, limit, tag = input.readTag();
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
                            this.type_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.blessValue_ = input.readInt32();
                            break;
                        case 40:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.finishState_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.finishState_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 42:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x10) != 16 && input.getBytesUntilLimit() > 0) {
                                this.finishState_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.finishState_.add(Integer.valueOf(input.readInt32()));
                            }
                            input.popLimit(limit);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.finishState_ = Collections.unmodifiableList(this.finishState_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }


        public static final Descriptors.Descriptor getDescriptor() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessRefreshPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBlessHandler.internal_static_pomelo_area_BlessRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessRefreshPush.class, Builder.class);
        }


        public static Parser<BlessRefreshPush> PARSER = (Parser<BlessRefreshPush>) new AbstractParser<BlessRefreshPush>() {
            public GuildBlessHandler.BlessRefreshPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBlessHandler.BlessRefreshPush(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_MSG_FIELD_NUMBER = 2;


        private Object s2CMsg_;


        public static final int TYPE_FIELD_NUMBER = 3;


        private int type_;


        public static final int BLESSVALUE_FIELD_NUMBER = 4;


        private int blessValue_;


        public static final int FINISHSTATE_FIELD_NUMBER = 5;


        private List<Integer> finishState_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<BlessRefreshPush> getParserForType() {
            return PARSER;
        }


        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        private static final BlessRefreshPush defaultInstance = new BlessRefreshPush(true);

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

        public boolean hasType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasBlessValue() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getBlessValue() {
            return this.blessValue_;
        }

        public List<Integer> getFinishStateList() {
            return this.finishState_;
        }

        public int getFinishStateCount() {
            return this.finishState_.size();
        }

        public int getFinishState(int index) {
            return ((Integer) this.finishState_.get(index)).intValue();
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.type_ = 0;
            this.blessValue_ = 0;
            this.finishState_ = Collections.emptyList();
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.type_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.blessValue_);
            for (int i = 0; i < this.finishState_.size(); i++)
                output.writeInt32(5, ((Integer) this.finishState_.get(i)).intValue());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.type_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.blessValue_);
            int dataSize = 0;
            for (int i = 0; i < this.finishState_.size(); i++)
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.finishState_.get(i)).intValue());
            size += dataSize;
            size += 1 * getFinishStateList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BlessRefreshPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BlessRefreshPush) PARSER.parseFrom(data);
        }

        public static BlessRefreshPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessRefreshPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessRefreshPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BlessRefreshPush) PARSER.parseFrom(data);
        }

        public static BlessRefreshPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BlessRefreshPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessRefreshPush parseFrom(InputStream input) throws IOException {
            return (BlessRefreshPush) PARSER.parseFrom(input);
        }

        public static BlessRefreshPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessRefreshPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BlessRefreshPush parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessRefreshPush) PARSER.parseDelimitedFrom(input);
        }

        public static BlessRefreshPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessRefreshPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BlessRefreshPush parseFrom(CodedInputStream input) throws IOException {
            return (BlessRefreshPush) PARSER.parseFrom(input);
        }

        public static BlessRefreshPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessRefreshPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BlessRefreshPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBlessHandler.BlessRefreshPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int type_;
            private int blessValue_;
            private List<Integer> finishState_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessRefreshPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBlessHandler.BlessRefreshPush.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.finishState_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.finishState_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBlessHandler.BlessRefreshPush.alwaysUseFieldBuilders) ;
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
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.blessValue_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.finishState_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBlessHandler.internal_static_pomelo_area_BlessRefreshPush_descriptor;
            }

            public GuildBlessHandler.BlessRefreshPush getDefaultInstanceForType() {
                return GuildBlessHandler.BlessRefreshPush.getDefaultInstance();
            }

            public GuildBlessHandler.BlessRefreshPush build() {
                GuildBlessHandler.BlessRefreshPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBlessHandler.BlessRefreshPush buildPartial() {
                GuildBlessHandler.BlessRefreshPush result = new GuildBlessHandler.BlessRefreshPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.blessValue_ = this.blessValue_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.finishState_ = Collections.unmodifiableList(this.finishState_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.finishState_ = this.finishState_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBlessHandler.BlessRefreshPush)
                    return mergeFrom((GuildBlessHandler.BlessRefreshPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBlessHandler.BlessRefreshPush other) {
                if (other == GuildBlessHandler.BlessRefreshPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasType()) setType(other.getType());
                if (other.hasBlessValue()) setBlessValue(other.getBlessValue());
                if (!other.finishState_.isEmpty()) {
                    if (this.finishState_.isEmpty()) {
                        this.finishState_ = other.finishState_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        ensureFinishStateIsMutable();
                        this.finishState_.addAll(other.finishState_);
                    }
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
                GuildBlessHandler.BlessRefreshPush parsedMessage = null;
                try {
                    parsedMessage = (GuildBlessHandler.BlessRefreshPush) GuildBlessHandler.BlessRefreshPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBlessHandler.BlessRefreshPush) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBlessHandler.BlessRefreshPush.getDefaultInstance().getS2CMsg();
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

            public boolean hasType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x4;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasBlessValue() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getBlessValue() {
                return this.blessValue_;
            }

            public Builder setBlessValue(int value) {
                this.bitField0_ |= 0x8;
                this.blessValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlessValue() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.blessValue_ = 0;
                onChanged();
                return this;
            }

            private void ensureFinishStateIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.finishState_ = new ArrayList<>(this.finishState_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<Integer> getFinishStateList() {
                return Collections.unmodifiableList(this.finishState_);
            }

            public int getFinishStateCount() {
                return this.finishState_.size();
            }

            public int getFinishState(int index) {
                return ((Integer) this.finishState_.get(index)).intValue();
            }

            public Builder setFinishState(int index, int value) {
                ensureFinishStateIsMutable();
                this.finishState_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addFinishState(int value) {
                ensureFinishStateIsMutable();
                this.finishState_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllFinishState(Iterable<? extends Integer> values) {
                ensureFinishStateIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.finishState_);
                onChanged();
                return this;
            }

            public Builder clearFinishState() {
                this.finishState_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
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
        String[] descriptorData = {"\n\027guildBlessHandler.proto\022\013pomelo.area\032\nitem.proto\032\fcommon.proto\"0\n\tBlessItem\022#\n\004item\030\001 \003(\0132\025.pomelo.item.MiniItem\"\027\n\025GetMyBlessInfoRequest\" \n\022BlessActionRequest\022\n\n\002id\030\001 \001(\005\"(\n\027ReceiveBlessGiftRequest\022\r\n\005index\030\001 \002(\005\"\025\n\023UpgradeBlessRequest\"\001\n\013MyBlessInfo\022\022\n\nblessCount\030\001 \001(\005\022)\n\nblessAttrs\030\002 \003(\0132\025.pomelo.AttributeBase\022\020\n\bbuffTime\030\003 \001(\005\022\024\n\freceiveState\030\004 \003(\005\022(\n\bitemList\030\005 \003(\0132\026.pomelo.area.BlessItem\"", "l\n\026GetMyBlessInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\rs2c_blessInfo\030\003 \001(\0132\030.pomelo.area.MyBlessInfo\"i\n\013BlessResult\022\022\n\nblessCount\030\001 \001(\005\022\022\n\nblessValue\030\002 \001(\005\022\n\n\002id\030\003 \001(\005\022\021\n\tfinishNum\030\004 \001(\005\022\023\n\013finishState\030\005 \003(\005\"f\n\023BlessActionResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\ns2c_result\030\003 \001(\0132\030.pomelo.area.BlessResult\"%\n\rReceiveResult\022\024\n\freceiveState\030\001 \001(\005\"m\n\030ReceiveBlessGiftResponse\022\020\n\bs2c_code\030", "\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022.\n\ns2c_result\030\003 \001(\0132\032.pomelo.area.ReceiveResult\"^\n\024UpgradeBlessResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\ts2c_level\030\003 \001(\005\022\020\n\bs2c_fund\030\004 \001(\005\"l\n\020BlessRefreshPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004type\030\003 \001(\005\022\022\n\nblessValue\030\004 \001(\005\022\023\n\013finishState\030\005 \003(\0052\003\n\021guildBlessHandler\022`\n\025getMyBlessInfoRequest\022\".pomelo.area.GetMyBlessInfoRequest\032#.pomelo.area.GetMyBlessInfoResponse\022W\n\022", "blessActionRequest\022\037.pomelo.area.BlessActionRequest\032 .pomelo.area.BlessActionResponse\022f\n\027receiveBlessGiftRequest\022$.pomelo.area.ReceiveBlessGiftRequest\032%.pomelo.area.ReceiveBlessGiftResponse\022Z\n\023upgradeBlessRequest\022 .pomelo.area.UpgradeBlessRequest\032!.pomelo.area.UpgradeBlessResponse2Q\n\016guildBlessPush\022?\n\020blessRefreshPush\022\035.pomelo.area.BlessRefreshPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                GuildBlessHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                ItemOuterClass.getDescriptor(),
                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_BlessItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BlessItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BlessItem_descriptor, new String[]{"Item"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMyBlessInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMyBlessInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMyBlessInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_BlessActionRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BlessActionRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BlessActionRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveBlessGiftRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveBlessGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveBlessGiftRequest_descriptor, new String[]{"Index"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeBlessRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeBlessRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeBlessRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_MyBlessInfo_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MyBlessInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MyBlessInfo_descriptor, new String[]{"BlessCount", "BlessAttrs", "BuffTime", "ReceiveState", "ItemList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMyBlessInfoResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMyBlessInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMyBlessInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CBlessInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BlessResult_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BlessResult_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BlessResult_descriptor, new String[]{"BlessCount", "BlessValue", "Id", "FinishNum", "FinishState"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BlessActionResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BlessActionResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BlessActionResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CResult"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveResult_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveResult_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveResult_descriptor, new String[]{"ReceiveState"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveBlessGiftResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveBlessGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveBlessGiftResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CResult"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeBlessResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeBlessResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeBlessResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLevel", "S2CFund"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BlessRefreshPush_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BlessRefreshPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BlessRefreshPush_descriptor, new String[]{"S2CCode", "S2CMsg", "Type", "BlessValue", "FinishState"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        ItemOuterClass.getDescriptor();
        Common.getDescriptor();
    }

    public static interface BlessRefreshPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasType();

        int getType();

        boolean hasBlessValue();

        int getBlessValue();

        List<Integer> getFinishStateList();

        int getFinishStateCount();

        int getFinishState(int param1Int);
    }

    public static interface UpgradeBlessResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CLevel();

        int getS2CLevel();

        boolean hasS2CFund();

        int getS2CFund();
    }

    public static interface ReceiveBlessGiftResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CResult();

        GuildBlessHandler.ReceiveResult getS2CResult();

        GuildBlessHandler.ReceiveResultOrBuilder getS2CResultOrBuilder();
    }

    public static interface ReceiveResultOrBuilder extends MessageOrBuilder {
        boolean hasReceiveState();

        int getReceiveState();
    }

    public static interface BlessActionResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CResult();

        GuildBlessHandler.BlessResult getS2CResult();

        GuildBlessHandler.BlessResultOrBuilder getS2CResultOrBuilder();
    }

    public static interface BlessResultOrBuilder extends MessageOrBuilder {
        boolean hasBlessCount();

        int getBlessCount();

        boolean hasBlessValue();

        int getBlessValue();

        boolean hasId();

        int getId();

        boolean hasFinishNum();

        int getFinishNum();

        List<Integer> getFinishStateList();

        int getFinishStateCount();

        int getFinishState(int param1Int);
    }

    public static interface GetMyBlessInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CBlessInfo();

        GuildBlessHandler.MyBlessInfo getS2CBlessInfo();

        GuildBlessHandler.MyBlessInfoOrBuilder getS2CBlessInfoOrBuilder();
    }

    public static interface MyBlessInfoOrBuilder extends MessageOrBuilder {
        boolean hasBlessCount();

        int getBlessCount();

        List<Common.AttributeBase> getBlessAttrsList();

        Common.AttributeBase getBlessAttrs(int param1Int);

        int getBlessAttrsCount();

        List<? extends Common.AttributeBaseOrBuilder> getBlessAttrsOrBuilderList();

        Common.AttributeBaseOrBuilder getBlessAttrsOrBuilder(int param1Int);

        boolean hasBuffTime();

        int getBuffTime();

        List<Integer> getReceiveStateList();

        int getReceiveStateCount();

        int getReceiveState(int param1Int);

        List<GuildBlessHandler.BlessItem> getItemListList();

        GuildBlessHandler.BlessItem getItemList(int param1Int);

        int getItemListCount();

        List<? extends GuildBlessHandler.BlessItemOrBuilder> getItemListOrBuilderList();

        GuildBlessHandler.BlessItemOrBuilder getItemListOrBuilder(int param1Int);
    }

    public static interface UpgradeBlessRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface ReceiveBlessGiftRequestOrBuilder extends MessageOrBuilder {
        boolean hasIndex();

        int getIndex();
    }

    public static interface BlessActionRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface GetMyBlessInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface BlessItemOrBuilder extends MessageOrBuilder {
        List<ItemOuterClass.MiniItem> getItemList();

        ItemOuterClass.MiniItem getItem(int param1Int);

        int getItemCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getItemOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getItemOrBuilder(int param1Int);
    }
}


