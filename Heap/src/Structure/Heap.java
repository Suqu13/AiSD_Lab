package Structure;

import java.util.ArrayList;

public abstract class Heap {
    public abstract void heapify(ArrayList<Integer> list);

    public abstract void insert(Integer object);

    protected abstract void fix();

    public abstract boolean remove(Integer object);

    public abstract void show();

    public abstract void clear();


}
