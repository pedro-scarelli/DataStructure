package dataStructure.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StaticListTest {
    StaticList list = new StaticList();
    
    @Test
    public void push() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);

        assertEquals("5,10,15,20", list.toString());
    }

    @Test
    public void getSize() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);

        assertEquals(4, list.getSize());
    }

    @Test
    public void search() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);

        assertEquals(2, list.search(15));
    }

    @Test
    public void searchNonExistingElement() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);

        assertEquals(-1, list.search(30));
    }

    @Test
    public void pop() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);
        list.pop(10);

        assertEquals("5,15,20", list.toString());
        assertEquals(3, list.getSize());
    }

    @Test
    public void pushWithResize() {
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.push(8);
        list.push(9);
        list.push(10);
        list.push(11);
        list.push(12);
        list.push(13);
        list.push(14);
        list.push(15);

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", list.toString());
        assertEquals(15, list.getSize());
    }

    @Test
    public void getElement() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);

        assertEquals(20, list.getElement(3));
    }

    @Test
    public void getUnreachableElementShouldThrowIndexOutOfBoundsException() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);

        try{
            list.getElement(5);
            fail();
        } catch (IndexOutOfBoundsException message) { }
    }

    @Test
    public void free() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);
        list.free();

        assertEquals(true, list.isEmpty());
    }
}
