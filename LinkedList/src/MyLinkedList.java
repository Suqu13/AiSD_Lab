public class MyLinkedList<T> implements LinkedList<T> {

    private class Element {
        /*
        next- information about next element
        previous- information about previous element
        value- current value

        */
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

    /*
    This method adds the new element to the linkedlist. It considers two options, when the linkedlist is empty and when there is
    some elements.
     */

    @Override
    public void add(T ob) {
        Element newElement = new Element(ob);
        if (head.getNext() == null) {
            newElement.setPrevious(head);
            head.setNext(newElement);
        } else {
            Element eL = head;
            // this loop is searching for the last element in the linkedlist
            while (eL.getNext() != null) {
                eL = eL.getNext();
            }
            newElement.setPrevious(eL);
            newElement.setNext(null);
            eL.setNext(newElement);
        }
    }

    /*
    This method adds the new element in the specified list index. It has to check if the index is correct and
    consider two option. If the index is equal to the size of the list, we can use previous method (add).
     */

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
        // this loop is searching for the right index, counting elements and comparing counter to index
        while (eL.getNext() != null) {
            if (index == i) {
                newElement.setNext(eL.getNext());
                newElement.setPrevious(eL);
                eL.getNext().setPrevious(newElement);
                eL.setNext(newElement);
                return;
            }
            eL = eL.getNext();
            i++;
        }
    }

    /*
    Adds the new element on the first place in the linkedlist. Chooses one option, when the linkedlist is empty,
    or has some elements
     */
    @SuppressWarnings("Duplicates")
    @Override
    public void addFirst(T ob) {
        Element newElement = new Element(ob);
        newElement.setPrevious(head);
        if (head.getNext() == null) {
            newElement.setNext(null);
        } else {
            newElement.setNext(head.getNext());
            head.getNext().setPrevious(newElement);
        }
        head.setNext(newElement);
    }

    /*
    It sets the new value of the element on the specified index
     */
    @Override
    public void set(int index, T ob) throws IndexOutOfBoundsException {
        if (index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        Element eL = head.getNext();
        int i = 0;
        //the loop is finding the element with the specified index
        while (eL != null) {
            if (index == i) {
                eL.setValue(ob);
                return;
            }
            eL = eL.getNext();
            i++;
        }
    }
    /*
    makes the linkedlist empty/ clear
     */
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
        Element eL = head.getNext();
        int i = 0;
        while (eL != null) {
            if (index == i) {
                return eL.getValue();
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
            if (index == i) {
                if (i == size() - 1) {
                    eL.getPrevious().setNext(null);
                } else {
                    eL.getPrevious().setNext(eL.getNext());
                    eL.getNext().setPrevious(eL.getPrevious());
                }
                eL.setPrevious(null);
                eL.setNext(null);
                return eL.getValue();
            }
            i++;
        }
        return null;
    }

    @Override
    public T remove(T ob) {
        Element eL = head;
        while (eL.getNext() != null) {
            eL = eL.getNext();
            if (ob.equals(eL.getValue())) {
                if (eL.getNext() == null) {
                    eL.getPrevious().setNext(null);
                } else {
                    eL.getPrevious().setNext(eL.getNext());
                    eL.getNext().setPrevious(eL.getPrevious());
                }
                eL.setNext(null);
                eL.setPrevious(null);
                return eL.getValue();
            }
        }
        return null;
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
