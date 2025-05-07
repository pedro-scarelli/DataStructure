package dataStructure.stack;

import dataStructure.list.linkedList.*;
import dataStructure.stack.exceptions.EmptyStackException;

public class ListStack<T> implements Stack<T>{

    private LinkedList <T> list = new LinkedList<>();

    @Override
    public void push(T info) {
        list.push(info);
    }

    @Override
    public T pop() {
        T valor = peek();
        list.pop(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }

        return list.getFirst().getInfo();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void free() {
        try{
            while(true) {
                pop();
            }
        } catch (EmptyStackException e) { }
    }
    
    @Override
    public String toString() {
        String stringContent = "";
        ListNode <T> noToString = list.getFirst();

        while(noToString != null) {
            if (noToString != list.getFirst()) {
                stringContent += ",";
            }
            stringContent += noToString.getInfo();
            noToString = noToString.getNext();
        }

        return stringContent;
    }
}
