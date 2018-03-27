public interface Stack<T> {
    public boolean isFull();
    public boolean isEmpty();
    public T pop() throws EmptyStackExceptionE;
    public void push(T ob) throws FullStackException;
}
