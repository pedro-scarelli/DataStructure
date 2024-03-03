package com.estrutura;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListaEstaticaTest {
    
    @Test
    public void inserir(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        assertEquals("5,10,15,20", l1.toString());
    }

    @Test
    public void getTamanho(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        assertEquals(4, l1.getTamanho());
    }

    @Test
    public void buscar(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        assertEquals(2, l1.buscar(15));
    }

    @Test
    public void buscarFalse(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        assertEquals(-1, l1.buscar(30));
    }

    @Test
    public void retirar(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        l1.retirar(10);
        assertEquals("5,15,20", l1.toString());
        assertEquals(3, l1.getTamanho());
    }

    @Test
    public void inserirCRedimensionamento(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(1);
        l1.inserir(2);
        l1.inserir(3);
        l1.inserir(4);
        l1.inserir(5);
        l1.inserir(6);
        l1.inserir(7);
        l1.inserir(8);
        l1.inserir(9);
        l1.inserir(10);
        l1.inserir(11);
        l1.inserir(12);
        l1.inserir(13);
        l1.inserir(14);
        l1.inserir(15);
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", l1.toString());
        assertEquals(15, l1.getTamanho());
    }

    @Test
    public void obterElemento(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        assertEquals(20, l1.obterElemento(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void excecao(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        l1.obterElemento(5);
    }

    @Test
    public void liberar(){
        ListaEstatica l1 = new ListaEstatica();
        l1.inserir(5);
        l1.inserir(10);
        l1.inserir(15);
        l1.inserir(20);
        l1.liberar();
        assertEquals(true, l1.estaVazia());
    }
}
