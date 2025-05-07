package dataStructure.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import dataStructure.list.linkedList.LinkedList;
import dataStructure.list.linkedList.ListNode;

public class LinkedListTest {
    LinkedList <Integer> linkedList = new LinkedList<>();

    @Test
    public void isEmpty() {
        assertEquals(true, linkedList.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        linkedList.push(5);
        assertEquals(false, linkedList.isEmpty());
    }

    @Test
    public void include() {
        linkedList.push(5);
        ListNode<Integer> node = linkedList.getFirst();

        assertEquals(5, node.getInfo().intValue());
        assertEquals(null,node.getNext());
    }

    @Test
    public void includeMultipleNumbers() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);

        assertEquals(3, linkedList.getSize());
        assertEquals("15,10,5", linkedList.toString());
    }

    @Test
    public void searchFirstPosition() {
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(15);
        linkedList.push(5);
        linkedList.push(20);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.popAllValues(5);

        assertEquals("20,15,10", linkedList.toString());
    }

    @Test
    public void searchPosition() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);

        assertEquals(Integer.valueOf(15), linkedList.search(15).getInfo());
    }

    @Test
    public void searchNonExistingPosition() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);

        assertEquals(null, linkedList.search(50));
    }

    @Test
    public void popFirstElement() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);
        linkedList.pop(20);

        assertEquals("15,10,5", linkedList.toString());
    }

    @Test
    public void popElement() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);
        linkedList.pop(15);

        assertEquals("20,10,5", linkedList.toString());
    }

    @Test
    public void getNode() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);

        assertEquals(Integer.valueOf(20), linkedList.getNode(0).getInfo());
    }

    @Test
    public void getLastNode() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);

        assertEquals(Integer.valueOf(5), linkedList.getNode(3).getInfo());
    }

    @Test
    public void getNonReachableNode() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);

        try{
            linkedList.getNode(10);
            fail();
        } catch (IndexOutOfBoundsException message) { }
    }

    @Test
    public void getEmptyLinkedListSize() {
        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void getSize() {
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(20);

        assertEquals(4, linkedList.getSize());
    }
}
