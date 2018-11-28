package Trees;

import Nodes.AbstractNode;
import Nodes.NodeBST;

public class BST<K extends Comparable<? super K>> extends Tree<K> {


    @Override
    public boolean insert(K key) {
        return recursiveInsertion(key, root);
    }

    private boolean recursiveInsertion(K key, AbstractNode node) {
        if (key == null) throw new NullPointerException();
        if (root == null) {
            root = new NodeBST(key, null, null);
            size++;
            return true;
        }
        if (compareKeys.apply((K) node.getKey(), key) > 0) {
            if (node.getLeftChild() != null) {
                return recursiveInsertion(key, node.getLeftChild());
            } else {
                node.setLeftChild(new NodeBST(key, null, null));
                node.getLeftChild().setParent(node);
                size++;
                return true;
            }
        }
        if (compareKeys.apply((K) node.getKey(), key) < 0) {
            if (node.getRightChild() != null) {
                return recursiveInsertion(key, node.getRightChild());
            } else {
                node.setRightChild(new NodeBST(key, null, null));
                node.getRightChild().setParent(node);
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractNode remove(K key) {
        return recursiveRemoving(key, root);
    }

    private AbstractNode recursiveRemoving(K key, AbstractNode node) {
        if (key == null) throw new NullPointerException();
        if (root == null) return null;

        if (compareKeys.apply((K) node.getKey(), key) > 0) {
            return recursiveRemoving(key, node.getLeftChild());
        } else if (compareKeys.apply((K) node.getKey(), key) < 0) {
            if (node.getRightChild() != null) {
                return recursiveRemoving(key, node.getRightChild());
            }
        } else if (node.getRightChild() == null && node.getLeftChild() == null) {
            if (compareKeys.apply((K) node.getParent().getKey(), (K) node.getKey()) > 0) {
                node.getParent().setLeftChild(null);
            } else {
                node.getParent().setRightChild(null);
            }
            size--;
            return node;
        } else if (node.getRightChild() != null && node.getLeftChild() == null) {
            if (compareKeys.apply((K) node.getParent().getKey(), (K) node.getKey()) > 0) {
                node.getParent().setLeftChild(node.getRightChild());
            } else {
                node.getParent().setRightChild(node.getRightChild());
            }
            size--;
            return node;
        } else if (node.getRightChild() == null && node.getLeftChild() != null) {
            if (compareKeys.apply((K) node.getParent().getKey(), (K) node.getKey()) > 0) {
                node.getParent().setLeftChild(node.getLeftChild());
            } else {
                node.getParent().setRightChild(node.getLeftChild());
            }
            size--;
            return node;
        } else if (node.getLeftChild() != null && node.getRightChild() != null) {
            size--;
            return swapIfItHasTwoChildren(node);
        }
        return null;
    }

    private AbstractNode swapIfItHasTwoChildren(AbstractNode node) {
        AbstractNode oldNode = new NodeBST(node.getKey(), null, node.getParent());
        oldNode.setLeftChild(node.getLeftChild());
        oldNode.setRightChild(node.getRightChild());

        AbstractNode newNode = consequent(node);
        node.setKey(newNode.getKey());
        if (newNode.getRightChild() == null) {
            newNode.getParent().setLeftChild(null);
        } else {
            newNode.getParent().setLeftChild(newNode.getRightChild());
        }
        return oldNode;
    }
}