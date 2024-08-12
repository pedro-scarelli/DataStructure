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

    public int contarNosInternos(){
        return contarNosInternos(this.raiz);
    }

    public int contarNosInternos(NoArvoreBinaria<T> sa){
        if(sa == null || sa.getEsquerda() == null && sa.getDireita() == null){
            return 0;
        } else {
            return 1 + contarNosInternos(sa.getEsquerda()) + contarNosInternos(sa.getDireita());
        }
    }

    //extras
    public int obterAltura(){
        return (raiz != null) ? obterAltura(raiz) : -1;
    }

    private int obterAltura(NoArvoreBinaria<T> no){
        int altura = 0;
        if(no.getEsquerda() != null || no.getDireita() != null){
            altura++;
            if(no.getDireita() != null){
                altura += obterAltura(no.getDireita());
            } else if(no.getEsquerda() != null){
                altura += obterAltura(no.getEsquerda());
            }
        }
        return altura;
    }

    public String arvorePos(NoArvoreBinaria<T> no){    
        String resultado = "<";    
        if(no != null){
            resultado += arvorePos(no.getEsquerda()) + 
            arvorePos(no.getDireita()) +
            no.getInfo();
        } 

        return resultado += ">";    
    }

    public String arvoreOrdem(NoArvoreBinaria<T> no){    
        String resultado = "<";    
        if(no != null){
            resultado += arvoreOrdem(no.getEsquerda()) +
            no.getInfo() + 
            arvoreOrdem(no.getDireita());
        } 

        return resultado += ">";    
    }

    public int contarFolhas(){
        return (raiz != null) ? contarFolhas(raiz) : 0;
    }

    private int contarFolhas(NoArvoreBinaria<T> no){
        int folhas = 0;
        if(no.getEsquerda() == null && no.getDireita() == null){
            return folhas += 1;
        } else {
            if(no.getDireita() != null){
                folhas += contarFolhas(no.getDireita());
            }
            
            if(no.getEsquerda() != null){
                folhas += contarFolhas(no.getEsquerda());
            }
        }
        return folhas;
    }

    public boolean isBalanced() {
        return isBalanced(raiz);
    }

    private boolean isBalanced(NoArvoreBinaria<T> no) {
        if (no == null) return true;

        // Verifica a altura da subárvore esquerda e direita
        int leftHeight = getHeight(no.getEsquerda());
        int rightHeight = getHeight(no.getDireita());

        // Verifica se a diferença de altura é menor ou igual a 1 e se ambas as subárvores também são balanceadas
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(no.getEsquerda()) && isBalanced(no.getDireita());
    }

    private int getHeight(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return Math.max(getHeight(no.getEsquerda()), getHeight(no.getDireita())) + 1;
    }

    public void inverter(){
        inverter(raiz);
    }

    private NoArvoreBinaria<T> inverter(NoArvoreBinaria<T> no){
        if(no == null) return null;

        NoArvoreBinaria<T> temp = no.getEsquerda();
        no.setEsquerda(no.getDireita());
        no.setDireita(temp);

        inverter(no.getDireita());
        inverter(no.getEsquerda());

        return no;
    }
}
