package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import ed.filas.FilaCheiaException;
import ed.filas.FilaVaziaException;
import ed.filas.FilaVetor;

public class FilaVetorTest {
    
    @Test
    public void estaVazia(){
    FilaVetor<Integer> fila = new FilaVetor<>(5);
    assertTrue(fila.estaVazia());
    }

    @Test
    public void estaVaziaFalse(){
    FilaVetor<Integer> fila = new FilaVetor<>(5);
    fila.inserir(10);
    assertTrue(!fila.estaVazia());
    }

    @Test
    public void inserir(){
    FilaVetor<Integer> fila = new FilaVetor<>(10);
    fila.inserir(10);
    fila.inserir(20);
    fila.inserir(30);
    assertEquals(Integer.valueOf(10), fila.retirar());
    assertEquals(Integer.valueOf(20), fila.retirar());
    assertEquals(Integer.valueOf(30), fila.retirar());
    assertTrue(fila.estaVazia());
    }

    @Test
    public void filaCheia(){
    FilaVetor<Integer> fila = new FilaVetor<>(3);
    fila.inserir(10);
    fila.inserir(20);
    fila.inserir(30);
    try{
        fila.inserir(40);
        fail();
    }catch(FilaCheiaException e){}
    }

    @Test
    public void filaVazia(){
    FilaVetor<Integer> fila = new FilaVetor<>(3);
    try{
        fila.retirar();
        fail();
    }catch(FilaVaziaException e){}
    }

    @Test
    public void peek(){
    FilaVetor<Integer> fila = new FilaVetor<>(5);
    fila.inserir(10);
    fila.inserir(20);
    fila.inserir(30);
    assertEquals(Integer.valueOf(10), fila.peek());
    assertEquals(Integer.valueOf(10), fila.retirar());
    }

    @Test
    public void liberar(){
    FilaVetor<Integer> fila = new FilaVetor<>(5);
    fila.inserir(10);
    fila.inserir(20);
    fila.inserir(30);
    fila.liberar();
    assertTrue(fila.estaVazia());
    }

    @Test
    public void concatenacao(){
    FilaVetor<Integer> fila = new FilaVetor<>(5);
    fila.inserir(10);
    fila.inserir(20);
    fila.inserir(30);

    FilaVetor<Integer> fila2 = new FilaVetor<>(3);
    fila2.inserir(40);
    fila2.inserir(50);

    FilaVetor<Integer> fila3 = fila.criarFilaConcatenada(fila2);

    assertEquals("10,20,30", fila.toString());
    assertEquals("40,50", fila2.toString());
    assertEquals("10,20,30,40,50", fila3.toString());
    assertEquals(8, fila3.getLimite());
    }

    @Test
    public void encolher(){
    FilaVetor<String> fila = new FilaVetor<>(10);
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("A");
    fila.inserir("B");
    fila.inserir("C");
    fila.inserir("D");
    fila.retirar();
    fila.retirar();
    fila.retirar();

    fila.encolher();

    assertEquals("A,B,C,D", fila.toString());
    assertEquals(4, fila.limite);
    }

    @Test
    public void encolher2(){
    FilaVetor<String> fila = new FilaVetor<>(10);
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("z");
    fila.inserir("A");
    fila.inserir("B");
    fila.retirar();
    fila.retirar();
    fila.inserir("C");
    fila.inserir("D");
    fila.retirar();
    fila.retirar();
    fila.retirar();
    fila.retirar();
    fila.retirar();
    fila.retirar();

    fila.encolher();

    assertEquals("A,B,C,D", fila.toString());
    assertEquals(4, fila.limite);
    }

    @Test
    public void encolher3(){
    FilaVetor<String> fila = new FilaVetor<>(10);
    fila.inserir("A");
    fila.inserir("B");
    fila.inserir("C");
    fila.inserir("D");
    fila.encolher();

    assertEquals("A,B,C,D", fila.toString());
    assertEquals(4, fila.limite);
    }

    @Test
    public void encolher4(){
    FilaVetor<String> fila = new FilaVetor<>(4);
    fila.inserir("A");
    fila.inserir("B");
    fila.inserir("C");
    fila.inserir("D");
    fila.encolher();

    assertEquals("A,B,C,D", fila.toString());
    assertEquals(4, fila.limite);
    }
}
