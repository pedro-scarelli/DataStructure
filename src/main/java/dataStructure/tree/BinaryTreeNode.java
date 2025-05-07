package dataStructure.tree;

public class BinaryTreeNode <T>{
    
    private T info;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;


    public BinaryTreeNode(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T info, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {
        this.info = info;
        setLeft(leftNode);
        setRight(rightNode);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
