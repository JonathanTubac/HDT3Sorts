package uvg.edu;

import uvg.edu.Controller.IComparator;

public class SortingAlgorithms {
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

    public static <T> void mergeSort(T[] array, IComparator<T> comparator) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        T[] left = java.util.Arrays.copyOfRange(array, 0, mid);
        T[] right = java.util.Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(array, left, right, comparator);
    }

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

    public static <T> void quickSort(T[] array, IComparator<T> comparator) {
        quickSortHelper(array, 0, array.length - 1, comparator);
    }

    private static <T> void quickSortHelper(T[] array, int low, int high, IComparator<T> comparator) {
        if (low < high) {
            int pi = partition(array, low, high, comparator);
            quickSortHelper(array, low, pi - 1, comparator);
            quickSortHelper(array, pi + 1, high, comparator);
        }
    }

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

}
