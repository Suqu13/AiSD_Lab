public class MyQueue<T> implements IQueue {

    //BRAKUJE METODY, KTÓRA ZMIENIA ITERACJE

    private int ending;
    private int beginning;
    private T[] array;

    public MyQueue(int size) {
        int t = size + 1;
        array = (T[]) (new Object[t]);
        if (t == 0) {
            ending = (size) / 2;
            beginning = ending;
        } else {
            t++;
            ending = (size) / 2;
            beginning = ending;
        }
    }


    @Override
    public boolean isEmpty() {
        boolean t = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                t = false;
            }
        }
        return t;
    }

    @Override
    public boolean isFull() {
        /*boolean t = false;
        for (int i = 0; i < array.length; i++) {
            if (i != ending && array[i] != null) {
                t = true;
            }
        }
        return false;*/

        if (beginning < ending) {
            if (beginning == 0) {
                return ending == array.length - 1;
            } else {
                return false;
            }
        } else {
            return ending == beginning - 1;
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int n = beginning;
        T objectT = array[n];
        array[n] = null;
        n++;
        beginning = this.takeLastOrFirst(n);
        return objectT;

    }

    public void showBE() {
        System.out.println("\nPoczątek: " + beginning + "\nKoniec: " + ending + "\n");
    }


    @Override
    public void enqueue(Object object) throws FullQueueException {
        if (isFull() || array[ending] != null) {
            throw new FullQueueException();
        } else {
            int n = ending;
            array[n] = (T) object;
            n++;
            ending = this.takeLastOrFirst(n);
        }

    }

    @Override
    public T first() throws EmptyQueueException {
        return array[beginning];
    }

    @Override
    public int sizeQueue() {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                n++;
        }
        return n;
    }

    public int takeLastOrFirst(int n) {
        if (n < 0) {
            n = array.length - 1;
        }
        if (n > array.length - 1) {
            n = 0;
        }
        return n;
    }
}
