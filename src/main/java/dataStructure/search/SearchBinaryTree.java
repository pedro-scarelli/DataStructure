package dataStructure.search;

import dataStructure.tree.BinaryTreeNode;

public class SearchBinaryTree<T extends Comparable<T>> extends BinaryTreeAbstract<T> {

    @Override
    public BinaryTreeNode<T> search(T info) {
        return search(getRoot(), info);
    }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T info) {
        BinaryTreeNode<T> p = getRoot();
        
        while(p != null && !p.getInfo().equals(info)) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }

        return p;
    }

    public void push(T info) {
        BinaryTreeNode<T> newBinaryTreeNode = new BinaryTreeNode<T>(info);

        if (isEmpty()) {
            setRoot(newBinaryTreeNode);
        } else {
            BinaryTreeNode<T> p = getRoot();
            BinaryTreeNode<T> father;

            while(true) {
                father = p;
                if (info.compareTo(p.getInfo()) < 0) {
                    p = p.getLeft();
                    if (p == null) {
                        father.setLeft(newBinaryTreeNode);
                        return;
                    }
                } else {
                    p = p.getRight();
                    if (p == null) {
                        father.setRight(newBinaryTreeNode);
                        return;
                    }
                }
            }
        }
    }

    public void pop(T info) {
        BinaryTreeNode<T> p = getRoot();
        BinaryTreeNode<T> father = null;
        boolean isLeftChild = false;
        
        while((p != null) && (!p.getInfo().equals(info))) {
            father = p;

            if (info.compareTo(p.getInfo()) < 0) {
                isLeftChild = true;
                p = p.getLeft();
            } else {
                isLeftChild = false;
                p = p.getRight();
            }
        }

        if (p != null) {
            if ((p.getLeft() == null) && (p.getRight() == null)) {
                if (p == getRoot()) {
                    setRoot(null);
                } else {
                    if (isLeftChild) {
                        father.setLeft(null);
                    } else {
                        father.setRight(null);
                    }
                }
            } else {
                if (p.getRight() == null) {
                    if (p == getRoot()) {
                        setRoot(p.getLeft());
                    } else {
                        if (isLeftChild) {
                            father.setLeft(p.getLeft());
                        } else {
                            father.setRight(p.getLeft());
                        }
                    }
                } else {
                    if (p.getLeft() == null) {
                        if (p == getRoot()) {
                            setRoot(p.getRight());
                        } else {
                            if (isLeftChild) {
                                father.setLeft(p.getRight());
                            } else {
                                father.setRight(p.getRight());
                            }
                        }
                    } else {
                        BinaryTreeNode<T> next = extractNext(p);
                        if (p == getRoot()) {
                            setRoot(next);
                        } else {
                            if (isLeftChild) {
                                father.setLeft(next);
                            } else {
                                father.setRight(next);   
                            }
                        }
                        next.setLeft(p.getLeft());
                    }
                }
            }
        }
    }

    private BinaryTreeNode<T> extractNext(BinaryTreeNode<T> p) {
        BinaryTreeNode<T> actual = p.getRight();
        BinaryTreeNode<T> fatherNext = p;
        BinaryTreeNode<T> next = p;

        while(actual != null) {
            fatherNext = next;
            next = actual;
            actual = actual.getLeft();
        }

        if (next != p.getRight()) {
            fatherNext.setLeft(next.getRight());
            next.setRight(p.getRight());
        }

        return next;
    }
}
