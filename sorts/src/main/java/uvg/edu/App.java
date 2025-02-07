package uvg.edu;

import uvg.edu.SortingAlgorithms;
import uvg.edu.Controller.IntegerComparator;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Main application class to demonstrate sorting algorithms.
 * 
 * Integrantes:
 * - Carlos López
 * - Jonathan Tubac
 */
public class App {
    public static void main(String[] args) {
        // Generate 3000 random numbers and save them to a file
        String fileName = "numeros.txt";
        generateRandomNumbers(fileName, 100000);

        // Read numbers from the file and store them in an array
        Integer[] array = readNumbersFromFile(fileName);

        // Create the comparator
        IntegerComparator comparator = new IntegerComparator();

        // Clone the array for each sorting algorithm
        Integer[] insertionArray = array.clone();
        Integer[] mergeArray = array.clone();
        Integer[] quickArray = array.clone();
        Integer[] shellArray = array.clone();
        Integer[] radixArray = array.clone();
        Integer[] bucketArray = array.clone();

        // Sort and display the sorted array for each algorithm
        System.out.println("Sorting with Insertion Sort...");
        SortingAlgorithms.insertionSort(insertionArray, comparator);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArray));

        System.out.println("Sorting with Merge Sort...");
        SortingAlgorithms.mergeSort(mergeArray, comparator);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArray));

        System.out.println("Sorting with Quick Sort...");
        SortingAlgorithms.quickSort(quickArray, comparator);
        System.out.println("Quick Sort: " + Arrays.toString(quickArray));

        System.out.println("Sorting with Shell Sort...");
        SortingAlgorithms.shellSort(shellArray, comparator);
        System.out.println("Shell Sort: " + Arrays.toString(shellArray));

        System.out.println("Sorting with Radix Sort...");
        SortingAlgorithms.radixSort(radixArray);
        System.out.println("Radix Sort: " + Arrays.toString(radixArray));

        System.out.println("Sorting with Bucket Sort...");
        SortingAlgorithms.bucketSort(bucketArray);
        System.out.println("Bucket Sort: " + Arrays.toString(bucketArray));
    }

    /**
     * Generates random numbers and saves them to a file.
     * 
     * @param fileName the name of the file to save the numbers
     * @param count    the number of random numbers to generate
     */
    private static void generateRandomNumbers(String fileName, int count) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < count; i++) {
                int num = random.nextInt(10000); // Numbers between 0 and 9999
                writer.write(num + "\n");
            }
            System.out.println("Generated " + count + " random numbers in " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads numbers from a file and stores them in an array.
     * 
     * @param fileName the name of the file to read the numbers from
     * @return an array of integers read from the file
     */
    private static Integer[] readNumbersFromFile(String fileName) {
        try {
            List<Integer> numbers = Files.lines(Paths.get(fileName))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println("Read " + numbers.size() + " numbers from " + fileName);
            return numbers.toArray(new Integer[0]);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new Integer[0];
        }
    }
}