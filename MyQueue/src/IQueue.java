public interface IQueue<T> {

    boolean isEmpty();
    boolean isFull();
    public T dequeue() throws EmptyQueueException;
    public void enqueue(T object) throws FullQueueException;
    public T first() throws EmptyQueueException;
    public int sizeQueue();
}
