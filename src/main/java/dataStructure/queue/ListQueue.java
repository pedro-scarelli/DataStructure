package dataStructure.queue;

import dataStructure.list.linkedList.LinkedList;
import dataStructure.list.linkedList.ListNode;
import dataStructure.queue.exceptions.EmptyQueueException;

public class ListQueue<T> implements Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void push(T info) {
        list.pushAtEnd(info);
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
            throw new EmptyQueueException();
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
        } catch (EmptyQueueException e) { }
    }
    
    @Override
    public String toString() {
        String stringContent = "";
        ListNode<T> node = list.getFirst();
        while(node != null) {
            if (node != list.getFirst()) {
                stringContent += ",";
            }
            stringContent += node.getInfo();
            node = node.getNext();
        }

        return stringContent;
    }
}
