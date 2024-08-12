package ed;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuscasEstaticaTest {
    
    ListaOrdenada<Integer> listaOrdenada = new ListaOrdenada<>();



    @Test
    public void inserir(){
        listaOrdenada.inserir(100);
        listaOrdenada.inserir(20);
        listaOrdenada.inserir(70);
        listaOrdenada.inserir(1);

        assertEquals("1,20,70,100", listaOrdenada.toString());
    }

    @Test
    public void buscar(){
        listaOrdenada.inserir(0);
        listaOrdenada.inserir(10);
        listaOrdenada.inserir(20);
        listaOrdenada.inserir(30);
        listaOrdenada.inserir(40);
        listaOrdenada.inserir(50);
        listaOrdenada.inserir(60);
        listaOrdenada.inserir(70);
        listaOrdenada.inserir(80);
        listaOrdenada.inserir(90);
        listaOrdenada.inserir(100);

        assertEquals(2, listaOrdenada.buscar(20));
        assertEquals(4, listaOrdenada.buscar(40));
        assertEquals(7, listaOrdenada.buscar(70));
        assertEquals(10, listaOrdenada.buscar(100));
        assertEquals(-1, listaOrdenada.buscar(85));
    }
}
