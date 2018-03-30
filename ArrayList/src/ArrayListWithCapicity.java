public class ArrayListWithCapicity<E> implements List<E> {

    private static final int defaultCapicity = 16;
    private int initialCapicity;
    private E[] tab;
    private int size = 0;

    public ArrayListWithCapicity() {
        this(defaultCapicity);
    }

    public ArrayListWithCapicity(int initialCapicity) {
        if (initialCapicity <= 0) this.initialCapicity = defaultCapicity;
        tab = (E[]) new Object[this.initialCapicity];
        size = 0;
    }

    private void ensureCapicity(int capicity) {
        if (tab.length < capicity) {
            E[] copy = (E[]) new Object[capicity + capicity / 2];
            System.arraycopy(tab, 0, copy, 0, size);
            tab = copy;
        }
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }


    @Override
    public void add(E object) {
        ensureCapicity(size + 1);
        tab[size] = object;
        size++;
    }

    @Override
    public void add(int index, E object) {
        checkOutOfBounds(index);
        ensureCapicity(size + 1);
        if (index != size) System.arraycopy(tab, index, tab, index + 1, size - index);
        tab[index] = object;
        size++;

    }

    @Override
    public boolean remove(E object) {
        int index = indexOf(object);
        if (index != -1) {
            size --;
            System.arraycopy(tab, index + 1, tab, index, size - index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeIndex(int index) {
        checkOutOfBounds(index);
        size -= 1;
        System.arraycopy(tab, index + 1, tab, index, size - index);

    }

    @Override
    public void clear() {
        tab = (E[]) new Object[initialCapicity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E object) {
        checkOutOfBounds(index);
        tab[index] = object;

    }

    @Override
    public boolean contains(E object) {
        boolean t = false;
        int i = 0;
        while (i < size) {
            if (object.equals(tab[i])) {
                t = true;
            }
            i++;
        }
        return t;
    }

    @Override
    public int lastIndexOf(E object) {
        int i = 0;
        int n = -1;
        while (i < size) {
            if (object.equals(tab[i])) {
                n = i;
            }
            i++;
        }
        return n;
    }

    @Override
    public int indexOf(E object) {
        int i = 0;
        while (i < size && !object.equals(tab[i])) i++;
        return i < size ? i : -1;
    }

    @Override
    public E get(int index) {
        checkOutOfBounds(index);
        return tab[index];
    }


    public void show(){
        int i = 0;
        while (i < size){
            System.out.println(tab[i]);
            i++;
        }
    }
}
