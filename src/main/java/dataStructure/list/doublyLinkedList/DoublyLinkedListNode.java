package dataStructure.list.doublyLinkedList;

public class DoublyLinkedListNode<T> {

    private T info;
    private DoublyLinkedListNode<T> next;
    private DoublyLinkedListNode<T> previous;

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public DoublyLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }
}
