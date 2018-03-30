public class ArrayListWithoutCapicity<E> implements List<E> {

    private E[] tab = null;

    @Override
    public void add(E object) {
        if (tab == null) {
            tab = (E[]) new Object[1];
            tab[0] = object;
        } else {
            E[] tab_1 = (E[]) new Object[tab.length + 1];
            for (int i = 0; i < tab.length; i++) {
                tab_1[i] = tab[i];
            }
            tab_1[tab.length] = object;
            tab = tab_1;
        }

    }

    @Override
    public void add(int index, E object) {
        if (index < 0 || tab.length < index) throw new IndexOutOfBoundsException();
        if (index == tab.length) {
            add(object);
            return;
        }
        E[] tab_1 = (E[]) new Object[tab.length + 1];
        int j = 0;
        for (int i = 0; i < tab.length; i++) {
            if (index == j) {
                tab_1[j] = object;
                j++;
            }
            tab_1[j] = tab[i];
            j++;
        }
        tab = tab_1;
    }


    public void show() {
        if (tab == null) throw new NullPointerException();
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    @Override
    public boolean remove(E object) {
        if (tab == null) throw new NullPointerException();
        boolean t = contains(object);
        if (t == true) {
            E[] tab_1 = (E[]) new Object[tab.length - 1];
            int j = 0;
            int n = 0;
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] == object && n == 0) {
                    n = 1;
                } else {
                    tab_1[j] = tab[i];
                    j++;
                }
            }
            if (tab_1.length == 0) tab_1 = null;
            tab = tab_1;
        }
        return t;
    }

    @Override
    public void removeIndex(int index) {
        if (index < 0 || index >= tab.length) throw new IndexOutOfBoundsException();
        if (tab == null) throw new NullPointerException();
        E[] tab_1 = (E[]) new Object[tab.length - 1];
        int j = 0;
        for (int i = 0; i < tab.length; i++) {
            if (index == i) {
            } else {
                tab_1[j] = tab[i];
                j++;
            }
        }
        if (tab_1.length == 0) tab_1 = null;
        tab = tab_1;
    }

    @Override
    public void clear() {
        tab = null;

    }

    @Override
    public boolean isEmpty() {
        if (tab == null) return true;
        return false;
    }

    @Override
    public int size() {
        return tab.length;
    }

    @Override
    public void set(int index, E object) {
        if (index < 0 || index >= tab.length) throw new IndexOutOfBoundsException();
        tab[index] = object;
    }

    @Override
    public boolean contains(E object) {
        if (tab == null) throw new NullPointerException();
        boolean t = false;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == object) {
                t = true;
            }
        }
        return t;
    }

    @Override
    public int lastIndexOf(E object) {
        if (tab == null) throw new NullPointerException();
        int index = -1;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == object) {
                index = i;
            }
        }
        if (index != -1) {
            return index;
        }
        return index;
    }

    @Override
    public int indexOf(E object) {
        if (tab == null) throw new NullPointerException();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == object) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if(tab == null) throw new NullPointerException();
        return tab[index];
    }


}