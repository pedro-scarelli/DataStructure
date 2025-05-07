package dataStructure.sort;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortTest {
    
    Integer[] info = {70,2,88,15,90,30};

    @Test
    public void bubble() {
        BubbleSort<Integer> bubble = new BubbleSort<>();
        bubble.setInfo(info);
        bubble.sort();
        Integer[] expected = {2,15,30,70,88,90};

        assertArrayEquals(expected, bubble.getInfo());
    }

    @Test
    public void bubbleDescending() {
        BubbleSort<Integer> bubble = new BubbleSort<>();
        bubble.setInfo(info);
        bubble.sortDescending();
        Integer[] expected = {90,88,70,30,15,2};

        assertArrayEquals(expected, bubble.getInfo());
    }

    @Test
    public void bubbleOptimized() {
        OptimizedBubbleSort<Integer> bubbleOptimized = new OptimizedBubbleSort<>();
        bubbleOptimized.setInfo(info);
        bubbleOptimized.sort();
        Integer[] expected = {2,15,30,70,88,90};

        assertArrayEquals(expected, bubbleOptimized.getInfo());
    }

    @Test
    public void quickSort() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.setInfo(info);
        quickSort.sort();
        Integer[] expected = {2,15,30,70,88,90};

        assertArrayEquals(expected, quickSort.getInfo());
    }

    @Test
    public void mergeSort() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.setInfo(info);
        mergeSort.sort();
        Integer[] expected = {2,15,30,70,88,90};

        assertArrayEquals(expected, mergeSort.getInfo());
    }
}
