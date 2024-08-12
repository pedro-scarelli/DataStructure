package ed.hash;

import java.awt.event.ItemEvent;

import ed.ListaEncadeada.ListaEncadeada;
import ed.ListaEncadeada.NoLista;

public class MapaDispersao<T> {
    
    private ListaEncadeada<NoMapa<T>> info [];

    public MapaDispersao(int tamanho){
        info = (ListaEncadeada<NoMapa<T>>[]) new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave){
        return chave % info.length;
    }

    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);
        
        if(info[indice] == null)
            info[indice] = new ListaEncadeada<>();
        NoMapa<T> noMapa = new NoMapa<>();

        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
    }
    
    public void incluirTodos(MapaDispersao<T> outroMapa){
        for (ListaEncadeada<NoMapa<T>> posicao : outroMapa.info) {
            if(posicao != null){
                NoLista<NoMapa<T>> item = posicao.getPrimeiro();
                while(item != null){
                    inserir(item.getInfo().getChave(), item.getInfo().getInfo());
                    item = item.getProximo();
                }
            }
        }
    }

    public void remover(int chave){
        int indice = calcularHash(chave);

        if(info[indice] != null){
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);
        
            if (info[indice].buscar(noMapa) != null){
                info[indice].retirar(noMapa);
            }
        }
    }
    
    public T buscar(int chave){
        int indice = calcularHash(chave);

        if(info[indice] != null){
            NoMapa<T> noMapa = new NoMapa<T>();
            noMapa.setChave(chave);
            
            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if(no != null){
                return no.getInfo().getInfo();
            }
        }
        return null;
    }
}
