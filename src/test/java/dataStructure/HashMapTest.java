package dataStructure;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import dataStructure.hash.HashMap;
import dataStructure.helpers.Student;

public class HashMapTest {
    HashMap<Student> mapa = new HashMap<>(53);

    @Test
    public void push() {
        Student student = new Student(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.push(12000, student);

        assertTrue(mapa.search(12000).equals(student));
    }

    @Test
    public void includeAll() {
        Student student = new Student(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.push(12000, student);

        Student student2 = new Student(14000, "Pedro", LocalDate.of(1999, 1, 20));
        mapa.push(14000, student2);

        Student student3 = new Student(12500, "Marta", LocalDate.of(2001, 2, 18));
        mapa.push(12500, student3);

        Student student4 = new Student(13000, "Lucas", LocalDate.of(1998, 11, 25));
        mapa.push(13000, student4);


        HashMap<Student> outroMapa = new HashMap<>(53);

        Student student5 = new Student(15000, "Tomas", LocalDate.of(2000, 1, 1));
        outroMapa.push(15000, student5);

        Student student6 = new Student(16000, "Roberta", LocalDate.of(1999, 1, 20));
        outroMapa.push(16000, student6);

        Student student7 = new Student(15500, "Toni", LocalDate.of(2001, 2, 18));
        outroMapa.push(15500, student7);

        Student student8 = new Student(17000, "Jack", LocalDate.of(1998, 11, 25));
        outroMapa.push(17000, student8);

        mapa.incluirTodos(outroMapa);

        assertTrue(mapa.search(12000).equals(student));
        assertTrue(mapa.search(14000).equals(student2));
        assertTrue(mapa.search(12500).equals(student3));
        assertTrue(mapa.search(13000).equals(student4));
        assertTrue(mapa.search(15000).equals(student5));
        assertTrue(mapa.search(16000).equals(student6));
        assertTrue(mapa.search(15500).equals(student7));
        assertTrue(mapa.search(17000).equals(student8));
    }

    @Test
    public void pushMany() {
        Student student = new Student(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.push(12000, student);

        Student student2 = new Student(14000, "Pedro", LocalDate.of(1999, 1, 20));
        mapa.push(14000, student2);

        Student student3 = new Student(12500, "Marta", LocalDate.of(2001, 2, 18));
        mapa.push(12500, student3);

        Student student4 = new Student(13000, "Lucas", LocalDate.of(1998, 11, 25));
        mapa.push(13000, student4);


        assertTrue(mapa.search(12000).equals(student));
        assertTrue(mapa.search(14000).equals(student2));
        assertTrue(mapa.search(12500).equals(student3));
        assertTrue(mapa.search(13000).equals(student4));
    }

    @Test
    public void pushWithSearchAndConflicts() {
        Student student = new Student(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.push(12000, student);

        Student student2 = new Student(14000, "Pedro", LocalDate.of(1999, 1, 20));
        mapa.push(14000, student2);

        Student student3 = new Student(14226, "Marta", LocalDate.of(2001, 2, 18));
        mapa.push(12500, student3);

        Student student4 = new Student(17180, "Lucas", LocalDate.of(1998, 11, 25));
        mapa.push(13000, student4);

        assertTrue(mapa.search(12000).equals(student));
        assertTrue(mapa.search(14000).equals(student2));
        assertTrue(mapa.search(12500).equals(student3));
        assertTrue(mapa.search(13000).equals(student4));
    }
}
