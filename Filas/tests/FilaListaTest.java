package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ed.filas.*;

public class FilaListaTest {
    
    FilaLista<Integer> fila = new FilaLista<>();

    @Test   
    public void estaVazia(){
        assertTrue(fila.estaVazia());
    }

    @Test
    public void estaVaziaFalse(){
        fila.inserir(10);
        assertTrue(!fila.estaVazia());
    }

    @Test
    public void inserir(){
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertEquals(Integer.valueOf(10), fila.retirar());
        assertEquals(Integer.valueOf(20), fila.retirar());
        assertEquals(Integer.valueOf(30), fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void peek(){
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertEquals(Integer.valueOf(10), fila.peek());
        assertEquals(Integer.valueOf(10), fila.retirar());
    }

    @Test
    public void liberar(){
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        assertTrue(fila.estaVazia());
    }
}
