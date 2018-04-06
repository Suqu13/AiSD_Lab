import java.util.ArrayList;

public class MyStack<T> implements Stack {

    private ArrayList<T> myStack = new ArrayList<T>();

    @Override
    public boolean isEmpty() {
        if(myStack.isEmpty()) return true;
        return false;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty()) throw new EmptyStackException();
        T ob = myStack.get(myStack.size()-1);
        myStack.remove(myStack.size()-1);
        return ob;
    }

    @Override
    public void push(Object first, Object last) {
        myStack.add((T) first);
        myStack.add((T) last);
    }


    @Override
    public int size() {
        return myStack.size();
    }

}
