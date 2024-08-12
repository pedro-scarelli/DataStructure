package ed;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ed.buscas.ArvoreBinariaBusca;

public class ArvoreBinariaBuscaTest<T> {
    
    ArvoreBinariaBusca<Integer> arvoreBusca = new ArvoreBinariaBusca<>();

    @Test
    public void inserirTest(){
        arvoreBusca.inserir(50);
        arvoreBusca.inserir(30);
        arvoreBusca.inserir(70);
        arvoreBusca.inserir(40);
        arvoreBusca.inserir(25);
        arvoreBusca.inserir(75);
        arvoreBusca.inserir(65);
        arvoreBusca.inserir(35);
        arvoreBusca.inserir(60);

        assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>", arvoreBusca.toString());
    }

    @Test
    public void removerFolha(){
        arvoreBusca.inserir(50);
        arvoreBusca.inserir(30);
        arvoreBusca.inserir(25);
        arvoreBusca.inserir(40);

        arvoreBusca.retirar(40);

        assertEquals("<50<30<25<><>><>><>>", arvoreBusca.toString());
    }

    @Test
    public void removerNoComUmFilho(){
        arvoreBusca.inserir(80);
        arvoreBusca.inserir(52);
        arvoreBusca.inserir(90);
        arvoreBusca.inserir(48);
        arvoreBusca.inserir(71);
        arvoreBusca.inserir(63);
        arvoreBusca.inserir(67);

        arvoreBusca.retirar(71);

        assertEquals("<80<52<48<><>><63<><67<><>>>><90<><>>>", arvoreBusca.toString());
    }

    @Test
    public void removerNoComDoisFilhos(){
        arvoreBusca.inserir(250);
        arvoreBusca.inserir(38);
        arvoreBusca.inserir(26);
        arvoreBusca.inserir(72);
        arvoreBusca.inserir(55);
        arvoreBusca.inserir(90);
        arvoreBusca.inserir(41);
        arvoreBusca.inserir(60);
        arvoreBusca.inserir(43);
        arvoreBusca.inserir(78);
        arvoreBusca.inserir(92);
        arvoreBusca.inserir(74);

        arvoreBusca.retirar(38);

        assertEquals("<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>", arvoreBusca.toString());
    }
}
