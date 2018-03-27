import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayStack<T> implements Stack  {

    private int top;
    private T array[];

    @SuppressWarnings("unchecked")
    public ArrayStack (int stackSize){
        array= (T[])(new Object[stackSize]);
        top=0;
    }

    @Override
    public boolean isFull() {
        if(top==array.length){
            return true;
        } else {
            return false;
        }
    }

    public int showTop(){
        return top;
    }

    @Override
    public boolean isEmpty() {
        if(top==0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T pop() throws EmptyStackExceptionE {
        if(isEmpty()==true)
            throw new EmptyStackExceptionE();
        return array[--top];
    }

    @Override
    public void push(Object ob) throws FullStackException {
        if (isFull())
            throw new FullStackException();
        array[top++]=(T) ob;
    }

}
