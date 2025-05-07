package dataStructure.sort;

public class MergeSort<T extends Comparable<T>> extends SortAbstract<T> {
    
    @Override
    public void sort() {
        mergeSort(0, getInfo().length - 1);
    }

    private void mergeSort(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(start, middle);
            mergeSort(middle+1, end);
            merge(start, end, middle);
        }
    }

    @SuppressWarnings("unchecked")
    public void merge(int start, int end, int middle) {
        T[] info = getInfo();
        int leftSize = middle - start + 1;
        T[] left = (T[]) new Comparable[leftSize];
        for (int i = 0; i <= leftSize -1; i++) {
            left[i] = info[start+i];
        }

        int rightSize = end - middle;
        T[] right = (T[]) new Comparable[rightSize];
        for (int i = 0; i <= rightSize -1; i++) {
            right[i] = info[middle+1+i];
        }

        int leftLength = 0;
        int rightLength = 0;

        int i;
        for (i = start; i <= end; i++) {
            if (leftLength < leftSize && rightLength < rightSize) {
                if (left[leftLength].compareTo(right[rightLength]) < 0) {
                    info[i] = left[leftLength];
                    leftLength++;
                } else {
                    info[i] = right[rightLength];
                    rightLength++;
                }
            } else
                break;
        }

        while(leftLength < leftSize) {
            info[i] = left[leftLength];
            leftLength++;
            i++;
        }

        while(rightLength < rightSize) {
            info[i] = right[rightLength];   
            rightLength++;
            i++;
        }
    }
}
