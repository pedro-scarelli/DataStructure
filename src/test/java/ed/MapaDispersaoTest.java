package ed;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ed.hash.Aluno;
import ed.hash.MapaDispersao;

public class MapaDispersaoTest {
    MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

    @Test
    public void inserir(){
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(12000, obj1);

        assertTrue(mapa.buscar(12000).equals(obj1));
    }

    @Test
    public void incluirTodos(){
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(12000, obj1);

        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        mapa.inserir(14000, obj2);

        Aluno obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        mapa.inserir(12500, obj3);

        Aluno obj4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));
        mapa.inserir(13000, obj4);


        MapaDispersao<Aluno> outroMapa = new MapaDispersao<>(53);

        Aluno obj5 = new Aluno(15000, "Tomas", LocalDate.of(2000, 1, 1));
        outroMapa.inserir(15000, obj5);

        Aluno obj6 = new Aluno(16000, "Roberta", LocalDate.of(1999, 1, 20));
        outroMapa.inserir(16000, obj6);

        Aluno obj7 = new Aluno(15500, "Toni", LocalDate.of(2001, 2, 18));
        outroMapa.inserir(15500, obj7);

        Aluno obj8 = new Aluno(17000, "Jack", LocalDate.of(1998, 11, 25));
        outroMapa.inserir(17000, obj8);

        mapa.incluirTodos(outroMapa);
        assertTrue(mapa.buscar(12000).equals(obj1));
        assertTrue(mapa.buscar(14000).equals(obj2));
        assertTrue(mapa.buscar(12500).equals(obj3));
        assertTrue(mapa.buscar(13000).equals(obj4));
        assertTrue(mapa.buscar(15000).equals(obj5));
        assertTrue(mapa.buscar(16000).equals(obj6));
        assertTrue(mapa.buscar(15500).equals(obj7));
        assertTrue(mapa.buscar(17000).equals(obj8));
    }

    @Test
    public void inserirVarios(){
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(12000, obj1);

        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        mapa.inserir(14000, obj2);

        Aluno obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        mapa.inserir(12500, obj3);

        Aluno obj4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));
        mapa.inserir(13000, obj4);


        assertTrue(mapa.buscar(12000).equals(obj1));
        assertTrue(mapa.buscar(14000).equals(obj2));
        assertTrue(mapa.buscar(12500).equals(obj3));
        assertTrue(mapa.buscar(13000).equals(obj4));
    }

    @Test
    public void insercaoEBuscaComColisao(){
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(12000, obj1);

        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        mapa.inserir(14000, obj2);

        Aluno obj3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        mapa.inserir(12500, obj3);

        Aluno obj4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));
        mapa.inserir(13000, obj4);


        assertTrue(mapa.buscar(12000).equals(obj1));
        assertTrue(mapa.buscar(14000).equals(obj2));
        assertTrue(mapa.buscar(12500).equals(obj3));
        assertTrue(mapa.buscar(13000).equals(obj4));
    }
}
