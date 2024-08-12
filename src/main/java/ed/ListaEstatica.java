package ed;

public class ListaEstatica<T> extends ListaAbstract<T> {

    private Object[] info = getInfo();
    
    @Override
    public void inserir(T value){
        if(getTamanho() == getInfo().length){
            redimensionar();  
        }
        info[getTamanho()] = value;
        setTamanho(getTamanho()+1);
    }

    @Override
    public int buscar(T value){
        for (int i = 0; i < getTamanho(); i++) {
            if(info[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
}
