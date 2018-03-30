public interface List<E> {
    public void add(E object);
    public void add(int index, E object);
    public boolean remove(E object);
    public void removeIndex(int index);
    public void clear();
    public boolean isEmpty();
    public int size();
    public void set(int index, E object);
    public boolean contains(E object);
    public int lastIndexOf(E object);
    public int indexOf(E object);
    public E get(int index);
}
