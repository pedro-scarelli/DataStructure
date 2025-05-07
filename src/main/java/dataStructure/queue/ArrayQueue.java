package dataStructure.queue;

import dataStructure.queue.exceptions.EmptyQueueException;
import dataStructure.queue.exceptions.FullQueueException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] info;
    public int limit;
    public int size;
    public int start;

    public ArrayQueue(int limit) {
        info = (T[])new Object[limit];
        this.limit = limit;
        size = 0;
        start = 0;
    }

    @Override
    public void push(T valor) {
        if (size == limit) {
            throw new FullQueueException();
        }

        info[(start + size) % limit] = valor;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return info[start];
    }

    @Override
    public T pop() {
        T valor = peek();
        info[start] = null;

        start = (start +1) % limit;
        size--;

        return valor;
    }

    @Override
    public void free() {
        try{
            while(true) {
                pop();
            }
        } catch(EmptyQueueException e) { }
    }

    public void shrink() {
        T[] novoInfo = (T[])new Object[size];

        for (int whiteSpaces = 0; whiteSpaces < size; whiteSpaces++) {
            novoInfo[whiteSpaces] = info[start];
            start = (start + 1) % limit;
        }

        start = 0;
        limit = size;
        info = novoInfo;
    }

    public int getLimit() {
        return limit;
    }
    
    @Override
    public String toString() {
        String result = "";

        int index = start;
        for (int i = 0; i < size; i++) {
            result += info[index];
            if (i != size - 1) {
                result += ","; 
            }
            index = (index + 1) % limit;
        }

        return result;
    } 

    public ArrayQueue<T> createConcatenatedQueue(ArrayQueue<T> queueToBeConcatenated) {
        ArrayQueue<T> concatenadQueue = new ArrayQueue<>(limit + queueToBeConcatenated.getLimit());


        int index = this.start;
        for (int i = 0; i < this.size; i++) {
            concatenadQueue.push(info[index]);
            index = (index + 1) % concatenadQueue.limit;
        }

        index = queueToBeConcatenated.start;
        for (int i = 0; i < queueToBeConcatenated.size; i++) {
            concatenadQueue.push(queueToBeConcatenated.info[index]);
            index = (start + 1) % concatenadQueue.limit;
        }
        System.out.println(concatenadQueue.size);

        return concatenadQueue;
    }
}
