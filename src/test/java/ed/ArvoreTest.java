package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ed.arvores.Arvore;
import ed.arvores.NoArvore;

public class ArvoreTest {
    
    Arvore<Integer> arvore = new Arvore<>();

    @Test
    public void toStringTest(){
        NoArvore<Integer> no9 = new NoArvore<Integer>(9); 
        NoArvore<Integer> no10 = new NoArvore<Integer>(10); 

        no9.setProximo(no10); ///testar inserindo filho
        NoArvore<Integer> no4 = new NoArvore<Integer>(4); 

        no4.inserirFilho(no9);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8); 

        NoArvore<Integer> no3 = new NoArvore<Integer>(3); 

        no3.inserirFilho(no8);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5); 
        NoArvore<Integer> no6 = new NoArvore<Integer>(6); 
        NoArvore<Integer> no7 = new NoArvore<Integer>(7); 

        no6.setProximo(no7);
        no5.setProximo(no6);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2); 

        no2.inserirFilho(no5);

        no3.setProximo(no4);
        no2.setProximo(no3);
        NoArvore<Integer> no1 = new NoArvore<Integer>(1); 
        no1.inserirFilho(no2);
        arvore.setRaiz(no1);

        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    public void buscar(){
        NoArvore<Integer> no9 = new NoArvore<Integer>(9); 
        NoArvore<Integer> no10 = new NoArvore<Integer>(10); 

        no9.setProximo(no10);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4); 

        no4.inserirFilho(no9);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8); 

        NoArvore<Integer> no3 = new NoArvore<Integer>(3); 

        no3.inserirFilho(no8);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5); 
        NoArvore<Integer> no6 = new NoArvore<Integer>(6); 
        NoArvore<Integer> no7 = new NoArvore<Integer>(7); 

        no6.setProximo(no7);
        no5.setProximo(no6);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2); 

        no2.inserirFilho(no5);

        no3.setProximo(no4);
        no2.setProximo(no3);
        NoArvore<Integer> no1 = new NoArvore<Integer>(1); 
        no1.inserirFilho(no2);
        arvore.setRaiz(no1);

        assertTrue(arvore.pertence(7));
    }

    @Test
    public void buscarFalse(){
        NoArvore<Integer> no9 = new NoArvore<Integer>(9); 
        NoArvore<Integer> no10 = new NoArvore<Integer>(10); 

        no9.setProximo(no10);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4); 

        no4.inserirFilho(no9);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8); 

        NoArvore<Integer> no3 = new NoArvore<Integer>(3); 

        no3.inserirFilho(no8);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5); 
        NoArvore<Integer> no6 = new NoArvore<Integer>(6); 
        NoArvore<Integer> no7 = new NoArvore<Integer>(7); 

        no6.setProximo(no7);
        no5.setProximo(no6);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2); 

        no2.inserirFilho(no5);

        no3.setProximo(no4);
        no2.setProximo(no3);
        NoArvore<Integer> no1 = new NoArvore<Integer>(1); 
        no1.inserirFilho(no2);
        arvore.setRaiz(no1);

        assertTrue(!arvore.pertence(55));
    }

    @Test
    public void contarNos(){
        NoArvore<Integer> no9 = new NoArvore<Integer>(9); 
        NoArvore<Integer> no10 = new NoArvore<Integer>(10); 

        no9.setProximo(no10);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4); 

        no4.inserirFilho(no9);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8); 

        NoArvore<Integer> no3 = new NoArvore<Integer>(3); 

        no3.inserirFilho(no8);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5); 
        NoArvore<Integer> no6 = new NoArvore<Integer>(6); 
        NoArvore<Integer> no7 = new NoArvore<Integer>(7); 

        no6.setProximo(no7);
        no5.setProximo(no6);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2); 

        no2.inserirFilho(no5);

        no3.setProximo(no4);
        no2.setProximo(no3);
        NoArvore<Integer> no1 = new NoArvore<Integer>(1); 
        no1.inserirFilho(no2);
        arvore.setRaiz(no1);

        assertEquals(10, arvore.contarNos());
    }
}
