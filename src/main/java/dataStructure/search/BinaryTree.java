package dataStructure.search;

import dataStructure.tree.BinaryTreeNode;

public class BinaryTree<T> extends BinaryTreeAbstract<T> {
    
    @Override
    public void setRoot(BinaryTreeNode<T> root) {
        super.setRoot(root);
    }

    @Override
    public BinaryTreeNode<T> search(T info) {
        return search(getRoot(), info);
    }
    
    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T info) {
        if (node == null) {
            return null;
        }

        if (node.getInfo().equals(info)) {
            return node;
        }

        BinaryTreeNode<T> foundedNode;

        foundedNode = search(node.getLeft(), info);
        if (foundedNode == null) {
            foundedNode = search(node.getRight(), info);
        }

        return foundedNode;           
    }
}
