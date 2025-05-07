package dataStructure.list.linkedList;

public class ListNode<T> {

    private T info;
    private ListNode<T> next;

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public ListNode<T>  getNext() {
        return this.next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
