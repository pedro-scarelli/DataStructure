package ed;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import ed.ordenacoes.OrdenacaoBolha;
import ed.ordenacoes.OrdenacaoBolhaOtimizada;
import ed.ordenacoes.OrdenacaoMergeSort;
import ed.ordenacoes.OrdenacaoQuickSort;

public class OrdenacaoTest {
    
    Integer[]info = {70,2,88,15,90,30};

    @Test
    public void bolha(){
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(info);
        bolha.ordenar();
        Integer[] esperado = {2,15,30,70,88,90};
        assertArrayEquals(esperado, bolha.getInfo());
    }

    @Test
    public void bolhaDescrescente(){
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(info);
        bolha.ordenarDecrescente();
        Integer[] esperado = {90,88,70,30,15,2};
        assertArrayEquals(esperado, bolha.getInfo());
    }

    @Test
    public void bolhaOtimizada(){
        OrdenacaoBolhaOtimizada<Integer> bolhaOtimizada = new OrdenacaoBolhaOtimizada<>();
        bolhaOtimizada.setInfo(info);
        bolhaOtimizada.ordenar();
        Integer[] esperado = {2,15,30,70,88,90};
        assertArrayEquals(esperado, bolhaOtimizada.getInfo());
    }

    @Test
    public void quickSort(){
        OrdenacaoQuickSort<Integer> quickSort = new OrdenacaoQuickSort<>();
        quickSort.setInfo(info);
        quickSort.ordenar();
        Integer[] esperado = {2,15,30,70,88,90};
        assertArrayEquals(esperado, quickSort.getInfo());
    }

    @Test
    public void mergeSort(){
        OrdenacaoMergeSort<Integer> mergeSort = new OrdenacaoMergeSort<>();
        mergeSort.setInfo(info);
        mergeSort.ordenar();
        Integer[] esperado = {2,15,30,70,88,90};
        assertArrayEquals(esperado, mergeSort.getInfo());
    }
}
