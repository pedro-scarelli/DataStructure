package ed;

public abstract class ListaAbstract<T>{
 
    private T[] info;
    private int tamanho;

    public ListaAbstract(){
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public int getTamanho(){
        return tamanho;
    }

    protected void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    protected T[] getInfo() {
        return info;
    }
    
    public void setInfo(T[]info){
        this.info = info;
    }

    protected void redimensionar(){
        T[] newInfo = (T[]) new Object[getTamanho() + 10]; 

        for (int i = 0; i < info.length; i++) {
            newInfo[i] = getInfo()[i];
        } 
        setInfo(newInfo);
    }

    public abstract void inserir(T value);

    public void exibir(){
        for (int i = 0; i < getTamanho(); i++) {
            System.out.println(getInfo()[i] + "\n");
        }
    }

    public abstract int buscar(T value);

    public void retirar(T value){
        int posicao = buscar(value);

        if(posicao > -1){
            for (int i = posicao+1; i < getTamanho(); i++) {
                getInfo()[i-1] = getInfo()[i];
            }
            tamanho--;        
        }
    }
    public void liberar(){
        setInfo((T[]) new Object[10]);
        tamanho = 0;
    }
    public T obterElemento(int position){
        if(position > getTamanho() || getInfo()[position].equals(0)){
            throw new IndexOutOfBoundsException();
        }
        return getInfo()[position]; 
    }

    public boolean estaVazia(){
        if(getTamanho() == 0){
            return true;
        }        
        return false;
    }

    @Override
    public String toString(){
        String stringContent = "";
        for (int i = 0; i < getTamanho(); i++) {
            if (i > 0) {
                stringContent += ",";
            }
            stringContent += getInfo()[i];
        }
        return stringContent;
    }
}
