package ed;

public class NoLista<T> {
    private T info;
    private NoLista proximo;

    public T getInfo(){
        return this.info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public NoLista<T>  getProximo(){
        return this.proximo;
    }

    public void setProximo(NoLista<T> proximo){
        this.proximo = proximo;
    }
}
