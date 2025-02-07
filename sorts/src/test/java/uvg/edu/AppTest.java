package uvg.edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import uvg.edu.Controller.IComparator;
import uvg.edu.SortingAlgorithms;

/**
 * Clase de pruebas unitarias para los algoritmos de ordenamiento.
 * * Integrantes:
 *  * - Carlos López
 *  * - Jonathan Tubac
 */
public class AppTest {
    /**
     * Comparador para ordenar enteros.
     */
    private final IComparator<Integer> comparator = Integer::compare;

    /**
     * Arreglo desordenado utilizado en las pruebas.
     */
    private Integer[] unsortedArray = {5, 2, 9, 1, 5, 6};

    /**
     * Arreglo ordenado esperado después de aplicar los algoritmos de ordenamiento.
     */
    private Integer[] sortedArray = {1, 2, 5, 5, 6, 9};

    /**
     * Prueba para el algoritmo de ordenamiento por inserción.
     */
    @Test
    void testInsertionSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.insertionSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    /**
     * Prueba para el algoritmo de ordenamiento Merge Sort.
     */
    @Test
    void testMergeSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.mergeSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    /**
     * Prueba para el algoritmo de ordenamiento Quick Sort.
     */
    @Test
    void testQuickSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.quickSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    /**
     * Prueba para el algoritmo de ordenamiento Shell Sort.
     */
    @Test
    void testShellSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.shellSort(array, comparator);
        assertArrayEquals(sortedArray, array);
    }

    /**
     * Prueba para el algoritmo de ordenamiento Radix Sort.
     */
    @Test
    void testRadixSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.radixSort(array);
        assertArrayEquals(sortedArray, array);
    }

    /**
     * Prueba para el algoritmo de ordenamiento Bucket Sort.
     */
    @Test
    void testBucketSort() {
        Integer[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingAlgorithms.bucketSort(array);
        assertArrayEquals(sortedArray, array);
    }
}
