public class MyLinkedList<T> implements LinkedList<T> {

    private class Element {

        Element next;
        Element previous;
        T value;

        public Element(T value) {
            this.value = value;
        }

        public Element() {

        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrevious() {
            return previous;
        }

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    Element head = new Element();

    @Override
    public void add(T ob) {
        Element newElement = new Element(ob);
        if (head.getNext() == null) {
            newElement.setPrevious(head);
            head.setNext(newElement);
        } else {
            Element eL = head;
            while (eL.getNext() != null) {
                eL = eL.getNext();
            }
            newElement.setPrevious(eL);
            newElement.setNext(null);
            eL.setNext(newElement);
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void add(int index, T ob) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if (index == size()) {
            add(ob);
            return;
        }
        Element newElement = new Element(ob);
        Element eL = head;
        int i = 0;
        while (eL.getNext() != null) {
            if (index == i) {
                Element eL_1 = eL.getNext();
                eL.setNext(newElement);
                newElement.setPrevious(eL);
                newElement.setNext(eL_1);
                eL_1.setPrevious(newElement);
                return;
            }
            eL = eL.getNext();
            i++;
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void addFirst(T ob) {
        Element newElement = new Element(ob);
        if (head.getNext() == null) {
            head.setNext(newElement);
            newElement.setPrevious(head);
            newElement.setNext(null);
        } else {
            Element eL_1 = head.getNext();
            head.setNext(newElement);
            newElement.setPrevious(head);
            newElement.setNext(eL_1);
            eL_1.setPrevious(newElement);
        }
    }

    @Override
    public void set(int index, T ob) throws IndexOutOfBoundsException {

    }

    @Override
    public void clear() {
        head.getNext().setPrevious(null);
        head.setNext(null);
    }

    @Override
    public boolean contains(T ob) {
        Element eL = head;
        while (eL != null) {
            if (ob.equals(eL.getValue())) return true;
            eL = eL.getNext();
        }
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        Element eL = head;
        int i = 0;
        while (eL.getNext() != null) {
            if (index == i) {
                return eL.getNext().getValue();
            }
            eL = eL.getNext();
            i++;
        }
        return null;
    }

    @Override
    public T getFirst() throws NullPointerException {
        if (head.getNext() == null) throw new NullPointerException();
        return head.getNext().getValue();
    }

    @Override
    public T getLast() throws NullPointerException {
        Element eL = head;
        while (eL.getNext() != null) {
            eL = eL.getNext();
        }
        if (eL == head) throw new NullPointerException();
        return eL.getValue();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public int indexOf(T ob) {
        Element eL = head;
        int i = 0;
        while (eL.getNext() != null) {
            if (ob.equals(eL.getNext().getValue())) {
                return i;
            }
            eL = eL.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T ob) {
        Element eL = head;
        int n = -1;
        int i = 0;
        while (eL.getNext() != null) {
            if (ob.equals(eL.getNext().getValue())) {
                n = i;
            }
            eL = eL.getNext();
            i++;
        }
        return n;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        Element eL = head;
        int i = 0;
        while (eL.getNext() != null) {
            eL = eL.getNext();
            if (i == size() - 1) {
                eL.getPrevious().setNext(null);
                eL.setPrevious(null);
                eL.setNext(null);
                break;
            }
            if (index == i) {
                eL.getPrevious().setNext(eL.getNext());
                eL.getNext().setPrevious(eL.getPrevious());
                eL.setPrevious(null);
                eL.setNext(null);
                break;
            }
            i++;
        }
        return eL.getValue();
    }

    @Override
    public T remove(T ob) {
        Element eL = head;
        while (eL.getNext() != null) {
            eL = eL.getNext();
            if (ob.equals(eL.getValue())) {
                if (eL.getNext() == null) {
                    eL.getPrevious().setNext(null);
                    eL.setNext(null);
                    eL.setPrevious(null);
                    break;
                } else {
                    eL.getPrevious().setNext(eL.getNext());
                    eL.getNext().setPrevious(eL.getPrevious());
                    eL.setNext(null);
                    eL.setPrevious(null);
                    break;
                }
            }

        }
        return eL.getValue();
    }

    @Override
    public T removeFirst() throws NullPointerException {
        Element eL = head.getNext();
        if (eL == null) throw new NullPointerException();
        if (eL.getNext() == null) {
            head.setNext(null);
        } else {
            head.setNext(eL.getNext());
            eL.getNext().setPrevious(head);
        }
        eL.setPrevious(null);
        eL.setNext(null);
        return eL.getValue();
    }

    @Override
    public T removeLast() {
        Element eL = head;
        while (eL.getNext() != null) {
            eL = eL.getNext();
            if (eL.getNext() == null && eL != head) {
                eL.getPrevious().setNext(null);
                eL.setPrevious(null);
            }
        }
        if (eL == head) throw new NullPointerException();
        return eL.getValue();
    }

    @Override
    public int size() {
        Element eL = head;
        int i = 0;
        while (eL.getNext() != null) {
            eL = eL.getNext();
            i++;
        }
        return i;
    }

    public void show() {
        Element eL = head.getNext();
        while (eL != null) {
            System.out.println(eL.getValue());
            eL = eL.getNext();
        }
    }
}
