package dataStructure.stack;

import dataStructure.stack.exceptions.EmptyStackException;
import dataStructure.stack.exceptions.FullStackException;

public class ArrayStack<T> implements Stack<T>{

    private Object info[];
    private int limit;
    private int size;

    public ArrayStack(int limit) {
        info = (T[])new Object[limit];
        this.limit = limit;
        this.size = 0;
    }

    @Override
    public void push(T value) {
        if (size == limit) {
            throw new FullStackException();
        } else {
            info[size] = value;
            size++;
        }
    }

    @Override
    public T pop() {
        T value = peek();
        info[size-1] = null;
        size--;

        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } 
        return (T)info[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void free() {
        try{
            while (true) {
                pop();
            }
        }  catch (EmptyStackException e) { }
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = size-1; i >= 0; i--) {
            result += info[i];
            if (i > 0) {
                result += ",";
            }
        }

        return result;
    } 
    
    public void concatenate(ArrayStack<T> stackToConcatenate) {
        if (size + stackToConcatenate.size > limit) {
            throw new RuntimeException("Não há espaços para empilhar todos os dados");
        }

        for (int i = 0; i < stackToConcatenate.size; i++) {
            push((T) stackToConcatenate.info[i]);
        }
    }

    public void setLimit(int limit) {
        this.limit = limit;
        info = (T[])new Object[limit];
    }
}
