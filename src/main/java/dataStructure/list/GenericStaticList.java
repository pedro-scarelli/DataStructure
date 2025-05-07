package dataStructure.list;

public class GenericStaticList <T>{
 
    private Object[] info;
    private int size;

    public GenericStaticList() {
        info = new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Object[] getInfo() {
        return info;
    }
    
    public void setInfo(Object[]info) {
        this.info = info;
    }

    private void resize() {
        Object [] newInfo = new Object[getSize() + 10]; 

        for (int position = 0; position < info.length; position++) {
            newInfo[position] = getInfo()[position];
        } 
        setInfo(newInfo);
    }

    public void push(T value) {
        if (getSize() == getInfo().length) {
            resize();  
        }
        getInfo()[getSize()] = value;
        size++;
    }

    public void print() {
        for (int position = 0; position < getSize(); position++) {
            System.out.println(getInfo()[position] + "\n");
        }
    }

    public int search(T value) {
        for (int position = 0; position < getSize(); position++) {
            if (getInfo()[position] == value) {
                return position;
            }
        }

        return - 1;
    }

    public void pop(T value) {
        int position = search(value);

        if (position > -1) {
            for (int next = position+1; next < getSize(); next++) {
                getInfo()[next-1] = getInfo()[next];
            }
            size--; 
            getInfo()[size] = null;    
        }
    }

    public void popElements(int start, int end) {
        if (end > getSize()-1) {
            end = getSize()-1;
        }

        for (int position = end; position >= start; position--) {
            for (int next = position+1; next < getSize(); next++) {
                getInfo()[next-1] = getInfo()[next];
            }
            size--;
            getInfo()[size] = null;
        }
    }

    public void popElements2(int start, int end) {
        if (start < 0 || start >= size || end < 0 || end >= size || start > end) {
            throw new IllegalArgumentException("Invalid start or end indexes.");
        }
    
        int removedElements = end - start + 1;
        int newSize = size - removedElements;
    
        for (int i = end + 1; i < size; i++) {
            info[i - removedElements] = info[i];
        }
    
        for (int i = newSize; i < size; i++) {
            info[i] = null;
        }
    
        size = newSize;
    }

    public void free() {
        setInfo(new Object[10]);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public T getElement(int position) {
        if (position > getSize() || getInfo()[position] == null) {
            throw new IndexOutOfBoundsException();
        }

        return (T) getInfo()[position]; 
    }

    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }

        return false;
    }

    public void invert() {
        int tradeCount = getSize() / 2;
        int left = 0;
        int right = getSize() - 1;

        while(tradeCount > 0) {
            Object backup = getInfo()[left];
            getInfo()[left] = getInfo()[right];
            getInfo()[right] = backup;

            left++;
            right--;

            tradeCount--;
        }
    }

    @Override
    public String toString() {
        String stringContent = "";
        for (int position = 0; position < getSize(); position++) {
            if (position > 0) {
                stringContent += ",";
            }
            stringContent += getInfo()[position];
        }

        return stringContent;
    }
}


