public class TESTER {
    public static void main(String[] args) {
        //BRAK METODY, KTÓRA ZMIENIA ITERACJE

        String S = "Elo";
        boolean B = false;
        double D = 2.23;
        char C = 'x';
        int I = 2;

        MyQueue myQueue=new MyQueue(5);

        System.out.println("\n");

        myQueue.showBE();


        try {
            myQueue.enqueue(S);
            System.out.println("1");
            myQueue.showBE();

            myQueue.enqueue((Object) B);
            System.out.println("2");
            myQueue.showBE();

            myQueue.enqueue((Object) D);
            System.out.println("3");
            myQueue.showBE();

            myQueue.enqueue((Object) C);
            System.out.println("4");
            myQueue.showBE();

            myQueue.enqueue((Object) I);
            System.out.println("5");
            myQueue.showBE();

            myQueue.enqueue((Object) I);
            System.out.println("6");
            myQueue.showBE();


        } catch (FullQueueException e) {
            e.MyFull();
        }

        myQueue.showBE();

        System.out.println("\nSize: " + myQueue.sizeQueue());


        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }
        System.out.println("\nSize: " + myQueue.sizeQueue());

        myQueue.showBE();


        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }
        System.out.println("\nSize: " + myQueue.sizeQueue());

        myQueue.showBE();

        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }
        System.out.println("\nSize: " + myQueue.sizeQueue());

        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }
        System.out.println("\nSize: " + myQueue.sizeQueue());

        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }
        System.out.println("\nSize: " + myQueue.sizeQueue());

        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }

        try {
            System.out.println("Element: " + myQueue.dequeue());
        } catch (EmptyQueueException e) {
            e.MyEmpty();
        }
    }
}
