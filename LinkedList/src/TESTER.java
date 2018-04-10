import java.util.ArrayList;

public class TESTER {
    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        ArrayList list = new ArrayList();

        String q = "kara";
        String s = "nazwa";
        String z = "zaraza";
        String w = "wstawione";
        int i = 66;
        double d = 2.75;
        double g = 0.98;

        linkedList.add(s);
        linkedList.add(q);
        linkedList.add(z);
        linkedList.add(w);
        linkedList.add(2, d);

        System.out.println("\n");

        System.out.println("1");
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));

        System.out.println("\n");

        linkedList.show();

        System.out.println("\n");

        linkedList.set(0, q);
        linkedList.set(4, z);

        linkedList.show();

        System.out.println("\n");

        // System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.remove(2));

        System.out.println("\n");

        linkedList.show();

    }
}
