package ed.ordenacoes;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    
    @Override
    public void ordenar(){
        for (int i = getInfo().length -1; i > 1; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    trocar(j, j+1);
                }   
            }
        }
    }
    //     {70,2,88,15,90,30}; 
    //      {90,88,70,30,15,2};
    public void ordenarDecrescente(){
        boolean trocou = false;
        for (int i = getInfo().length -1; i > 1; i--) {
        for (int j = 0; j <= i-1; j++) {
        if (getInfo()[j].compareTo(getInfo()[j + 1]) < 0) {
        trocar(j, j+1);
        trocou = true;
        }
        if(trocou){
        i++;
        trocou = false;
        break;
        }
        }
        }
        }
}
