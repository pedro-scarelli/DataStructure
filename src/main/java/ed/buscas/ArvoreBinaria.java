package ed.buscas;

import ed.arvores.NoArvoreBinaria;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {
    
    @Override
    public void setRaiz(NoArvoreBinaria<T> raiz){super.setRaiz(raiz);}

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }
    
    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info){
        if(no == null){
            return null;
        } else {
            if(no.getInfo().equals(info)){
                return no;
            } else {
                NoArvoreBinaria<T> noLocalizado;

                noLocalizado = buscar(no.getEsquerda(), info);
                if(noLocalizado == null){
                    noLocalizado = buscar(no.getDireita(), info);
                }

                return noLocalizado;
            }            
        }
    }
}


/*
if(no == null)
            return false;
        else
            return (no.getInfo().equals(info)||
            pertence(no.getEsquerda(), info) ||
            pertence(no.getDireita(), info)); 
            */