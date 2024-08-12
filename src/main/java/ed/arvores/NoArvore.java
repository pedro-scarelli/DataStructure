package ed.arvores;

public class NoArvore<T> {
    
    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;

    public NoArvore(T info){
        this.info = info;
    }

    public void inserirFilho(NoArvore<T> sa){
        if(primeiro != null){
            sa.proximo = primeiro;
        }
        primeiro = sa;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }
}
