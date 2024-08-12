package ed.Pilhas;

public class PilhaVetor<T> implements Pilha<T>{

    private Object info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite){
        info = (T[])new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T value) {
        if(tamanho == limite){
            throw new PilhaCheiaException();
        } else {
            info[tamanho] = value;
            tamanho++;
        }
    }

    @Override
    public T pop() {
        T value = peek();
        info[tamanho-1] = null;
        tamanho--;

        return value;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new PilhaVaziaException();
        } 
        return (T)info[tamanho-1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;

        /*OU 
        try{
            while (true) {
                pop();
            }
        }  catch (PilhaVaziaException e){

        }
        */ 
    }

    @Override
    public String toString(){
        String resultado = "";

        for (int i = tamanho-1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado += ",";
            }
        }

        return resultado;
    } 
    
    public void concatenar(PilhaVetor<T> pilha2){
        if(tamanho + pilha2.tamanho > limite){
            throw new RuntimeException("Não há espaços para empilhar todos os dados");
        }

        for (int i = 0; i < pilha2.tamanho; i++) {
            push((T)pilha2.info[i]);
        }
    }

    public void setLimite(int limite) {
        this.limite = limite;
        info = (T[])new Object[limite];
    }
}
