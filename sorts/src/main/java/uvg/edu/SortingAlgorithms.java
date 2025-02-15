package uvg.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uvg.edu.Controller.IComparator;

/**
 * Class containing various sorting algorithms.
 * 
 * Integrantes:
 * - Carlos López
 * - Jonathan Tubac
 */
public class SortingAlgorithms {

    /**
     * Sorts an array using the Insertion Sort algorithm.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to be sorted
     * @param comparator the comparator to determine the order of elements
     */
    public static <T> void insertionSort(T[] array, IComparator<T> comparator) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && comparator.Compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Sorts an array using the Merge Sort algorithm.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to be sorted
     * @param comparator the comparator to determine the order of elements
     */
    public static <T> void mergeSort(T[] array, IComparator<T> comparator) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        T[] left = java.util.Arrays.copyOfRange(array, 0, mid);
        T[] right = java.util.Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(array, left, right, comparator);
    }

    /**
     * Merges two subarrays into a single sorted array.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to store the merged result
     * @param left      the left subarray
     * @param right     the right subarray
     * @param comparator the comparator to determine the order of elements
     */
    private static <T> void merge(T[] array, T[] left, T[] right, IComparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.Compare(left[i], right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    /**
     * Sorts an array using the Quick Sort algorithm.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to be sorted
     * @param comparator the comparator to determine the order of elements
     */
    public static <T> void quickSort(T[] array, IComparator<T> comparator) {
        quickSortHelper(array, 0, array.length - 1, comparator);
    }

    /**
     * Helper method for Quick Sort.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to be sorted
     * @param low       the starting index of the subarray
     * @param high      the ending index of the subarray
     * @param comparator the comparator to determine the order of elements
     */
    private static <T> void quickSortHelper(T[] array, int low, int high, IComparator<T> comparator) {
        if (low < high) {
            int pi = partition(array, low, high, comparator);
            quickSortHelper(array, low, pi - 1, comparator);
            quickSortHelper(array, pi + 1, high, comparator);
        }
    }

    /**
     * Partitions the array for Quick Sort.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to be partitioned
     * @param low       the starting index of the subarray
     * @param high      the ending index of the subarray
     * @param comparator the comparator to determine the order of elements
     * @return the partition index
     */
    private static <T> int partition(T[] array, int low, int high, IComparator<T> comparator) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.Compare(array[j], pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * Sorts an array using the Shell Sort algorithm.
     * 
     * @param <T>       the type of elements in the array
     * @param array     the array to be sorted
     * @param comparator the comparator to determine the order of elements
     */
    public static <T> void shellSort(T[] array, IComparator<T> comparator) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && comparator.Compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    /**
     * Sorts an array using the Radix Sort algorithm.
     * 
     * @param array the array to be sorted
     */
    public static void radixSort(Integer[] array) {
        if (array.length == 0) return;

        int max = Arrays.stream(array).max(Integer::compare).get();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    /**
     * Helper method for Radix Sort to sort by a specific digit.
     * 
     * @param array the array to be sorted
     * @param exp   the exponent (10^k) representing the digit place
     */
    private static void countingSortByDigit(Integer[] array, int exp) {
        int n = array.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    /**
     * Sorts an array using the Bucket Sort algorithm.
     * 
     * @param array the array to be sorted
     */
    public static void bucketSort(Integer[] array) {
        if (array.length == 0) return;

        int max = Arrays.stream(array).max(Integer::compare).get();
        int min = Arrays.stream(array).min(Integer::compare).get();

        int numBuckets = 10;
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : array) {
            int bucketIndex = (int) ((num - min) * (numBuckets - 1) / (max - min));
            buckets.get(bucketIndex).add(num);
        }

        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }

    /**
     * Sorts a list using the Insertion Sort algorithm.
     * 
     * @param list the list to be sorted
     */
    private static void insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
