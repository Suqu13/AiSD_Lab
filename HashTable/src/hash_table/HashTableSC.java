package hash_table;

import java.util.*;

public class HashTableSC<K, V> extends HashTable<K, V> {
    private LinkedList<Pair<K, V>>[] arr;

    public HashTableSC() {
        arr = new LinkedList[super.initialCapacity];
        fill();
    }

    private void fill() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        for (Pair pair : arr[index]) {
            if (pair.getKey() == key)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) throw new NullPointerException();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) {
                for (Pair pair : arr[i]) {
                    if (pair.getValue() == value)
                        return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        for (Pair pair : arr[index]) {
            if (pair.getKey() == key)
                return (V) pair.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        Pair<K, V> pair = new Pair<K, V>(key, value);
        V previousValue = get(key);
        if (arr[index].isEmpty()) {
            arr[index].add(pair);
        } else {
            for (Pair<K, V> pair_ : arr[index]) {
                if (pair_.getKey() == key) {
                    pair_.setValue(value);
                    return previousValue;
                }
            }
            arr[index].add(pair);
        }
        counter++;
        rehash();
        return previousValue;
    }

    @Override
    public V remove(Object key) {
        if (key == null) throw new NullPointerException();
        int index = key.hashCode() % arr.length;
        for (Pair pair : arr[index]) {
            if (pair.getKey() == key) {
                V v = (V) pair.getValue();
                arr[index].remove(pair);
                counter--;
                return v;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        arr = new LinkedList[super.initialCapacity];
        counter = 0;
        fill();
    }

    @Override
    public Set<K> keySet() {
        if (isEmpty()) return null;
        Set<K> set = new TreeSet<>();
        for (LinkedList<Pair<K, V>> list : arr) {
            for (Pair<K, V> pair : list) {
                set.add(pair.getKey());
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        if (isEmpty()) return null;
        Collection<V> collection = new ArrayList<>();
        for (LinkedList<Pair<K, V>> list : arr) {
            for (Pair<K, V> pair : list) {
                collection.add(pair.getValue());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new TreeSet<>();
        for (LinkedList<Pair<K, V>> list : arr) {
            for (Pair<K, V> pair : list) {
                set.add(pair);
            }
        }
        return set;
    }

    @Override
    public void rehash() {
        int size = 0;
        for (LinkedList<Pair<K, V>> list : arr) {
            if (!list.isEmpty()) {
                size++;
            }
        }
        if (size <= arr.length * loadFactor) return;
        LinkedList<Pair<K, V>>[] newOne = arr.clone();
        arr = new LinkedList[arr.length * 2];
        fill();
        for (LinkedList<Pair<K, V>> list : newOne) {
            for (Pair<K, V> pair : list) {
                put(pair.getKey(), pair.getValue());
            }

        }

    }

    public void show() {
        int i = 0;
        for (LinkedList<Pair<K, V>> list : arr) {
            System.out.print("\n" + i + " > ");
            int j = 0;
            for (Pair<K, V> pair : list) {
                System.out.print(j + " " + pair.getKey() + " " + pair.getValue() + "|| ");
                j++;
            }
            i++;
        }
    }


}
