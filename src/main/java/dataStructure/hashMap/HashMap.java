package dataStructure.hashMap;

import dataStructure.list.linkedList.LinkedList;
import dataStructure.list.linkedList.ListNode;

public class HashMap<T> {
    
    private LinkedList<MapNode<T>> info [];

    public HashMap(int size) {
        info = (LinkedList<MapNode<T>>[]) new LinkedList[size];
    }

    private int calculateHash(int key) {
        return key % info.length;
    }

    public void push(int key, T dado) {
        int index = calculateHash(key);
        
        if (info[index] == null)
            info[index] = new LinkedList<>();
        MapNode<T> mapNode = new MapNode<>();

        mapNode.setKey(key);
        mapNode.setInfo(dado);

        info[index].push(mapNode);
    }
    
    public void incluirTodos(HashMap<T> mapToInclude) {
        for (LinkedList<MapNode<T>> position : mapToInclude.info) {
            if (position != null) {
                ListNode<MapNode<T>> item = position.getFirst();
                while(item != null) {
                    push(item.getInfo().getKey(), item.getInfo().getInfo());
                    item = item.getNext();
                }
            }
        }
    }

    public void pop(int key) {
        int index = calculateHash(key);

        if (info[index] != null) {
            MapNode<T> mapNode = new MapNode<>();
            mapNode.setKey(key);
        
            if (info[index].search(mapNode) != null) {
                info[index].pop(mapNode);
            }
        }
    }
    
    public T search(int key) {
        int index = calculateHash(key);

        if (info[index] != null) {
            MapNode<T> mapNode = new MapNode<T>();
            mapNode.setKey(key);
            
            ListNode<MapNode<T>> node = info[index].search(mapNode);
            if (node != null) {
                return node.getInfo().getInfo();
            }
        }
    
        return null;
    }
}
