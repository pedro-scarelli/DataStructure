package ed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ed.arvores.ArvoreBinaria;
import ed.arvores.NoArvoreBinaria;

public class ArvoreBinariaTest {
    
    ArvoreBinaria<Integer> arvoreBinaria = new ArvoreBinaria<>();

    @Test   
    public void estaVazia(){
        assertTrue(arvoreBinaria.estaVazia());
    }

    @Test
    public void estaVaziaFalse(){
        arvoreBinaria.setRaiz(new NoArvoreBinaria<Integer>(5));
        assertTrue(!arvoreBinaria.estaVazia());
    }

    @Test
    public void methodToString(){
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);

        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvoreBinaria.toString());
    } 

    @Test
    public void pertenceRaiz(){
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);
        assertTrue(arvoreBinaria.pertence(1));
    }

    @Test
    public void pertenceInterno(){
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);
        assertTrue(arvoreBinaria.pertence(3));
    }

    @Test
    public void pertenceFolha(){
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);
        assertTrue(arvoreBinaria.pertence(6));
    }

    @Test
    public void pertenceFalse(){
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);
        assertTrue(!arvoreBinaria.pertence(10));
    }

    @Test
    public void contarNos(){
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);
        assertEquals(6, arvoreBinaria.contarNos());
    }
}
