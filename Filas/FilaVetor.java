package ed.filas;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    public int limite;
    public int tamanho;
    public int inicio;

    public FilaVetor(int limite){
        info = (T[])new Object[limite];
        this.limite = limite;
        tamanho = 0;
        inicio = 0;
    }
    @Override
    public void inserir(T valor) {
        if(tamanho == limite){
            throw new FilaCheiaException();
        }

        info[(inicio + tamanho) % limite] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new FilaVaziaException();
        }

        return info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();
        info[inicio] = null;

        inicio = (inicio +1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        /*info = (T[])new Object[limite];
        tamanho = 0*/

        try{
            while(true){
                retirar();
            }
        } catch(FilaVaziaException e){

        }
    }
    public int getLimite() {
        return limite;
    }
    
    @Override
    public String toString(){
        String resultado = "";

        int indice = inicio;
        for (int i = 0; i < tamanho; i++) {
            resultado += info[indice];
            if (i != tamanho-1) {
                resultado += ","; 
            }
            indice = (indice+1) % limite;
        }

        return resultado;
    } 

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> fila2){
        FilaVetor<T> filaConcatenada = new FilaVetor<>(limite + fila2.getLimite());


        int indice = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            filaConcatenada.inserir(info[indice]);
            indice = (inicio + 1) & limite;
        }

        indice = fila2.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            filaConcatenada.inserir(fila2.info[indice]);
            indice = (inicio + 1) & limite;
        }
        
        return filaConcatenada;
    }
}
