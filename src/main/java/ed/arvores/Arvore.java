package ed.arvores;

public class Arvore<T>{
    
    private NoArvore<T> raiz;

    public Arvore(){
        raiz = new NoArvore<T>(null);
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString(){
        if(raiz == null){
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no){
        String resultado = "<";    
        resultado += no.getInfo();

        NoArvore<T> primeiro = no.getPrimeiro();
        while(primeiro != null){
            resultado += obterRepresentacaoTextual(primeiro);
            primeiro = primeiro.getProximo();  
        } 

        return resultado += ">";   
    }

    public boolean pertence(T value){
        if(raiz == null){
            return false;
        } else {
            return pertence(raiz, value);
        }
    }

    private boolean pertence(NoArvore<T> no, T value){
        if(no.getInfo() == value){
            return true;
        } else {
            NoArvore<T> primeiro = no.getPrimeiro();
            while(primeiro != null){
                if(pertence(primeiro, value)){
                    return true;
                }
                primeiro = primeiro.getProximo();
            }
            
            return false;
        }  
    }

    public int contarNos(){
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no){
        int qtdeNos = 0;

        if(no.getInfo() != null){
            qtdeNos++;
            NoArvore<T> primeiro = no.getPrimeiro();
            while(primeiro != null){
                qtdeNos += contarNos(primeiro);                
                primeiro = primeiro.getProximo();
            }
        } 
        
        return qtdeNos; 
    }
}
