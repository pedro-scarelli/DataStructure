package dataStructure.tree;

public class TreeNode<T> {
    
    private T info;
    private TreeNode<T> first;
    private TreeNode<T> next;

    public TreeNode(T info) {
        this.info = info;
    }

    public void pushFilho(TreeNode<T> subTree) {
        if (first != null) {
            subTree.next = first;
        }
        first = subTree;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public TreeNode<T> getFirst() {
        return first;
    }

    public void setfirst(TreeNode<T> first) {
        this.first = first;
    }

    public TreeNode<T> getNext() {
        return next;
    }

    public void setNext(TreeNode<T> next) {
        this.next = next;
    }
}
