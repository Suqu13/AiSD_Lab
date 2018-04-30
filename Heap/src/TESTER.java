import Structure.Heap;
import Structure.MaxHeap;
import Structure.MinHeap;

import java.util.ArrayList;

public class TESTER {

    /* GENERATOR LOSOWYCH LICZB BEZ POWTÓRZEŃ */
    public static ArrayList<Integer> generate(){

        ArrayList<Integer> list = new ArrayList<>();
        int k = 0;
        while (k < 20) {

            boolean t = true;
            int n = (int) (Math.random() * 100);
            for (Integer i : list) {
                if (i == n) {
                    t = false;
                }
            }
            if (t) {
                list.add(n);
            } else {
                continue;
            }
            k++;
        }
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list1 = generate();
        ArrayList<Integer> list2 = generate();


        Heap maxHeap = new MaxHeap();
        Heap minHeap = new MinHeap();

        System.out.println("\nNumbers: list1");
        for (int l : list1) {
            System.out.print(l + " ");
        }

        System.out.println("");
        System.out.println("\nMaxHeap- heapify");
        maxHeap.heapify(list1);
        maxHeap.show();

        //Usuwa losowe elementy z kopca
        System.out.println("");
        System.out.println("\nMaxHeap- removed");
        maxHeap.remove(list1.get((int) (Math.random()*19)));
        maxHeap.remove(list1.get((int) (Math.random()*18)));
        maxHeap.show();

        System.out.println("\n");
        System.out.println("\nNumbers: list2");
        for (int l : list2) {
            System.out.print(l + " ");
        }

        System.out.println("");
        System.out.println("\nMinHeap- heapify");
        minHeap.heapify(list2);
        minHeap.show();

        //Usuwa losowe elementy z kopca
        System.out.println("");
        System.out.println("\nMinHeap- removed");
        minHeap.remove(list2.get((int) (Math.random()*19)));
        minHeap.remove(list2.get((int) (Math.random()*18)));
        minHeap.show();

        System.out.println("\n");
    }
}
