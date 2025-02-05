package uvg.edu.Controller;

/**
 * Implementation of IComparator for Integer objects.
 * 
 * Integrantes:
 * - Carlos López
 * - Jonathan Tubac
 */
public class IntegerComparator implements IComparator<Integer> {

    /**
     * Compares two Integer objects.
     * 
     * @param _object1 the first Integer to compare
     * @param _object2 the second Integer to compare
     * @return the difference between _object1 and _object2 (ascending order)
     */
    @Override
    public int Compare(Integer _object1, Integer _object2) {
        return _object1 - _object2; // Ascending comparison
    }
}
