package dataStructure.list.doublyLinkedList;

public class DoublyLinkedList<T> {

    private DoublyLinkedListNode<T> first;

    public DoublyLinkedList() {
        this.first = null;
    }

    public DoublyLinkedListNode<T> getFirst() {
        return this.first;
    }

    public void push(T info) {
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
        newNode.setInfo(info);
        newNode.setNext(first);
        newNode.setPrevious(null);

        if (first != null) {
            first.setPrevious(newNode);
        }
        first = newNode;        
    }

    public DoublyLinkedListNode<T> search(T info) {
        DoublyLinkedListNode<T> pivot = first;

        while(pivot != null) {
            if (pivot.getInfo().equals(info)) {
                return pivot;
            }
            pivot = pivot.getNext();
        }

        return null;
    }

    public void pop(T info) {
        DoublyLinkedListNode<T> nodeToRemove = search(info);
        if (nodeToRemove != null) {
            if (nodeToRemove == first) {
                this.first = first.getNext();
            } else {
                nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
            }
            if (nodeToRemove.getNext() != null) {
                nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
            }
        }
    }  
    
    public void printInReverseOrder() {
        DoublyLinkedListNode<T> actual = getLast();
              
        while(actual != null) {
            System.out.println(actual.getInfo());
            actual = actual.getPrevious();
        } 
    }

    public DoublyLinkedListNode<T> getLast() {
        DoublyLinkedListNode<T> ultimo = first;
        DoublyLinkedListNode<T> actual = first;

        while (actual != null) {
            ultimo = actual;
            actual = actual.getNext();
        } 
        return ultimo;
    }

    public void free() {
        DoublyLinkedListNode<T> node = this.first;
        while (node != null) {
            node.setPrevious(null);
            DoublyLinkedListNode<T> backup = node.getNext();
            node.setNext(null);
            node = backup;
        }
        first = null;
    }

    @Override
    public String toString() {
        String stringContent = "";
        DoublyLinkedListNode<T> stringNode = first;
        while(stringNode != null) {
            if (stringNode != first) {
                stringContent += ",";
            }
            stringContent += stringNode.getInfo();
            stringNode = stringNode.getNext();
        }

        return stringContent;
    }
}
