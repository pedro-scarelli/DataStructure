package dataStructure.hash;

public class MapNode <T> {
    
    private int key;
    private T info;

    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        MapNode<T> other = (MapNode) object;
        if (key != other.key)
            return false;

        return true;
    }
}
