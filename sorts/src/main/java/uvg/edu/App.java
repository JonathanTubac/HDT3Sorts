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

public class App {
    public static void main(String[] args) {
        // Generar 3000 números aleatorios y guardarlos en un archivo
        String fileName = "numeros.txt";
        generateRandomNumbers(fileName, 3000);

        // Leer los números desde el archivo y guardarlos en un arreglo
        Integer[] array = readNumbersFromFile(fileName);

        // Crear el comparador
        IntegerComparator comparator = new IntegerComparator();

        // Clonar el arreglo para cada algoritmo de ordenación
        Integer[] insertionArray = array.clone();
        Integer[] mergeArray = array.clone();
        Integer[] quickArray = array.clone();
        Integer[] shellArray = array.clone();
        Integer[] radixArray = array.clone();
        Integer[] bucketArray = array.clone();

        // Ordenar y mostrar el arreglo ordenado para cada algoritmo
        System.out.println("Ordenando con Insertion Sort...");
        SortingAlgorithms.insertionSort(insertionArray, comparator);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArray));

        System.out.println("Ordenando con Merge Sort...");
        SortingAlgorithms.mergeSort(mergeArray, comparator);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArray));

        System.out.println("Ordenando con Quick Sort...");
        SortingAlgorithms.quickSort(quickArray, comparator);
        System.out.println("Quick Sort: " + Arrays.toString(quickArray));

        System.out.println("Ordenando con Shell Sort...");
        SortingAlgorithms.shellSort(shellArray, comparator);
        System.out.println("Shell Sort: " + Arrays.toString(shellArray));

        System.out.println("Ordenando con Radix Sort...");
        SortingAlgorithms.radixSort(radixArray);
        System.out.println("Radix Sort: " + Arrays.toString(radixArray));

        System.out.println("Ordenando con Bucket Sort...");
        SortingAlgorithms.bucketSort(bucketArray);
        System.out.println("Bucket Sort: " + Arrays.toString(bucketArray));
    }

    // Método para generar números aleatorios y guardarlos en un archivo
    private static void generateRandomNumbers(String fileName, int count) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < count; i++) {
                int num = random.nextInt(10000); // Números entre 0 y 9999
                writer.write(num + "\n");
            }
            System.out.println("Se generaron " + count + " números aleatorios en " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para leer números desde un archivo y guardarlos en un arreglo
    private static Integer[] readNumbersFromFile(String fileName) {
        try {
            List<Integer> numbers = Files.lines(Paths.get(fileName))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println("Se leyeron " + numbers.size() + " números desde " + fileName);
            return numbers.toArray(new Integer[0]);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return new Integer[0];
        }
    }
}