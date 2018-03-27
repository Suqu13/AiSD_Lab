import java.util.Iterator;

public class FilterIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private Predicate<T> predicate;

    public FilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
        super();
        this.iterator = iterator;
        this.predicate = predicate;
        findNextValue();
    }

    private T newElement = null;
    private boolean newHasNext = true;

    private void findNextValue() {
        while (iterator.hasNext()) {
            newElement = iterator.next();
            if (predicate.accepept(newElement)) {
                return;
            }
        }
        newElement = null;
        newHasNext = false;
    }

    @Override
    public boolean hasNext() {
        return newHasNext;
    }

    @Override
    public T next() {
        T nextValue = newElement;
        findNextValue();
        return nextValue;
    }
}
