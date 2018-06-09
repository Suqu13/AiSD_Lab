package hash_table;

public class TESTER {
    public static void main(String[] args) {
        HashTableOA hashTableAO = new HashTableOA();




        hashTableAO.put(16, 4);
        hashTableAO.put(31, 5);
        hashTableAO.put(15, "d");
        hashTableAO.put(34, 5);
        hashTableAO.put(10, 4);
        hashTableAO.put(51, 5);
        hashTableAO.put(13, "$");
        /*hashTableAO.put(31, 5);
        hashTableAO.put(66, 4);
        hashTableAO.put(36, "%");
        hashTableAO.put("as", 4);
        hashTableAO.put("ada", 5);
        hashTableAO.put(14, "d");
        hashTableAO.put(13, 5);*/

        hashTableAO.show();
        hashTableAO.remove(13);
        System.out.println(" ");
        hashTableAO.show();



    }
}
