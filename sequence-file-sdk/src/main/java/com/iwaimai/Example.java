// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/example.proto

package com.iwaimai;

public final class Example {
  private Example() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PersonOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 id = 1;
    /**
     * <code>required int32 id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required int32 id = 1;</code>
     */
    int getId();

    // required string name = 2;
    /**
     * <code>required string name = 2;</code>
     */
    boolean hasName();
    /**
     * <code>required string name = 2;</code>
     */
    java.lang.String getName();
    /**
     * <code>required string name = 2;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    // optional string email = 3;
    /**
     * <code>optional string email = 3;</code>
     */
    boolean hasEmail();
    /**
     * <code>optional string email = 3;</code>
     */
    java.lang.String getEmail();
    /**
     * <code>optional string email = 3;</code>
     */
    com.google.protobuf.ByteString
        getEmailBytes();

    // repeated string likes = 4;
    /**
     * <code>repeated string likes = 4;</code>
     */
    java.util.List<java.lang.String>
    getLikesList();
    /**
     * <code>repeated string likes = 4;</code>
     */
    int getLikesCount();
    /**
     * <code>repeated string likes = 4;</code>
     */
    java.lang.String getLikes(int index);
    /**
     * <code>repeated string likes = 4;</code>
     */
    com.google.protobuf.ByteString
        getLikesBytes(int index);
  }
  /**
   * Protobuf type {@code Person}
   */
  public static final class Person extends
      com.google.protobuf.GeneratedMessage
      implements PersonOrBuilder {
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Person(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Person defaultInstance;
    public static Person getDefaultInstance() {
      return defaultInstance;
    }

    public Person getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Person(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              name_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              email_ = input.readBytes();
              break;
            }
            case 34: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                likes_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000008;
              }
              likes_.add(input.readBytes());
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          likes_ = new com.google.protobuf.UnmodifiableLazyStringList(likes_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.iwaimai.Example.internal_static_Person_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.iwaimai.Example.internal_static_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.iwaimai.Example.Person.class, com.iwaimai.Example.Person.Builder.class);
    }

    public static com.google.protobuf.Parser<Person> PARSER =
        new com.google.protobuf.AbstractParser<Person>() {
      public Person parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Person(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>required int32 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    // required string name = 2;
    public static final int NAME_FIELD_NUMBER = 2;
    private java.lang.Object name_;
    /**
     * <code>required string name = 2;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string email = 3;
    public static final int EMAIL_FIELD_NUMBER = 3;
    private java.lang.Object email_;
    /**
     * <code>optional string email = 3;</code>
     */
    public boolean hasEmail() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string email = 3;</code>
     */
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          email_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string email = 3;</code>
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // repeated string likes = 4;
    public static final int LIKES_FIELD_NUMBER = 4;
    private com.google.protobuf.LazyStringList likes_;
    /**
     * <code>repeated string likes = 4;</code>
     */
    public java.util.List<java.lang.String>
        getLikesList() {
      return likes_;
    }
    /**
     * <code>repeated string likes = 4;</code>
     */
    public int getLikesCount() {
      return likes_.size();
    }
    /**
     * <code>repeated string likes = 4;</code>
     */
    public java.lang.String getLikes(int index) {
      return likes_.get(index);
    }
    /**
     * <code>repeated string likes = 4;</code>
     */
    public com.google.protobuf.ByteString
        getLikesBytes(int index) {
      return likes_.getByteString(index);
    }

    private void initFields() {
      id_ = 0;
      name_ = "";
      email_ = "";
      likes_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getNameBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getEmailBytes());
      }
      for (int i = 0; i < likes_.size(); i++) {
        output.writeBytes(4, likes_.getByteString(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getNameBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getEmailBytes());
      }
      {
        int dataSize = 0;
        for (int i = 0; i < likes_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(likes_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getLikesList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.iwaimai.Example.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.iwaimai.Example.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.iwaimai.Example.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.iwaimai.Example.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.iwaimai.Example.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.iwaimai.Example.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.iwaimai.Example.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.iwaimai.Example.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.iwaimai.Example.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.iwaimai.Example.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.iwaimai.Example.Person prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.iwaimai.Example.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.iwaimai.Example.internal_static_Person_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.iwaimai.Example.internal_static_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.iwaimai.Example.Person.class, com.iwaimai.Example.Person.Builder.class);
      }

      // Construct using com.iwaimai.Example.Person.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        id_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        email_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        likes_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.iwaimai.Example.internal_static_Person_descriptor;
      }

      public com.iwaimai.Example.Person getDefaultInstanceForType() {
        return com.iwaimai.Example.Person.getDefaultInstance();
      }

      public com.iwaimai.Example.Person build() {
        com.iwaimai.Example.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.iwaimai.Example.Person buildPartial() {
        com.iwaimai.Example.Person result = new com.iwaimai.Example.Person(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.name_ = name_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.email_ = email_;
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          likes_ = new com.google.protobuf.UnmodifiableLazyStringList(
              likes_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.likes_ = likes_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.iwaimai.Example.Person) {
          return mergeFrom((com.iwaimai.Example.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.iwaimai.Example.Person other) {
        if (other == com.iwaimai.Example.Person.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasName()) {
          bitField0_ |= 0x00000002;
          name_ = other.name_;
          onChanged();
        }
        if (other.hasEmail()) {
          bitField0_ |= 0x00000004;
          email_ = other.email_;
          onChanged();
        }
        if (!other.likes_.isEmpty()) {
          if (likes_.isEmpty()) {
            likes_ = other.likes_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureLikesIsMutable();
            likes_.addAll(other.likes_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          
          return false;
        }
        if (!hasName()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.iwaimai.Example.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.iwaimai.Example.Person) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 id = 1;
      private int id_ ;
      /**
       * <code>required int32 id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder setId(int value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0;
        onChanged();
        return this;
      }

      // required string name = 2;
      private java.lang.Object name_ = "";
      /**
       * <code>required string name = 2;</code>
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string name = 2;</code>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string name = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string name = 2;</code>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 2;</code>
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 2;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        name_ = value;
        onChanged();
        return this;
      }

      // optional string email = 3;
      private java.lang.Object email_ = "";
      /**
       * <code>optional string email = 3;</code>
       */
      public boolean hasEmail() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string email = 3;</code>
       */
      public java.lang.String getEmail() {
        java.lang.Object ref = email_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          email_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string email = 3;</code>
       */
      public com.google.protobuf.ByteString
          getEmailBytes() {
        java.lang.Object ref = email_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          email_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string email = 3;</code>
       */
      public Builder setEmail(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        email_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string email = 3;</code>
       */
      public Builder clearEmail() {
        bitField0_ = (bitField0_ & ~0x00000004);
        email_ = getDefaultInstance().getEmail();
        onChanged();
        return this;
      }
      /**
       * <code>optional string email = 3;</code>
       */
      public Builder setEmailBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        email_ = value;
        onChanged();
        return this;
      }

      // repeated string likes = 4;
      private com.google.protobuf.LazyStringList likes_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureLikesIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          likes_ = new com.google.protobuf.LazyStringArrayList(likes_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public java.util.List<java.lang.String>
          getLikesList() {
        return java.util.Collections.unmodifiableList(likes_);
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public int getLikesCount() {
        return likes_.size();
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public java.lang.String getLikes(int index) {
        return likes_.get(index);
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public com.google.protobuf.ByteString
          getLikesBytes(int index) {
        return likes_.getByteString(index);
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public Builder setLikes(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureLikesIsMutable();
        likes_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public Builder addLikes(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureLikesIsMutable();
        likes_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public Builder addAllLikes(
          java.lang.Iterable<java.lang.String> values) {
        ensureLikesIsMutable();
        super.addAll(values, likes_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public Builder clearLikes() {
        likes_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string likes = 4;</code>
       */
      public Builder addLikesBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureLikesIsMutable();
        likes_.add(value);
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Person)
    }

    static {
      defaultInstance = new Person(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Person)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Person_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n src/main/resources/example.proto\"@\n\006Pe" +
      "rson\022\n\n\002id\030\001 \002(\005\022\014\n\004name\030\002 \002(\t\022\r\n\005email\030" +
      "\003 \001(\t\022\r\n\005likes\030\004 \003(\tB\026\n\013com.iwaimaiB\007Exa" +
      "mple"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_Person_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_Person_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Person_descriptor,
              new java.lang.String[] { "Id", "Name", "Email", "Likes", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
