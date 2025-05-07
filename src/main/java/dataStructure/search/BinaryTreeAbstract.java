package dataStructure.search;

import dataStructure.tree.BinaryTreeNode;

public abstract class BinaryTreeAbstract<T>{

    private BinaryTreeNode<T> root;

    public BinaryTreeAbstract() {
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    protected void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(BinaryTreeNode<T> node, T info) {
        return search(info) != null;
    }

    @Override
    public String toString() {
        return preOrderTree(root);
    }

    private String preOrderTree(BinaryTreeNode<T> node) {    
        String result = "<";    
        if (node != null) {
            result += node.getInfo() + 
            preOrderTree(node.getLeft()) + 
            preOrderTree(node.getRight());
        } 

        return result += ">";
    }

    public int countNodes() {
        return countNodes(this.root);
    }

    private int countNodes(BinaryTreeNode<T> subTree) {
        if (subTree == null) {
            return 0;
        } else {
            return 1 + countNodes(subTree.getLeft()) + countNodes(subTree.getRight());
        }
    }

    public abstract BinaryTreeNode<T> search(T info);
}
