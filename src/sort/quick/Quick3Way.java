package sort.quick;

import edu.princeton.cs.algs4.StdRandom;
import sort.SortTemplate;

/**
 * 三向切分的快速排序（熵最优）
 * @author acer
 */
public class Quick3Way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                SortTemplate.exch(a, lt++, i++);
            } else if (cmp > 0) {
                SortTemplate.exch(a, i, gt--);
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
