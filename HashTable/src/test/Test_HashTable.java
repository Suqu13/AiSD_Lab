package test;

import hash_table.HashTableOA;
import hash_table.HashTableSC;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test_HashTable {
    HashTableSC<Integer, String> integerStringHashTableSC;
    HashTableOA<Integer, String> integerStringHashTableOA;

    @Before
    public void prepar() {
        integerStringHashTableSC = new HashTableSC<>();
        integerStringHashTableOA = new HashTableOA<>();
    }

    @Test
    public void containsKey() {
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.containsKey(null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.containsKey(null));

        assertEquals(false, integerStringHashTableSC.containsKey(34));
        assertEquals(false, integerStringHashTableSC.containsKey("ds"));

        assertEquals(false, integerStringHashTableOA.containsKey(34));
        assertEquals(false, integerStringHashTableOA.containsKey("ds"));

        integerStringHashTableSC.put(34, "ala");
        integerStringHashTableOA.put(34, "ala");

        assertEquals(true, integerStringHashTableSC.containsKey(34));
        assertEquals(true, integerStringHashTableOA.containsKey(34));

    }

    @Test
    public void containsValue() {
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.containsValue(null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.containsValue(null));


        assertEquals(false, integerStringHashTableSC.containsValue(34));
        assertEquals(false, integerStringHashTableSC.containsValue("ds"));

        assertEquals(false, integerStringHashTableOA.containsValue(34));
        assertEquals(false, integerStringHashTableOA.containsValue("ds"));

        integerStringHashTableSC.put(34, "ala");
        integerStringHashTableOA.put(34, "ala");


        assertEquals(true, integerStringHashTableSC.containsValue("ala"));
        assertEquals(false, integerStringHashTableSC.containsValue("ds"));

        assertEquals(true, integerStringHashTableOA.containsValue("ala"));
        assertEquals(false, integerStringHashTableOA.containsValue("ds"));
    }

    @Test
    public void get() {
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.get(null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.get(null));


        assertEquals(null, integerStringHashTableSC.get(323));
        assertEquals(null, integerStringHashTableOA.get(323));

        integerStringHashTableSC.put(34, "ala");
        integerStringHashTableOA.put(34, "ala");

        assertEquals("ala", integerStringHashTableSC.get(34));
        assertEquals("ala", integerStringHashTableOA.get(34));
    }

    @Test
    public void put() {
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.put(null, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.put(34, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.put(null, "ala"));

        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.put(null, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.put(34, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.put(null, "ala"));

        assertEquals(null, integerStringHashTableSC.put(34, "ala"));
        assertEquals("ala", integerStringHashTableSC.put(34, "grzegorz"));

        assertEquals(null, integerStringHashTableOA.put(34, "ala"));
        assertEquals("ala", integerStringHashTableOA.put(34, "grzegorz"));
    }

    @Test
    public void remove() {
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.remove(null));

        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.remove(null));

        assertEquals(null, integerStringHashTableSC.remove(34));
        assertEquals(null, integerStringHashTableSC.remove("ala"));

        assertEquals(null, integerStringHashTableOA.remove(34));
        assertEquals(null, integerStringHashTableOA.remove("ala"));

        integerStringHashTableSC.put(34, "ala");
        integerStringHashTableOA.put(34, "ala");


        assertEquals("ala", integerStringHashTableSC.remove(34));
        assertEquals("ala", integerStringHashTableOA.remove(34));

    }


    @Test
    public void keySet() {
        assertEquals(null, integerStringHashTableSC.keySet());
        assertEquals(null, integerStringHashTableOA.keySet());


        integerStringHashTableSC.put(1, "ala");
        integerStringHashTableSC.put(2, "ma");
        integerStringHashTableSC.put(3, "kota");

        integerStringHashTableOA.put(1, "ala");
        integerStringHashTableOA.put(2, "ma");
        integerStringHashTableOA.put(3, "kota");

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        Set<Integer> set = integerStringHashTableSC.keySet();
        assertEquals(hashSet, set);

        set = integerStringHashTableOA.keySet();
        assertEquals(hashSet, set);

    }

    @Test
    public void values() {
        assertEquals(null, integerStringHashTableSC.values());

        assertEquals(null, integerStringHashTableOA.values());


        integerStringHashTableSC.put(1, "ala");
        integerStringHashTableSC.put(2, "ma");
        integerStringHashTableSC.put(3, "kota");

        integerStringHashTableOA.put(1, "ala");
        integerStringHashTableOA.put(2, "ma");
        integerStringHashTableOA.put(3, "kota");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ala");
        arrayList.add("ma");
        arrayList.add("kota");

        Collection<String> collection = integerStringHashTableSC.values();
        assertEquals(arrayList, collection);

        collection = integerStringHashTableOA.values();
        assertEquals(arrayList, collection);
    }

    @Test
    public void putAll() {

        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.putAll(null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.putAll(null));
    }

    @Test
    public void putIfAbsent() {
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.putIfAbsent(null, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.putIfAbsent(34, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableSC.putIfAbsent(null, "ala"));

        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.putIfAbsent(null, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.putIfAbsent(34, null));
        assertThrows(NullPointerException.class, () -> integerStringHashTableOA.putIfAbsent(null, "ala"));

        assertEquals(null, integerStringHashTableSC.putIfAbsent(34, "ala"));
        assertEquals("ala", integerStringHashTableSC.putIfAbsent(34, "ffff"));

        assertEquals(null, integerStringHashTableOA.putIfAbsent(34, "ala"));
        assertEquals("ala", integerStringHashTableOA.putIfAbsent(34, "ffff"));
    }

    @Test
    public void size() {
        assertEquals(0, integerStringHashTableSC.size());
        assertEquals(0, integerStringHashTableOA.size());

        integerStringHashTableSC.put(2, "ala");
        integerStringHashTableSC.put(33, "al2a");
        integerStringHashTableSC.put(23, "al2£");

        integerStringHashTableOA.put(2, "ala");
        integerStringHashTableOA.put(33, "al2a");
        integerStringHashTableOA.put(23, "al2£");

        assertEquals(3, integerStringHashTableSC.size());

        integerStringHashTableSC.remove(23);

        assertEquals(2, integerStringHashTableSC.size());

        integerStringHashTableSC.clear();

        assertEquals(0, integerStringHashTableSC.size());

        assertEquals(3, integerStringHashTableOA.size());

        integerStringHashTableOA.remove(23);

        assertEquals(2, integerStringHashTableOA.size());

        integerStringHashTableOA.clear();

        assertEquals(0, integerStringHashTableOA.size());

    }


}
