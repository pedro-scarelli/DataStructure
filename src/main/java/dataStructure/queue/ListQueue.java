package dataStructure.queue;

import dataStructure.list.linkedList.LinkedList;
import dataStructure.list.linkedList.ListNode;
import dataStructure.queue.exceptions.EmptyQueueException;

public class ListQueue<T> implements Queue<T> {

    private LinkedList<T> lista = new LinkedList<>();

    @Override
    public void push(T info) {
        lista.pushAtEnd(info);
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.pop(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (lista.isEmpty()) {
            throw new EmptyQueueException();
        }

        return lista.getFirst().getInfo();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public void free() {
        try{
            while(true) {
                pop();
            }
        } catch (EmptyQueueException e) { }
    }
    
    @Override
    public String toString() {
        String stringContent = "";
        ListNode<T> node = lista.getFirst();
        while(node != null) {
            if (node != lista.getFirst()) {
                stringContent += ",";
            }
            stringContent += node.getInfo();
            node = node.getNext();
        }

        return stringContent;
    }
}
