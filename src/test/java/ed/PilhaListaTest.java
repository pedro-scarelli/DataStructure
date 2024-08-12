package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ed.Pilhas.PilhaLista;

public class PilhaListaTest {
    PilhaLista<Integer> pilhaLista = new PilhaLista<>();

    @Test
    public void estaVazia(){
        assertTrue(pilhaLista.estaVazia());
    }

    @Test
    public void estaVaziaFalse(){
        pilhaLista.push(10);
        assertTrue(!pilhaLista.estaVazia());
    }

    @Test
    public void pushEPop(){
        pilhaLista.push(10);
        pilhaLista.push(20);
        pilhaLista.push(30);
        assertEquals(Integer.valueOf(30),pilhaLista.pop());
        assertEquals(Integer.valueOf(20),pilhaLista.pop());
        assertEquals(Integer.valueOf(10),pilhaLista.pop());
        assertTrue(pilhaLista.estaVazia());
    }

    @Test
    public void peek(){
        pilhaLista.push(10);
        pilhaLista.push(20);
        pilhaLista.push(30);
        assertEquals(Integer.valueOf(30), pilhaLista.peek());
        assertEquals(Integer.valueOf(30), pilhaLista.pop());    
    }

    @Test
    public void liberar(){
        pilhaLista.push(10);
        pilhaLista.push(20);
        pilhaLista.push(30);
        pilhaLista.liberar();
        assertTrue(pilhaLista.estaVazia()); 
    }
}
