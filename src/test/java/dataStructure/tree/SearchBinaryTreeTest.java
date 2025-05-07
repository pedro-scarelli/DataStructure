package dataStructure.tree;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import dataStructure.search.SearchBinaryTree;

public class SearchBinaryTreeTest<T> {
    
    SearchBinaryTree<Integer> searchTree = new SearchBinaryTree<>();

    @Test
    public void push() {
        searchTree.push(50);
        searchTree.push(30);
        searchTree.push(70);
        searchTree.push(40);
        searchTree.push(25);
        searchTree.push(75);
        searchTree.push(65);
        searchTree.push(35);
        searchTree.push(60);

        assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>", searchTree.toString());
    }

    @Test
    public void popLeaf() {
        searchTree.push(50);
        searchTree.push(30);
        searchTree.push(25);
        searchTree.push(40);

        searchTree.pop(40);

        assertEquals("<50<30<25<><>><>><>>", searchTree.toString());
    }

    @Test
    public void popNodeWithOneChild() {
        searchTree.push(80);
        searchTree.push(52);
        searchTree.push(90);
        searchTree.push(48);
        searchTree.push(71);
        searchTree.push(63);
        searchTree.push(67);

        searchTree.pop(71);

        assertEquals("<80<52<48<><>><63<><67<><>>>><90<><>>>", searchTree.toString());
    }

    @Test
    public void popNodeWithTwoChildren() {
        searchTree.push(250);
        searchTree.push(38);
        searchTree.push(26);
        searchTree.push(72);
        searchTree.push(55);
        searchTree.push(90);
        searchTree.push(41);
        searchTree.push(60);
        searchTree.push(43);
        searchTree.push(78);
        searchTree.push(92);
        searchTree.push(74);

        searchTree.pop(38);

        assertEquals("<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>", searchTree.toString());
    }
}
