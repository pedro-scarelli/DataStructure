package ed.arvores;

public class ArvoreBinaria<T>{
    
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public boolean pertence(T info){
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info){
        if(no == null)
            return false;
        else
            return (no.getInfo().equals(info)||
            pertence(no.getEsquerda(), info) ||
            pertence(no.getDireita(), info));
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

    private int contarNos(NoArvoreBinaria<T> no){
        if(no == null)
            return 0;
        else
            return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
}
