public interface Stack<T> {
    public boolean isEmpty();
    public T pop() throws EmptyStackException;
    public void push(T first, T last);
    public int size();
}
