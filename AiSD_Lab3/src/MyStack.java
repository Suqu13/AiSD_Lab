import java.util.ArrayList;

public class MyStack<T> implements Stack<T> {

    private ArrayList<T> myStack = new ArrayList<T>();
    int max = Integer.MIN_VALUE;

    @Override
    public boolean isEmpty() {
        return myStack.isEmpty();
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty()) throw new EmptyStackException();
        return myStack.remove(myStack.size()-1);
    }

    @Override
    public void push(T ob) {
        myStack.add(ob);
    }


    @Override
    public int size() {
        return myStack.size();
    }

    @Override
    public int maximumStackHeight() {
        if (myStack.size() > max) max = myStack.size();
        return max;
    }

}
