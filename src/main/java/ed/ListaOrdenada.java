package ed;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {
    
    @Override
    public void inserir(T value){
        Object[] info = getInfo();
        int n = getTamanho();
        if(n == info.length){
            redimensionar();  
            info = getInfo();
        }
        if(n == 0){
            info[0] = value;
            setTamanho(1);
        } else {
            int inicio = 0;
            int fim = n-1;   
            int meio = 0;
            while(inicio <= fim){
                meio = (inicio + fim) / 2;
                if(value.compareTo((T) info[meio]) < 0){
                    fim = meio-1;
                } else {
                    if(value.compareTo((T) info[meio]) > 0){
                        inicio = meio + 1;
                    } 
                } 
            }
            for (int i = n; i > meio; i--) {
                info[i] = info[i-1];
            }
            if(value.compareTo((T) info[meio]) > 0){
                info[meio+1] = value;
            } else {
                info[meio] = value;
            }
            setTamanho(n+1);
        }
    }

    @Override
    public int buscar(T value){
        Object[] info = getInfo();
        int n = getTamanho();
        int inicio = 0;
        int fim = n-1;   

        while(inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(value.compareTo((T) info[meio]) < 0){
                fim = meio-1;
            } else {
                if(value.compareTo((T) info[meio]) > 0){
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            } 
        }
        return -1;
    }
    
}
