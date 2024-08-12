package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import org.junit.Test;

import ed.Listas.ListaEstaticaG;

public class ListaEstaticaGTest {
    ListaEstaticaG <Integer>lista = new ListaEstaticaG<>();

    @Test
    public void retirarElementos(){
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.retirarElementos(4,5);
        assertEquals("10,20,30,40", lista.toString());
        assertEquals(4, lista.getTamanho());
    }

    @Test
    public void inserir(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals("5,10,15,20", lista.toString());
    }

    @Test
    public void getTamanho(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.getTamanho());
    }

    @Test
    public void buscar(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(2, lista.buscar(15));
    }

    @Test
    public void buscarFalse(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(-1, lista.buscar(30));
    }

    @Test
    public void retirar(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        assertEquals("5,15,20", lista.toString());
        assertEquals(3, lista.getTamanho());
    }

    @Test
    public void inserirCRedimensionamento(){
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        lista.inserir(9);
        lista.inserir(10);
        lista.inserir(11);
        lista.inserir(12);
        lista.inserir(13);
        lista.inserir(14);
        lista.inserir(15);
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
        assertEquals(15, lista.getTamanho());
    }

    @Test
    public void obterElemento(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(Integer.valueOf(20), lista.obterElemento(3));
    }

    @Test
    public void excecao(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        try{
            lista.obterElemento(5);
            fail();
        } catch (IndexOutOfBoundsException message){
            System.out.println("OutOfBounds");
        }
    }

    @Test
    public void liberar(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        assertEquals(true, lista.estaVazia());
    }
    @Test
    public void inverterComPosicoesPar(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inverter();

        assertEquals("20,15,10,5", lista.toString());
    }

    @Test
    public void inverterComPosicoesImpar(){
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inverter();

        assertEquals("25,20,15,10,5", lista.toString());
    }
}
