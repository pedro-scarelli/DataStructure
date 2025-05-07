package dataStructure.sort;

public class BubbleSort<T extends Comparable<T>> extends SortAbstract<T> {
    
    @Override
    public void sort() {
        for (int i = getInfo().length -1; i > 1; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    trade(j, j+1);
                }   
            }
        }
    }

    public void sortDescending() {
        boolean traded = false;
        for (int i = getInfo().length -1; i > 1; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) < 0) {
                    trade(j, j+1);
                    traded = true;
                }
                if (traded) {
                    i++;
                    traded = false;

                    break;
                }
            }
        }
    }
}
