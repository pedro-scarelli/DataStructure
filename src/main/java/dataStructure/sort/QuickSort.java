package dataStructure.sort;

public class QuickSort<T extends Comparable<T>> extends SortAbstract<T> {
    
    @Override
    public void sort() {
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int pivotIndex = partitionate(start, end);
            quickSort(start, pivotIndex - 1);
            quickSort(pivotIndex + 1, end);
        }
    }

    private int partitionate(int start, int end) {
        int a = start;
        int b = end + 1;
        T pivo = getInfo()[start];

        while(true) {
            do { a++; } while (a <= end && getInfo()[a].compareTo(pivo) == -1);

            do { b--; } while (b >= start && getInfo()[b].compareTo(pivo) > 0);
  
            if (a >= b) {
                break;
            }
            trade(a, b);
        }
        trade(b, start);

        return b;
    }
}
