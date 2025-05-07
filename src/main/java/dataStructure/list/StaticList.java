package dataStructure.list;

public class StaticList {
 
    private int[] info;
    private int size;

    public StaticList() {
        info = new int[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int[] getInfo() {
        return info;
    }
    
    public void setInfo(int[]info) {
        this.info = info;
    }

    private void resize() {
        int [] newInfo = new int[getSize() + 10]; 

        for (int i = 0; i < info.length; i++) {
            newInfo[i] = getInfo()[i];
        } 
        setInfo(newInfo);
    }

    public void push(int value) {
        if (getSize() == getInfo().length) {
            resize();  
        }
        getInfo()[getSize()] = value;
        size++;
    }

    public void print() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(getInfo()[i] + "\n");
        }
    }

    public int search(int value) {
        for (int i = 0; i < getSize(); i++) {
            if (getInfo()[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void pop(int value) {
        int position = search(value);

        if (position > -1) {
            for (int i = position+1; i < getSize(); i++) {
                getInfo()[i-1] = getInfo()[i];
            }
            size--;        
        }
    }

    public void free() {
        setInfo(new int[10]);
        size = 0;
    }

    public int getElement(int position) {
        if (position > getSize() || getInfo()[position] == 0) {
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
