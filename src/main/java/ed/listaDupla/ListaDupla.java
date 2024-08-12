package ed.listaDupla;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla(){
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro(){
        return this.primeiro;
    }

    public void inserir(T info){
        NoListaDupla<T> novoNo = new NoListaDupla<T>();
        novoNo.setInfo(info);
        novoNo.setProximo(primeiro);
        novoNo.setAnterior(null);
        if(primeiro != null){
            primeiro.setAnterior(novoNo);
        }
        primeiro = novoNo;        
    }

    public NoListaDupla<T> buscar(T info){
        NoListaDupla<T> p = primeiro;
        while(p != null){
            if(p.getInfo().equals(info)){
                return p;
            }
            p = p.getProximo();
        } 
        return null;
    }

    public void retirar(T info){
        NoListaDupla<T> noParaRemover = buscar(info);
        if(noParaRemover != null){
            if(noParaRemover == primeiro){
                this.primeiro = primeiro.getProximo();
            } else {
                noParaRemover.getAnterior().setProximo(noParaRemover.getProximo());
            }
            if(noParaRemover.getProximo() != null) {
                noParaRemover.getProximo().setAnterior(noParaRemover.getAnterior());
            }
        }
    }  
    
    public void exibirOrdemInversa (){
        NoListaDupla<T> atual = obterUltimo();
              
        while(atual != null){
            System.out.println(atual.getInfo());
            atual = atual.getAnterior();
        } 
    }

    public NoListaDupla<T> obterUltimo(){
        NoListaDupla<T> ultimo = primeiro;
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            ultimo = atual;
            atual = atual.getProximo();
        } 
        return ultimo;
    }

    public void liberar(){
        NoListaDupla<T> no = this.primeiro;
        while (no != null) {
            no.setAnterior(null);
            NoListaDupla<T> backup = no.getProximo();
            no.setProximo(null);
            no = backup;
        }
        primeiro = null;
    }

    @Override
    public String toString(){
        String stringContent = "";
        NoListaDupla<T> noToString = primeiro;
        while(noToString != null){
            if (noToString != primeiro) {
                stringContent += ",";
            }
            stringContent += noToString.getInfo();
            noToString = noToString.getProximo();
        }
        return stringContent;
    }
}
