package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ed.ListaDupla.ListaDupla;
import ed.ListaDupla.NoListaDupla;

public class ListaDuplaTest {
    
    ListaDupla <Integer> listaDupla = new ListaDupla<>();

    @Test
    public void inserirDados(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        assertEquals("20,15,10,5", listaDupla.toString());

        NoListaDupla no = listaDupla.buscar(5);
        String nosInvertidos = String.valueOf(no.getInfo());
        while (no.getAnterior() != null) {
            no = no.getAnterior();
            nosInvertidos += "," + no.getInfo();
        }
        assertEquals("5,10,15,20", nosInvertidos);
    }

    @Test
    public void buscarPrimeiroElemento(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        assertEquals(Integer.valueOf(20), listaDupla.buscar(20).getInfo());
    }

    @Test
    public void buscarElemento(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        assertEquals(Integer.valueOf(10), listaDupla.buscar(10).getInfo());
    }

    @Test
    public void removerPrimeiroElemento(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        listaDupla.retirar(20);
        assertEquals("15,10,5", listaDupla.toString());
        
        NoListaDupla no = listaDupla.buscar(5);
        String nosInvertidos = String.valueOf(no.getInfo());
        while (no.getAnterior() != null) {
            no = no.getAnterior();
            nosInvertidos += "," + no.getInfo();
        }
        assertEquals("5,10,15", nosInvertidos);
    }

    @Test
    public void removerElemento(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        listaDupla.retirar(10);
        assertEquals("20,15,5", listaDupla.toString());

        NoListaDupla no = listaDupla.buscar(5);
        String nosInvertidos = String.valueOf(no.getInfo());
        while (no.getAnterior() != null) {
            no = no.getAnterior();
            nosInvertidos += "," + no.getInfo();
        }
        assertEquals("5,15,20", nosInvertidos);
    }

    @Test
    public void removerUltimoElemento(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        listaDupla.retirar(5);
        assertEquals("20,15,10", listaDupla.toString());

        NoListaDupla no = listaDupla.buscar(10);
        String nosInvertidos = String.valueOf(no.getInfo());
        while (no.getAnterior() != null) {
            no = no.getAnterior();
            nosInvertidos += "," + no.getInfo();
        }
        assertEquals("10,15,20", nosInvertidos);
    }

    @Test
    public void liberarLista(){
        listaDupla.inserir(5);
        listaDupla.inserir(10);
        listaDupla.inserir(15);
        listaDupla.inserir(20);
        NoListaDupla no5 = listaDupla.buscar(5);
        NoListaDupla no10 = listaDupla.buscar(10);
        NoListaDupla no15 = listaDupla.buscar(15);
        NoListaDupla no20 = listaDupla.buscar(20);
        listaDupla.liberar();
        
        assertNull(no5.getAnterior());
        assertNull(no10.getAnterior());
        assertNull(no15.getAnterior());
        assertNull(no20.getAnterior());
        assertNull(no5.getProximo());
        assertNull(no10.getProximo());
        assertNull(no15.getProximo());
        assertNull(no20.getProximo());
        assertNull(listaDupla.getPrimeiro());
    }
}
