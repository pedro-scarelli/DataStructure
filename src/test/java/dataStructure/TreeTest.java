package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dataStructure.tree.Tree;
import dataStructure.tree.TreeNode;

public class TreeTest {
    
    Tree<Integer> arvore = new Tree<>();

    @Test
    public void toStringTest() {
        TreeNode<Integer> node9 = new TreeNode<Integer>(9); 
        TreeNode<Integer> node10 = new TreeNode<Integer>(10); 

        node9.setNext(node10); ///testar inserindo filho
        TreeNode<Integer> node4 = new TreeNode<Integer>(4); 

        node4.pushFilho(node9);

        TreeNode<Integer> node8 = new TreeNode<Integer>(8); 

        TreeNode<Integer> node3 = new TreeNode<Integer>(3); 

        node3.pushFilho(node8);

        TreeNode<Integer> node5 = new TreeNode<Integer>(5); 
        TreeNode<Integer> node6 = new TreeNode<Integer>(6); 
        TreeNode<Integer> node7 = new TreeNode<Integer>(7); 

        node6.setNext(node7);
        node5.setNext(node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2); 

        node2.pushFilho(node5);

        node3.setNext(node4);
        node2.setNext(node3);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1); 
        node1.pushFilho(node2);
        arvore.setRoot(node1);

        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    public void search() {
        TreeNode<Integer> node9 = new TreeNode<Integer>(9); 
        TreeNode<Integer> node10 = new TreeNode<Integer>(10); 

        node9.setNext(node10);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4); 

        node4.pushFilho(node9);

        TreeNode<Integer> node8 = new TreeNode<Integer>(8); 

        TreeNode<Integer> node3 = new TreeNode<Integer>(3); 

        node3.pushFilho(node8);

        TreeNode<Integer> node5 = new TreeNode<Integer>(5); 
        TreeNode<Integer> node6 = new TreeNode<Integer>(6); 
        TreeNode<Integer> node7 = new TreeNode<Integer>(7); 

        node6.setNext(node7);
        node5.setNext(node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2); 

        node2.pushFilho(node5);

        node3.setNext(node4);
        node2.setNext(node3);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1); 
        node1.pushFilho(node2);
        arvore.setRoot(node1);

        assertTrue(arvore.contains(7));
    }

    @Test
    public void searchNonExistingValue() {
        TreeNode<Integer> node9 = new TreeNode<Integer>(9); 
        TreeNode<Integer> node10 = new TreeNode<Integer>(10); 

        node9.setNext(node10);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4); 

        node4.pushFilho(node9);

        TreeNode<Integer> node8 = new TreeNode<Integer>(8); 

        TreeNode<Integer> node3 = new TreeNode<Integer>(3); 

        node3.pushFilho(node8);

        TreeNode<Integer> node5 = new TreeNode<Integer>(5); 
        TreeNode<Integer> node6 = new TreeNode<Integer>(6); 
        TreeNode<Integer> node7 = new TreeNode<Integer>(7); 

        node6.setNext(node7);
        node5.setNext(node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2); 

        node2.pushFilho(node5);

        node3.setNext(node4);
        node2.setNext(node3);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1); 
        node1.pushFilho(node2);
        arvore.setRoot(node1);

        assertTrue(!arvore.contains(55));
    }

    @Test
    public void countNodes() {
        TreeNode<Integer> node9 = new TreeNode<Integer>(9); 
        TreeNode<Integer> node10 = new TreeNode<Integer>(10); 

        node9.setNext(node10);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4); 

        node4.pushFilho(node9);

        TreeNode<Integer> node8 = new TreeNode<Integer>(8); 

        TreeNode<Integer> node3 = new TreeNode<Integer>(3); 

        node3.pushFilho(node8);

        TreeNode<Integer> node5 = new TreeNode<Integer>(5); 
        TreeNode<Integer> node6 = new TreeNode<Integer>(6); 
        TreeNode<Integer> node7 = new TreeNode<Integer>(7); 

        node6.setNext(node7);
        node5.setNext(node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2); 

        node2.pushFilho(node5);

        node3.setNext(node4);
        node2.setNext(node3);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1); 
        node1.pushFilho(node2);
        arvore.setRoot(node1);

        assertEquals(10, arvore.countNodes());
    }
}
