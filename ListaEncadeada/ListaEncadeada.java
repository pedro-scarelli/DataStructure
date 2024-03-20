package ed;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public ListaEncadeada(){
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro(){
        return this.primeiro;
    }

    public void inserir(T info){
        NoLista novoNo = new NoLista<T>();
        novoNo.setInfo(info);
        novoNo.setProximo(primeiro);
        primeiro = novoNo;
        
    }

    public boolean estaVazia(){
        return this.primeiro == null;
    }

    public NoLista<T> buscar(T info){
        NoLista p = primeiro;
        while(p != null){
            if(p.getInfo().equals(info)){
                return p;
            }
            p = p.getProximo();
        } 
        return null;
    }

    public void retirar(T info){
        NoLista anterior = null;
        NoLista p = primeiro;
        
        while(p != null && !p.getInfo().equals(info)){
            anterior = p;
            p = p.getProximo();
        } 
        if(p != null){
            if(p == primeiro){
                this.primeiro = primeiro.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }     
    
    public int obterComprimento(){
        int qtdeNos = 0;
        NoLista <T> noParaContagem = primeiro;
        while(noParaContagem != null){
            qtdeNos++;
            noParaContagem = noParaContagem.getProximo();
        }
        return qtdeNos;
    }

    public NoLista<T> obterNo(int index){
        if(index < 0){
            throw new java.lang.IndexOutOfBoundsException();
        }
        
        NoLista<T> noProcurado = getPrimeiro();
        while(noProcurado != null && index > 0){
            index--;
            noProcurado = noProcurado.getProximo();
        }

        if(noProcurado == null){
            throw new IndexOutOfBoundsException();
        }
        return noProcurado;        
    }

    @Override
    public String toString(){
        String stringContent = "";
        NoLista noToString = primeiro;
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
