package dataStructure.tree;

public class Tree<T>{
    
    private TreeNode<T> root;

    public Tree() {
        root = new TreeNode<T>(null);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        } else {
            return getTextRepresentation(root);
        }
    }

    private String getTextRepresentation(TreeNode<T> node) {
        String result = "<";    
        result += node.getInfo();

        TreeNode<T> first = node.getFirst();
        while(first != null) {
            result += getTextRepresentation(first);
            first = first.getNext();  
        } 

        return result += ">";   
    }

    public boolean contains(T value) {
        if (root == null) {
            return false;
        }

        return contains(root, value);
    }

    private boolean contains(TreeNode<T> node, T value) {
        if (node.getInfo() == value) {
            return true;
        }

        TreeNode<T> first = node.getFirst();
        while(first != null) {
            if (contains(first, value)) {
                return true;
            }
            first = first.getNext();
        }
        
        return false;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode<T> node) {
        int nodeCount = 0;

        if (node.getInfo() != null) {
            nodeCount++;
            TreeNode<T> first = node.getFirst();

            while(first != null) {
                nodeCount += countNodes(first);                
                first = first.getNext();
            }
        } 
        
        return nodeCount; 
    }
}
