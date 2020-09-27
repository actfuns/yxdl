package pomelo;

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


public final class Common {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Void
            extends GeneratedMessage
            implements VoidOrBuilder {
        private static final Void defaultInstance = new Void(true);
        private final UnknownFieldSet unknownFields;

        private Void(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Void(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Void getDefaultInstance() {
            return defaultInstance;
        }

        public Void getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Void(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Common.internal_static_pomelo_Void_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_Void_fieldAccessorTable.ensureFieldAccessorsInitialized(Void.class, Builder.class);
        }

        public static Parser<Void> PARSER = (Parser<Void>) new AbstractParser<Void>() {
            public Common.Void parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.Void(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Void> getParserForType() {
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

        public static Void parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data);
        }

        public static Void parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Void parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data);
        }

        public static Void parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Void parseFrom(InputStream input) throws IOException {
            return (Void) PARSER.parseFrom(input);
        }

        public static Void parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Void) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Void parseDelimitedFrom(InputStream input) throws IOException {
            return (Void) PARSER.parseDelimitedFrom(input);
        }

        public static Void parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Void) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Void parseFrom(CodedInputStream input) throws IOException {
            return (Void) PARSER.parseFrom(input);
        }

        public static Void parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Void) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Void prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.VoidOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_Void_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_Void_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.Void.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.Void.alwaysUseFieldBuilders) ;
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
                return Common.internal_static_pomelo_Void_descriptor;
            }

            public Common.Void getDefaultInstanceForType() {
                return Common.Void.getDefaultInstance();
            }

            public Common.Void build() {
                Common.Void result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Common.Void buildPartial() {
                Common.Void result = new Common.Void(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.Void) return mergeFrom((Common.Void) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.Void other) {
                if (other == Common.Void.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.Void parsedMessage = null;
                try {
                    parsedMessage = (Common.Void) Common.Void.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.Void) e.getUnfinishedMessage();
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


    public static final class EffectPropertyStruct
            extends GeneratedMessage
            implements EffectPropertyStructOrBuilder {
        private static final EffectPropertyStruct defaultInstance = new EffectPropertyStruct(true);
        private final UnknownFieldSet unknownFields;

        private EffectPropertyStruct(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EffectPropertyStruct(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static EffectPropertyStruct getDefaultInstance() {
            return defaultInstance;
        }

        public EffectPropertyStruct getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffectPropertyStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.describ_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.value_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.maxValue_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.name_ = bs;
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
            return Common.internal_static_pomelo_EffectPropertyStruct_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_EffectPropertyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(EffectPropertyStruct.class, Builder.class);
        }

        public static Parser<EffectPropertyStruct> PARSER = (Parser<EffectPropertyStruct>) new AbstractParser<EffectPropertyStruct>() {
            public Common.EffectPropertyStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.EffectPropertyStruct(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int DESCRIB_FIELD_NUMBER = 1;
        private Object describ_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int value_;
        public static final int MAXVALUE_FIELD_NUMBER = 3;
        private Object maxValue_;
        public static final int NAME_FIELD_NUMBER = 4;
        private Object name_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<EffectPropertyStruct> getParserForType() {
            return PARSER;
        }

        public boolean hasDescrib() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getDescrib() {
            Object ref = this.describ_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.describ_ = s;
            return s;
        }

        public ByteString getDescribBytes() {
            Object ref = this.describ_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.describ_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getValue() {
            return this.value_;
        }

        public boolean hasMaxValue() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getMaxValue() {
            Object ref = this.maxValue_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.maxValue_ = s;
            return s;
        }

        public ByteString getMaxValueBytes() {
            Object ref = this.maxValue_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.maxValue_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x8) == 8);
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

        private void initFields() {
            this.describ_ = "";
            this.value_ = 0;
            this.maxValue_ = "";
            this.name_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasDescrib()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getDescribBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.value_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getMaxValueBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getNameBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getDescribBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.value_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getMaxValueBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getNameBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EffectPropertyStruct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EffectPropertyStruct) PARSER.parseFrom(data);
        }

        public static EffectPropertyStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EffectPropertyStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffectPropertyStruct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EffectPropertyStruct) PARSER.parseFrom(data);
        }

        public static EffectPropertyStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EffectPropertyStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffectPropertyStruct parseFrom(InputStream input) throws IOException {
            return (EffectPropertyStruct) PARSER.parseFrom(input);
        }

        public static EffectPropertyStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffectPropertyStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static EffectPropertyStruct parseDelimitedFrom(InputStream input) throws IOException {
            return (EffectPropertyStruct) PARSER.parseDelimitedFrom(input);
        }

        public static EffectPropertyStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffectPropertyStruct) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EffectPropertyStruct parseFrom(CodedInputStream input) throws IOException {
            return (EffectPropertyStruct) PARSER.parseFrom(input);
        }

        public static EffectPropertyStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffectPropertyStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EffectPropertyStruct prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.EffectPropertyStructOrBuilder {
            private int bitField0_;
            private Object describ_;
            private int value_;
            private Object maxValue_;
            private Object name_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_EffectPropertyStruct_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_EffectPropertyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.EffectPropertyStruct.class, Builder.class);
            }

            private Builder() {
                this.describ_ = "";
                this.maxValue_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.describ_ = "";
                this.maxValue_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.EffectPropertyStruct.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.describ_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.maxValue_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_EffectPropertyStruct_descriptor;
            }

            public Common.EffectPropertyStruct getDefaultInstanceForType() {
                return Common.EffectPropertyStruct.getDefaultInstance();
            }

            public Common.EffectPropertyStruct build() {
                Common.EffectPropertyStruct result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Common.EffectPropertyStruct buildPartial() {
                Common.EffectPropertyStruct result = new Common.EffectPropertyStruct(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.describ_ = this.describ_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.value_ = this.value_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.maxValue_ = this.maxValue_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.name_ = this.name_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.EffectPropertyStruct)
                    return mergeFrom((Common.EffectPropertyStruct) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.EffectPropertyStruct other) {
                if (other == Common.EffectPropertyStruct.getDefaultInstance())
                    return this;
                if (other.hasDescrib()) {
                    this.bitField0_ |= 0x1;
                    this.describ_ = other.describ_;
                    onChanged();
                }
                if (other.hasValue())
                    setValue(other.getValue());
                if (other.hasMaxValue()) {
                    this.bitField0_ |= 0x4;
                    this.maxValue_ = other.maxValue_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x8;
                    this.name_ = other.name_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasDescrib())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.EffectPropertyStruct parsedMessage = null;
                try {
                    parsedMessage = (Common.EffectPropertyStruct) Common.EffectPropertyStruct.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.EffectPropertyStruct) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasDescrib() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getDescrib() {
                Object ref = this.describ_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.describ_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDescribBytes() {
                Object ref = this.describ_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.describ_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setDescrib(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.describ_ = value;
                onChanged();
                return this;
            }

            public Builder clearDescrib() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.describ_ = Common.EffectPropertyStruct.getDefaultInstance().getDescrib();
                onChanged();
                return this;
            }

            public Builder setDescribBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.describ_ = value;
                onChanged();
                return this;
            }

            public boolean hasValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int value) {
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.value_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxValue() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getMaxValue() {
                Object ref = this.maxValue_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.maxValue_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMaxValueBytes() {
                Object ref = this.maxValue_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.maxValue_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMaxValue(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.maxValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxValue() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.maxValue_ = Common.EffectPropertyStruct.getDefaultInstance().getMaxValue();
                onChanged();
                return this;
            }

            public Builder setMaxValueBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.maxValue_ = value;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.name_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.name_ = Common.EffectPropertyStruct.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.name_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class KeyValueStruct extends GeneratedMessage implements KeyValueStructOrBuilder {
        private final UnknownFieldSet unknownFields;

        private KeyValueStruct(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private KeyValueStruct(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static KeyValueStruct getDefaultInstance() {
            return defaultInstance;
        }

        public KeyValueStruct getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private KeyValueStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.key_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.value_ = bs;
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
            return Common.internal_static_pomelo_KeyValueStruct_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_KeyValueStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(KeyValueStruct.class, Builder.class);
        }

        public static Parser<KeyValueStruct> PARSER = (Parser<KeyValueStruct>) new AbstractParser<KeyValueStruct>() {
            public Common.KeyValueStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.KeyValueStruct(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int KEY_FIELD_NUMBER = 1;
        private Object key_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private Object value_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<KeyValueStruct> getParserForType() {
            return PARSER;
        }

        public boolean hasKey() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getKey() {
            Object ref = this.key_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.key_ = s;
            return s;
        }

        public ByteString getKeyBytes() {
            Object ref = this.key_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.key_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getValue() {
            Object ref = this.value_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.value_ = s;
            return s;
        }

        public ByteString getValueBytes() {
            Object ref = this.value_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.value_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.key_ = "";
            this.value_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasKey()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getKeyBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getValueBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getKeyBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getValueBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static KeyValueStruct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (KeyValueStruct) PARSER.parseFrom(data);
        }

        public static KeyValueStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KeyValueStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static KeyValueStruct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (KeyValueStruct) PARSER.parseFrom(data);
        }

        public static KeyValueStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KeyValueStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static KeyValueStruct parseFrom(InputStream input) throws IOException {
            return (KeyValueStruct) PARSER.parseFrom(input);
        }

        private static final KeyValueStruct defaultInstance = new KeyValueStruct(true);

        public static KeyValueStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KeyValueStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static KeyValueStruct parseDelimitedFrom(InputStream input) throws IOException {
            return (KeyValueStruct) PARSER.parseDelimitedFrom(input);
        }

        public static KeyValueStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KeyValueStruct) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static KeyValueStruct parseFrom(CodedInputStream input) throws IOException {
            return (KeyValueStruct) PARSER.parseFrom(input);
        }

        public static KeyValueStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KeyValueStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(KeyValueStruct prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.KeyValueStructOrBuilder {
            private int bitField0_;
            private Object key_;
            private Object value_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_KeyValueStruct_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_KeyValueStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.KeyValueStruct.class, Builder.class);
            }

            private Builder() {
                this.key_ = "";
                this.value_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.key_ = "";
                this.value_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.KeyValueStruct.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.key_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_KeyValueStruct_descriptor;
            }

            public Common.KeyValueStruct getDefaultInstanceForType() {
                return Common.KeyValueStruct.getDefaultInstance();
            }

            public Common.KeyValueStruct build() {
                Common.KeyValueStruct result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Common.KeyValueStruct buildPartial() {
                Common.KeyValueStruct result = new Common.KeyValueStruct(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.key_ = this.key_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.value_ = this.value_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.KeyValueStruct) return mergeFrom((Common.KeyValueStruct) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.KeyValueStruct other) {
                if (other == Common.KeyValueStruct.getDefaultInstance()) return this;
                if (other.hasKey()) {
                    this.bitField0_ |= 0x1;
                    this.key_ = other.key_;
                    onChanged();
                }
                if (other.hasValue()) {
                    this.bitField0_ |= 0x2;
                    this.value_ = other.value_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasKey()) return false;
                if (!hasValue()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.KeyValueStruct parsedMessage = null;
                try {
                    parsedMessage = (Common.KeyValueStruct) Common.KeyValueStruct.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.KeyValueStruct) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasKey() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getKey() {
                Object ref = this.key_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.key_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getKeyBytes() {
                Object ref = this.key_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.key_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setKey(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.key_ = Common.KeyValueStruct.getDefaultInstance().getKey();
                onChanged();
                return this;
            }

            public Builder setKeyBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public boolean hasValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getValue() {
                Object ref = this.value_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.value_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getValueBytes() {
                Object ref = this.value_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.value_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setValue(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.value_ = Common.KeyValueStruct.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public Builder setValueBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class PropertyStruct
            extends GeneratedMessage
            implements PropertyStructOrBuilder {
        private static final PropertyStruct defaultInstance = new PropertyStruct(true);
        private final UnknownFieldSet unknownFields;

        private PropertyStruct(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PropertyStruct(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PropertyStruct getDefaultInstance() {
            return defaultInstance;
        }

        public PropertyStruct getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PropertyStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.key_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.value_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.type_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.source_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.items_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.items_.add(input.readMessage(Common.KeyValueStruct.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16) this.items_ = Collections.unmodifiableList(this.items_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Common.internal_static_pomelo_PropertyStruct_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_PropertyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(PropertyStruct.class, Builder.class);
        }

        public static Parser<PropertyStruct> PARSER = (Parser<PropertyStruct>) new AbstractParser<PropertyStruct>() {
            public Common.PropertyStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.PropertyStruct(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int KEY_FIELD_NUMBER = 1;
        private Object key_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private Object value_;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int type_;
        public static final int SOURCE_FIELD_NUMBER = 4;
        private int source_;
        public static final int ITEMS_FIELD_NUMBER = 5;
        private List<Common.KeyValueStruct> items_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PropertyStruct> getParserForType() {
            return PARSER;
        }

        public boolean hasKey() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getKey() {
            Object ref = this.key_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.key_ = s;
            return s;
        }

        public ByteString getKeyBytes() {
            Object ref = this.key_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.key_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getValue() {
            Object ref = this.value_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.value_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }

        public ByteString getValueBytes() {
            Object ref = this.value_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.value_ = b;
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

        public boolean hasSource() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getSource() {
            return this.source_;
        }

        public List<Common.KeyValueStruct> getItemsList() {
            return this.items_;
        }

        public List<? extends Common.KeyValueStructOrBuilder> getItemsOrBuilderList() {
            return (List) this.items_;
        }

        public int getItemsCount() {
            return this.items_.size();
        }

        public Common.KeyValueStruct getItems(int index) {
            return this.items_.get(index);
        }

        public Common.KeyValueStructOrBuilder getItemsOrBuilder(int index) {
            return this.items_.get(index);
        }

        private void initFields() {
            this.key_ = "";
            this.value_ = "";
            this.type_ = 0;
            this.source_ = 0;
            this.items_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasKey()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasType()) {
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
                output.writeBytes(1, getKeyBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getValueBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.type_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.source_);
            for (int i = 0; i < this.items_.size(); i++)
                output.writeMessage(5, (MessageLite) this.items_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getKeyBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getValueBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.type_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.source_);
            for (int i = 0; i < this.items_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.items_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PropertyStruct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PropertyStruct) PARSER.parseFrom(data);
        }

        public static PropertyStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PropertyStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropertyStruct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PropertyStruct) PARSER.parseFrom(data);
        }

        public static PropertyStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PropertyStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropertyStruct parseFrom(InputStream input) throws IOException {
            return (PropertyStruct) PARSER.parseFrom(input);
        }

        public static PropertyStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropertyStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static PropertyStruct parseDelimitedFrom(InputStream input) throws IOException {
            return (PropertyStruct) PARSER.parseDelimitedFrom(input);
        }

        public static PropertyStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropertyStruct) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PropertyStruct parseFrom(CodedInputStream input) throws IOException {
            return (PropertyStruct) PARSER.parseFrom(input);
        }

        public static PropertyStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropertyStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PropertyStruct prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.PropertyStructOrBuilder {
            private int bitField0_;
            private Object key_;
            private Object value_;
            private int type_;
            private int source_;
            private List<Common.KeyValueStruct> items_;
            private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> itemsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_PropertyStruct_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_PropertyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.PropertyStruct.class, Builder.class);
            }

            private Builder() {
                this.key_ = "";
                this.value_ = "";
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.key_ = "";
                this.value_ = "";
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.PropertyStruct.alwaysUseFieldBuilders)
                    getItemsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.key_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.source_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_PropertyStruct_descriptor;
            }

            public Common.PropertyStruct getDefaultInstanceForType() {
                return Common.PropertyStruct.getDefaultInstance();
            }

            public Common.PropertyStruct build() {
                Common.PropertyStruct result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Common.PropertyStruct buildPartial() {
                Common.PropertyStruct result = new Common.PropertyStruct(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.key_ = this.key_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.value_ = this.value_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.source_ = this.source_;
                if (this.itemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.items_ = Collections.unmodifiableList(this.items_);
                        this.bitField0_ &= 0xFFFFFFEF;
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
                if (other instanceof Common.PropertyStruct)
                    return mergeFrom((Common.PropertyStruct) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.PropertyStruct other) {
                if (other == Common.PropertyStruct.getDefaultInstance())
                    return this;
                if (other.hasKey()) {
                    this.bitField0_ |= 0x1;
                    this.key_ = other.key_;
                    onChanged();
                }
                if (other.hasValue()) {
                    this.bitField0_ |= 0x2;
                    this.value_ = other.value_;
                    onChanged();
                }
                if (other.hasType())
                    setType(other.getType());
                if (other.hasSource())
                    setSource(other.getSource());
                if (this.itemsBuilder_ == null) {
                    if (!other.items_.isEmpty()) {
                        if (this.items_.isEmpty()) {
                            this.items_ = other.items_;
                            this.bitField0_ &= 0xFFFFFFEF;
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
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.itemsBuilder_ = Common.PropertyStruct.alwaysUseFieldBuilders ? getItemsFieldBuilder() : null;
                    } else {
                        this.itemsBuilder_.addAllMessages(other.items_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasKey())
                    return false;
                if (!hasValue())
                    return false;
                if (!hasType())
                    return false;
                for (int i = 0; i < getItemsCount(); i++) {
                    if (!getItems(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.PropertyStruct parsedMessage = null;
                try {
                    parsedMessage = (Common.PropertyStruct) Common.PropertyStruct.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.PropertyStruct) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasKey() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getKey() {
                Object ref = this.key_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.key_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getKeyBytes() {
                Object ref = this.key_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.key_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setKey(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.key_ = Common.PropertyStruct.getDefaultInstance().getKey();
                onChanged();
                return this;
            }

            public Builder setKeyBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public boolean hasValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getValue() {
                Object ref = this.value_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.value_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getValueBytes() {
                Object ref = this.value_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.value_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setValue(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.value_ = Common.PropertyStruct.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public Builder setValueBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.value_ = value;
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

            public boolean hasSource() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getSource() {
                return this.source_;
            }

            public Builder setSource(int value) {
                this.bitField0_ |= 0x8;
                this.source_ = value;
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.source_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemsIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.items_ = new ArrayList<>(this.items_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<Common.KeyValueStruct> getItemsList() {
                if (this.itemsBuilder_ == null)
                    return Collections.unmodifiableList(this.items_);
                return this.itemsBuilder_.getMessageList();
            }

            public int getItemsCount() {
                if (this.itemsBuilder_ == null)
                    return this.items_.size();
                return this.itemsBuilder_.getCount();
            }

            public Common.KeyValueStruct getItems(int index) {
                if (this.itemsBuilder_ == null)
                    return this.items_.get(index);
                return (Common.KeyValueStruct) this.itemsBuilder_.getMessage(index);
            }

            public Builder setItems(int index, Common.KeyValueStruct value) {
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

            public Builder setItems(int index, Common.KeyValueStruct.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItems(Common.KeyValueStruct value) {
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

            public Builder addItems(int index, Common.KeyValueStruct value) {
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

            public Builder addItems(Common.KeyValueStruct.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItems(int index, Common.KeyValueStruct.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItems(Iterable<? extends Common.KeyValueStruct> values) {
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
                    this.bitField0_ &= 0xFFFFFFEF;
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

            public Common.KeyValueStruct.Builder getItemsBuilder(int index) {
                return (Common.KeyValueStruct.Builder) getItemsFieldBuilder().getBuilder(index);
            }

            public Common.KeyValueStructOrBuilder getItemsOrBuilder(int index) {
                if (this.itemsBuilder_ == null)
                    return this.items_.get(index);
                return (Common.KeyValueStructOrBuilder) this.itemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.KeyValueStructOrBuilder> getItemsOrBuilderList() {
                if (this.itemsBuilder_ != null)
                    return this.itemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.items_);
            }

            public Common.KeyValueStruct.Builder addItemsBuilder() {
                return (Common.KeyValueStruct.Builder) getItemsFieldBuilder().addBuilder(Common.KeyValueStruct.getDefaultInstance());
            }

            public Common.KeyValueStruct.Builder addItemsBuilder(int index) {
                return (Common.KeyValueStruct.Builder) getItemsFieldBuilder().addBuilder(index, Common.KeyValueStruct.getDefaultInstance());
            }

            public List<Common.KeyValueStruct.Builder> getItemsBuilderList() {
                return getItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> getItemsFieldBuilder() {
                if (this.itemsBuilder_ == null) {
                    this.itemsBuilder_ = new RepeatedFieldBuilder(this.items_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.items_ = null;
                }
                return this.itemsBuilder_;
            }
        }
    }

    public static final class ObjectProperty extends GeneratedMessage implements ObjectPropertyOrBuilder {
        private final UnknownFieldSet unknownFields;

        private ObjectProperty(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ObjectProperty(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ObjectProperty getDefaultInstance() {
            return defaultInstance;
        }

        public ObjectProperty getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ObjectProperty(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.props_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.props_.add(input.readMessage(Common.PropertyStruct.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2)
                    this.props_ = Collections.unmodifiableList(this.props_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Common.internal_static_pomelo_ObjectProperty_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_ObjectProperty_fieldAccessorTable.ensureFieldAccessorsInitialized(ObjectProperty.class, Builder.class);
        }

        public static Parser<ObjectProperty> PARSER = (Parser<ObjectProperty>) new AbstractParser<ObjectProperty>() {
            public Common.ObjectProperty parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.ObjectProperty(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int PROPS_FIELD_NUMBER = 2;
        private List<Common.PropertyStruct> props_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ObjectProperty> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public List<Common.PropertyStruct> getPropsList() {
            return this.props_;
        }

        public List<? extends Common.PropertyStructOrBuilder> getPropsOrBuilderList() {
            return (List) this.props_;
        }

        public int getPropsCount() {
            return this.props_.size();
        }

        private static final ObjectProperty defaultInstance = new ObjectProperty(true);

        public Common.PropertyStruct getProps(int index) {
            return this.props_.get(index);
        }

        public Common.PropertyStructOrBuilder getPropsOrBuilder(int index) {
            return this.props_.get(index);
        }

        private void initFields() {
            this.id_ = 0;
            this.props_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getPropsCount(); i++) {
                if (!getProps(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            for (int i = 0; i < this.props_.size(); i++) output.writeMessage(2, (MessageLite) this.props_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            for (int i = 0; i < this.props_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.props_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ObjectProperty parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ObjectProperty) PARSER.parseFrom(data);
        }

        public static ObjectProperty parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ObjectProperty) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObjectProperty parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ObjectProperty) PARSER.parseFrom(data);
        }

        public static ObjectProperty parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ObjectProperty) PARSER.parseFrom(data, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }


        public static ObjectProperty parseFrom(InputStream input) throws IOException {
            return (ObjectProperty) PARSER.parseFrom(input);
        }


        public static ObjectProperty parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObjectProperty) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ObjectProperty parseDelimitedFrom(InputStream input) throws IOException {
            return (ObjectProperty) PARSER.parseDelimitedFrom(input);
        }


        public static ObjectProperty parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObjectProperty) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ObjectProperty parseFrom(CodedInputStream input) throws IOException {
            return (ObjectProperty) PARSER.parseFrom(input);
        }


        public static ObjectProperty parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObjectProperty) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ObjectProperty prototype) {
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
                implements Common.ObjectPropertyOrBuilder {
            private int bitField0_;


            private int id_;


            private List<Common.PropertyStruct> props_;


            private RepeatedFieldBuilder<Common.PropertyStruct, Common.PropertyStruct.Builder, Common.PropertyStructOrBuilder> propsBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_ObjectProperty_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_ObjectProperty_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.ObjectProperty.class, Builder.class);
            }


            private Builder() {
                this.props_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.props_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (Common.ObjectProperty.alwaysUseFieldBuilders) {
                    getPropsFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.propsBuilder_ == null) {
                    this.props_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.propsBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_ObjectProperty_descriptor;
            }


            public Common.ObjectProperty getDefaultInstanceForType() {
                return Common.ObjectProperty.getDefaultInstance();
            }


            public Common.ObjectProperty build() {
                Common.ObjectProperty result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Common.ObjectProperty buildPartial() {
                Common.ObjectProperty result = new Common.ObjectProperty(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if (this.propsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.props_ = Collections.unmodifiableList(this.props_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.props_ = this.props_;
                } else {
                    result.props_ = this.propsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Common.ObjectProperty) {
                    return mergeFrom((Common.ObjectProperty) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Common.ObjectProperty other) {
                if (other == Common.ObjectProperty.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (this.propsBuilder_ == null) {
                    if (!other.props_.isEmpty()) {
                        if (this.props_.isEmpty()) {
                            this.props_ = other.props_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensurePropsIsMutable();
                            this.props_.addAll(other.props_);
                        }
                        onChanged();
                    }
                } else if (!other.props_.isEmpty()) {
                    if (this.propsBuilder_.isEmpty()) {
                        this.propsBuilder_.dispose();
                        this.propsBuilder_ = null;
                        this.props_ = other.props_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.propsBuilder_ = Common.ObjectProperty.alwaysUseFieldBuilders ? getPropsFieldBuilder() : null;
                    } else {
                        this.propsBuilder_.addAllMessages(other.props_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i = 0; i < getPropsCount(); i++) {
                    if (!getProps(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.ObjectProperty parsedMessage = null;
                try {
                    parsedMessage = (Common.ObjectProperty) Common.ObjectProperty.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.ObjectProperty) e.getUnfinishedMessage();
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


            private void ensurePropsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.props_ = new ArrayList<>(this.props_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<Common.PropertyStruct> getPropsList() {
                if (this.propsBuilder_ == null) {
                    return Collections.unmodifiableList(this.props_);
                }
                return this.propsBuilder_.getMessageList();
            }


            public int getPropsCount() {
                if (this.propsBuilder_ == null) {
                    return this.props_.size();
                }
                return this.propsBuilder_.getCount();
            }


            public Common.PropertyStruct getProps(int index) {
                if (this.propsBuilder_ == null) {
                    return this.props_.get(index);
                }
                return (Common.PropertyStruct) this.propsBuilder_.getMessage(index);
            }


            public Builder setProps(int index, Common.PropertyStruct value) {
                if (this.propsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePropsIsMutable();
                    this.props_.set(index, value);
                    onChanged();
                } else {
                    this.propsBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setProps(int index, Common.PropertyStruct.Builder builderForValue) {
                if (this.propsBuilder_ == null) {
                    ensurePropsIsMutable();
                    this.props_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addProps(Common.PropertyStruct value) {
                if (this.propsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePropsIsMutable();
                    this.props_.add(value);
                    onChanged();
                } else {
                    this.propsBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addProps(int index, Common.PropertyStruct value) {
                if (this.propsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePropsIsMutable();
                    this.props_.add(index, value);
                    onChanged();
                } else {
                    this.propsBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addProps(Common.PropertyStruct.Builder builderForValue) {
                if (this.propsBuilder_ == null) {
                    ensurePropsIsMutable();
                    this.props_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.propsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addProps(int index, Common.PropertyStruct.Builder builderForValue) {
                if (this.propsBuilder_ == null) {
                    ensurePropsIsMutable();
                    this.props_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllProps(Iterable<? extends Common.PropertyStruct> values) {
                if (this.propsBuilder_ == null) {
                    ensurePropsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.props_);
                    onChanged();
                } else {
                    this.propsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearProps() {
                if (this.propsBuilder_ == null) {
                    this.props_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.propsBuilder_.clear();
                }
                return this;
            }


            public Builder removeProps(int index) {
                if (this.propsBuilder_ == null) {
                    ensurePropsIsMutable();
                    this.props_.remove(index);
                    onChanged();
                } else {
                    this.propsBuilder_.remove(index);
                }
                return this;
            }


            public Common.PropertyStruct.Builder getPropsBuilder(int index) {
                return (Common.PropertyStruct.Builder) getPropsFieldBuilder().getBuilder(index);
            }


            public Common.PropertyStructOrBuilder getPropsOrBuilder(int index) {
                if (this.propsBuilder_ == null) {
                    return this.props_.get(index);
                }
                return (Common.PropertyStructOrBuilder) this.propsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends Common.PropertyStructOrBuilder> getPropsOrBuilderList() {
                if (this.propsBuilder_ != null) {
                    return this.propsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.props_);
            }


            public Common.PropertyStruct.Builder addPropsBuilder() {
                return (Common.PropertyStruct.Builder) getPropsFieldBuilder().addBuilder(Common.PropertyStruct.getDefaultInstance());
            }


            public Common.PropertyStruct.Builder addPropsBuilder(int index) {
                return (Common.PropertyStruct.Builder) getPropsFieldBuilder().addBuilder(index, Common.PropertyStruct.getDefaultInstance());
            }


            public List<Common.PropertyStruct.Builder> getPropsBuilderList() {
                return getPropsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<Common.PropertyStruct, Common.PropertyStruct.Builder, Common.PropertyStructOrBuilder> getPropsFieldBuilder() {
                if (this.propsBuilder_ == null) {
                    this.propsBuilder_ = new RepeatedFieldBuilder(this.props_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.props_ = null;
                }
                return this.propsBuilder_;
            }
        }
    }


    public static final class AttributeBase
            extends GeneratedMessage
            implements AttributeBaseOrBuilder {
        private static final AttributeBase defaultInstance = new AttributeBase(true);
        private final UnknownFieldSet unknownFields;

        private AttributeBase(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AttributeBase(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AttributeBase getDefaultInstance() {
            return defaultInstance;
        }

        public AttributeBase getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttributeBase(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.value_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.isFormat_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.nextValue_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.minValue_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.maxValue_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.param1_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.param2_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.param3_ = input.readInt32();
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
            return Common.internal_static_pomelo_AttributeBase_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_AttributeBase_fieldAccessorTable.ensureFieldAccessorsInitialized(AttributeBase.class, Builder.class);
        }

        public static Parser<AttributeBase> PARSER = (Parser<AttributeBase>) new AbstractParser<AttributeBase>() {
            public Common.AttributeBase parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.AttributeBase(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int value_;
        public static final int ISFORMAT_FIELD_NUMBER = 3;
        private int isFormat_;
        public static final int NEXTVALUE_FIELD_NUMBER = 4;
        private int nextValue_;
        public static final int MINVALUE_FIELD_NUMBER = 5;
        private int minValue_;
        public static final int MAXVALUE_FIELD_NUMBER = 6;
        private int maxValue_;
        public static final int PARAM1_FIELD_NUMBER = 7;
        private int param1_;
        public static final int PARAM2_FIELD_NUMBER = 8;
        private int param2_;
        public static final int PARAM3_FIELD_NUMBER = 9;
        private int param3_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AttributeBase> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getValue() {
            return this.value_;
        }

        public boolean hasIsFormat() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getIsFormat() {
            return this.isFormat_;
        }

        public boolean hasNextValue() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getNextValue() {
            return this.nextValue_;
        }

        public boolean hasMinValue() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getMinValue() {
            return this.minValue_;
        }

        public boolean hasMaxValue() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getMaxValue() {
            return this.maxValue_;
        }

        public boolean hasParam1() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getParam1() {
            return this.param1_;
        }

        public boolean hasParam2() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getParam2() {
            return this.param2_;
        }

        public boolean hasParam3() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getParam3() {
            return this.param3_;
        }

        private void initFields() {
            this.id_ = 0;
            this.value_ = 0;
            this.isFormat_ = 0;
            this.nextValue_ = 0;
            this.minValue_ = 0;
            this.maxValue_ = 0;
            this.param1_ = 0;
            this.param2_ = 0;
            this.param3_ = 0;
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.value_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.isFormat_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.nextValue_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.minValue_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.maxValue_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.param1_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(8, this.param2_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.param3_);
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
                size += CodedOutputStream.computeInt32Size(2, this.value_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.isFormat_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.nextValue_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.minValue_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.maxValue_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.param1_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.param2_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.param3_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AttributeBase parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AttributeBase) PARSER.parseFrom(data);
        }

        public static AttributeBase parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AttributeBase) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttributeBase parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AttributeBase) PARSER.parseFrom(data);
        }

        public static AttributeBase parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AttributeBase) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttributeBase parseFrom(InputStream input) throws IOException {
            return (AttributeBase) PARSER.parseFrom(input);
        }

        public static AttributeBase parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttributeBase) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AttributeBase parseDelimitedFrom(InputStream input) throws IOException {
            return (AttributeBase) PARSER.parseDelimitedFrom(input);
        }

        public static AttributeBase parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttributeBase) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AttributeBase parseFrom(CodedInputStream input) throws IOException {
            return (AttributeBase) PARSER.parseFrom(input);
        }

        public static AttributeBase parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttributeBase) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AttributeBase prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.AttributeBaseOrBuilder {
            private int bitField0_;
            private int id_;
            private int value_;
            private int isFormat_;
            private int nextValue_;
            private int minValue_;
            private int maxValue_;
            private int param1_;
            private int param2_;
            private int param3_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_AttributeBase_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_AttributeBase_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.AttributeBase.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.AttributeBase.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.isFormat_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.nextValue_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.minValue_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.maxValue_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.param1_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.param2_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.param3_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_AttributeBase_descriptor;
            }

            public Common.AttributeBase getDefaultInstanceForType() {
                return Common.AttributeBase.getDefaultInstance();
            }

            public Common.AttributeBase build() {
                Common.AttributeBase result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Common.AttributeBase buildPartial() {
                Common.AttributeBase result = new Common.AttributeBase(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.value_ = this.value_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.isFormat_ = this.isFormat_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.nextValue_ = this.nextValue_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.minValue_ = this.minValue_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.maxValue_ = this.maxValue_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.param1_ = this.param1_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.param2_ = this.param2_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.param3_ = this.param3_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.AttributeBase)
                    return mergeFrom((Common.AttributeBase) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.AttributeBase other) {
                if (other == Common.AttributeBase.getDefaultInstance())
                    return this;
                if (other.hasId())
                    setId(other.getId());
                if (other.hasValue())
                    setValue(other.getValue());
                if (other.hasIsFormat())
                    setIsFormat(other.getIsFormat());
                if (other.hasNextValue())
                    setNextValue(other.getNextValue());
                if (other.hasMinValue())
                    setMinValue(other.getMinValue());
                if (other.hasMaxValue())
                    setMaxValue(other.getMaxValue());
                if (other.hasParam1())
                    setParam1(other.getParam1());
                if (other.hasParam2())
                    setParam2(other.getParam2());
                if (other.hasParam3())
                    setParam3(other.getParam3());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.AttributeBase parsedMessage = null;
                try {
                    parsedMessage = (Common.AttributeBase) Common.AttributeBase.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.AttributeBase) e.getUnfinishedMessage();
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

            public boolean hasValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int value) {
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.value_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsFormat() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getIsFormat() {
                return this.isFormat_;
            }

            public Builder setIsFormat(int value) {
                this.bitField0_ |= 0x4;
                this.isFormat_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFormat() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.isFormat_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNextValue() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getNextValue() {
                return this.nextValue_;
            }

            public Builder setNextValue(int value) {
                this.bitField0_ |= 0x8;
                this.nextValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextValue() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.nextValue_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMinValue() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getMinValue() {
                return this.minValue_;
            }

            public Builder setMinValue(int value) {
                this.bitField0_ |= 0x10;
                this.minValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinValue() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.minValue_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxValue() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getMaxValue() {
                return this.maxValue_;
            }

            public Builder setMaxValue(int value) {
                this.bitField0_ |= 0x20;
                this.maxValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxValue() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.maxValue_ = 0;
                onChanged();
                return this;
            }

            public boolean hasParam1() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getParam1() {
                return this.param1_;
            }

            public Builder setParam1(int value) {
                this.bitField0_ |= 0x40;
                this.param1_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam1() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.param1_ = 0;
                onChanged();
                return this;
            }

            public boolean hasParam2() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getParam2() {
                return this.param2_;
            }

            public Builder setParam2(int value) {
                this.bitField0_ |= 0x80;
                this.param2_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam2() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.param2_ = 0;
                onChanged();
                return this;
            }

            public boolean hasParam3() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getParam3() {
                return this.param3_;
            }

            public Builder setParam3(int value) {
                this.bitField0_ |= 0x100;
                this.param3_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam3() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.param3_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class AttributeSimple extends GeneratedMessage implements AttributeSimpleOrBuilder {
        private static final AttributeSimple defaultInstance = new AttributeSimple(true);
        private final UnknownFieldSet unknownFields;

        private AttributeSimple(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AttributeSimple(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AttributeSimple getDefaultInstance() {
            return defaultInstance;
        }

        public AttributeSimple getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttributeSimple(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.value_ = input.readInt32();
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
            return Common.internal_static_pomelo_AttributeSimple_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_AttributeSimple_fieldAccessorTable.ensureFieldAccessorsInitialized(AttributeSimple.class, Builder.class);
        }

        public static Parser<AttributeSimple> PARSER = (Parser<AttributeSimple>) new AbstractParser<AttributeSimple>() {
            public Common.AttributeSimple parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.AttributeSimple(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int value_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AttributeSimple> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getValue() {
            return this.value_;
        }


        private void initFields() {
            this.id_ = 0;
            this.value_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
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
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.value_);
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
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.value_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AttributeSimple parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AttributeSimple) PARSER.parseFrom(data);
        }


        public static AttributeSimple parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AttributeSimple) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AttributeSimple parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AttributeSimple) PARSER.parseFrom(data);
        }


        public static AttributeSimple parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AttributeSimple) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AttributeSimple parseFrom(InputStream input) throws IOException {
            return (AttributeSimple) PARSER.parseFrom(input);
        }


        public static AttributeSimple parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttributeSimple) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AttributeSimple parseDelimitedFrom(InputStream input) throws IOException {
            return (AttributeSimple) PARSER.parseDelimitedFrom(input);
        }


        public static AttributeSimple parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttributeSimple) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AttributeSimple parseFrom(CodedInputStream input) throws IOException {
            return (AttributeSimple) PARSER.parseFrom(input);
        }


        public static AttributeSimple parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttributeSimple) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AttributeSimple prototype) {
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
                implements Common.AttributeSimpleOrBuilder {
            private int bitField0_;


            private int id_;


            private int value_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_AttributeSimple_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_AttributeSimple_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.AttributeSimple.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (Common.AttributeSimple.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_AttributeSimple_descriptor;
            }


            public Common.AttributeSimple getDefaultInstanceForType() {
                return Common.AttributeSimple.getDefaultInstance();
            }


            public Common.AttributeSimple build() {
                Common.AttributeSimple result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Common.AttributeSimple buildPartial() {
                Common.AttributeSimple result = new Common.AttributeSimple(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.value_ = this.value_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Common.AttributeSimple) {
                    return mergeFrom((Common.AttributeSimple) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Common.AttributeSimple other) {
                if (other == Common.AttributeSimple.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasValue()) {
                    setValue(other.getValue());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.AttributeSimple parsedMessage = null;
                try {
                    parsedMessage = (Common.AttributeSimple) Common.AttributeSimple.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.AttributeSimple) e.getUnfinishedMessage();
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


            public boolean hasValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getValue() {
                return this.value_;
            }


            public Builder setValue(int value) {
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }


            public Builder clearValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.value_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class SkillKeyStruct
            extends GeneratedMessage
            implements SkillKeyStructOrBuilder {
        private static final SkillKeyStruct defaultInstance = new SkillKeyStruct(true);
        private final UnknownFieldSet unknownFields;

        private SkillKeyStruct(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SkillKeyStruct(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SkillKeyStruct getDefaultInstance() {
            return defaultInstance;
        }

        public SkillKeyStruct getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SkillKeyStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.keyPos_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.baseSkillId_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.advancedSkillId_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.icon_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.flag_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.unlockLevel_ = input.readInt32();
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.name_ = bs;
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
            return Common.internal_static_pomelo_SkillKeyStruct_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_SkillKeyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKeyStruct.class, Builder.class);
        }

        public static Parser<SkillKeyStruct> PARSER = (Parser<SkillKeyStruct>) new AbstractParser<SkillKeyStruct>() {
            public Common.SkillKeyStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.SkillKeyStruct(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int KEYPOS_FIELD_NUMBER = 1;
        private int keyPos_;
        public static final int BASESKILLID_FIELD_NUMBER = 2;
        private int baseSkillId_;
        public static final int ADVANCEDSKILLID_FIELD_NUMBER = 3;
        private int advancedSkillId_;
        public static final int ICON_FIELD_NUMBER = 4;
        private Object icon_;
        public static final int FLAG_FIELD_NUMBER = 5;
        private int flag_;
        public static final int UNLOCKLEVEL_FIELD_NUMBER = 6;
        private int unlockLevel_;
        public static final int NAME_FIELD_NUMBER = 7;
        private Object name_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SkillKeyStruct> getParserForType() {
            return PARSER;
        }

        public boolean hasKeyPos() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getKeyPos() {
            return this.keyPos_;
        }

        public boolean hasBaseSkillId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getBaseSkillId() {
            return this.baseSkillId_;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasAdvancedSkillId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getAdvancedSkillId() {
            return this.advancedSkillId_;
        }

        public boolean hasIcon() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getIcon() {
            Object ref = this.icon_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.icon_ = s;
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

        public boolean hasFlag() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getFlag() {
            return this.flag_;
        }

        public boolean hasUnlockLevel() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getUnlockLevel() {
            return this.unlockLevel_;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x40) == 64);
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

        private void initFields() {
            this.keyPos_ = 0;
            this.baseSkillId_ = 0;
            this.advancedSkillId_ = 0;
            this.icon_ = "";
            this.flag_ = 0;
            this.unlockLevel_ = 0;
            this.name_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasKeyPos()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBaseSkillId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAdvancedSkillId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIcon()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFlag()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUnlockLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.keyPos_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.baseSkillId_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.advancedSkillId_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getIconBytes());
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.flag_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.unlockLevel_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeBytes(7, getNameBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.keyPos_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.baseSkillId_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.advancedSkillId_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getIconBytes());
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.flag_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.unlockLevel_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeBytesSize(7, getNameBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SkillKeyStruct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SkillKeyStruct) PARSER.parseFrom(data);
        }

        public static SkillKeyStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SkillKeyStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkillKeyStruct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SkillKeyStruct) PARSER.parseFrom(data);
        }

        public static SkillKeyStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SkillKeyStruct) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkillKeyStruct parseFrom(InputStream input) throws IOException {
            return (SkillKeyStruct) PARSER.parseFrom(input);
        }

        public static SkillKeyStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkillKeyStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SkillKeyStruct parseDelimitedFrom(InputStream input) throws IOException {
            return (SkillKeyStruct) PARSER.parseDelimitedFrom(input);
        }

        public static SkillKeyStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkillKeyStruct) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SkillKeyStruct parseFrom(CodedInputStream input) throws IOException {
            return (SkillKeyStruct) PARSER.parseFrom(input);
        }

        public static SkillKeyStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkillKeyStruct) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SkillKeyStruct prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.SkillKeyStructOrBuilder {
            private int bitField0_;
            private int keyPos_;
            private int baseSkillId_;
            private int advancedSkillId_;
            private Object icon_;
            private int flag_;
            private int unlockLevel_;
            private Object name_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_SkillKeyStruct_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_SkillKeyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.SkillKeyStruct.class, Builder.class);
            }

            private Builder() {
                this.icon_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.icon_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.SkillKeyStruct.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.keyPos_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.baseSkillId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.advancedSkillId_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.icon_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.flag_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.unlockLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_SkillKeyStruct_descriptor;
            }

            public Common.SkillKeyStruct getDefaultInstanceForType() {
                return Common.SkillKeyStruct.getDefaultInstance();
            }

            public Common.SkillKeyStruct build() {
                Common.SkillKeyStruct result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Common.SkillKeyStruct buildPartial() {
                Common.SkillKeyStruct result = new Common.SkillKeyStruct(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.keyPos_ = this.keyPos_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.baseSkillId_ = this.baseSkillId_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.advancedSkillId_ = this.advancedSkillId_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.icon_ = this.icon_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.flag_ = this.flag_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.unlockLevel_ = this.unlockLevel_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.name_ = this.name_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.SkillKeyStruct)
                    return mergeFrom((Common.SkillKeyStruct) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.SkillKeyStruct other) {
                if (other == Common.SkillKeyStruct.getDefaultInstance())
                    return this;
                if (other.hasKeyPos())
                    setKeyPos(other.getKeyPos());
                if (other.hasBaseSkillId())
                    setBaseSkillId(other.getBaseSkillId());
                if (other.hasAdvancedSkillId())
                    setAdvancedSkillId(other.getAdvancedSkillId());
                if (other.hasIcon()) {
                    this.bitField0_ |= 0x8;
                    this.icon_ = other.icon_;
                    onChanged();
                }
                if (other.hasFlag())
                    setFlag(other.getFlag());
                if (other.hasUnlockLevel())
                    setUnlockLevel(other.getUnlockLevel());
                if (other.hasName()) {
                    this.bitField0_ |= 0x40;
                    this.name_ = other.name_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasKeyPos())
                    return false;
                if (!hasBaseSkillId())
                    return false;
                if (!hasAdvancedSkillId())
                    return false;
                if (!hasIcon())
                    return false;
                if (!hasFlag())
                    return false;
                if (!hasUnlockLevel())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.SkillKeyStruct parsedMessage = null;
                try {
                    parsedMessage = (Common.SkillKeyStruct) Common.SkillKeyStruct.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.SkillKeyStruct) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasKeyPos() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getKeyPos() {
                return this.keyPos_;
            }

            public Builder setKeyPos(int value) {
                this.bitField0_ |= 0x1;
                this.keyPos_ = value;
                onChanged();
                return this;
            }

            public Builder clearKeyPos() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.keyPos_ = 0;
                onChanged();
                return this;
            }

            public boolean hasBaseSkillId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getBaseSkillId() {
                return this.baseSkillId_;
            }

            public Builder setBaseSkillId(int value) {
                this.bitField0_ |= 0x2;
                this.baseSkillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBaseSkillId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.baseSkillId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAdvancedSkillId() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getAdvancedSkillId() {
                return this.advancedSkillId_;
            }

            public Builder setAdvancedSkillId(int value) {
                this.bitField0_ |= 0x4;
                this.advancedSkillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAdvancedSkillId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.advancedSkillId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIcon() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getIcon() {
                Object ref = this.icon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.icon_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.icon_ = value;
                onChanged();
                return this;
            }

            public Builder clearIcon() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.icon_ = Common.SkillKeyStruct.getDefaultInstance().getIcon();
                onChanged();
                return this;
            }

            public Builder setIconBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.icon_ = value;
                onChanged();
                return this;
            }

            public boolean hasFlag() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getFlag() {
                return this.flag_;
            }

            public Builder setFlag(int value) {
                this.bitField0_ |= 0x10;
                this.flag_ = value;
                onChanged();
                return this;
            }

            public Builder clearFlag() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.flag_ = 0;
                onChanged();
                return this;
            }

            public boolean hasUnlockLevel() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getUnlockLevel() {
                return this.unlockLevel_;
            }

            public Builder setUnlockLevel(int value) {
                this.bitField0_ |= 0x20;
                this.unlockLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnlockLevel() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.unlockLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.name_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.name_ = Common.SkillKeyStruct.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.name_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class OpenTimeInfo extends GeneratedMessage implements OpenTimeInfoOrBuilder {
        private static final OpenTimeInfo defaultInstance = new OpenTimeInfo(true);
        private final UnknownFieldSet unknownFields;

        private OpenTimeInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenTimeInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenTimeInfo getDefaultInstance() {
            return defaultInstance;
        }

        public OpenTimeInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenTimeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.openTime_ = input.readInt64();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.closeTime_ = input.readInt64();
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
            return Common.internal_static_pomelo_OpenTimeInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_OpenTimeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenTimeInfo.class, Builder.class);
        }

        public static Parser<OpenTimeInfo> PARSER = (Parser<OpenTimeInfo>) new AbstractParser<OpenTimeInfo>() {
            public Common.OpenTimeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.OpenTimeInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int OPENTIME_FIELD_NUMBER = 1;
        private long openTime_;
        public static final int CLOSETIME_FIELD_NUMBER = 2;
        private long closeTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OpenTimeInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasOpenTime() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public long getOpenTime() {
            return this.openTime_;
        }

        public boolean hasCloseTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public long getCloseTime() {
            return this.closeTime_;
        }


        private void initFields() {
            this.openTime_ = 0L;
            this.closeTime_ = 0L;
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
                output.writeInt64(1, this.openTime_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt64(2, this.closeTime_);
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
                size += CodedOutputStream.computeInt64Size(1, this.openTime_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt64Size(2, this.closeTime_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OpenTimeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenTimeInfo) PARSER.parseFrom(data);
        }


        public static OpenTimeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenTimeInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OpenTimeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenTimeInfo) PARSER.parseFrom(data);
        }


        public static OpenTimeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenTimeInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OpenTimeInfo parseFrom(InputStream input) throws IOException {
            return (OpenTimeInfo) PARSER.parseFrom(input);
        }


        public static OpenTimeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTimeInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OpenTimeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenTimeInfo) PARSER.parseDelimitedFrom(input);
        }


        public static OpenTimeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTimeInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OpenTimeInfo parseFrom(CodedInputStream input) throws IOException {
            return (OpenTimeInfo) PARSER.parseFrom(input);
        }


        public static OpenTimeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTimeInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OpenTimeInfo prototype) {
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
                implements Common.OpenTimeInfoOrBuilder {
            private int bitField0_;


            private long openTime_;


            private long closeTime_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_OpenTimeInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_OpenTimeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.OpenTimeInfo.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (Common.OpenTimeInfo.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.openTime_ = 0L;
                this.bitField0_ &= 0xFFFFFFFE;
                this.closeTime_ = 0L;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_OpenTimeInfo_descriptor;
            }


            public Common.OpenTimeInfo getDefaultInstanceForType() {
                return Common.OpenTimeInfo.getDefaultInstance();
            }


            public Common.OpenTimeInfo build() {
                Common.OpenTimeInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Common.OpenTimeInfo buildPartial() {
                Common.OpenTimeInfo result = new Common.OpenTimeInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.openTime_ = this.openTime_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.closeTime_ = this.closeTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Common.OpenTimeInfo) {
                    return mergeFrom((Common.OpenTimeInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Common.OpenTimeInfo other) {
                if (other == Common.OpenTimeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasOpenTime()) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.hasCloseTime()) {
                    setCloseTime(other.getCloseTime());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.OpenTimeInfo parsedMessage = null;
                try {
                    parsedMessage = (Common.OpenTimeInfo) Common.OpenTimeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.OpenTimeInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasOpenTime() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public long getOpenTime() {
                return this.openTime_;
            }


            public Builder setOpenTime(long value) {
                this.bitField0_ |= 0x1;
                this.openTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearOpenTime() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.openTime_ = 0L;
                onChanged();
                return this;
            }


            public boolean hasCloseTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public long getCloseTime() {
                return this.closeTime_;
            }


            public Builder setCloseTime(long value) {
                this.bitField0_ |= 0x2;
                this.closeTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearCloseTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.closeTime_ = 0L;
                onChanged();
                return this;
            }
        }
    }


    public static final class Avatar
            extends GeneratedMessage
            implements AvatarOrBuilder {
        private static final Avatar defaultInstance = new Avatar(true);
        private final UnknownFieldSet unknownFields;

        private Avatar(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Avatar(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Avatar getDefaultInstance() {
            return defaultInstance;
        }

        public Avatar getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Avatar(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.tag_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.fileName_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.effectType_ = input.readInt32();
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
            return Common.internal_static_pomelo_Avatar_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_Avatar_fieldAccessorTable.ensureFieldAccessorsInitialized(Avatar.class, Builder.class);
        }

        public static Parser<Avatar> PARSER = (Parser<Avatar>) new AbstractParser<Avatar>() {
            public Common.Avatar parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.Avatar(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TAG_FIELD_NUMBER = 1;
        private int tag_;
        public static final int FILENAME_FIELD_NUMBER = 2;
        private Object fileName_;
        public static final int EFFECTTYPE_FIELD_NUMBER = 3;
        private int effectType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Avatar> getParserForType() {
            return PARSER;
        }

        public boolean hasTag() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTag() {
            return this.tag_;
        }

        public boolean hasFileName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getFileName() {
            Object ref = this.fileName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.fileName_ = s;
            }
            return s;
        }


        public ByteString getFileNameBytes() {
            Object ref = this.fileName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.fileName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasEffectType() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getEffectType() {
            return this.effectType_;
        }


        private void initFields() {
            this.tag_ = 0;
            this.fileName_ = "";
            this.effectType_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasTag()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFileName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasEffectType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.tag_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getFileNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.effectType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.tag_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getFileNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.effectType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Avatar parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Avatar) PARSER.parseFrom(data);
        }


        public static Avatar parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Avatar) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Avatar parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Avatar) PARSER.parseFrom(data);
        }


        public static Avatar parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Avatar) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Avatar parseFrom(InputStream input) throws IOException {
            return (Avatar) PARSER.parseFrom(input);
        }


        public static Avatar parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Avatar) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Avatar parseDelimitedFrom(InputStream input) throws IOException {
            return (Avatar) PARSER.parseDelimitedFrom(input);
        }


        public static Avatar parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Avatar) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Avatar parseFrom(CodedInputStream input) throws IOException {
            return (Avatar) PARSER.parseFrom(input);
        }


        public static Avatar parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Avatar) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Avatar prototype) {
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
                implements Common.AvatarOrBuilder {
            private int bitField0_;


            private int tag_;


            private Object fileName_;


            private int effectType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_Avatar_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_Avatar_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.Avatar.class, Builder.class);
            }


            private Builder() {
                this.fileName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.fileName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (Common.Avatar.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.tag_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.fileName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.effectType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_Avatar_descriptor;
            }


            public Common.Avatar getDefaultInstanceForType() {
                return Common.Avatar.getDefaultInstance();
            }


            public Common.Avatar build() {
                Common.Avatar result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Common.Avatar buildPartial() {
                Common.Avatar result = new Common.Avatar(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.tag_ = this.tag_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.fileName_ = this.fileName_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.effectType_ = this.effectType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Common.Avatar) {
                    return mergeFrom((Common.Avatar) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Common.Avatar other) {
                if (other == Common.Avatar.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTag()) {
                    setTag(other.getTag());
                }
                if (other.hasFileName()) {
                    this.bitField0_ |= 0x2;
                    this.fileName_ = other.fileName_;
                    onChanged();
                }
                if (other.hasEffectType()) {
                    setEffectType(other.getEffectType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasTag()) {
                    return false;
                }
                if (!hasFileName()) {
                    return false;
                }
                if (!hasEffectType()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.Avatar parsedMessage = null;
                try {
                    parsedMessage = (Common.Avatar) Common.Avatar.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.Avatar) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasTag() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getTag() {
                return this.tag_;
            }


            public Builder setTag(int value) {
                this.bitField0_ |= 0x1;
                this.tag_ = value;
                onChanged();
                return this;
            }


            public Builder clearTag() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.tag_ = 0;
                onChanged();
                return this;
            }


            public boolean hasFileName() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getFileName() {
                Object ref = this.fileName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.fileName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getFileNameBytes() {
                Object ref = this.fileName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.fileName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setFileName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.fileName_ = value;
                onChanged();
                return this;
            }


            public Builder clearFileName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.fileName_ = Common.Avatar.getDefaultInstance().getFileName();
                onChanged();
                return this;
            }


            public Builder setFileNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.fileName_ = value;
                onChanged();
                return this;
            }


            public boolean hasEffectType() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getEffectType() {
                return this.effectType_;
            }


            public Builder setEffectType(int value) {
                this.bitField0_ |= 0x4;
                this.effectType_ = value;
                onChanged();
                return this;
            }


            public Builder clearEffectType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.effectType_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ErrMsg
            extends GeneratedMessage
            implements ErrMsgOrBuilder {
        private static final ErrMsg defaultInstance = new ErrMsg(true);
        private final UnknownFieldSet unknownFields;

        private ErrMsg(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ErrMsg(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ErrMsg getDefaultInstance() {
            return defaultInstance;
        }

        public ErrMsg getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ErrMsg(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return Common.internal_static_pomelo_ErrMsg_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_ErrMsg_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrMsg.class, Builder.class);
        }

        public static Parser<ErrMsg> PARSER = (Parser<ErrMsg>) new AbstractParser<ErrMsg>() {
            public Common.ErrMsg parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.ErrMsg(input, extensionRegistry);
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

        public Parser<ErrMsg> getParserForType() {
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


        public static ErrMsg parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data);
        }


        public static ErrMsg parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ErrMsg parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data);
        }


        public static ErrMsg parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ErrMsg parseFrom(InputStream input) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input);
        }


        public static ErrMsg parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ErrMsg parseDelimitedFrom(InputStream input) throws IOException {
            return (ErrMsg) PARSER.parseDelimitedFrom(input);
        }


        public static ErrMsg parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrMsg) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ErrMsg parseFrom(CodedInputStream input) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input);
        }


        public static ErrMsg parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ErrMsg prototype) {
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
                implements Common.ErrMsgOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_ErrMsg_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_ErrMsg_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.ErrMsg.class, Builder.class);
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
                if (Common.ErrMsg.alwaysUseFieldBuilders) ;
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
                return Common.internal_static_pomelo_ErrMsg_descriptor;
            }


            public Common.ErrMsg getDefaultInstanceForType() {
                return Common.ErrMsg.getDefaultInstance();
            }


            public Common.ErrMsg build() {
                Common.ErrMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Common.ErrMsg buildPartial() {
                Common.ErrMsg result = new Common.ErrMsg(this);
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
                if (other instanceof Common.ErrMsg) {
                    return mergeFrom((Common.ErrMsg) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Common.ErrMsg other) {
                if (other == Common.ErrMsg.getDefaultInstance()) {
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
                Common.ErrMsg parsedMessage = null;
                try {
                    parsedMessage = (Common.ErrMsg) Common.ErrMsg.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.ErrMsg) e.getUnfinishedMessage();
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
                this.s2CMsg_ = Common.ErrMsg.getDefaultInstance().getS2CMsg();
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


    public static final class DemonTowerFloorInfo
            extends GeneratedMessage
            implements DemonTowerFloorInfoOrBuilder {
        private static final DemonTowerFloorInfo defaultInstance = new DemonTowerFloorInfo(true);
        private final UnknownFieldSet unknownFields;

        private DemonTowerFloorInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DemonTowerFloorInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DemonTowerFloorInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DemonTowerFloorInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DemonTowerFloorInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.floorId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.firstPlayerName_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.firstPlayerDate_ = input.readInt64();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.fastPlayerName_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.fastPlayerTime_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.myFastTime_ = input.readInt32();
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
            return Common.internal_static_pomelo_DemonTowerFloorInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_DemonTowerFloorInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerFloorInfo.class, Builder.class);
        }

        public static Parser<DemonTowerFloorInfo> PARSER = (Parser<DemonTowerFloorInfo>) new AbstractParser<DemonTowerFloorInfo>() {
            public Common.DemonTowerFloorInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.DemonTowerFloorInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int FLOORID_FIELD_NUMBER = 1;
        private int floorId_;
        public static final int FIRSTPLAYERNAME_FIELD_NUMBER = 2;
        private Object firstPlayerName_;
        public static final int FIRSTPLAYERDATE_FIELD_NUMBER = 3;
        private long firstPlayerDate_;
        public static final int FASTPLAYERNAME_FIELD_NUMBER = 4;
        private Object fastPlayerName_;
        public static final int FASTPLAYERTIME_FIELD_NUMBER = 5;
        private int fastPlayerTime_;
        public static final int MYFASTTIME_FIELD_NUMBER = 6;
        private int myFastTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DemonTowerFloorInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasFloorId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getFloorId() {
            return this.floorId_;
        }

        public boolean hasFirstPlayerName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getFirstPlayerName() {
            Object ref = this.firstPlayerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.firstPlayerName_ = s;
            return s;
        }

        public ByteString getFirstPlayerNameBytes() {
            Object ref = this.firstPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.firstPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasFirstPlayerDate() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public long getFirstPlayerDate() {
            return this.firstPlayerDate_;
        }

        public boolean hasFastPlayerName() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getFastPlayerName() {
            Object ref = this.fastPlayerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.fastPlayerName_ = s;
            return s;
        }

        public ByteString getFastPlayerNameBytes() {
            Object ref = this.fastPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.fastPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasFastPlayerTime() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getFastPlayerTime() {
            return this.fastPlayerTime_;
        }

        public boolean hasMyFastTime() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getMyFastTime() {
            return this.myFastTime_;
        }

        private void initFields() {
            this.floorId_ = 0;
            this.firstPlayerName_ = "";
            this.firstPlayerDate_ = 0L;
            this.fastPlayerName_ = "";
            this.fastPlayerTime_ = 0;
            this.myFastTime_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasFloorId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.floorId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getFirstPlayerNameBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeInt64(3, this.firstPlayerDate_);
            if ((this.bitField0_ & 0x8) == 8) output.writeBytes(4, getFastPlayerNameBytes());
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.fastPlayerTime_);
            if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.myFastTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.floorId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getFirstPlayerNameBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt64Size(3, this.firstPlayerDate_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(4, getFastPlayerNameBytes());
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.fastPlayerTime_);
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.myFastTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DemonTowerFloorInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(data);
        }

        public static DemonTowerFloorInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DemonTowerFloorInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(data);
        }

        public static DemonTowerFloorInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DemonTowerFloorInfo parseFrom(InputStream input) throws IOException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(input);
        }

        public static DemonTowerFloorInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DemonTowerFloorInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DemonTowerFloorInfo) PARSER.parseDelimitedFrom(input);
        }

        public static DemonTowerFloorInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DemonTowerFloorInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DemonTowerFloorInfo parseFrom(CodedInputStream input) throws IOException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(input);
        }

        public static DemonTowerFloorInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DemonTowerFloorInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DemonTowerFloorInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        static {
            defaultInstance.initFields();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.DemonTowerFloorInfoOrBuilder {
            private int bitField0_;
            private int floorId_;
            private Object firstPlayerName_;
            private long firstPlayerDate_;
            private Object fastPlayerName_;
            private int fastPlayerTime_;
            private int myFastTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_DemonTowerFloorInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_DemonTowerFloorInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.DemonTowerFloorInfo.class, Builder.class);
            }

            private Builder() {
                this.firstPlayerName_ = "";
                this.fastPlayerName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.firstPlayerName_ = "";
                this.fastPlayerName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Common.DemonTowerFloorInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.floorId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.firstPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.firstPlayerDate_ = 0L;
                this.bitField0_ &= 0xFFFFFFFB;
                this.fastPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.fastPlayerTime_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.myFastTime_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_DemonTowerFloorInfo_descriptor;
            }

            public Common.DemonTowerFloorInfo getDefaultInstanceForType() {
                return Common.DemonTowerFloorInfo.getDefaultInstance();
            }

            public Common.DemonTowerFloorInfo build() {
                Common.DemonTowerFloorInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Common.DemonTowerFloorInfo buildPartial() {
                Common.DemonTowerFloorInfo result = new Common.DemonTowerFloorInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.floorId_ = this.floorId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.firstPlayerName_ = this.firstPlayerName_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.firstPlayerDate_ = this.firstPlayerDate_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.fastPlayerName_ = this.fastPlayerName_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.fastPlayerTime_ = this.fastPlayerTime_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.myFastTime_ = this.myFastTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.DemonTowerFloorInfo)
                    return mergeFrom((Common.DemonTowerFloorInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.DemonTowerFloorInfo other) {
                if (other == Common.DemonTowerFloorInfo.getDefaultInstance())
                    return this;
                if (other.hasFloorId())
                    setFloorId(other.getFloorId());
                if (other.hasFirstPlayerName()) {
                    this.bitField0_ |= 0x2;
                    this.firstPlayerName_ = other.firstPlayerName_;
                    onChanged();
                }
                if (other.hasFirstPlayerDate())
                    setFirstPlayerDate(other.getFirstPlayerDate());
                if (other.hasFastPlayerName()) {
                    this.bitField0_ |= 0x8;
                    this.fastPlayerName_ = other.fastPlayerName_;
                    onChanged();
                }
                if (other.hasFastPlayerTime())
                    setFastPlayerTime(other.getFastPlayerTime());
                if (other.hasMyFastTime())
                    setMyFastTime(other.getMyFastTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasFloorId())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.DemonTowerFloorInfo parsedMessage = null;
                try {
                    parsedMessage = (Common.DemonTowerFloorInfo) Common.DemonTowerFloorInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.DemonTowerFloorInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasFloorId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getFloorId() {
                return this.floorId_;
            }

            public Builder setFloorId(int value) {
                this.bitField0_ |= 0x1;
                this.floorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFloorId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.floorId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFirstPlayerName() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getFirstPlayerName() {
                Object ref = this.firstPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.firstPlayerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFirstPlayerNameBytes() {
                Object ref = this.firstPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.firstPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFirstPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.firstPlayerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearFirstPlayerName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.firstPlayerName_ = Common.DemonTowerFloorInfo.getDefaultInstance().getFirstPlayerName();
                onChanged();
                return this;
            }

            public Builder setFirstPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.firstPlayerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasFirstPlayerDate() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public long getFirstPlayerDate() {
                return this.firstPlayerDate_;
            }

            public Builder setFirstPlayerDate(long value) {
                this.bitField0_ |= 0x4;
                this.firstPlayerDate_ = value;
                onChanged();
                return this;
            }

            public Builder clearFirstPlayerDate() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.firstPlayerDate_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasFastPlayerName() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getFastPlayerName() {
                Object ref = this.fastPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.fastPlayerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFastPlayerNameBytes() {
                Object ref = this.fastPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.fastPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFastPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.fastPlayerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearFastPlayerName() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.fastPlayerName_ = Common.DemonTowerFloorInfo.getDefaultInstance().getFastPlayerName();
                onChanged();
                return this;
            }

            public Builder setFastPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.fastPlayerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasFastPlayerTime() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getFastPlayerTime() {
                return this.fastPlayerTime_;
            }

            public Builder setFastPlayerTime(int value) {
                this.bitField0_ |= 0x10;
                this.fastPlayerTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFastPlayerTime() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.fastPlayerTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMyFastTime() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getMyFastTime() {
                return this.myFastTime_;
            }

            public Builder setMyFastTime(int value) {
                this.bitField0_ |= 0x20;
                this.myFastTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearMyFastTime() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.myFastTime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\fcommon.proto\022\006pomelo\"\006\n\004Void\"V\n\024EffectPropertyStruct\022\017\n\007describ\030\001 \002(\t\022\r\n\005value\030\002 \001(\005\022\020\n\bmaxValue\030\003 \001(\t\022\f\n\004name\030\004 \001(\t\",\n\016KeyValueStruct\022\013\n\003key\030\001 \002(\t\022\r\n\005value\030\002 \002(\t\"q\n\016PropertyStruct\022\013\n\003key\030\001 \002(\t\022\r\n\005value\030\002 \002(\t\022\f\n\004type\030\003 \002(\005\022\016\n\006source\030\004 \001(\005\022%\n\005items\030\005 \003(\0132\026.pomelo.KeyValueStruct\"C\n\016ObjectProperty\022\n\n\002id\030\001 \002(\005\022%\n\005props\030\002 \003(\0132\026.pomelo.PropertyStruct\"£\001\n\rAttributeBase\022\n\n\002id\030\001 \002(\005\022\r\n\005value\030\002 \001(\005\022\020\n\bisF", "ormat\030\003 \001(\005\022\021\n\tnextValue\030\004 \001(\005\022\020\n\bminValue\030\005 \001(\005\022\020\n\bmaxValue\030\006 \001(\005\022\016\n\006param1\030\007 \001(\005\022\016\n\006param2\030\b \001(\005\022\016\n\006param3\030\t \001(\005\",\n\017AttributeSimple\022\n\n\002id\030\001 \002(\005\022\r\n\005value\030\002 \001(\005\"\001\n\016SkillKeyStruct\022\016\n\006keyPos\030\001 \002(\005\022\023\n\013baseSkillId\030\002 \002(\005\022\027\n\017advancedSkillId\030\003 \002(\005\022\f\n\004icon\030\004 \002(\t\022\f\n\004flag\030\005 \002(\005\022\023\n\013unlockLevel\030\006 \002(\005\022\f\n\004name\030\007 \001(\t\"3\n\fOpenTimeInfo\022\020\n\bopenTime\030\001 \001(\003\022\021\n\tcloseTime\030\002 \001(\003\";\n\006Avatar\022\013\n\003tag\030\001 \002(\005\022\020\n\bfileName\030\002 \002(\t\022\022", "\n\neffectType\030\003 \002(\005\"+\n\006ErrMsg\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\001\n\023DemonTowerFloorInfo\022\017\n\007floorId\030\001 \002(\005\022\027\n\017firstPlayerName\030\002 \001(\t\022\027\n\017firstPlayerDate\030\003 \001(\003\022\026\n\016fastPlayerName\030\004 \001(\t\022\026\n\016fastPlayerTime\030\005 \001(\005\022\022\n\nmyFastTime\030\006 \001(\005"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                Common.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_Void_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_Void_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_Void_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_EffectPropertyStruct_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_EffectPropertyStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_EffectPropertyStruct_descriptor, new String[]{"Describ", "Value", "MaxValue", "Name"});


    private static final Descriptors.Descriptor internal_static_pomelo_KeyValueStruct_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_KeyValueStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_KeyValueStruct_descriptor, new String[]{"Key", "Value"});


    private static final Descriptors.Descriptor internal_static_pomelo_PropertyStruct_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_PropertyStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_PropertyStruct_descriptor, new String[]{"Key", "Value", "Type", "Source", "Items"});


    private static final Descriptors.Descriptor internal_static_pomelo_ObjectProperty_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_ObjectProperty_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_ObjectProperty_descriptor, new String[]{"Id", "Props"});


    private static final Descriptors.Descriptor internal_static_pomelo_AttributeBase_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_AttributeBase_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_AttributeBase_descriptor, new String[]{"Id", "Value", "IsFormat", "NextValue", "MinValue", "MaxValue", "Param1", "Param2", "Param3"});


    private static final Descriptors.Descriptor internal_static_pomelo_AttributeSimple_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_AttributeSimple_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_AttributeSimple_descriptor, new String[]{"Id", "Value"});


    private static final Descriptors.Descriptor internal_static_pomelo_SkillKeyStruct_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_SkillKeyStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_SkillKeyStruct_descriptor, new String[]{"KeyPos", "BaseSkillId", "AdvancedSkillId", "Icon", "Flag", "UnlockLevel", "Name"});


    private static final Descriptors.Descriptor internal_static_pomelo_OpenTimeInfo_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_OpenTimeInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_OpenTimeInfo_descriptor, new String[]{"OpenTime", "CloseTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_Avatar_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_Avatar_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_Avatar_descriptor, new String[]{"Tag", "FileName", "EffectType"});


    private static final Descriptors.Descriptor internal_static_pomelo_ErrMsg_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_ErrMsg_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_ErrMsg_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_DemonTowerFloorInfo_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_DemonTowerFloorInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_DemonTowerFloorInfo_descriptor, new String[]{"FloorId", "FirstPlayerName", "FirstPlayerDate", "FastPlayerName", "FastPlayerTime", "MyFastTime"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface DemonTowerFloorInfoOrBuilder extends MessageOrBuilder {
        boolean hasFloorId();

        int getFloorId();

        boolean hasFirstPlayerName();

        String getFirstPlayerName();

        ByteString getFirstPlayerNameBytes();

        boolean hasFirstPlayerDate();

        long getFirstPlayerDate();

        boolean hasFastPlayerName();

        String getFastPlayerName();

        ByteString getFastPlayerNameBytes();

        boolean hasFastPlayerTime();

        int getFastPlayerTime();

        boolean hasMyFastTime();

        int getMyFastTime();
    }

    public static interface ErrMsgOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AvatarOrBuilder extends MessageOrBuilder {
        boolean hasTag();

        int getTag();

        boolean hasFileName();

        String getFileName();

        ByteString getFileNameBytes();

        boolean hasEffectType();

        int getEffectType();
    }

    public static interface OpenTimeInfoOrBuilder extends MessageOrBuilder {
        boolean hasOpenTime();

        long getOpenTime();

        boolean hasCloseTime();

        long getCloseTime();
    }

    public static interface SkillKeyStructOrBuilder extends MessageOrBuilder {
        boolean hasKeyPos();

        int getKeyPos();

        boolean hasBaseSkillId();

        int getBaseSkillId();

        boolean hasAdvancedSkillId();

        int getAdvancedSkillId();

        boolean hasIcon();

        String getIcon();

        ByteString getIconBytes();

        boolean hasFlag();

        int getFlag();

        boolean hasUnlockLevel();

        int getUnlockLevel();

        boolean hasName();

        String getName();

        ByteString getNameBytes();
    }

    public static interface AttributeSimpleOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasValue();

        int getValue();
    }

    public static interface AttributeBaseOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasValue();

        int getValue();

        boolean hasIsFormat();

        int getIsFormat();

        boolean hasNextValue();

        int getNextValue();

        boolean hasMinValue();

        int getMinValue();

        boolean hasMaxValue();

        int getMaxValue();

        boolean hasParam1();

        int getParam1();

        boolean hasParam2();

        int getParam2();

        boolean hasParam3();

        int getParam3();
    }

    public static interface ObjectPropertyOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        List<Common.PropertyStruct> getPropsList();

        Common.PropertyStruct getProps(int param1Int);

        int getPropsCount();

        List<? extends Common.PropertyStructOrBuilder> getPropsOrBuilderList();

        Common.PropertyStructOrBuilder getPropsOrBuilder(int param1Int);
    }

    public static interface PropertyStructOrBuilder extends MessageOrBuilder {
        boolean hasKey();

        String getKey();

        ByteString getKeyBytes();

        boolean hasValue();

        String getValue();

        ByteString getValueBytes();

        boolean hasType();

        int getType();

        boolean hasSource();

        int getSource();

        List<Common.KeyValueStruct> getItemsList();

        Common.KeyValueStruct getItems(int param1Int);

        int getItemsCount();

        List<? extends Common.KeyValueStructOrBuilder> getItemsOrBuilderList();

        Common.KeyValueStructOrBuilder getItemsOrBuilder(int param1Int);
    }

    public static interface KeyValueStructOrBuilder extends MessageOrBuilder {
        boolean hasKey();

        String getKey();

        ByteString getKeyBytes();

        boolean hasValue();

        String getValue();

        ByteString getValueBytes();
    }

    public static interface EffectPropertyStructOrBuilder extends MessageOrBuilder {
        boolean hasDescrib();

        String getDescrib();

        ByteString getDescribBytes();

        boolean hasValue();

        int getValue();

        boolean hasMaxValue();

        String getMaxValue();

        ByteString getMaxValueBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();
    }

    public static interface VoidOrBuilder extends MessageOrBuilder {
    }
}


