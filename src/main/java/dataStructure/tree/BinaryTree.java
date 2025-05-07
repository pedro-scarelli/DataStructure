package dataStructure.tree;

public class BinaryTree<T>{
    
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T info) {
        return contains(root, info);
    }

    private boolean contains(BinaryTreeNode<T> node, T info) {
        if (node == null)
            return false;
        else
            return (node.getInfo().equals(info)||
            contains(node.getLeft(), info) ||
            contains(node.getRight(), info));
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

    public int countInternalNodes() {
        return countInternalNodes(this.root);
    }

    public int countInternalNodes(BinaryTreeNode<T> subTree) {
        if (subTree == null || subTree.getLeft() == null && subTree.getRight() == null) {
            return 0;
        } else {
            return 1 + countInternalNodes(subTree.getLeft()) + countInternalNodes(subTree.getRight());
        }
    }

    //extras
    public int getHeight() {
        return (root != null) ? getHeight(root) : -1;
    }

    private int getHeight(BinaryTreeNode<T> node) {
        int altura = 0;
        if (node.getLeft() != null || node.getRight() != null) {
            altura++;
            if (node.getRight() != null) {
                altura += getHeight(node.getRight());
            } else if (node.getLeft() != null) {
                altura += getHeight(node.getLeft());
            }
        }
        return altura;
    }

    public String posOrderTree(BinaryTreeNode<T> node) {    
        String result = "<";    
        if (node != null) {
            result += posOrderTree(node.getLeft()) + 
            posOrderTree(node.getRight()) +
            node.getInfo();
        } 

        return result += ">";    
    }

    public String tree(BinaryTreeNode<T> node) {    
        String result = "<";    
        if (node != null) {
            result += tree(node.getLeft()) +
            node.getInfo() + 
            tree(node.getRight());
        } 

        return result += ">";    
    }

    public int countLeaves() {
        return (root != null) ? countLeaves(root) : 0;
    }

    private int countLeaves(BinaryTreeNode<T> node) {
        int leaves = 0;
        if (node.getLeft() == null && node.getRight() == null) {
            return leaves += 1;
        } else {
            if (node.getRight() != null) {
                leaves += countLeaves(node.getRight());
            }
            
            if (node.getLeft() != null) {
                leaves += countLeaves(node.getLeft());
            }
        }
        return leaves;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(BinaryTreeNode<T> node) {
        if (node == null) return true;

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }

    public void invert() {
        invert(root);
    }

    private BinaryTreeNode<T> invert(BinaryTreeNode<T> node) {
        if (node == null) return null;

        BinaryTreeNode<T> backup = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(backup);

        invert(node.getRight());
        invert(node.getLeft());

        return node;
    }
}
