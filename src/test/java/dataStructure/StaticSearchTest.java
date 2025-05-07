package dataStructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dataStructure.list.OrderedList;

public class StaticSearchTest {
    
    OrderedList<Integer> listaOrdenada = new OrderedList<>();

    @Test
    public void push() {
        listaOrdenada.push(100);
        listaOrdenada.push(20);
        listaOrdenada.push(70);
        listaOrdenada.push(1);

        assertEquals("1,20,70,100", listaOrdenada.toString());
    }

    @Test
    public void search() {
        listaOrdenada.push(0);
        listaOrdenada.push(10);
        listaOrdenada.push(20);
        listaOrdenada.push(30);
        listaOrdenada.push(40);
        listaOrdenada.push(50);
        listaOrdenada.push(60);
        listaOrdenada.push(70);
        listaOrdenada.push(80);
        listaOrdenada.push(90);
        listaOrdenada.push(100);

        assertEquals(2, listaOrdenada.search(20));
        assertEquals(4, listaOrdenada.search(40));
        assertEquals(7, listaOrdenada.search(70));
        assertEquals(10, listaOrdenada.search(100));
        assertEquals(-1, listaOrdenada.search(85));
    }
}
