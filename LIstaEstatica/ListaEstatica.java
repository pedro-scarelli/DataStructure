package com.estrutura;

public class ListaEstatica {
 
    private int[] info;
    private int tamanho;

    public ListaEstatica(){
        info = new int[10];
        tamanho = 0;
    }

    public int getTamanho(){
        return tamanho;
    }

    public int[] getInfo() {
        return info;
    }
    
    public void setInfo(int[]info){
        this.info = info;
    }
    private void redimensionar(){
        int newTamanho = getTamanho() + 10;
        int [] newInfo = new int[newTamanho]; 

        for (int i = 0; i < info.length; i++) {
            newInfo[i] = getInfo()[i];
        } 
        setInfo(newInfo);
    }

    public void inserir(int value){
        
        if(getTamanho() <= getInfo().length){
            redimensionar();  
        }
        getInfo()[getTamanho()] = value;
        tamanho++;
    }

    public void exibir(){
        for (int i = 0; i < getTamanho(); i++) {
            System.out.println(getInfo()[i] + "\n");
        }
    }

    public int buscar(int value){
        for (int i = 0; i < getTamanho(); i++) {
            if(getInfo()[i] == value){
                return i;
            }
        }
        return -1;
    }
    public void retirar(int value){
        for (int i = 0; i < getTamanho(); i++) {
            if(getInfo()[i] == value){
                for (int j = i; j <= getTamanho(); j++) {
                    getInfo()[j] = getInfo()[j+1];
                }
                i = getTamanho();
                tamanho--;
            }
        }
    }
    public void liberar(){
        int [] newInfo = new int[10]; 
        setInfo(newInfo);
    }
    public int obterElemento(int position){
        if(position > getTamanho() || getInfo()[position] == 0){
            throw new IndexOutOfBoundsException();
        }
        return getInfo()[position];
    }

    public boolean estaVazia(){
        for (int i = 0; i < getTamanho(); i++) {
            if(getInfo()[i] != 0){
                return false;
            }
        }
        return true;
    }
    public String toString(){
        String stringContent = "";
        for (int i = 0; i < getTamanho(); i++) {
            if (i == getTamanho()-1) {
                stringContent += getInfo()[i];
            } else{
                stringContent += getInfo()[i] + ",";
            }
        }
        return stringContent;
    }
}
