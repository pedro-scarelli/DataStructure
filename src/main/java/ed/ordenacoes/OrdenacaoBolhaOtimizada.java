package ed.ordenacoes;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    
    @Override
    public void ordenar(){
        T[] info = getInfo();
        for (int i = info.length -1; i > 1; i--) {
            boolean trocou = false;
            for (int j = 0; j <= i-1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j+1);
                    trocou = true;
                }   
            }
            if(!trocou){
                break;
            }
        }
    }
}
