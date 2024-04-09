package ed.Pilhas;

import ed.ListaEncadeada.*;

public class PilhaLista<T> implements Pilha<T>{

    private ListaEncadeada <T> lista = new ListaEncadeada<>();

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if(lista.estaVazia()){
            throw new PilhaVaziaException();
        }

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar(){
        lista = new ListaEncadeada<>();

        /*  OU 
        try{
            while(true){
                pop();
            }
        } catch (PilhaCheiaException e){

        // }*/
    }
    
    @Override
    public String toString(){
        String stringContent = "";
        NoLista <T> noToString = lista.getPrimeiro();
        while(noToString != null){
            if (noToString != lista.getPrimeiro()) {
                stringContent += ",";
            }
            stringContent += noToString.getInfo();
            noToString = noToString.getProximo();
        }
        return stringContent;
    }
}
