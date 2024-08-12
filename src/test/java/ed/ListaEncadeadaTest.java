package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import ed.ListaEncadeada.ListaEncadeada;
import ed.ListaEncadeada.NoLista;

public class ListaEncadeadaTest {
    ListaEncadeada <Integer> listaEncadeada = new ListaEncadeada<>();

    @Test//1
    public void isEmptyTrue(){
        assertEquals(true, listaEncadeada.estaVazia());
    }

    @Test//2
    public void isEmptyFalse(){
        listaEncadeada.inserir(5);
        assertEquals(false, listaEncadeada.estaVazia());
    }

    @Test//3
    public void include(){
        listaEncadeada.inserir(5);
        NoLista<Integer> no = listaEncadeada.getPrimeiro();
        assertEquals(5, no.getInfo().intValue());
        assertEquals(null,no.getProximo());
    }

    @Test//4
    public void includeMultipleNumbers(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        assertEquals(3, listaEncadeada.obterComprimento());
        assertEquals("15,10,5", listaEncadeada.toString());
    }

    @Test//5
    public void searchFirstPosition(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(20);
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(5);
        listaEncadeada.retirarTodos(5);
        assertEquals("20,15,10", listaEncadeada.toString());
    }

    @Test//6
    public void searchPosition(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        assertEquals(Integer.valueOf(15), listaEncadeada.buscar(15).getInfo());
    }

    @Test//7
    public void searchFalsePosition(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        assertEquals(null, listaEncadeada.buscar(50));
    }

    @Test//8
    public void removeFirstElement(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        listaEncadeada.retirar(20);
        assertEquals("15,10,5", listaEncadeada.toString());
    }

    @Test//9
    public void removeElement(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        listaEncadeada.retirar(15);
        assertEquals("20,10,5", listaEncadeada.toString());
    }

    @Test//10
    public void getNo(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        assertEquals(Integer.valueOf(20), listaEncadeada.obterNo(0).getInfo());
    }

    @Test//11
    public void getLastNo(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        assertEquals(Integer.valueOf(5), listaEncadeada.obterNo(3).getInfo());
    }

    @Test//12
    public void getNoFalse(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        try{
            listaEncadeada.obterNo(10);
            fail();
        } catch (IndexOutOfBoundsException message){
            System.out.println("OutOfBounds");
        }
    }

    @Test//13
    public void getSize0(){
        assertEquals(0, listaEncadeada.obterComprimento());
    }

    @Test//14
    public void getSize(){
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);
        assertEquals(4, listaEncadeada.obterComprimento());
    }
}
