package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dataStructure.tree.BinaryTree;
import dataStructure.tree.BinaryTreeNode;

public class BinaryTreeTest {
    
    BinaryTree<Integer> arvoreBinaria = new BinaryTree<>();

    @Test   
    public void isEmpty() {
        assertTrue(arvoreBinaria.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        arvoreBinaria.setRoot(new BinaryTreeNode<Integer>(5));
        assertTrue(!arvoreBinaria.isEmpty());
    }

    @Test
    public void methodToString() {
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);

        assertEquals("<<<>2<<>4<>>>1<<<>5<>>3<<>6<>>>>", arvoreBinaria.tree(root));
        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvoreBinaria.toString());
        assertEquals("<<<><<><>4>2><<<><>5><<><>6>3>1>", arvoreBinaria.posOrderTree(root));
    } 

    @Test
    public void containsRootNode() {
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);
        assertTrue(arvoreBinaria.contains(1));
    }

    @Test
    public void containsInternalNode() {
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);
        assertTrue(arvoreBinaria.contains(3));
    }

    @Test
    public void containsLeafNode() {
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);
        assertTrue(arvoreBinaria.contains(6));
    }

    @Test
    public void notContains() {
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);
        assertTrue(!arvoreBinaria.contains(10));
    }

    @Test
    public void countNodes() {
        BinaryTreeNode<Integer> no9 = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> no10 = new BinaryTreeNode<Integer>(10);

        BinaryTreeNode<Integer> no7 = new BinaryTreeNode<Integer>(7, no9, no10);
        BinaryTreeNode<Integer> no8 = new BinaryTreeNode<Integer>(8);

        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4, no7, no8);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);


        BinaryTreeNode<Integer> no12 = new BinaryTreeNode<Integer>(12);

        BinaryTreeNode<Integer> no11 = new BinaryTreeNode<Integer>(11, no12, null);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6, null, no11);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);
        assertEquals(7, arvoreBinaria.countInternalNodes());
    }

    @Test
    public void getOneNodeTreeHeight() {
        assertEquals(-1, arvoreBinaria.getHeight());

        BinaryTreeNode<Integer> onlyRootNode = new BinaryTreeNode<Integer>(10);
        arvoreBinaria.setRoot(onlyRootNode);
        assertEquals(0, arvoreBinaria.getHeight());
    }

    @Test
    public void getOnlyLeftNodesTreeHeight() {
        assertEquals(-1, arvoreBinaria.getHeight());
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no4, null);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, no3, null);
        BinaryTreeNode<Integer> rootEsquerda = new BinaryTreeNode<Integer>(1, no2, null);
        arvoreBinaria.setRoot(rootEsquerda);
        assertEquals(3, arvoreBinaria.getHeight());
    }

    @Test
    public void getBalancedTreeHeight() {
        assertEquals(-1, arvoreBinaria.getHeight());
        BinaryTreeNode<Integer> no7 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no2Bal = new BinaryTreeNode<Integer>(2, no5, no6);
        BinaryTreeNode<Integer> no3Bal = new BinaryTreeNode<Integer>(3, null, no7);
        BinaryTreeNode<Integer> rootBal = new BinaryTreeNode<Integer>(1, no2Bal, no3Bal);
        arvoreBinaria.setRoot(rootBal);
        assertEquals(2, arvoreBinaria.getHeight());
    }

    @Test
    public void countLeaves() {
        BinaryTreeNode<Integer> folha1 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> folha2 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> folha3 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> folha4 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> folha5 = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> folha6 = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> folha7 = new BinaryTreeNode<Integer>(10);

        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, folha1);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, folha2, folha3);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(11, folha4, folha5);
        BinaryTreeNode<Integer> no7 = new BinaryTreeNode<Integer>(12, folha6, folha7);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<Integer>(13, no6, no7);

        BinaryTreeNode<Integer> rootPrincipal = new BinaryTreeNode<Integer>(14, root, root2);

        arvoreBinaria.setRoot(rootPrincipal);

        assertEquals(7, arvoreBinaria.countLeaves());
    }

    @Test
    public void invertTree() {
        BinaryTreeNode<Integer> no4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> no2 = new BinaryTreeNode<Integer>(2, null, no4);

        BinaryTreeNode<Integer> no5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> no6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> no3 = new BinaryTreeNode<Integer>(3, no5, no6);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, no2, no3);
        arvoreBinaria.setRoot(root);

        arvoreBinaria.invert();

        assertEquals("<1<3<6<><>><5<><>>><2<4<><>><>>>", arvoreBinaria.toString());
    }                   
}
