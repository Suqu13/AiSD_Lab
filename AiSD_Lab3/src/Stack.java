public interface Stack<T> {
    public boolean isEmpty();
    public T pop() throws EmptyStackException;
    public void push(T ob);
    public int size();
    public int maximumStackHeight();

}
