package dataStructure.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import org.junit.Test;

public class GenericStaticListTest {
    GenericStaticList <Integer> list = new GenericStaticList<>();

    @Test
    public void popElements() {
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.push(60);
        list.popElements(4,5);

        assertEquals("10,20,30,40", list.toString());
        assertEquals(4, list.getSize());
    }

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

        assertEquals(Integer.valueOf(20), list.getElement(3));
    }

    @Test
    public void getFirstElementShouldThrowIndexOutOfBoundsException() {
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
    @Test
    public void invertWithPairPositions() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);
        list.invert();

        assertEquals("20,15,10,5", list.toString());
    }

    @Test
    public void invertWithOddPositions() {
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);
        list.push(25);
        list.invert();

        assertEquals("25,20,15,10,5", list.toString());
    }
}
