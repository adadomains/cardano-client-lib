package com.bloxbean.cardano.client.metadata.cbor;

import co.nstant.in.cbor.model.*;

import java.math.BigInteger;

public class CBORMetadataMap {
    private Map map;

    public CBORMetadataMap() {
        map = new Map();
    }

    public CBORMetadataMap(Map map) {
        this.map = map;
    }

    public CBORMetadataMap put(BigInteger key, BigInteger value) {
        map.put(new UnsignedInteger(key), new UnsignedInteger(value));
        return this;
    }

    public CBORMetadataMap putNegative(BigInteger key, BigInteger value) {
        map.put(new UnsignedInteger(key), new NegativeInteger(value));
        return this;
    }

    public CBORMetadataMap put(BigInteger key, byte[] value) {
        map.put(new UnsignedInteger(key), new ByteString(value));
        return this;
    }

    public CBORMetadataMap put(BigInteger key, String value) {
        map.put(new UnsignedInteger(key), new UnicodeString(value));
        return this;
    }

    public CBORMetadataMap put(BigInteger key, CBORMetadataMap value) {
        if(value != null)
            map.put(new UnsignedInteger(key), value.getMap());
        return this;
    }

    public CBORMetadataMap put(BigInteger key, CBORMetadataList list) {
        if(list != null)
            map.put(new UnsignedInteger(key), list.getArray());
        return this;
    }

    public CBORMetadataMap put(String key, BigInteger value) {
        map.put(new UnicodeString(key), new UnsignedInteger(value));
        return this;
    }

    public CBORMetadataMap putNegative(String key, BigInteger value) {
        map.put(new UnicodeString(key), new NegativeInteger(value));
        return this;
    }

    public CBORMetadataMap put(String key, byte[] value) {
        map.put(new UnicodeString(key), new ByteString(value));
        return this;
    }

    public CBORMetadataMap put(String key, String value) {
        map.put(new UnicodeString(key), new UnicodeString(value));
        return this;
    }

    public CBORMetadataMap put(String key, CBORMetadataMap value) {
        if(value != null)
            map.put(new UnicodeString(key), value.getMap());
        return this;
    }

    public CBORMetadataMap put(String key, CBORMetadataList list) {
        if(list != null)
            map.put(new UnicodeString(key), list.getArray());
        return this;
    }

    public CBORMetadataMap put(byte[] key, BigInteger value) {
        map.put(new ByteString(key), new UnsignedInteger(value));
        return this;
    }

    public CBORMetadataMap putNegative(byte[] key, BigInteger value) {
        map.put(new ByteString(key), new NegativeInteger(value));
        return this;
    }

    public CBORMetadataMap put(byte[] key, byte[] value) {
        map.put(new ByteString(key), new ByteString(value));
        return this;
    }

    public CBORMetadataMap put(byte[] key, String value) {
        map.put(new ByteString(key), new UnicodeString(value));
        return this;
    }

    public CBORMetadataMap put(byte[] key, CBORMetadataMap value) {
        if(value != null)
            map.put(new ByteString(key), value.getMap());
        return this;
    }

    public CBORMetadataMap put(byte[] key, CBORMetadataList list) {
        if(list != null)
            map.put(new ByteString(key), list.getArray());
        return this;
    }

    Map getMap() {
        return map;
    }
}
