public interface LinkedList<T> {
    public void add(T ob);
    public void add(int index, T ob) throws IndexOutOfBoundsException;
    public void addFirst(T ob);
    public void set(int index, T ob) throws IndexOutOfBoundsException;
    public void clear();
    public boolean contains(T ob);
    public T get(int index) throws IndexOutOfBoundsException;
    public T getFirst() throws NullPointerException;;
    public T getLast() throws NullPointerException;
    public int indexOf(T ob);
    public int lastIndexOf(T ob);
    public T remove(int index) throws IndexOutOfBoundsException;
    public T remove(T ob);
    public T removeFirst() throws NullPointerException;
    public T removeLast() throws NullPointerException;
    public int size();
}
