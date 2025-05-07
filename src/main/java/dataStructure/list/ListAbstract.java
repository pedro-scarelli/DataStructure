package dataStructure.list;

public abstract class ListAbstract<T>{
 
    private T[] info;
    private int size;

    @SuppressWarnings("unchecked")
    public ListAbstract() {
        info = (T[]) new Object[10];
        size = 0;
    }

    public abstract void push(T value);

    public abstract int search(T value);

    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    protected T[] getInfo() {
        return info;
    }
    
    public void setInfo(T[]info) {
        this.info = info;
    }

    @SuppressWarnings("unchecked")
    protected void resize() {
        T[] newInfo = (T[]) new Object[getSize() + 10]; 

        for (int i = 0; i < info.length; i++) {
            newInfo[i] = getInfo()[i];
        } 
        setInfo(newInfo);
    }

    public void print() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(getInfo()[i] + "\n");
        }
    }

    public void pop(T value) {
        int position = search(value);

        if (position > -1) {
            for (int i = position+1; i < getSize(); i++) {
                getInfo()[i-1] = getInfo()[i];
            }
            size--;        
        }
    }

    @SuppressWarnings("unchecked")
    public void free() {
        setInfo((T[]) new Object[10]);
        size = 0;
    }

    public T getElement(int position) {
        if (position > getSize() || getInfo()[position].equals(0)) {
            throw new IndexOutOfBoundsException();
        }

        return getInfo()[position]; 
    }

    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String stringContent = "";

        for (int i = 0; i < getSize(); i++) {
            if (i > 0) {
                stringContent += ",";
            }
            stringContent += getInfo()[i];
        }

        return stringContent;
    }
}
