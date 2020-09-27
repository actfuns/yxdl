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


public final class MapHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class MapUnit
            extends GeneratedMessage
            implements MapUnitOrBuilder {
        private static final MapUnit defaultInstance = new MapUnit(true);
        private final UnknownFieldSet unknownFields;

        private MapUnit(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MapUnit(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MapUnit getDefaultInstance() {
            return defaultInstance;
        }

        public MapUnit getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MapUnit(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.templateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.x_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.y_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.name_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.type_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.lv_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.force_ = input.readInt32();
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
            return MapHandler.internal_static_pomelo_area_MapUnit_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_MapUnit_fieldAccessorTable.ensureFieldAccessorsInitialized(MapUnit.class, Builder.class);
        }

        public static Parser<MapUnit> PARSER = (Parser<MapUnit>) new AbstractParser<MapUnit>() {
            public MapHandler.MapUnit parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.MapUnit(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TEMPLATEID_FIELD_NUMBER = 1;
        private int templateId_;
        public static final int X_FIELD_NUMBER = 2;
        private int x_;
        public static final int Y_FIELD_NUMBER = 3;
        private int y_;
        public static final int NAME_FIELD_NUMBER = 4;
        private Object name_;
        public static final int TYPE_FIELD_NUMBER = 5;
        private int type_;
        public static final int LV_FIELD_NUMBER = 6;
        private int lv_;
        public static final int FORCE_FIELD_NUMBER = 7;
        private int force_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MapUnit> getParserForType() {
            return PARSER;
        }

        public boolean hasTemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTemplateId() {
            return this.templateId_;
        }

        public boolean hasX() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getX() {
            return this.x_;
        }

        public boolean hasY() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getY() {
            return this.y_;
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

        public boolean hasType() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasLv() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getLv() {
            return this.lv_;
        }

        public boolean hasForce() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getForce() {
            return this.force_;
        }

        private void initFields() {
            this.templateId_ = 0;
            this.x_ = 0;
            this.y_ = 0;
            this.name_ = "";
            this.type_ = 0;
            this.lv_ = 0;
            this.force_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasTemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasX()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasY()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.templateId_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.x_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.y_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getNameBytes());
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.type_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.lv_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.force_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.templateId_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.x_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.y_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getNameBytes());
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.type_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.lv_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.force_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MapUnit parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MapUnit) PARSER.parseFrom(data);
        }

        public static MapUnit parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MapUnit) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MapUnit parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MapUnit) PARSER.parseFrom(data);
        }

        public static MapUnit parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MapUnit) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MapUnit parseFrom(InputStream input) throws IOException {
            return (MapUnit) PARSER.parseFrom(input);
        }

        public static MapUnit parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MapUnit) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MapUnit parseDelimitedFrom(InputStream input) throws IOException {
            return (MapUnit) PARSER.parseDelimitedFrom(input);
        }

        public static MapUnit parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MapUnit) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MapUnit parseFrom(CodedInputStream input) throws IOException {
            return (MapUnit) PARSER.parseFrom(input);
        }

        public static MapUnit parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MapUnit) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MapUnit prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.MapUnitOrBuilder {
            private int bitField0_;
            private int templateId_;
            private int x_;
            private int y_;
            private Object name_;
            private int type_;
            private int lv_;
            private int force_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_MapUnit_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_MapUnit_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.MapUnit.class, Builder.class);
            }

            private Builder() {
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.MapUnit.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.templateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.x_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.y_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.lv_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.force_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_MapUnit_descriptor;
            }

            public MapHandler.MapUnit getDefaultInstanceForType() {
                return MapHandler.MapUnit.getDefaultInstance();
            }

            public MapHandler.MapUnit build() {
                MapHandler.MapUnit result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.MapUnit buildPartial() {
                MapHandler.MapUnit result = new MapHandler.MapUnit(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.templateId_ = this.templateId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.x_ = this.x_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.y_ = this.y_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.lv_ = this.lv_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.force_ = this.force_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.MapUnit)
                    return mergeFrom((MapHandler.MapUnit) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.MapUnit other) {
                if (other == MapHandler.MapUnit.getDefaultInstance())
                    return this;
                if (other.hasTemplateId())
                    setTemplateId(other.getTemplateId());
                if (other.hasX())
                    setX(other.getX());
                if (other.hasY())
                    setY(other.getY());
                if (other.hasName()) {
                    this.bitField0_ |= 0x8;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasType())
                    setType(other.getType());
                if (other.hasLv())
                    setLv(other.getLv());
                if (other.hasForce())
                    setForce(other.getForce());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTemplateId())
                    return false;
                if (!hasX())
                    return false;
                if (!hasY())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.MapUnit parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.MapUnit) MapHandler.MapUnit.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.MapUnit) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
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

            public boolean hasX() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getX() {
                return this.x_;
            }

            public Builder setX(int value) {
                this.bitField0_ |= 0x2;
                this.x_ = value;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.x_ = 0;
                onChanged();
                return this;
            }

            public boolean hasY() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getY() {
                return this.y_;
            }

            public Builder setY(int value) {
                this.bitField0_ |= 0x4;
                this.y_ = value;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.y_ = 0;
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
                this.name_ = MapHandler.MapUnit.getDefaultInstance().getName();
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

            public boolean hasType() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x10;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLv() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getLv() {
                return this.lv_;
            }

            public Builder setLv(int value) {
                this.bitField0_ |= 0x20;
                this.lv_ = value;
                onChanged();
                return this;
            }

            public Builder clearLv() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.lv_ = 0;
                onChanged();
                return this;
            }

            public boolean hasForce() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getForce() {
                return this.force_;
            }

            public Builder setForce(int value) {
                this.bitField0_ |= 0x40;
                this.force_ = value;
                onChanged();
                return this;
            }

            public Builder clearForce() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.force_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class WorldMap extends GeneratedMessage implements WorldMapOrBuilder {
        private static final WorldMap defaultInstance = new WorldMap(true);
        private final UnknownFieldSet unknownFields;

        private WorldMap(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WorldMap(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WorldMap getDefaultInstance() {
            return defaultInstance;
        }

        public WorldMap getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldMap(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.isOpen_ = input.readInt32();
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
            return MapHandler.internal_static_pomelo_area_WorldMap_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_WorldMap_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldMap.class, Builder.class);
        }

        public static Parser<WorldMap> PARSER = (Parser<WorldMap>) new AbstractParser<WorldMap>() {
            public MapHandler.WorldMap parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.WorldMap(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ISOPEN_FIELD_NUMBER = 2;
        private int isOpen_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WorldMap> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasIsOpen() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getIsOpen() {
            return this.isOpen_;
        }

        private void initFields() {
            this.id_ = 0;
            this.isOpen_ = 0;
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
            if (!hasIsOpen()) {
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
                output.writeInt32(2, this.isOpen_);
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
                size += CodedOutputStream.computeInt32Size(2, this.isOpen_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static WorldMap parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WorldMap) PARSER.parseFrom(data);
        }

        public static WorldMap parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldMap) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldMap parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WorldMap) PARSER.parseFrom(data);
        }

        public static WorldMap parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldMap) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldMap parseFrom(InputStream input) throws IOException {
            return (WorldMap) PARSER.parseFrom(input);
        }

        public static WorldMap parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldMap) PARSER.parseFrom(input, extensionRegistry);
        }

        public static WorldMap parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldMap) PARSER.parseDelimitedFrom(input);
        }

        public static WorldMap parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldMap) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static WorldMap parseFrom(CodedInputStream input) throws IOException {
            return (WorldMap) PARSER.parseFrom(input);
        }

        public static WorldMap parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldMap) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(WorldMap prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.WorldMapOrBuilder {
            private int bitField0_;
            private int id_;
            private int isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_WorldMap_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_WorldMap_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.WorldMap.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.WorldMap.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.isOpen_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_WorldMap_descriptor;
            }

            public MapHandler.WorldMap getDefaultInstanceForType() {
                return MapHandler.WorldMap.getDefaultInstance();
            }

            public MapHandler.WorldMap build() {
                MapHandler.WorldMap result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.WorldMap buildPartial() {
                MapHandler.WorldMap result = new MapHandler.WorldMap(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.isOpen_ = this.isOpen_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.WorldMap)
                    return mergeFrom((MapHandler.WorldMap) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.WorldMap other) {
                if (other == MapHandler.WorldMap.getDefaultInstance())
                    return this;
                if (other.hasId())
                    setId(other.getId());
                if (other.hasIsOpen())
                    setIsOpen(other.getIsOpen());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasIsOpen())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.WorldMap parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.WorldMap) MapHandler.WorldMap.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.WorldMap) e.getUnfinishedMessage();
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

            public boolean hasIsOpen() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(int value) {
                this.bitField0_ |= 0x2;
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.isOpen_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetWorldMapListRequest extends GeneratedMessage implements GetWorldMapListRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private GetWorldMapListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetWorldMapListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetWorldMapListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetWorldMapListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetWorldMapListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MapHandler.internal_static_pomelo_area_GetWorldMapListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetWorldMapListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWorldMapListRequest.class, Builder.class);
        }

        public static Parser<GetWorldMapListRequest> PARSER = (Parser<GetWorldMapListRequest>) new AbstractParser<GetWorldMapListRequest>() {
            public MapHandler.GetWorldMapListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetWorldMapListRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetWorldMapListRequest> getParserForType() {
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

        private static final GetWorldMapListRequest defaultInstance = new GetWorldMapListRequest(true);

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetWorldMapListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetWorldMapListRequest) PARSER.parseFrom(data);
        }

        public static GetWorldMapListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWorldMapListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMapListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetWorldMapListRequest) PARSER.parseFrom(data);
        }

        public static GetWorldMapListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWorldMapListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMapListRequest parseFrom(InputStream input) throws IOException {
            return (GetWorldMapListRequest) PARSER.parseFrom(input);
        }

        public static GetWorldMapListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMapListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetWorldMapListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetWorldMapListRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetWorldMapListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMapListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetWorldMapListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetWorldMapListRequest) PARSER.parseFrom(input);
        }

        public static GetWorldMapListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMapListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetWorldMapListRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetWorldMapListRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetWorldMapListRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetWorldMapListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetWorldMapListRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetWorldMapListRequest.alwaysUseFieldBuilders) ;
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
                return MapHandler.internal_static_pomelo_area_GetWorldMapListRequest_descriptor;
            }

            public MapHandler.GetWorldMapListRequest getDefaultInstanceForType() {
                return MapHandler.GetWorldMapListRequest.getDefaultInstance();
            }

            public MapHandler.GetWorldMapListRequest build() {
                MapHandler.GetWorldMapListRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetWorldMapListRequest buildPartial() {
                MapHandler.GetWorldMapListRequest result = new MapHandler.GetWorldMapListRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetWorldMapListRequest)
                    return mergeFrom((MapHandler.GetWorldMapListRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetWorldMapListRequest other) {
                if (other == MapHandler.GetWorldMapListRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetWorldMapListRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetWorldMapListRequest) MapHandler.GetWorldMapListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetWorldMapListRequest) e.getUnfinishedMessage();
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


    public static final class GetWorldMapListResponse
            extends GeneratedMessage
            implements GetWorldMapListResponseOrBuilder {
        private static final GetWorldMapListResponse defaultInstance = new GetWorldMapListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetWorldMapListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetWorldMapListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetWorldMapListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetWorldMapListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetWorldMapListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.data_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.data_.add(input.readMessage(MapHandler.WorldMap.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.data_ = Collections.unmodifiableList(this.data_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MapHandler.internal_static_pomelo_area_GetWorldMapListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetWorldMapListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWorldMapListResponse.class, Builder.class);
        }

        public static Parser<GetWorldMapListResponse> PARSER = (Parser<GetWorldMapListResponse>) new AbstractParser<GetWorldMapListResponse>() {
            public MapHandler.GetWorldMapListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetWorldMapListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int DATA_FIELD_NUMBER = 3;
        private List<MapHandler.WorldMap> data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetWorldMapListResponse> getParserForType() {
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

        public List<MapHandler.WorldMap> getDataList() {
            return this.data_;
        }

        public List<? extends MapHandler.WorldMapOrBuilder> getDataOrBuilderList() {
            return (List) this.data_;
        }

        public int getDataCount() {
            return this.data_.size();
        }

        public MapHandler.WorldMap getData(int index) {
            return this.data_.get(index);
        }

        public MapHandler.WorldMapOrBuilder getDataOrBuilder(int index) {
            return this.data_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.data_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getDataCount(); i++) {
                if (!getData(i).isInitialized()) {
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
            for (int i = 0; i < this.data_.size(); i++) output.writeMessage(3, (MessageLite) this.data_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.data_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.data_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetWorldMapListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetWorldMapListResponse) PARSER.parseFrom(data);
        }

        public static GetWorldMapListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWorldMapListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMapListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetWorldMapListResponse) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static GetWorldMapListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWorldMapListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMapListResponse parseFrom(InputStream input) throws IOException {
            return (GetWorldMapListResponse) PARSER.parseFrom(input);
        }

        public static GetWorldMapListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMapListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetWorldMapListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetWorldMapListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetWorldMapListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMapListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetWorldMapListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetWorldMapListResponse) PARSER.parseFrom(input);
        }

        public static GetWorldMapListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMapListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetWorldMapListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetWorldMapListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<MapHandler.WorldMap> data_;
            private RepeatedFieldBuilder<MapHandler.WorldMap, MapHandler.WorldMap.Builder, MapHandler.WorldMapOrBuilder> dataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetWorldMapListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetWorldMapListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetWorldMapListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetWorldMapListResponse.alwaysUseFieldBuilders)
                    getDataFieldBuilder();
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
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetWorldMapListResponse_descriptor;
            }

            public MapHandler.GetWorldMapListResponse getDefaultInstanceForType() {
                return MapHandler.GetWorldMapListResponse.getDefaultInstance();
            }

            public MapHandler.GetWorldMapListResponse build() {
                MapHandler.GetWorldMapListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetWorldMapListResponse buildPartial() {
                MapHandler.GetWorldMapListResponse result = new MapHandler.GetWorldMapListResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.dataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.data_ = this.data_;
                } else {
                    result.data_ = this.dataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetWorldMapListResponse)
                    return mergeFrom((MapHandler.GetWorldMapListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetWorldMapListResponse other) {
                if (other == MapHandler.GetWorldMapListResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.dataBuilder_ == null) {
                    if (!other.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = other.data_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(other.data_);
                        }
                        onChanged();
                    }
                } else if (!other.data_.isEmpty()) {
                    if (this.dataBuilder_.isEmpty()) {
                        this.dataBuilder_.dispose();
                        this.dataBuilder_ = null;
                        this.data_ = other.data_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.dataBuilder_ = MapHandler.GetWorldMapListResponse.alwaysUseFieldBuilders ? getDataFieldBuilder() : null;
                    } else {
                        this.dataBuilder_.addAllMessages(other.data_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getDataCount(); i++) {
                    if (!getData(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetWorldMapListResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetWorldMapListResponse) MapHandler.GetWorldMapListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetWorldMapListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GetWorldMapListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.data_ = new ArrayList<>(this.data_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<MapHandler.WorldMap> getDataList() {
                if (this.dataBuilder_ == null)
                    return Collections.unmodifiableList(this.data_);
                return this.dataBuilder_.getMessageList();
            }

            public int getDataCount() {
                if (this.dataBuilder_ == null)
                    return this.data_.size();
                return this.dataBuilder_.getCount();
            }

            public MapHandler.WorldMap getData(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.WorldMap) this.dataBuilder_.getMessage(index);
            }

            public Builder setData(int index, MapHandler.WorldMap value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.set(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setData(int index, MapHandler.WorldMap.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addData(MapHandler.WorldMap value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addData(int index, MapHandler.WorldMap value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addData(MapHandler.WorldMap.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addData(int index, MapHandler.WorldMap.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllData(Iterable<? extends MapHandler.WorldMap> values) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.data_);
                    onChanged();
                } else {
                    this.dataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder removeData(int index) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.remove(index);
                    onChanged();
                } else {
                    this.dataBuilder_.remove(index);
                }
                return this;
            }

            public MapHandler.WorldMap.Builder getDataBuilder(int index) {
                return (MapHandler.WorldMap.Builder) getDataFieldBuilder().getBuilder(index);
            }

            public MapHandler.WorldMapOrBuilder getDataOrBuilder(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.WorldMapOrBuilder) this.dataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MapHandler.WorldMapOrBuilder> getDataOrBuilderList() {
                if (this.dataBuilder_ != null)
                    return this.dataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.data_);
            }

            public MapHandler.WorldMap.Builder addDataBuilder() {
                return (MapHandler.WorldMap.Builder) getDataFieldBuilder().addBuilder(MapHandler.WorldMap.getDefaultInstance());
            }

            public MapHandler.WorldMap.Builder addDataBuilder(int index) {
                return (MapHandler.WorldMap.Builder) getDataFieldBuilder().addBuilder(index, MapHandler.WorldMap.getDefaultInstance());
            }

            public List<MapHandler.WorldMap.Builder> getDataBuilderList() {
                return getDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MapHandler.WorldMap, MapHandler.WorldMap.Builder, MapHandler.WorldMapOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new RepeatedFieldBuilder(this.data_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }
        }
    }

    public static final class GetPlayerListRequest extends GeneratedMessage implements GetPlayerListRequestOrBuilder {
        private static final GetPlayerListRequest defaultInstance = new GetPlayerListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetPlayerListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetPlayerListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetPlayerListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetPlayerListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MapHandler.internal_static_pomelo_area_GetPlayerListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetPlayerListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerListRequest.class, Builder.class);
        }

        public static Parser<GetPlayerListRequest> PARSER = (Parser<GetPlayerListRequest>) new AbstractParser<GetPlayerListRequest>() {
            public MapHandler.GetPlayerListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetPlayerListRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetPlayerListRequest> getParserForType() {
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


        public static GetPlayerListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetPlayerListRequest) PARSER.parseFrom(data);
        }


        public static GetPlayerListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPlayerListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetPlayerListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetPlayerListRequest) PARSER.parseFrom(data);
        }


        public static GetPlayerListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPlayerListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetPlayerListRequest parseFrom(InputStream input) throws IOException {
            return (GetPlayerListRequest) PARSER.parseFrom(input);
        }


        public static GetPlayerListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetPlayerListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetPlayerListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetPlayerListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerListRequest) PARSER.parseFrom(input);
        }


        public static GetPlayerListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetPlayerListRequest prototype) {
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
                implements MapHandler.GetPlayerListRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetPlayerListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetPlayerListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetPlayerListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetPlayerListRequest.alwaysUseFieldBuilders) ;
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
                return MapHandler.internal_static_pomelo_area_GetPlayerListRequest_descriptor;
            }


            public MapHandler.GetPlayerListRequest getDefaultInstanceForType() {
                return MapHandler.GetPlayerListRequest.getDefaultInstance();
            }


            public MapHandler.GetPlayerListRequest build() {
                MapHandler.GetPlayerListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MapHandler.GetPlayerListRequest buildPartial() {
                MapHandler.GetPlayerListRequest result = new MapHandler.GetPlayerListRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetPlayerListRequest) {
                    return mergeFrom((MapHandler.GetPlayerListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MapHandler.GetPlayerListRequest other) {
                if (other == MapHandler.GetPlayerListRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetPlayerListRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetPlayerListRequest) MapHandler.GetPlayerListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetPlayerListRequest) e.getUnfinishedMessage();
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


    public static final class GetPlayerListResponse
            extends GeneratedMessage
            implements GetPlayerListResponseOrBuilder {
        private static final GetPlayerListResponse defaultInstance = new GetPlayerListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetPlayerListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetPlayerListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetPlayerListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetPlayerListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.data_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.data_.add(input.readMessage(MapHandler.MapUnit.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.data_ = Collections.unmodifiableList(this.data_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MapHandler.internal_static_pomelo_area_GetPlayerListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetPlayerListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerListResponse.class, Builder.class);
        }

        public static Parser<GetPlayerListResponse> PARSER = (Parser<GetPlayerListResponse>) new AbstractParser<GetPlayerListResponse>() {
            public MapHandler.GetPlayerListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetPlayerListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int DATA_FIELD_NUMBER = 3;
        private List<MapHandler.MapUnit> data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetPlayerListResponse> getParserForType() {
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

        public List<MapHandler.MapUnit> getDataList() {
            return this.data_;
        }

        public List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList() {
            return (List) this.data_;
        }

        public int getDataCount() {
            return this.data_.size();
        }

        public MapHandler.MapUnit getData(int index) {
            return this.data_.get(index);
        }

        public MapHandler.MapUnitOrBuilder getDataOrBuilder(int index) {
            return this.data_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.data_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getDataCount(); i++) {
                if (!getData(i).isInitialized()) {
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
            for (int i = 0; i < this.data_.size(); i++) output.writeMessage(3, (MessageLite) this.data_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.data_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.data_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetPlayerListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetPlayerListResponse) PARSER.parseFrom(data);
        }

        public static GetPlayerListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPlayerListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetPlayerListResponse) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static GetPlayerListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPlayerListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerListResponse parseFrom(InputStream input) throws IOException {
            return (GetPlayerListResponse) PARSER.parseFrom(input);
        }

        public static GetPlayerListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetPlayerListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetPlayerListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetPlayerListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerListResponse) PARSER.parseFrom(input);
        }

        public static GetPlayerListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetPlayerListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetPlayerListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<MapHandler.MapUnit> data_;
            private RepeatedFieldBuilder<MapHandler.MapUnit, MapHandler.MapUnit.Builder, MapHandler.MapUnitOrBuilder> dataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetPlayerListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetPlayerListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetPlayerListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetPlayerListResponse.alwaysUseFieldBuilders)
                    getDataFieldBuilder();
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
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetPlayerListResponse_descriptor;
            }

            public MapHandler.GetPlayerListResponse getDefaultInstanceForType() {
                return MapHandler.GetPlayerListResponse.getDefaultInstance();
            }

            public MapHandler.GetPlayerListResponse build() {
                MapHandler.GetPlayerListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetPlayerListResponse buildPartial() {
                MapHandler.GetPlayerListResponse result = new MapHandler.GetPlayerListResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.dataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.data_ = this.data_;
                } else {
                    result.data_ = this.dataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetPlayerListResponse)
                    return mergeFrom((MapHandler.GetPlayerListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetPlayerListResponse other) {
                if (other == MapHandler.GetPlayerListResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.dataBuilder_ == null) {
                    if (!other.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = other.data_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(other.data_);
                        }
                        onChanged();
                    }
                } else if (!other.data_.isEmpty()) {
                    if (this.dataBuilder_.isEmpty()) {
                        this.dataBuilder_.dispose();
                        this.dataBuilder_ = null;
                        this.data_ = other.data_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.dataBuilder_ = MapHandler.GetPlayerListResponse.alwaysUseFieldBuilders ? getDataFieldBuilder() : null;
                    } else {
                        this.dataBuilder_.addAllMessages(other.data_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getDataCount(); i++) {
                    if (!getData(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetPlayerListResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetPlayerListResponse) MapHandler.GetPlayerListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetPlayerListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GetPlayerListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.data_ = new ArrayList<>(this.data_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<MapHandler.MapUnit> getDataList() {
                if (this.dataBuilder_ == null)
                    return Collections.unmodifiableList(this.data_);
                return this.dataBuilder_.getMessageList();
            }

            public int getDataCount() {
                if (this.dataBuilder_ == null)
                    return this.data_.size();
                return this.dataBuilder_.getCount();
            }

            public MapHandler.MapUnit getData(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.MapUnit) this.dataBuilder_.getMessage(index);
            }

            public Builder setData(int index, MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.set(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setData(int index, MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addData(MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addData(int index, MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addData(MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addData(int index, MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllData(Iterable<? extends MapHandler.MapUnit> values) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.data_);
                    onChanged();
                } else {
                    this.dataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder removeData(int index) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.remove(index);
                    onChanged();
                } else {
                    this.dataBuilder_.remove(index);
                }
                return this;
            }

            public MapHandler.MapUnit.Builder getDataBuilder(int index) {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().getBuilder(index);
            }

            public MapHandler.MapUnitOrBuilder getDataOrBuilder(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.MapUnitOrBuilder) this.dataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList() {
                if (this.dataBuilder_ != null)
                    return this.dataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.data_);
            }

            public MapHandler.MapUnit.Builder addDataBuilder() {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().addBuilder(MapHandler.MapUnit.getDefaultInstance());
            }

            public MapHandler.MapUnit.Builder addDataBuilder(int index) {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().addBuilder(index, MapHandler.MapUnit.getDefaultInstance());
            }

            public List<MapHandler.MapUnit.Builder> getDataBuilderList() {
                return getDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MapHandler.MapUnit, MapHandler.MapUnit.Builder, MapHandler.MapUnitOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new RepeatedFieldBuilder(this.data_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }
        }
    }

    public static final class GetMonsterListRequest extends GeneratedMessage implements GetMonsterListRequestOrBuilder {
        private static final GetMonsterListRequest defaultInstance = new GetMonsterListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMonsterListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMonsterListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMonsterListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMonsterListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMonsterListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MapHandler.internal_static_pomelo_area_GetMonsterListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetMonsterListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMonsterListRequest.class, Builder.class);
        }

        public static Parser<GetMonsterListRequest> PARSER = (Parser<GetMonsterListRequest>) new AbstractParser<GetMonsterListRequest>() {
            public MapHandler.GetMonsterListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetMonsterListRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMonsterListRequest> getParserForType() {
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


        public static GetMonsterListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMonsterListRequest) PARSER.parseFrom(data);
        }


        public static GetMonsterListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMonsterListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMonsterListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMonsterListRequest) PARSER.parseFrom(data);
        }


        public static GetMonsterListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMonsterListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMonsterListRequest parseFrom(InputStream input) throws IOException {
            return (GetMonsterListRequest) PARSER.parseFrom(input);
        }


        public static GetMonsterListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMonsterListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMonsterListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMonsterListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetMonsterListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMonsterListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMonsterListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMonsterListRequest) PARSER.parseFrom(input);
        }


        public static GetMonsterListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMonsterListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMonsterListRequest prototype) {
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
                implements MapHandler.GetMonsterListRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetMonsterListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetMonsterListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetMonsterListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetMonsterListRequest.alwaysUseFieldBuilders) ;
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
                return MapHandler.internal_static_pomelo_area_GetMonsterListRequest_descriptor;
            }


            public MapHandler.GetMonsterListRequest getDefaultInstanceForType() {
                return MapHandler.GetMonsterListRequest.getDefaultInstance();
            }


            public MapHandler.GetMonsterListRequest build() {
                MapHandler.GetMonsterListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MapHandler.GetMonsterListRequest buildPartial() {
                MapHandler.GetMonsterListRequest result = new MapHandler.GetMonsterListRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetMonsterListRequest) {
                    return mergeFrom((MapHandler.GetMonsterListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MapHandler.GetMonsterListRequest other) {
                if (other == MapHandler.GetMonsterListRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetMonsterListRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetMonsterListRequest) MapHandler.GetMonsterListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetMonsterListRequest) e.getUnfinishedMessage();
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


    public static final class GetMonsterListResponse
            extends GeneratedMessage
            implements GetMonsterListResponseOrBuilder {
        private static final GetMonsterListResponse defaultInstance = new GetMonsterListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMonsterListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMonsterListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMonsterListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMonsterListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMonsterListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.data_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.data_.add(input.readMessage(MapHandler.MapUnit.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.data_ = Collections.unmodifiableList(this.data_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MapHandler.internal_static_pomelo_area_GetMonsterListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetMonsterListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMonsterListResponse.class, Builder.class);
        }

        public static Parser<GetMonsterListResponse> PARSER = (Parser<GetMonsterListResponse>) new AbstractParser<GetMonsterListResponse>() {
            public MapHandler.GetMonsterListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetMonsterListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int DATA_FIELD_NUMBER = 3;
        private List<MapHandler.MapUnit> data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMonsterListResponse> getParserForType() {
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

        public List<MapHandler.MapUnit> getDataList() {
            return this.data_;
        }

        public List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList() {
            return (List) this.data_;
        }

        public int getDataCount() {
            return this.data_.size();
        }

        public MapHandler.MapUnit getData(int index) {
            return this.data_.get(index);
        }

        public MapHandler.MapUnitOrBuilder getDataOrBuilder(int index) {
            return this.data_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.data_ = Collections.emptyList();
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
            for (int i = 0; i < getDataCount(); i++) {
                if (!getData(i).isInitialized()) {
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
            for (int i = 0; i < this.data_.size(); i++)
                output.writeMessage(3, (MessageLite) this.data_.get(i));
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
            for (int i = 0; i < this.data_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.data_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetMonsterListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMonsterListResponse) PARSER.parseFrom(data);
        }

        public static GetMonsterListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMonsterListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMonsterListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMonsterListResponse) PARSER.parseFrom(data);
        }

        public static GetMonsterListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMonsterListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMonsterListResponse parseFrom(InputStream input) throws IOException {
            return (GetMonsterListResponse) PARSER.parseFrom(input);
        }

        public static GetMonsterListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMonsterListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMonsterListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMonsterListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetMonsterListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMonsterListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMonsterListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMonsterListResponse) PARSER.parseFrom(input);
        }

        public static GetMonsterListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMonsterListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMonsterListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetMonsterListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<MapHandler.MapUnit> data_;
            private RepeatedFieldBuilder<MapHandler.MapUnit, MapHandler.MapUnit.Builder, MapHandler.MapUnitOrBuilder> dataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetMonsterListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetMonsterListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetMonsterListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetMonsterListResponse.alwaysUseFieldBuilders)
                    getDataFieldBuilder();
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
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetMonsterListResponse_descriptor;
            }

            public MapHandler.GetMonsterListResponse getDefaultInstanceForType() {
                return MapHandler.GetMonsterListResponse.getDefaultInstance();
            }

            public MapHandler.GetMonsterListResponse build() {
                MapHandler.GetMonsterListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetMonsterListResponse buildPartial() {
                MapHandler.GetMonsterListResponse result = new MapHandler.GetMonsterListResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.dataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.data_ = this.data_;
                } else {
                    result.data_ = this.dataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetMonsterListResponse)
                    return mergeFrom((MapHandler.GetMonsterListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetMonsterListResponse other) {
                if (other == MapHandler.GetMonsterListResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.dataBuilder_ == null) {
                    if (!other.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = other.data_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(other.data_);
                        }
                        onChanged();
                    }
                } else if (!other.data_.isEmpty()) {
                    if (this.dataBuilder_.isEmpty()) {
                        this.dataBuilder_.dispose();
                        this.dataBuilder_ = null;
                        this.data_ = other.data_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.dataBuilder_ = MapHandler.GetMonsterListResponse.alwaysUseFieldBuilders ? getDataFieldBuilder() : null;
                    } else {
                        this.dataBuilder_.addAllMessages(other.data_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getDataCount(); i++) {
                    if (!getData(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetMonsterListResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetMonsterListResponse) MapHandler.GetMonsterListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetMonsterListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GetMonsterListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.data_ = new ArrayList<>(this.data_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<MapHandler.MapUnit> getDataList() {
                if (this.dataBuilder_ == null)
                    return Collections.unmodifiableList(this.data_);
                return this.dataBuilder_.getMessageList();
            }

            public int getDataCount() {
                if (this.dataBuilder_ == null)
                    return this.data_.size();
                return this.dataBuilder_.getCount();
            }

            public MapHandler.MapUnit getData(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.MapUnit) this.dataBuilder_.getMessage(index);
            }

            public Builder setData(int index, MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.set(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setData(int index, MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addData(MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addData(int index, MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addData(MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addData(int index, MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllData(Iterable<? extends MapHandler.MapUnit> values) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.data_);
                    onChanged();
                } else {
                    this.dataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder removeData(int index) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.remove(index);
                    onChanged();
                } else {
                    this.dataBuilder_.remove(index);
                }
                return this;
            }

            public MapHandler.MapUnit.Builder getDataBuilder(int index) {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().getBuilder(index);
            }

            public MapHandler.MapUnitOrBuilder getDataOrBuilder(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.MapUnitOrBuilder) this.dataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList() {
                if (this.dataBuilder_ != null)
                    return this.dataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.data_);
            }

            public MapHandler.MapUnit.Builder addDataBuilder() {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().addBuilder(MapHandler.MapUnit.getDefaultInstance());
            }

            public MapHandler.MapUnit.Builder addDataBuilder(int index) {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().addBuilder(index, MapHandler.MapUnit.getDefaultInstance());
            }

            public List<MapHandler.MapUnit.Builder> getDataBuilderList() {
                return getDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MapHandler.MapUnit, MapHandler.MapUnit.Builder, MapHandler.MapUnitOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new RepeatedFieldBuilder(this.data_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }
        }
    }

    public static final class GnterSceneByAreaIdRequest extends GeneratedMessage implements GnterSceneByAreaIdRequestOrBuilder {
        private static final GnterSceneByAreaIdRequest defaultInstance = new GnterSceneByAreaIdRequest(true);
        private final UnknownFieldSet unknownFields;

        private GnterSceneByAreaIdRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GnterSceneByAreaIdRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GnterSceneByAreaIdRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GnterSceneByAreaIdRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GnterSceneByAreaIdRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SAreaId_ = input.readInt32();
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
            return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GnterSceneByAreaIdRequest.class, Builder.class);
        }

        public static Parser<GnterSceneByAreaIdRequest> PARSER = (Parser<GnterSceneByAreaIdRequest>) new AbstractParser<GnterSceneByAreaIdRequest>() {
            public MapHandler.GnterSceneByAreaIdRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GnterSceneByAreaIdRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_AREAID_FIELD_NUMBER = 1;
        private int c2SAreaId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GnterSceneByAreaIdRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SAreaId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SAreaId() {
            return this.c2SAreaId_;
        }

        private void initFields() {
            this.c2SAreaId_ = 0;
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
            if (!hasC2SAreaId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SAreaId_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SAreaId_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GnterSceneByAreaIdRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(data);
        }


        public static GnterSceneByAreaIdRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GnterSceneByAreaIdRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(data);
        }


        public static GnterSceneByAreaIdRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GnterSceneByAreaIdRequest parseFrom(InputStream input) throws IOException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(input);
        }


        public static GnterSceneByAreaIdRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GnterSceneByAreaIdRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GnterSceneByAreaIdRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GnterSceneByAreaIdRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GnterSceneByAreaIdRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GnterSceneByAreaIdRequest parseFrom(CodedInputStream input) throws IOException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(input);
        }


        public static GnterSceneByAreaIdRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GnterSceneByAreaIdRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GnterSceneByAreaIdRequest prototype) {
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
                implements MapHandler.GnterSceneByAreaIdRequestOrBuilder {
            private int bitField0_;


            private int c2SAreaId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GnterSceneByAreaIdRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MapHandler.GnterSceneByAreaIdRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SAreaId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdRequest_descriptor;
            }


            public MapHandler.GnterSceneByAreaIdRequest getDefaultInstanceForType() {
                return MapHandler.GnterSceneByAreaIdRequest.getDefaultInstance();
            }


            public MapHandler.GnterSceneByAreaIdRequest build() {
                MapHandler.GnterSceneByAreaIdRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MapHandler.GnterSceneByAreaIdRequest buildPartial() {
                MapHandler.GnterSceneByAreaIdRequest result = new MapHandler.GnterSceneByAreaIdRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SAreaId_ = this.c2SAreaId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GnterSceneByAreaIdRequest) {
                    return mergeFrom((MapHandler.GnterSceneByAreaIdRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MapHandler.GnterSceneByAreaIdRequest other) {
                if (other == MapHandler.GnterSceneByAreaIdRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SAreaId()) {
                    setC2SAreaId(other.getC2SAreaId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SAreaId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GnterSceneByAreaIdRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GnterSceneByAreaIdRequest) MapHandler.GnterSceneByAreaIdRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GnterSceneByAreaIdRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SAreaId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SAreaId() {
                return this.c2SAreaId_;
            }


            public Builder setC2SAreaId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SAreaId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SAreaId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SAreaId_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GnterSceneByAreaIdResponse
            extends GeneratedMessage
            implements GnterSceneByAreaIdResponseOrBuilder {
        private static final GnterSceneByAreaIdResponse defaultInstance = new GnterSceneByAreaIdResponse(true);
        private final UnknownFieldSet unknownFields;

        private GnterSceneByAreaIdResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GnterSceneByAreaIdResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GnterSceneByAreaIdResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GnterSceneByAreaIdResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GnterSceneByAreaIdResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GnterSceneByAreaIdResponse.class, Builder.class);
        }

        public static Parser<GnterSceneByAreaIdResponse> PARSER = (Parser<GnterSceneByAreaIdResponse>) new AbstractParser<GnterSceneByAreaIdResponse>() {
            public MapHandler.GnterSceneByAreaIdResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GnterSceneByAreaIdResponse(input, extensionRegistry);
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

        public Parser<GnterSceneByAreaIdResponse> getParserForType() {
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

        private void initFields() {
            this.s2CCode_ = 0;
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getS2CMsgBytes());
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GnterSceneByAreaIdResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(data);
        }

        public static GnterSceneByAreaIdResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GnterSceneByAreaIdResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(data);
        }

        public static GnterSceneByAreaIdResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GnterSceneByAreaIdResponse parseFrom(InputStream input) throws IOException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(input);
        }

        public static GnterSceneByAreaIdResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GnterSceneByAreaIdResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GnterSceneByAreaIdResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GnterSceneByAreaIdResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GnterSceneByAreaIdResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GnterSceneByAreaIdResponse parseFrom(CodedInputStream input) throws IOException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(input);
        }

        public static GnterSceneByAreaIdResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GnterSceneByAreaIdResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GnterSceneByAreaIdResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GnterSceneByAreaIdResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GnterSceneByAreaIdResponse.class, Builder.class);
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
                if (MapHandler.GnterSceneByAreaIdResponse.alwaysUseFieldBuilders) ;
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
                return MapHandler.internal_static_pomelo_area_GnterSceneByAreaIdResponse_descriptor;
            }

            public MapHandler.GnterSceneByAreaIdResponse getDefaultInstanceForType() {
                return MapHandler.GnterSceneByAreaIdResponse.getDefaultInstance();
            }

            public MapHandler.GnterSceneByAreaIdResponse build() {
                MapHandler.GnterSceneByAreaIdResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GnterSceneByAreaIdResponse buildPartial() {
                MapHandler.GnterSceneByAreaIdResponse result = new MapHandler.GnterSceneByAreaIdResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GnterSceneByAreaIdResponse)
                    return mergeFrom((MapHandler.GnterSceneByAreaIdResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GnterSceneByAreaIdResponse other) {
                if (other == MapHandler.GnterSceneByAreaIdResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
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
                MapHandler.GnterSceneByAreaIdResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GnterSceneByAreaIdResponse) MapHandler.GnterSceneByAreaIdResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GnterSceneByAreaIdResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GnterSceneByAreaIdResponse.getDefaultInstance().getS2CMsg();
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
        }
    }

    public static final class GetNpcListRequest extends GeneratedMessage implements GetNpcListRequestOrBuilder {
        private static final GetNpcListRequest defaultInstance = new GetNpcListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetNpcListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetNpcListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetNpcListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetNpcListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetNpcListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MapHandler.internal_static_pomelo_area_GetNpcListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetNpcListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetNpcListRequest.class, Builder.class);
        }

        public static Parser<GetNpcListRequest> PARSER = (Parser<GetNpcListRequest>) new AbstractParser<GetNpcListRequest>() {
            public MapHandler.GetNpcListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetNpcListRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetNpcListRequest> getParserForType() {
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


        public static GetNpcListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetNpcListRequest) PARSER.parseFrom(data);
        }


        public static GetNpcListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetNpcListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetNpcListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetNpcListRequest) PARSER.parseFrom(data);
        }


        public static GetNpcListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetNpcListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetNpcListRequest parseFrom(InputStream input) throws IOException {
            return (GetNpcListRequest) PARSER.parseFrom(input);
        }


        public static GetNpcListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetNpcListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetNpcListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetNpcListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetNpcListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetNpcListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetNpcListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetNpcListRequest) PARSER.parseFrom(input);
        }


        public static GetNpcListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetNpcListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetNpcListRequest prototype) {
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
                implements MapHandler.GetNpcListRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetNpcListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetNpcListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetNpcListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetNpcListRequest.alwaysUseFieldBuilders) ;
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
                return MapHandler.internal_static_pomelo_area_GetNpcListRequest_descriptor;
            }


            public MapHandler.GetNpcListRequest getDefaultInstanceForType() {
                return MapHandler.GetNpcListRequest.getDefaultInstance();
            }


            public MapHandler.GetNpcListRequest build() {
                MapHandler.GetNpcListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MapHandler.GetNpcListRequest buildPartial() {
                MapHandler.GetNpcListRequest result = new MapHandler.GetNpcListRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetNpcListRequest) {
                    return mergeFrom((MapHandler.GetNpcListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MapHandler.GetNpcListRequest other) {
                if (other == MapHandler.GetNpcListRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetNpcListRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetNpcListRequest) MapHandler.GetNpcListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetNpcListRequest) e.getUnfinishedMessage();
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


    public static final class GetNpcListResponse
            extends GeneratedMessage
            implements GetNpcListResponseOrBuilder {
        private static final GetNpcListResponse defaultInstance = new GetNpcListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetNpcListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetNpcListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetNpcListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetNpcListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetNpcListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.data_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.data_.add(input.readMessage(MapHandler.MapUnit.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.data_ = Collections.unmodifiableList(this.data_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MapHandler.internal_static_pomelo_area_GetNpcListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetNpcListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetNpcListResponse.class, Builder.class);
        }

        public static Parser<GetNpcListResponse> PARSER = (Parser<GetNpcListResponse>) new AbstractParser<GetNpcListResponse>() {
            public MapHandler.GetNpcListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetNpcListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int DATA_FIELD_NUMBER = 3;
        private List<MapHandler.MapUnit> data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetNpcListResponse> getParserForType() {
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

        public List<MapHandler.MapUnit> getDataList() {
            return this.data_;
        }

        public List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList() {
            return (List) this.data_;
        }

        public int getDataCount() {
            return this.data_.size();
        }

        public MapHandler.MapUnit getData(int index) {
            return this.data_.get(index);
        }

        public MapHandler.MapUnitOrBuilder getDataOrBuilder(int index) {
            return this.data_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.data_ = Collections.emptyList();
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
            for (int i = 0; i < getDataCount(); i++) {
                if (!getData(i).isInitialized()) {
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
            for (int i = 0; i < this.data_.size(); i++)
                output.writeMessage(3, (MessageLite) this.data_.get(i));
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
            for (int i = 0; i < this.data_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.data_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetNpcListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetNpcListResponse) PARSER.parseFrom(data);
        }

        public static GetNpcListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetNpcListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetNpcListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetNpcListResponse) PARSER.parseFrom(data);
        }

        public static GetNpcListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetNpcListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetNpcListResponse parseFrom(InputStream input) throws IOException {
            return (GetNpcListResponse) PARSER.parseFrom(input);
        }

        public static GetNpcListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetNpcListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetNpcListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetNpcListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetNpcListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetNpcListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetNpcListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetNpcListResponse) PARSER.parseFrom(input);
        }

        public static GetNpcListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetNpcListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetNpcListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetNpcListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<MapHandler.MapUnit> data_;
            private RepeatedFieldBuilder<MapHandler.MapUnit, MapHandler.MapUnit.Builder, MapHandler.MapUnitOrBuilder> dataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetNpcListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetNpcListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetNpcListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetNpcListResponse.alwaysUseFieldBuilders)
                    getDataFieldBuilder();
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
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetNpcListResponse_descriptor;
            }

            public MapHandler.GetNpcListResponse getDefaultInstanceForType() {
                return MapHandler.GetNpcListResponse.getDefaultInstance();
            }

            public MapHandler.GetNpcListResponse build() {
                MapHandler.GetNpcListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetNpcListResponse buildPartial() {
                MapHandler.GetNpcListResponse result = new MapHandler.GetNpcListResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.dataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.data_ = this.data_;
                } else {
                    result.data_ = this.dataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetNpcListResponse)
                    return mergeFrom((MapHandler.GetNpcListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetNpcListResponse other) {
                if (other == MapHandler.GetNpcListResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.dataBuilder_ == null) {
                    if (!other.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = other.data_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(other.data_);
                        }
                        onChanged();
                    }
                } else if (!other.data_.isEmpty()) {
                    if (this.dataBuilder_.isEmpty()) {
                        this.dataBuilder_.dispose();
                        this.dataBuilder_ = null;
                        this.data_ = other.data_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.dataBuilder_ = MapHandler.GetNpcListResponse.alwaysUseFieldBuilders ? getDataFieldBuilder() : null;
                    } else {
                        this.dataBuilder_.addAllMessages(other.data_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getDataCount(); i++) {
                    if (!getData(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetNpcListResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetNpcListResponse) MapHandler.GetNpcListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetNpcListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GetNpcListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.data_ = new ArrayList<>(this.data_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<MapHandler.MapUnit> getDataList() {
                if (this.dataBuilder_ == null)
                    return Collections.unmodifiableList(this.data_);
                return this.dataBuilder_.getMessageList();
            }

            public int getDataCount() {
                if (this.dataBuilder_ == null)
                    return this.data_.size();
                return this.dataBuilder_.getCount();
            }

            public MapHandler.MapUnit getData(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.MapUnit) this.dataBuilder_.getMessage(index);
            }

            public Builder setData(int index, MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.set(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setData(int index, MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addData(MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addData(int index, MapHandler.MapUnit value) {
                if (this.dataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureDataIsMutable();
                    this.data_.add(index, value);
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addData(MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addData(int index, MapHandler.MapUnit.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllData(Iterable<? extends MapHandler.MapUnit> values) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.data_);
                    onChanged();
                } else {
                    this.dataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder removeData(int index) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.remove(index);
                    onChanged();
                } else {
                    this.dataBuilder_.remove(index);
                }
                return this;
            }

            public MapHandler.MapUnit.Builder getDataBuilder(int index) {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().getBuilder(index);
            }

            public MapHandler.MapUnitOrBuilder getDataOrBuilder(int index) {
                if (this.dataBuilder_ == null)
                    return this.data_.get(index);
                return (MapHandler.MapUnitOrBuilder) this.dataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList() {
                if (this.dataBuilder_ != null)
                    return this.dataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.data_);
            }

            public MapHandler.MapUnit.Builder addDataBuilder() {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().addBuilder(MapHandler.MapUnit.getDefaultInstance());
            }

            public MapHandler.MapUnit.Builder addDataBuilder(int index) {
                return (MapHandler.MapUnit.Builder) getDataFieldBuilder().addBuilder(index, MapHandler.MapUnit.getDefaultInstance());
            }

            public List<MapHandler.MapUnit.Builder> getDataBuilderList() {
                return getDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MapHandler.MapUnit, MapHandler.MapUnit.Builder, MapHandler.MapUnitOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new RepeatedFieldBuilder(this.data_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }
        }
    }

    public static final class GetMapListRequest extends GeneratedMessage implements GetMapListRequestOrBuilder {
        private static final GetMapListRequest defaultInstance = new GetMapListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMapListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMapListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMapListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMapListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMapListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SMapId_ = input.readInt32();
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
            return MapHandler.internal_static_pomelo_area_GetMapListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetMapListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMapListRequest.class, Builder.class);
        }

        public static Parser<GetMapListRequest> PARSER = (Parser<GetMapListRequest>) new AbstractParser<GetMapListRequest>() {
            public MapHandler.GetMapListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetMapListRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_MAPID_FIELD_NUMBER = 1;
        private int c2SMapId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMapListRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SMapId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SMapId() {
            return this.c2SMapId_;
        }

        private void initFields() {
            this.c2SMapId_ = 0;
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
            if (!hasC2SMapId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SMapId_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SMapId_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMapListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMapListRequest) PARSER.parseFrom(data);
        }


        public static GetMapListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMapListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMapListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMapListRequest) PARSER.parseFrom(data);
        }


        public static GetMapListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMapListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMapListRequest parseFrom(InputStream input) throws IOException {
            return (GetMapListRequest) PARSER.parseFrom(input);
        }


        public static GetMapListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMapListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMapListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetMapListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMapListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMapListRequest) PARSER.parseFrom(input);
        }


        public static GetMapListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMapListRequest prototype) {
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
                implements MapHandler.GetMapListRequestOrBuilder {
            private int bitField0_;


            private int c2SMapId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetMapListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetMapListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetMapListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetMapListRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SMapId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetMapListRequest_descriptor;
            }


            public MapHandler.GetMapListRequest getDefaultInstanceForType() {
                return MapHandler.GetMapListRequest.getDefaultInstance();
            }


            public MapHandler.GetMapListRequest build() {
                MapHandler.GetMapListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MapHandler.GetMapListRequest buildPartial() {
                MapHandler.GetMapListRequest result = new MapHandler.GetMapListRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SMapId_ = this.c2SMapId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetMapListRequest) {
                    return mergeFrom((MapHandler.GetMapListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MapHandler.GetMapListRequest other) {
                if (other == MapHandler.GetMapListRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SMapId()) {
                    setC2SMapId(other.getC2SMapId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SMapId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetMapListRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetMapListRequest) MapHandler.GetMapListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetMapListRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SMapId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SMapId() {
                return this.c2SMapId_;
            }


            public Builder setC2SMapId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SMapId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SMapId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SMapId_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetMapListResponse
            extends GeneratedMessage
            implements GetMapListResponseOrBuilder {
        private static final GetMapListResponse defaultInstance = new GetMapListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMapListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMapListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMapListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMapListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMapListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.s2CMapIds_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CMapIds_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 26:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x4) != 4 && input.getBytesUntilLimit() > 0) {
                                this.s2CMapIds_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.s2CMapIds_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CMapIds_ = Collections.unmodifiableList(this.s2CMapIds_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MapHandler.internal_static_pomelo_area_GetMapListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetMapListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMapListResponse.class, Builder.class);
        }

        public static Parser<GetMapListResponse> PARSER = (Parser<GetMapListResponse>) new AbstractParser<GetMapListResponse>() {
            public MapHandler.GetMapListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetMapListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_MAPIDS_FIELD_NUMBER = 3;
        private List<Integer> s2CMapIds_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMapListResponse> getParserForType() {
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

        public List<Integer> getS2CMapIdsList() {
            return this.s2CMapIds_;
        }

        public int getS2CMapIdsCount() {
            return this.s2CMapIds_.size();
        }

        public int getS2CMapIds(int index) {
            return ((Integer) this.s2CMapIds_.get(index)).intValue();
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CMapIds_ = Collections.emptyList();
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
            for (int i = 0; i < this.s2CMapIds_.size(); i++)
                output.writeInt32(3, ((Integer) this.s2CMapIds_.get(i)).intValue());
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
            int dataSize = 0;
            for (int i = 0; i < this.s2CMapIds_.size(); i++)
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.s2CMapIds_.get(i)).intValue());
            size += dataSize;
            size += 1 * getS2CMapIdsList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetMapListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMapListResponse) PARSER.parseFrom(data);
        }

        public static GetMapListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMapListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMapListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMapListResponse) PARSER.parseFrom(data);
        }

        public static GetMapListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMapListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMapListResponse parseFrom(InputStream input) throws IOException {
            return (GetMapListResponse) PARSER.parseFrom(input);
        }

        public static GetMapListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMapListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMapListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetMapListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMapListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMapListResponse) PARSER.parseFrom(input);
        }

        public static GetMapListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMapListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetMapListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<Integer> s2CMapIds_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetMapListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetMapListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetMapListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CMapIds_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CMapIds_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetMapListResponse.alwaysUseFieldBuilders) ;
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
                this.s2CMapIds_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetMapListResponse_descriptor;
            }

            public MapHandler.GetMapListResponse getDefaultInstanceForType() {
                return MapHandler.GetMapListResponse.getDefaultInstance();
            }

            public MapHandler.GetMapListResponse build() {
                MapHandler.GetMapListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetMapListResponse buildPartial() {
                MapHandler.GetMapListResponse result = new MapHandler.GetMapListResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((this.bitField0_ & 0x4) == 4) {
                    this.s2CMapIds_ = Collections.unmodifiableList(this.s2CMapIds_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.s2CMapIds_ = this.s2CMapIds_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetMapListResponse)
                    return mergeFrom((MapHandler.GetMapListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetMapListResponse other) {
                if (other == MapHandler.GetMapListResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (!other.s2CMapIds_.isEmpty()) {
                    if (this.s2CMapIds_.isEmpty()) {
                        this.s2CMapIds_ = other.s2CMapIds_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        ensureS2CMapIdsIsMutable();
                        this.s2CMapIds_.addAll(other.s2CMapIds_);
                    }
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
                MapHandler.GetMapListResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetMapListResponse) MapHandler.GetMapListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetMapListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GetMapListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CMapIdsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CMapIds_ = new ArrayList<>(this.s2CMapIds_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Integer> getS2CMapIdsList() {
                return Collections.unmodifiableList(this.s2CMapIds_);
            }

            public int getS2CMapIdsCount() {
                return this.s2CMapIds_.size();
            }

            public int getS2CMapIds(int index) {
                return ((Integer) this.s2CMapIds_.get(index)).intValue();
            }

            public Builder setS2CMapIds(int index, int value) {
                ensureS2CMapIdsIsMutable();
                this.s2CMapIds_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addS2CMapIds(int value) {
                ensureS2CMapIdsIsMutable();
                this.s2CMapIds_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllS2CMapIds(Iterable<? extends Integer> values) {
                ensureS2CMapIdsIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.s2CMapIds_);
                onChanged();
                return this;
            }

            public Builder clearS2CMapIds() {
                this.s2CMapIds_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetAliveMonsterLineInfoRequest extends GeneratedMessage implements GetAliveMonsterLineInfoRequestOrBuilder {
        private static final GetAliveMonsterLineInfoRequest defaultInstance = new GetAliveMonsterLineInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetAliveMonsterLineInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAliveMonsterLineInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAliveMonsterLineInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetAliveMonsterLineInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAliveMonsterLineInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAliveMonsterLineInfoRequest.class, Builder.class);
        }

        public static Parser<GetAliveMonsterLineInfoRequest> PARSER = (Parser<GetAliveMonsterLineInfoRequest>) new AbstractParser<GetAliveMonsterLineInfoRequest>() {
            public MapHandler.GetAliveMonsterLineInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetAliveMonsterLineInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAliveMonsterLineInfoRequest> getParserForType() {
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


        public static GetAliveMonsterLineInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(data);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(data);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(input);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetAliveMonsterLineInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetAliveMonsterLineInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(input);
        }


        public static GetAliveMonsterLineInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAliveMonsterLineInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetAliveMonsterLineInfoRequest prototype) {
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
                implements MapHandler.GetAliveMonsterLineInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetAliveMonsterLineInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetAliveMonsterLineInfoRequest.alwaysUseFieldBuilders) ;
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
                return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_descriptor;
            }


            public MapHandler.GetAliveMonsterLineInfoRequest getDefaultInstanceForType() {
                return MapHandler.GetAliveMonsterLineInfoRequest.getDefaultInstance();
            }


            public MapHandler.GetAliveMonsterLineInfoRequest build() {
                MapHandler.GetAliveMonsterLineInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MapHandler.GetAliveMonsterLineInfoRequest buildPartial() {
                MapHandler.GetAliveMonsterLineInfoRequest result = new MapHandler.GetAliveMonsterLineInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetAliveMonsterLineInfoRequest) {
                    return mergeFrom((MapHandler.GetAliveMonsterLineInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MapHandler.GetAliveMonsterLineInfoRequest other) {
                if (other == MapHandler.GetAliveMonsterLineInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MapHandler.GetAliveMonsterLineInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetAliveMonsterLineInfoRequest) MapHandler.GetAliveMonsterLineInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetAliveMonsterLineInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetAliveMonsterLineInfoResponse
            extends GeneratedMessage
            implements GetAliveMonsterLineInfoResponseOrBuilder {
        private static final GetAliveMonsterLineInfoResponse defaultInstance = new GetAliveMonsterLineInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetAliveMonsterLineInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAliveMonsterLineInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAliveMonsterLineInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetAliveMonsterLineInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAliveMonsterLineInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.s2CMonsterInfos_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CMonsterInfos_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 26:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x4) != 4 && input.getBytesUntilLimit() > 0) {
                                this.s2CMonsterInfos_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.s2CMonsterInfos_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CMonsterInfos_ = Collections.unmodifiableList(this.s2CMonsterInfos_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAliveMonsterLineInfoResponse.class, Builder.class);
        }

        public static Parser<GetAliveMonsterLineInfoResponse> PARSER = (Parser<GetAliveMonsterLineInfoResponse>) new AbstractParser<GetAliveMonsterLineInfoResponse>() {
            public MapHandler.GetAliveMonsterLineInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapHandler.GetAliveMonsterLineInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_MONSTERINFOS_FIELD_NUMBER = 3;
        private List<Integer> s2CMonsterInfos_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAliveMonsterLineInfoResponse> getParserForType() {
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

        public List<Integer> getS2CMonsterInfosList() {
            return this.s2CMonsterInfos_;
        }

        public int getS2CMonsterInfosCount() {
            return this.s2CMonsterInfos_.size();
        }

        public int getS2CMonsterInfos(int index) {
            return ((Integer) this.s2CMonsterInfos_.get(index)).intValue();
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CMonsterInfos_ = Collections.emptyList();
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
            for (int i = 0; i < this.s2CMonsterInfos_.size(); i++)
                output.writeInt32(3, ((Integer) this.s2CMonsterInfos_.get(i)).intValue());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            int dataSize = 0;
            for (int i = 0; i < this.s2CMonsterInfos_.size(); i++)
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.s2CMonsterInfos_.get(i)).intValue());
            size += dataSize;
            size += 1 * getS2CMonsterInfosList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(data);
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(data);
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(input);
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetAliveMonsterLineInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetAliveMonsterLineInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(input);
        }

        public static GetAliveMonsterLineInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAliveMonsterLineInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetAliveMonsterLineInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MapHandler.GetAliveMonsterLineInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<Integer> s2CMonsterInfos_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MapHandler.GetAliveMonsterLineInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CMonsterInfos_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CMonsterInfos_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapHandler.GetAliveMonsterLineInfoResponse.alwaysUseFieldBuilders) ;
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
                this.s2CMonsterInfos_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MapHandler.internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_descriptor;
            }

            public MapHandler.GetAliveMonsterLineInfoResponse getDefaultInstanceForType() {
                return MapHandler.GetAliveMonsterLineInfoResponse.getDefaultInstance();
            }

            public MapHandler.GetAliveMonsterLineInfoResponse build() {
                MapHandler.GetAliveMonsterLineInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MapHandler.GetAliveMonsterLineInfoResponse buildPartial() {
                MapHandler.GetAliveMonsterLineInfoResponse result = new MapHandler.GetAliveMonsterLineInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((this.bitField0_ & 0x4) == 4) {
                    this.s2CMonsterInfos_ = Collections.unmodifiableList(this.s2CMonsterInfos_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.s2CMonsterInfos_ = this.s2CMonsterInfos_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MapHandler.GetAliveMonsterLineInfoResponse)
                    return mergeFrom((MapHandler.GetAliveMonsterLineInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapHandler.GetAliveMonsterLineInfoResponse other) {
                if (other == MapHandler.GetAliveMonsterLineInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (!other.s2CMonsterInfos_.isEmpty()) {
                    if (this.s2CMonsterInfos_.isEmpty()) {
                        this.s2CMonsterInfos_ = other.s2CMonsterInfos_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        ensureS2CMonsterInfosIsMutable();
                        this.s2CMonsterInfos_.addAll(other.s2CMonsterInfos_);
                    }
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
                MapHandler.GetAliveMonsterLineInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (MapHandler.GetAliveMonsterLineInfoResponse) MapHandler.GetAliveMonsterLineInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MapHandler.GetAliveMonsterLineInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MapHandler.GetAliveMonsterLineInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CMonsterInfosIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CMonsterInfos_ = new ArrayList<>(this.s2CMonsterInfos_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Integer> getS2CMonsterInfosList() {
                return Collections.unmodifiableList(this.s2CMonsterInfos_);
            }

            public int getS2CMonsterInfosCount() {
                return this.s2CMonsterInfos_.size();
            }

            public int getS2CMonsterInfos(int index) {
                return ((Integer) this.s2CMonsterInfos_.get(index)).intValue();
            }

            public Builder setS2CMonsterInfos(int index, int value) {
                ensureS2CMonsterInfosIsMutable();
                this.s2CMonsterInfos_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addS2CMonsterInfos(int value) {
                ensureS2CMonsterInfosIsMutable();
                this.s2CMonsterInfos_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllS2CMonsterInfos(Iterable<? extends Integer> values) {
                ensureS2CMonsterInfosIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.s2CMonsterInfos_);
                onChanged();
                return this;
            }

            public Builder clearS2CMonsterInfos() {
                this.s2CMonsterInfos_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\020mapHandler.proto\022\013pomelo.area\"j\n\007MapUnit\022\022\n\ntemplateId\030\001 \002(\005\022\t\n\001x\030\002 \002(\005\022\t\n\001y\030\003 \002(\005\022\f\n\004name\030\004 \001(\t\022\f\n\004type\030\005 \001(\005\022\n\n\002lv\030\006 \001(\005\022\r\n\005force\030\007 \001(\005\"&\n\bWorldMap\022\n\n\002id\030\001 \002(\005\022\016\n\006isOpen\030\002 \002(\005\"\030\n\026GetWorldMapListRequest\"a\n\027GetWorldMapListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\004data\030\003 \003(\0132\025.pomelo.area.WorldMap\"\026\n\024GetPlayerListRequest\"^\n\025GetPlayerListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\"\n\004data\030\003 \003", "(\0132\024.pomelo.area.MapUnit\"\027\n\025GetMonsterListRequest\"_\n\026GetMonsterListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\"\n\004data\030\003 \003(\0132\024.pomelo.area.MapUnit\"/\n\031GnterSceneByAreaIdRequest\022\022\n\nc2s_areaId\030\001 \002(\005\"?\n\032GnterSceneByAreaIdResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\023\n\021GetNpcListRequest\"[\n\022GetNpcListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\"\n\004data\030\003 \003(\0132\024.pomelo.area.MapUnit\"&\n\021GetMapListRequest\022\021\n\tc", "2s_mapId\030\001 \002(\005\"K\n\022GetMapListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\022\n\ns2c_mapIds\030\003 \003(\005\" \n\036GetAliveMonsterLineInfoRequest\"^\n\037GetAliveMonsterLineInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\030\n\020s2c_monsterInfos\030\003 \003(\0052É\005\n\nmapHandler\022l\n\031enterSceneByAreaIdRequest\022&.pomelo.area.GnterSceneByAreaIdRequest\032'.pomelo.area.GnterSceneByAreaIdResponse\022c\n\026getWorldMapListRequest\022#.pomelo.area.GetWorldMapLi", "stRequest\032$.pomelo.area.GetWorldMapListResponse\022]\n\024getPlayerListRequest\022!.pomelo.area.GetPlayerListRequest\032\".pomelo.area.GetPlayerListResponse\022`\n\025getMonsterListRequest\022\".pomelo.area.GetMonsterListRequest\032#.pomelo.area.GetMonsterListResponse\022T\n\021getNpcListRequest\022\036.pomelo.area.GetNpcListRequest\032\037.pomelo.area.GetNpcListResponse\022T\n\021getMapListRequest\022\036.pomelo.area.GetMapListRequest\032\037.pomelo.area.GetMap", "ListResponse\022{\n\036getAliveMonsterLineInfoRequest\022+.pomelo.area.GetAliveMonsterLineInfoRequest\032,.pomelo.area.GetAliveMonsterLineInfoResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                MapHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_MapUnit_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MapUnit_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MapUnit_descriptor, new String[]{"TemplateId", "X", "Y", "Name", "Type", "Lv", "Force"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_WorldMap_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WorldMap_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WorldMap_descriptor, new String[]{"Id", "IsOpen"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetWorldMapListRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetWorldMapListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetWorldMapListRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetWorldMapListResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetWorldMapListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetWorldMapListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Data"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetPlayerListRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetPlayerListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetPlayerListRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetPlayerListResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetPlayerListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetPlayerListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Data"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMonsterListRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMonsterListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMonsterListRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMonsterListResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMonsterListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMonsterListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Data"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GnterSceneByAreaIdRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GnterSceneByAreaIdRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GnterSceneByAreaIdRequest_descriptor, new String[]{"C2SAreaId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GnterSceneByAreaIdResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GnterSceneByAreaIdResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GnterSceneByAreaIdResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetNpcListRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetNpcListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetNpcListRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetNpcListResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetNpcListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetNpcListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Data"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMapListRequest_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMapListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMapListRequest_descriptor, new String[]{"C2SMapId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMapListResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMapListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMapListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CMapIds"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAliveMonsterLineInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAliveMonsterLineInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CMonsterInfos"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface GetAliveMonsterLineInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<Integer> getS2CMonsterInfosList();

        int getS2CMonsterInfosCount();

        int getS2CMonsterInfos(int param1Int);
    }

    public static interface GetAliveMonsterLineInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetMapListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<Integer> getS2CMapIdsList();

        int getS2CMapIdsCount();

        int getS2CMapIds(int param1Int);
    }

    public static interface GetMapListRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SMapId();

        int getC2SMapId();
    }

    public static interface GetNpcListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MapHandler.MapUnit> getDataList();

        MapHandler.MapUnit getData(int param1Int);

        int getDataCount();

        List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList();

        MapHandler.MapUnitOrBuilder getDataOrBuilder(int param1Int);
    }

    public static interface GetNpcListRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GnterSceneByAreaIdResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GnterSceneByAreaIdRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SAreaId();

        int getC2SAreaId();
    }

    public static interface GetMonsterListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MapHandler.MapUnit> getDataList();

        MapHandler.MapUnit getData(int param1Int);

        int getDataCount();

        List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList();

        MapHandler.MapUnitOrBuilder getDataOrBuilder(int param1Int);
    }

    public static interface GetMonsterListRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetPlayerListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MapHandler.MapUnit> getDataList();

        MapHandler.MapUnit getData(int param1Int);

        int getDataCount();

        List<? extends MapHandler.MapUnitOrBuilder> getDataOrBuilderList();

        MapHandler.MapUnitOrBuilder getDataOrBuilder(int param1Int);
    }

    public static interface GetPlayerListRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetWorldMapListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MapHandler.WorldMap> getDataList();

        MapHandler.WorldMap getData(int param1Int);

        int getDataCount();

        List<? extends MapHandler.WorldMapOrBuilder> getDataOrBuilderList();

        MapHandler.WorldMapOrBuilder getDataOrBuilder(int param1Int);
    }

    public static interface GetWorldMapListRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface WorldMapOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasIsOpen();

        int getIsOpen();
    }

    public static interface MapUnitOrBuilder extends MessageOrBuilder {
        boolean hasTemplateId();

        int getTemplateId();

        boolean hasX();

        int getX();

        boolean hasY();

        int getY();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasType();

        int getType();

        boolean hasLv();

        int getLv();

        boolean hasForce();

        int getForce();
    }
}


