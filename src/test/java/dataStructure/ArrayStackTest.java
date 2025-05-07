package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import dataStructure.stack.*;
import dataStructure.stack.exceptions.EmptyStackException;
import dataStructure.stack.exceptions.FullStackException;

public class ArrayStackTest {
    ArrayStack<Integer> pilhaVetor = new ArrayStack<>(10);

    @Test
    public void isEmpty() {
        assertTrue(pilhaVetor.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        pilhaVetor.setLimit(5); 
        pilhaVetor.push(10);
        assertTrue(!pilhaVetor.isEmpty());
    }

    @Test
    public void pushAndPop() {
        pilhaVetor.setLimit(10); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        assertEquals(Integer.valueOf(30),pilhaVetor.pop());
        assertEquals(Integer.valueOf(20),pilhaVetor.pop());
        assertEquals(Integer.valueOf(10),pilhaVetor.pop());
        assertTrue(pilhaVetor.isEmpty());
    }

    @Test
    public void pushShouldThrowFullStackException() {
        pilhaVetor.setLimit(3); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        try{
            pilhaVetor.push(40);
            fail();
        } catch(FullStackException error) { }
    }

    @Test
    public void popShouldThrowEmptyStackException() {
        try{
            pilhaVetor.pop();
            fail();
        } catch(EmptyStackException error) { }
    }

    @Test
    public void peek() {
        pilhaVetor.setLimit(5); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        assertEquals(Integer.valueOf(30),pilhaVetor.peek());
        assertEquals(Integer.valueOf(30),pilhaVetor.pop());    
    }

    @Test
    public void free() {
        pilhaVetor.setLimit(5); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        pilhaVetor.free();
        assertTrue(pilhaVetor.isEmpty()); 
    }

    @Test
    public void concatenate() {
        pilhaVetor.setLimit(5); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        ArrayStack<Integer> pilha2 = new ArrayStack<>(2);
        pilha2.push(40);
        pilha2.push(50);
        pilhaVetor.concatenate(pilha2);
        assertEquals("50,40,30,20,10", pilhaVetor.toString()); 
    }
}
