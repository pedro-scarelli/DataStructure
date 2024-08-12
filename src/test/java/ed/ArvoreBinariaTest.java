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

        assertEquals("<<<>2<<>4<>>>1<<<>5<>>3<<>6<>>>>", arvoreBinaria.arvoreOrdem(raiz));
        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvoreBinaria.toString());
        assertEquals("<<<><<><>4>2><<<><>5><<><>6>3>1>", arvoreBinaria.arvorePos(raiz));
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
            /*    1
            *  2,        3
         * null, 4      5 6
               7,  8
              9 10              */

        
        NoArvoreBinaria<Integer> no9 = new NoArvoreBinaria<Integer>(9);
        NoArvoreBinaria<Integer> no10 = new NoArvoreBinaria<Integer>(10);

        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<Integer>(7, no9, no10);
        NoArvoreBinaria<Integer> no8 = new NoArvoreBinaria<Integer>(8);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, no7, no8);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);


        NoArvoreBinaria<Integer> no12 = new NoArvoreBinaria<Integer>(12);

        NoArvoreBinaria<Integer> no11 = new NoArvoreBinaria<Integer>(11, no12, null);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, no11);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);
        assertEquals(7, arvoreBinaria.contarNosInternos());
    }

    @Test
    public void contarNos2(){
            /*    1
            *  2,        3
         * null, 4      5 6
               7,  8
              9 10              */

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, null, null);
        arvoreBinaria.setRaiz(raiz);
        assertEquals(0, arvoreBinaria.contarNosInternos());
    }

    @Test
    public void contarNos3(){
            /*    1
            *  2,        3
         * null, 4      5 6
               7,  8
              9 10              */

              NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, null);
              NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, null, no2);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no3, null);
        arvoreBinaria.setRaiz(raiz);
        assertEquals(2, arvoreBinaria.contarNosInternos());
    }

    @Test
    public void obterAltura(){
        // Teste com árvore vazia
        assertEquals(-1, arvoreBinaria.obterAltura());

        // Teste com árvore de um nó
        NoArvoreBinaria<Integer> raizUnicoNo = new NoArvoreBinaria<Integer>(10);
        arvoreBinaria.setRaiz(raizUnicoNo);
        assertEquals(0, arvoreBinaria.obterAltura());

        // Teste com árvore onde todos os nós estão à esquerda
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no4, null);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, no3, null);
        NoArvoreBinaria<Integer> raizEsquerda = new NoArvoreBinaria<Integer>(1, no2, null);
        arvoreBinaria.setRaiz(raizEsquerda);
        assertEquals(3, arvoreBinaria.obterAltura());

        // Teste com árvore perfeitamente balanceada
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<Integer>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no2Bal = new NoArvoreBinaria<Integer>(2, no5, no6);
        NoArvoreBinaria<Integer> no3Bal = new NoArvoreBinaria<Integer>(3, null, no7);
        NoArvoreBinaria<Integer> raizBal = new NoArvoreBinaria<Integer>(1, no2Bal, no3Bal);
        arvoreBinaria.setRaiz(raizBal);
        assertEquals(2, arvoreBinaria.obterAltura());

        // Teste com árvore desbalanceada
        NoArvoreBinaria<Integer> no10 = new NoArvoreBinaria<Integer>(10);
        NoArvoreBinaria<Integer> no9 = new NoArvoreBinaria<Integer>(9, null, no10);
        NoArvoreBinaria<Integer> no8 = new NoArvoreBinaria<Integer>(8, null, no9);
        NoArvoreBinaria<Integer> no1Des = new NoArvoreBinaria<Integer>(1, null, no8);
        arvoreBinaria.setRaiz(no1Des);
        assertEquals(3, arvoreBinaria.obterAltura());
    }

    @Test
    public void testContarFolhas() {
        // Criando os nós folha
        NoArvoreBinaria<Integer> folha1 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> folha2 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> folha3 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> folha4 = new NoArvoreBinaria<Integer>(7);
        NoArvoreBinaria<Integer> folha5 = new NoArvoreBinaria<Integer>(8);
        NoArvoreBinaria<Integer> folha6 = new NoArvoreBinaria<Integer>(9);
        NoArvoreBinaria<Integer> folha7 = new NoArvoreBinaria<Integer>(10);

        // Criando os nós intermediários
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, folha1);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, folha2, folha3);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(11, folha4, folha5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<Integer>(12, folha6, folha7);

        // Criando a raiz
        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        NoArvoreBinaria<Integer> raiz2 = new NoArvoreBinaria<Integer>(13, no6, no7);

        // Criando mais um nível de árvore
        NoArvoreBinaria<Integer> raizPrincipal = new NoArvoreBinaria<Integer>(14, raiz, raiz2);

        // Configurando a árvore binária
        arvoreBinaria.setRaiz(raizPrincipal);

        // Verificando o número de folhas
        assertEquals(7, arvoreBinaria.contarFolhas());
    }

    @Test
    public void testInvertTree() {
        // Montagem da árvore original
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(1, no2, no3);
        arvoreBinaria.setRaiz(raiz);

        // Inverte a árvore
        arvoreBinaria.inverter();

        // Verifica se a árvore foi invertida corretamente
        assertEquals("<1<3<6<><>><5<><>>><2<4<><>><>>>", arvoreBinaria.toString());
    }                   
}
