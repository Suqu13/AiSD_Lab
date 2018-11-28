package Trees;

import Nodes.AbstractNode;

import java.util.function.BiFunction;


public abstract class Tree<K extends Comparable<? super K>> {

    protected AbstractNode root;
    protected int size = 0;

    protected BiFunction<K, K, Integer> compareKeys = (key1, key2) -> key1.compareTo(key2);


    public abstract boolean insert(K key);

    public boolean search(K key) {
        if (key == null) throw new NullPointerException();
        return recursiveSearch(key, root);
    }

    private boolean recursiveSearch(K key, AbstractNode node) {
        if (node == null) return false;
        if (compareKeys.apply((K) node.getKey(), key) > 0) {
            return recursiveSearch(key, node.getLeftChild());
        } else if (compareKeys.apply((K) node.getKey(), key) < 0) {
            return recursiveSearch(key, node.getRightChild());
        } else {
            return true;
        }
    }

    public abstract AbstractNode remove(K key);

    protected AbstractNode consequent(AbstractNode node) {
        if (node == null) throw new NullPointerException();
        return goLeft(node.getRightChild());
    }

    protected AbstractNode goLeft(AbstractNode node) {
        if (node.getLeftChild() != null) {
            return goLeft(node.getLeftChild());
        } else {
            return node;
        }
    }

    protected AbstractNode predecessor(AbstractNode node) {
        if (node == null) throw new NullPointerException();
        return goRight(node.getLeftChild());
    }

    protected AbstractNode goRight(AbstractNode node) {
        if (node.getRightChild() != null) {
            return goRight(node.getRightChild());
        } else {
            return node;
        }
    }

    public AbstractNode getMin() {
        return goLeft(root);
    }

    public AbstractNode getMax() {
        return goRight(root);
    }

    public int getHeight() {
        return countHeight(root);
    }

    private int countHeight(AbstractNode node) {
        int n = 0;
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return n;
        } else if (node.getLeftChild() != null && node.getRightChild() == null) {
            return countHeight(node.getLeftChild()) + 1;
        } else if (node.getLeftChild() == null && node.getRightChild() != null) {
            return countHeight(node.getRightChild()) + 1;
        } else {
            int value1 = countHeight(node.getRightChild()) + 1;
            int value2 = countHeight(node.getLeftChild()) + 1;
            if (value1 > value2) {
                return value1;
            }
            return value2;
        }
    }

    public int nodesNumber() {
        return getSize() - leavesNumber();
    }

    public int leavesNumber() {
        return countLeaves(root);
    }

    private int countLeaves(AbstractNode node) {
        int n = 0;
        if (node == null) return n;
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return n + 1;
        }
        return countLeaves(node.getLeftChild()) + countLeaves(node.getRightChild()) + n;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
