package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.InsertionX;
import sort.quick.Quick;

public class SortBehaviorTest {
    public static void main(String[] args) {
        String[] a = In.readStrings(args[0]);
        InsertionX.sort(a);
        assert SortTemplate.isSorted(a);
        SortTemplate.show(a);
    }
}
