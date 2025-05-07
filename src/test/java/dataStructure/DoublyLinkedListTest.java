package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import dataStructure.list.doublyLinkedList.DoublyLinkedList;
import dataStructure.list.doublyLinkedList.DoublyLinkedListNode;

public class DoublyLinkedListTest {
    
    DoublyLinkedList <Integer> doublyLinkedList = new DoublyLinkedList<>();

    @Test
    public void push() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);
        assertEquals("20,15,10,5", doublyLinkedList.toString());

        DoublyLinkedListNode<Integer> node = doublyLinkedList.search(5);
        String invertedNodes = String.valueOf(node.getInfo());
        while (node.getPrevious() != null) {
            node = node.getPrevious();
            invertedNodes += "," + node.getInfo();
        }

        assertEquals("5,10,15,20", invertedNodes);
    }

    @Test
    public void searchFirstElement() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);

        assertEquals(Integer.valueOf(20), doublyLinkedList.search(20).getInfo());
    }

    @Test
    public void searchMiddleElement() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);

        assertEquals(Integer.valueOf(10), doublyLinkedList.search(10).getInfo());
    }

    @Test
    public void popFirstElement() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);
        doublyLinkedList.pop(20);

        assertEquals("15,10,5", doublyLinkedList.toString());
        
        DoublyLinkedListNode<Integer> node = doublyLinkedList.search(5);
        String invertedNodes = String.valueOf(node.getInfo());
        while (node.getPrevious() != null) {
            node = node.getPrevious();
            invertedNodes += "," + node.getInfo();
        }

        assertEquals("5,10,15", invertedNodes);
    }

    @Test
    public void popMiddleElement() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);
        doublyLinkedList.pop(10);

        assertEquals("20,15,5", doublyLinkedList.toString());

        DoublyLinkedListNode<Integer> node = doublyLinkedList.search(5);
        String invertedNodes = String.valueOf(node.getInfo());
        while (node.getPrevious() != null) {
            node = node.getPrevious();
            invertedNodes += "," + node.getInfo();
        }

        assertEquals("5,15,20", invertedNodes);
    }

    @Test
    public void popLastElement() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);
        doublyLinkedList.pop(5);

        assertEquals("20,15,10", doublyLinkedList.toString());

        DoublyLinkedListNode<Integer> node = doublyLinkedList.search(10);
        String invertedNodes = String.valueOf(node.getInfo());
        while (node.getPrevious() != null) {
            node = node.getPrevious();
            invertedNodes += "," + node.getInfo();
        }

        assertEquals("10,15,20", invertedNodes);
    }

    @Test
    public void freeList() {
        doublyLinkedList.push(5);
        doublyLinkedList.push(10);
        doublyLinkedList.push(15);
        doublyLinkedList.push(20);
        DoublyLinkedListNode<Integer> node5 = doublyLinkedList.search(5);
        DoublyLinkedListNode<Integer> node10 = doublyLinkedList.search(10);
        DoublyLinkedListNode<Integer> node15 = doublyLinkedList.search(15);
        DoublyLinkedListNode<Integer> node20 = doublyLinkedList.search(20);
        doublyLinkedList.free();
        
        assertNull(node5.getPrevious());
        assertNull(node10.getPrevious());
        assertNull(node15.getPrevious());
        assertNull(node20.getPrevious());
        assertNull(node5.getNext());
        assertNull(node10.getNext());
        assertNull(node15.getNext());
        assertNull(node20.getNext());
        assertNull(doublyLinkedList.getFirst());
    }
}
