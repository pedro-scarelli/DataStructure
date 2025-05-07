package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dataStructure.queue.*;

public class ListQueueTest {
    
    ListQueue<Integer> queue = new ListQueue<>();

    @Test   
    public void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        queue.push(10);

        assertTrue(!queue.isEmpty());
    }

    @Test
    public void push() {
        queue.push(10);
        queue.push(20);
        queue.push(30);

        assertEquals(Integer.valueOf(10), queue.pop());
        assertEquals(Integer.valueOf(20), queue.pop());
        assertEquals(Integer.valueOf(30), queue.pop());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void peek() {
        queue.push(10);
        queue.push(20);
        queue.push(30);

        assertEquals(Integer.valueOf(10), queue.peek());
        assertEquals(Integer.valueOf(10), queue.pop());
    }

    @Test
    public void free() {
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.free();

        assertTrue(queue.isEmpty());
    }
}
