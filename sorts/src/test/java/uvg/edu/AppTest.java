package uvg.edu;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import uvg.edu.Controller.IComparator;
import uvg.edu.SortingAlgorithms;

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private final IComparator<Integer> comparator = Integer::compare;

    private Integer[] unsortedArray = {5, 2, 9, 1, 5, 6};
    private Integer[] sortedArray = {1, 2, 5, 5, 6, 9};

    @Test
    void testInsertionSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.insertionSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void testMergeSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.mergeSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void testQuickSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.quickSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void testShellSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.shellSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void testRadixSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.radixSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void testBucketSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.bucketSort(array);
        assertArrayEquals(sortedArray, array);
    }
}
