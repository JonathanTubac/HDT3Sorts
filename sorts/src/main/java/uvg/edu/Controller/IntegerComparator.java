package uvg.edu.Controller;

import java.util.Comparator;

public class IntegerComparator implements IComparator<Integer> {

    @Override
    public int Compare(Integer _object1, Integer _object2) {
        return _object1 - _object2; // Comparación ascendente
    }
}
