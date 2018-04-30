package Structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap extends Heap {

    private List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    @Override
    public void heapify(ArrayList<Integer> list_) {
        for (Integer i : list_) {
            list.add(i);
        }
        fix();
    }

    @Override
    public void insert(Integer object) {
        list.add(object);
        fix();

    }

    @Override
    protected void fix() {
        for (int index = list.size() - 1; index >= 0; index--) {
            int i = index;
            int previous;

            while (i > 0) {

                boolean swapped = false;

                if ((i - 1) % 2 == 0) {
                    previous = (i - 1) / 2;
                } else {
                    previous = (i - 2) / 2;
                }

                if (list.get(i) < list.get(previous)) {
                    Collections.swap(list, i, previous);
                    swapped = true;
                }

                if (swapped) {
                    i = index;
                } else if (i == 0) {
                    i = -1;
                } else {
                    i = previous;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public boolean remove(Integer object) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == object) {
                Collections.swap(list, i, list.size() - 1);
                list.remove(list.size() - 1);
                fix();
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void clear() {
        list.clear();
    }


}




