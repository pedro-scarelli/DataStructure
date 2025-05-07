package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dataStructure.stack.ListStack;

public class ListStackTest {
    ListStack<Integer> listStack = new ListStack<>();

    @Test
    public void isEmpty() {
        assertTrue(listStack.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        listStack.push(10);

        assertTrue(!listStack.isEmpty());
    }

    @Test
    public void pushAndPop() {
        listStack.push(10);
        listStack.push(20);
        listStack.push(30);

        assertEquals(Integer.valueOf(30), listStack.pop());
        assertEquals(Integer.valueOf(20), listStack.pop());
        assertEquals(Integer.valueOf(10), listStack.pop());
        assertTrue(listStack.isEmpty());
    }

    @Test
    public void peek() {
        listStack.push(10);
        listStack.push(20);
        listStack.push(30);

        assertEquals(Integer.valueOf(30), listStack.peek());
        assertEquals(Integer.valueOf(30), listStack.pop());    
    }

    @Test
    public void free() {
        listStack.push(10);
        listStack.push(20);
        listStack.push(30);
        listStack.free();

        assertTrue(listStack.isEmpty()); 
    }
}
