package ed.Listas;

public class ListaEstaticaG <T>{
 
    private Object[] info;
    private int tamanho;

    public ListaEstaticaG(){
        info = new Object[10];
        tamanho = 0;
    }

    public int getTamanho(){
        return tamanho;
    }

    public Object[] getInfo() {
        return info;
    }
    
    public void setInfo(Object[]info){
        this.info = info;
    }

    private void redimensionar(){
        Object [] newInfo = new Object[getTamanho() + 10]; 

        for (int posicao = 0; posicao < info.length; posicao++) {
            newInfo[posicao] = getInfo()[posicao];
        } 
        setInfo(newInfo);
    }

    public void inserir(T value){
        if(getTamanho() == getInfo().length){
            redimensionar();  
        }
        getInfo()[getTamanho()] = value;
        tamanho++;
    }

    public void exibir(){
        for (int posicao = 0; posicao < getTamanho(); posicao++) {
            System.out.println(getInfo()[posicao] + "\n");
        }
    }

    public int buscar(T value){
        for (int posicao = 0; posicao < getTamanho(); posicao++) {
            if(getInfo()[posicao] == value){
                return posicao;
            }
        }
        return -1;
    }
    public void retirar(T value){
        int posicao = buscar(value);

        if(posicao > -1){
            for (int proximo = posicao+1; proximo < getTamanho(); proximo++) {
                getInfo()[proximo-1] = getInfo()[proximo];
            }
            tamanho--; 
            getInfo()[tamanho] = null;    
        }
    }

    public void retirarElementos(int inicio, int fim){
        if(fim > getTamanho()-1){
            fim = getTamanho()-1;
        }
        for (int posicao = fim; posicao >= inicio; posicao--) {
            for (int proximo = posicao+1; proximo < getTamanho(); proximo++) {
                getInfo()[proximo-1] = getInfo()[proximo];
            }
            tamanho--;
            getInfo()[tamanho] = null;
        }
    }

    //estudar
    public void retirarElementos2(int inicio, int fim) {
        if (inicio < 0 || inicio >= tamanho || fim < 0 || fim >= tamanho || inicio > fim) {
            throw new IllegalArgumentException("Índices de início ou fim inválidos.");
        }
    
        int elementosRemovidos = fim - inicio + 1;
        int novoTamanho = tamanho - elementosRemovidos;
    
        for (int i = fim + 1; i < tamanho; i++) {
            info[i - elementosRemovidos] = info[i];
        }
    
        for (int i = novoTamanho; i < tamanho; i++) {
            info[i] = null; // Limpar as referências dos elementos removidos
        }
    
        tamanho = novoTamanho;
    }

    public void liberar(){
        setInfo(new Object[10]);
        tamanho = 0;
    }
    public T obterElemento(int position){
        if(position > getTamanho() || getInfo()[position] == null){
            throw new IndexOutOfBoundsException();
        }

        return (T)getInfo()[position]; 
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
        for (int posicaoObjeto = 0; posicaoObjeto < getTamanho(); posicaoObjeto++) {
            if (posicaoObjeto > 0) {
                stringContent += ",";
            }
            stringContent += getInfo()[posicaoObjeto];
        }
        return stringContent;
    }

    public void inverter(){
        int qtdeTrocas = getTamanho()/ 2;
        int esquerda = 0;
        int direita = getTamanho() -1;

        while(qtdeTrocas > 0){
            Object objetoBackup = getInfo()[esquerda];
            getInfo()[esquerda] = getInfo()[direita];
            getInfo()[direita] = objetoBackup;

            esquerda++;
            direita--;

            qtdeTrocas--;
        }
    }
}


