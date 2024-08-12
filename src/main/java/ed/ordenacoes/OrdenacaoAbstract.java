package ed.ordenacoes;

public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void trocar(int a, int b){
        T backup = info[a];
        info[a] = info[b];
        info[b] = backup;
    }

    public abstract void ordenar();
}
