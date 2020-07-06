package sort.quick;

import sort.SortTemplate;

/**
 * @author YCH
 */
public class BestQuick3Way {
    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int p = lo;
        int q = hi + 1;
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (SortTemplate.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (SortTemplate.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i == j && a[i].compareTo(v) == 0) {
                SortTemplate.exch(a, ++p, i);
            }
            if (i >= j) {
                break;
            }

            SortTemplate.exch(a, i, j);
            if (a[i].compareTo(v) == 0) {
                SortTemplate.exch(a, ++p, i);
            }
            if (a[j].compareTo(v) == 0) {
                SortTemplate.exch(a, --q, j);
            }
        }

        i = j + 1;
        for (int k = lo; k <= p; k++) {
            SortTemplate.exch(a, k, j--);
        }
        for (int k = hi; k >= q ; k--) {
            SortTemplate.exch(a, k, i++);
        }

        sort(a, lo, j);
        sort(a, i, hi);
    }
}
