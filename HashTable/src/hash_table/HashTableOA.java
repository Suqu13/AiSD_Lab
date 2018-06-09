package hash_table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class HashTableOA<K, V> extends HashTable<K, V> {
    private Pair<K, V>[] arr;
    private int initialCapacity;

    public HashTableOA() {
        arr = new Pair[super.initialCapacity];
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        int i = 1;
        while (arr[index] != null) {
            if (arr[index].getKey() == key) {
                return true;
            }
            index = (key.hashCode() * i++) % arr.length;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) throw new NullPointerException();
        for (Pair<K, V> pair : arr) {
            if (pair != null && pair.getValue() == value) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        int i = 1;
        while (arr[index] != null) {
            if (arr[index].getKey() == key) {
                return arr[index].getValue();
            }
            index = (key.hashCode() * i++) % arr.length;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        int i = 1;
        int index = key.hashCode() % arr.length;
        while (arr[index] != null) {
            if (arr[index].getKey() == key) {
                V oldValue = arr[index].getValue();
                arr[index].setValue(value);
                return oldValue;
            }
            index = (key.hashCode() * i++) % arr.length;
        }
        arr[index] = new Pair<K, V>(key, value);
        counter++;
        rehash();
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        int i = 1;
        while (arr[index] != null) {
            if (arr[index].getKey() == key) {
                V oldValue = arr[index].getValue();
                arr[index] = null;
                counter--;
                return oldValue;
            }
            index = (key.hashCode() * i++) % arr.length;
        }
        return null;
    }

    @Override
    public void clear() {
        arr = new Pair[initialCapacity];
        counter = 0;
    }

    @Override
    public Set<K> keySet() {
        if (isEmpty()) return null;
        Set<K> set = new TreeSet<>();
        for (Pair<K, V> pair : arr) {
            if (pair != null)
                set.add(pair.getKey());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        if (isEmpty()) return null;
        Collection<V> collection = new ArrayList<>();
        for (Pair<K, V> pair : arr) {
            if (pair != null)
                ((ArrayList<V>) collection).add(pair.getValue());
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new TreeSet<>();
        for (Pair<K, V> pair : arr) {
            if (pair != null) {
                set.add(pair);
            }
        }
        return set;
    }

    @Override
    public void rehash() {
        int size = 0;
        for (Pair<K, V> pair : arr) {
            if (pair != null) {
                size++;
            }
        }
        if (size <= arr.length * loadFactor) return;
        Pair<K, V>[] newOne = arr.clone();
        arr = new Pair[arr.length * 2];
        for (Pair<K, V> pair : newOne) {
            if (pair != null)
                put(pair.getKey(), pair.getValue());
        }
    }

    public void show() {
        int i = 0;
        for (Pair<K, V> pair : arr) {
            if (pair != null) {
                System.out.println(i + ">  " + pair.getKey() + " " + pair.getValue() + "|| ");
            } else {
                System.out.println(i + "> ");
            }
            i++;
        }

    }

}
