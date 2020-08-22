package com.example.ds.hash;

public class BasicHashTable<X, Y> {
    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[tableSize];
        this.size = 0;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        // if we don't have anything for the given key, just return null
        if (data[hash] == null) {
            return null;
        }
        // otherwise get the hashEntry for the key and return its value
        else {
            return (Y) data[hash].getValue();
        }

    }

    public void put(X key, Y value) {
        if (size == capacity) throw new IllegalStateException("Hash table reached its capacity");

        int hash = calculateHash(key);
        data[hash] = new HashEntry<X, Y>(key, value);
        size++;
    }

    public Y delete(X key) {
        // first get the value of this key so it can be returned
        Y value = get(key);
        // clear out hash table slot for the key and return the removed value
        if (value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            size--;

            hash = (hash + 1) % this.capacity;
            // if the next slot is not empty we should re add it so e can keep the hash algorithm clean
            while (data[hash] != null) {
                HashEntry he = data[hash];
                data[hash] = null;
                put((X) he.getKey(), (Y) he.getValue());
                // we re-positioned the hash item nd didn't really add a new one so back off the size
                size--;
                hash = (hash + 1) % this.capacity;
            }
        }
        return value;
    }

    public boolean hasKey(X key) {
        int hash = calculateHash(key);
        if (data[hash] == null) {
            return false;
        } else {
            return data[hash].getKey().equals(key);
        }
    }

    public boolean hasValue(Y value) {

        for (HashEntry datum : data) {
            if (datum.getValue() != null && datum.getValue().equals(value)) {

                return true;
            }
        }
        return false;
    }

    private int calculateHash(X key) {
        int hash = (key.hashCode() % this.capacity); // hash slot
        // this is necessary to deal with collisions
        while (data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    public int size() {
        return this.size;
    }

    // HashEntry class
    private class HashEntry<X, Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }
}
