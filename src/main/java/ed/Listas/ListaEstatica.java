package ed.Listas;

public class ListaEstatica {
 
    private int[] info;
    private int tamanho;

    public ListaEstatica(){
        info = new int[10];
        tamanho = 0;
    }

    public int getTamanho(){
        return tamanho;
    }

    public int[] getInfo() {
        return info;
    }
    
    public void setInfo(int[]info){
        this.info = info;
    }

    private void redimensionar(){
        int [] newInfo = new int[getTamanho() + 10]; 

        for (int i = 0; i < info.length; i++) {
            newInfo[i] = getInfo()[i];
        } 
        setInfo(newInfo);
    }

    public void inserir(int value){
        if(getTamanho() == getInfo().length){
            redimensionar();  
        }
        getInfo()[getTamanho()] = value;
        tamanho++;
    }

    public void exibir(){
        for (int i = 0; i < getTamanho(); i++) {
            System.out.println(getInfo()[i] + "\n");
        }
    }

    public int buscar(int value){
        for (int i = 0; i < getTamanho(); i++) {
            if(getInfo()[i] == value){
                return i;
            }
        }
        return -1;
    }
    public void retirar(int value){
        int posicao = buscar(value);

        if(posicao > -1){
            for (int i = posicao+1; i < getTamanho(); i++) {
                getInfo()[i-1] = getInfo()[i];
            }
            tamanho--;        
        }
    }
    public void liberar(){
        setInfo(new int[10]);
        tamanho = 0;
    }
    public int obterElemento(int position){
        if(position > getTamanho() || getInfo()[position] == 0){
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
