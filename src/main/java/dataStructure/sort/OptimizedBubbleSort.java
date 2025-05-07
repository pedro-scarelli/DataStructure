package dataStructure.sort;

public class OptimizedBubbleSort<T extends Comparable<T>> extends SortAbstract<T> {
    
    @Override
    public void sort() {
        T[] info = getInfo();
        for (int i = info.length -1; i > 1; i--) {
            boolean traded = false;
            for (int j = 0; j <= i-1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trade(j, j+1);
                    traded = true;
                }   
            }
            if (!traded) {
                break;
            }
        }
    }
}
