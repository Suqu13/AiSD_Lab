package Nodes;

public abstract class AbstractNode<K, V> {

    protected K key;
    protected V value;
    protected AbstractNode leftChild;
    protected AbstractNode rightChild;
    protected AbstractNode parent;


    public AbstractNode(K key,V value ,AbstractNode parent) {
        this.key = key;

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public AbstractNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AbstractNode leftChild) {
        this.leftChild = leftChild;
    }

    public AbstractNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AbstractNode rightChild) {
        this.rightChild = rightChild;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public AbstractNode getParent() {
        return parent;
    }

    public void setParent(AbstractNode parent) {
        this.parent = parent;
    }

}
