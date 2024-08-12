package ed.buscas;

import ed.arvores.NoArvoreBinaria;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info){
        NoArvoreBinaria<T> p = getRaiz();
        
        while(p != null && !p.getInfo().equals(info)){
            if(info.compareTo(p.getInfo()) < 0){
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }

        return p;
    }

    public void inserir(T info){
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(info);

        if(estaVazia()){
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> p = getRaiz();
            NoArvoreBinaria<T> pai;

            while(true){
                pai = p;
                if(info.compareTo(p.getInfo()) < 0){
                    p = p.getEsquerda();
                    if(p == null){
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = p.getDireita();
                    if(p == null){
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    public void retirar(T info){
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;
        
        while((p != null) && (!p.getInfo().equals(info))){
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if(p != null){
            if((p.getEsquerda() == null) && (p.getDireita() == null)){
                if(p == getRaiz()){
                    setRaiz(null);
                } else {
                    if(filhoEsquerda){
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            } else {
                if(p.getDireita() == null){
                    if(p == getRaiz()){
                        setRaiz(p.getEsquerda());
                    } else {
                        if(filhoEsquerda){
                            pai.setEsquerda(p.getEsquerda());
                        } else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }
                } else {
                    if(p.getEsquerda() == null){
                        if(p == getRaiz()){
                            setRaiz(p.getDireita());
                        } else {
                            if(filhoEsquerda){
                                pai.setEsquerda(p.getDireita());
                            } else {
                                pai.setDireita(p.getDireita());
                            }
                        }
                    } else {
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                        if(p == getRaiz()){
                            setRaiz(sucessor);
                        } else {
                            if(filhoEsquerda){
                                pai.setEsquerda(sucessor);
                            } else {
                                pai.setDireita(sucessor);   
                            }
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p){
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while(atual != null){
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if(sucessor != p.getDireita()){
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }
}
