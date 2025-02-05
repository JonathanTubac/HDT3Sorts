package uvg.edu;

/**
 * Hello world!
 *
 */



import uvg.edu.SortingAlgorithms;
import uvg.edu.Controller.IntegerComparator;

import java.util.Arrays;


public class App 
{
    public static void main( String[] args )
    {

        Integer[] array = {5, 2, 9, 1, 5, 6};
        IntegerComparator comparator = new IntegerComparator();

        System.out.println("Array original: " + Arrays.toString(array));


        Integer[] insertionArray = array.clone();
        SortingAlgorithms.insertionSort(insertionArray, comparator);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArray));


        Integer[] mergeArray = array.clone();
        SortingAlgorithms.mergeSort(mergeArray, comparator);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArray));


        Integer[] quickArray = array.clone();
        SortingAlgorithms.quickSort(quickArray, comparator);
        System.out.println("Quick Sort: " + Arrays.toString(quickArray));

        Integer[] shellArray = array.clone();
        SortingAlgorithms.shellSort(shellArray, comparator);
        System.out.println("Shell Sort: " + Arrays.toString(shellArray));
    }
}

