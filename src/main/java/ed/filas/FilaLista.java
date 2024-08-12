package ed.filas;

import ed.ListaEncadeada.ListaEncadeada;
import ed.ListaEncadeada.NoLista;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override
    public void inserir(T info) {
        lista.inserirNoFinal(info);
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if(lista.estaVazia()){
            throw new FilaVaziaException();
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
        NoLista<T> noToString = lista.getPrimeiro();
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
