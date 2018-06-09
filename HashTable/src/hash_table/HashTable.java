package hash_table;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class HashTable<K, V> implements Map<K, V> {
    protected int initialCapacity;
    protected double loadFactor;
    protected int counter = 0 ;

    public HashTable() {
        initialCapacity = 11;
        loadFactor = 0.75;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (counter == 0)
            return true;
        return false;
    }

    @Override
    public abstract boolean containsKey(Object key);

    @Override
    public abstract boolean containsValue(Object value);

    @Override
    public abstract V get(Object key);

    @Override
    public abstract V put(K key, V value);

    @Override
    public abstract V remove(Object key);

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m == null) throw new NullPointerException();
        for (Map.Entry<? extends K, ? extends V> map : m.entrySet()) {
            put(map.getKey(), map.getValue());
        }
    }

    @Override
    public abstract void clear();

    @Override
    public abstract Set<K> keySet();

    @Override
    public abstract Collection<V> values();

    @Override
    public abstract Set<Entry<K, V>> entrySet();

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        if (key == null || defaultValue == null) throw new NullPointerException();
        V value = get(key);
        if (value == null)
            return defaultValue;
        return value;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        V previousValue = get(key);
        if (previousValue == null)
            put(key, value);
        return previousValue;
    }

    public abstract void rehash();

    protected class Pair<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        protected Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

    }
}
