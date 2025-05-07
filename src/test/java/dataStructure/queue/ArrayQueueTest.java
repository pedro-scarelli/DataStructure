package dataStructure.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import dataStructure.queue.exceptions.*;

public class ArrayQueueTest {
 
    @Test
    public void isEmpty() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        assertTrue(queue.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.push(10);

        assertTrue(!queue.isEmpty());
    }

    @Test
    public void push() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        queue.push(10);
        queue.push(20);
        queue.push(30);

        assertEquals(Integer.valueOf(10), queue.pop());
        assertEquals(Integer.valueOf(20), queue.pop());
        assertEquals(Integer.valueOf(30), queue.pop());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void pushShouldThrowFullQueueException() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        queue.push(10);
        queue.push(20);
        queue.push(30);

        try{
            queue.push(40);
            fail();
        }catch(FullQueueException e) {}
    }

    @Test
    public void popShouldThrowEmptyQueueException() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);

        try{
            queue.pop();
            fail();
        }catch(EmptyQueueException e) {}
    }

    @Test
    public void peek() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);

        assertEquals(Integer.valueOf(10), queue.peek());
        assertEquals(Integer.valueOf(10), queue.pop());
    }

    @Test
    public void free() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.free();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void concatenate() {
    ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        queue.push(10);
        queue.push(20);
        queue.push(30);

        ArrayQueue<Integer> queueToConcatenate = new ArrayQueue<>(2);
        queueToConcatenate.push(40);
        queueToConcatenate.push(50);

        ArrayQueue<Integer> concatenatedQueue = queue.createConcatenatedQueue(queueToConcatenate);

        assertEquals("10,20,30", queue.toString());
        assertEquals("40,50", queueToConcatenate.toString());
        assertEquals("10,20,30,40,50", concatenatedQueue.toString());
        assertEquals(5, concatenatedQueue.getLimit());
    }

    @Test
    public void shrink() {
    ArrayQueue<String> queue = new ArrayQueue<>(10);
        queue.push("z");
        queue.push("z");
        queue.push("z");
        queue.push("z");
        queue.push("z");
        queue.push("z");
        queue.push("z");
        queue.push("z");
        queue.push("A");
        queue.push("B");
        queue.pop();
        queue.pop();
        queue.push("C");
        queue.push("D");
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

        queue.shrink();

        assertEquals("A,B,C,D", queue.toString());
        assertEquals(4, queue.limit);
    }

    @Test
    public void shrinkShouldOnlyRemoveFreeSpaces() {
    ArrayQueue<String> queue = new ArrayQueue<>(10);
        queue.push("A");
        queue.push("B");
        queue.push("C");
        queue.push("D");
        queue.shrink();

        assertEquals("A,B,C,D", queue.toString());
        assertEquals(4, queue.limit);
    }

    @Test
    public void shrinkShouldMaintainQueue() {
        ArrayQueue<String> queue = new ArrayQueue<>(4);
        queue.push("A");
        queue.push("B");
        queue.push("C");
        queue.push("D");
        queue.shrink();

        assertEquals("A,B,C,D", queue.toString());
        assertEquals(4, queue.limit);
    }
}

