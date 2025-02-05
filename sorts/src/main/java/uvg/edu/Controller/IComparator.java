package uvg.edu.Controller;

/**
 * Interface for comparing two objects of the same type.
 * 
 * Integrantes:
 * - Carlos López
 * - Jonathan Tubac
 * 
 * @param <T> the type of objects to be compared
 */
public interface IComparator<T> {
    /**
     * Compares two objects.
     * 
     * @param _object1 the first object to compare
     * @param _object2 the second object to compare
     * @return a negative integer, zero, or a positive integer if the first object is less than, equal to, or greater than the second
     */
    public int Compare(T _object1, T _object2);
}
