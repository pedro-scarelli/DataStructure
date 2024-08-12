package ed.buscas;

import ed.arvores.NoArvoreBinaria;

public abstract class ArvoreBinariaAbstract<T>{

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
    
    public boolean estaVazia(){
        return this.raiz == null;
    }

    public boolean pertence(NoArvoreBinaria<T> no, T info){
        return buscar(info) != null;
    }

    @Override
    public String toString(){
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no){    
        String resultado = "<";    
        if(no != null){
            resultado += no.getInfo() + 
            arvorePre(no.getEsquerda()) + 
            arvorePre(no.getDireita());
        } 

        return resultado += ">";    
    }

    public int contarNos(){
        return contarNos(this.raiz);
    }

    private int contarNos(NoArvoreBinaria<T> sa){
        if(sa == null){
            return 0;
        } else {
            return 1 + contarNos(sa.getEsquerda()) + contarNos(sa.getDireita());
        }
    }

    public abstract NoArvoreBinaria<T> buscar(T info);
}
