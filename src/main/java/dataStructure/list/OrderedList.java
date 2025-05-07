package dataStructure.list;

public class OrderedList<T extends Comparable<T>> extends ListAbstract<T> {
    
    @Override
    public void push(T value) {
        Object[] info = getInfo();
        int n = getSize();
        if (n == info.length) {
            resize();  
            info = getInfo();
        }
        if (n == 0) {
            info[0] = value;
            setSize(1);
        } else {
            int start = 0;
            int end = n-1;   
            int middle = 0;
            while(start <= end) {
                middle = (start + end) / 2;
                if (value.compareTo((T) info[middle]) < 0) {
                    end = middle-1;
                } else {
                    if (value.compareTo((T) info[middle]) > 0) {
                        start = middle + 1;
                    } 
                } 
            }
            for (int i = n; i > middle; i--) {
                info[i] = info[i-1];
            }
            if (value.compareTo((T) info[middle]) > 0) {
                info[middle+1] = value;
            } else {
                info[middle] = value;
            }
            setSize(n+1);
        }
    }

    @Override
    public int search(T value) {
        Object[] info = getInfo();
        int n = getSize();
        int start = 0;
        int end = n-1;   

        while(start <= end) {
            int middle = (start + end) / 2;
            if (value.compareTo((T) info[middle]) < 0) {
                end = middle-1;
            } else {
                if (value.compareTo((T) info[middle]) > 0) {
                    start = middle + 1;
                } else {
                    return middle;
                }
            } 
        }
        return -1;
    }
}
