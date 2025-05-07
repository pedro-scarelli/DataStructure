package dataStructure.queue;

public interface Queue<T> {

    public void push(T valor);

    public boolean isEmpty();

    public T peek();

    public T pop();
    
    public void free();

}
