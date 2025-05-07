package dataStructure.list.linkedList;

public class LinkedList<T> {
    private ListNode<T> first;
    private ListNode<T> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public ListNode<T> getFirst() {
        return this.first;
    }

    public void pushAtEnd(T info) {
        ListNode<T> newNode = new ListNode<T>();    
        newNode.setInfo(info);
        if (first == null) {
            first = newNode; 
        } else {
            last.setNext(newNode);   
        }

        last = newNode;
    }

    public void push(T info) {
        ListNode<T> newNode = new ListNode<T>();    
        newNode.setInfo(info);

        if (first == null) {
            first = newNode;
            last = newNode;
            return;
        }

        newNode.setNext(first);
        first = newNode;
    }

    public void popAllValues(T valor) {
        while (first != null && first.getInfo().equals(valor)) {
            first = first.getNext();
        }
        
        ListNode<T> actual = first;
        while (actual != null && actual.getNext() != null) {
            if (actual.getNext().getInfo().equals(valor)) {
                actual.setNext(actual.getNext().getNext());
            } else {
                actual = actual.getNext();
            }
        }
    }
    
    public boolean isEmpty() {
        return first == null;
    }

    public ListNode<T> search(T info) {
        ListNode<T> p = first;
        while(p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getNext();
        } 

        return null;
    }

    public void pop(T info) {
        ListNode<T> previous = null;
        ListNode<T> u = last;
        
        while(u != null && !u.getInfo().equals(info)) {
            previous = u;
            u = u.getNext();
        } 

        if (u != null) {
            if (u == first) {
                first = first.getNext();
            } else if (u == last) {
                previous.setNext(null);
                last = previous;
            } else {
                previous.setNext(u.getNext());
            }
        }
    }   

    public void pop() {
        first = first.getNext();
    }     
    
    public int getSize() {
        int nodeCount = 0;
        ListNode <T> current = first;

        while(current != null) {
            nodeCount++;
            current = current.getNext();
        }

        return nodeCount;
    }

    public ListNode<T> getNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        ListNode<T> searchedNode = getFirst();
        while(searchedNode != null && index > 0) {
            index--;
            searchedNode = searchedNode.getNext();
        }

        if (searchedNode == null) {
            throw new IndexOutOfBoundsException();
        }

        return searchedNode;        
    }

    @Override
    public String toString() {
        String stringContent = "";
        ListNode<T> noToString = first;
        while(noToString != null) {
            if (noToString != first) {
                stringContent += ",";
            }
            stringContent += noToString.getInfo();
            noToString = noToString.getNext();
        }

        return stringContent;
    }

    public void setFirst(ListNode<T> first) {
        this.first = first;
    }

    public ListNode<T> getLast() {
        return last;
    }
}