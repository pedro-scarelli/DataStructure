package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import ed.Pilhas.*;

public class PilhaVetorTest {
    PilhaVetor<Integer> pilhaVetor = new PilhaVetor<>(10);

    @Test
    public void estaVazia(){
        assertTrue(pilhaVetor.estaVazia());
    }

    @Test
    public void estaVaziaFalse(){
        pilhaVetor.setLimite(5); 
        pilhaVetor.push(10);
        assertTrue(!pilhaVetor.estaVazia());
    }

    @Test
    public void pushEPop(){
        pilhaVetor.setLimite(10); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        assertEquals(Integer.valueOf(30),pilhaVetor.pop());
        assertEquals(Integer.valueOf(20),pilhaVetor.pop());
        assertEquals(Integer.valueOf(10),pilhaVetor.pop());
        assertTrue(pilhaVetor.estaVazia());
    }

    @Test
    public void pilhaCheia(){
        pilhaVetor.setLimite(3); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        try{
            pilhaVetor.push(40);
            fail();
        } catch(PilhaCheiaException error){
            System.out.println(error);
        }
    }

    @Test
    public void pilhaVazia(){
        try{
            pilhaVetor.pop();
            fail();
        } catch(PilhaVaziaException error){
            System.out.println(error);
        }
    }

    @Test
    public void peek(){
        pilhaVetor.setLimite(5); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        assertEquals(Integer.valueOf(30),pilhaVetor.peek());
        assertEquals(Integer.valueOf(30),pilhaVetor.pop());    
    }

    @Test
    public void liberar(){
        pilhaVetor.setLimite(5); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        pilhaVetor.liberar();
        assertTrue(pilhaVetor.estaVazia()); 
    }

    @Test
    public void concatenar(){
        pilhaVetor.setLimite(5); 
        pilhaVetor.push(10);
        pilhaVetor.push(20);
        pilhaVetor.push(30);
        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(2);
        pilha2.push(40);
        pilha2.push(50);
        pilhaVetor.concatenar(pilha2);
        assertEquals("50,40,30,20,10", pilhaVetor.toString()); 
    }
}
