package sort.merge;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

/**
 * 自底向上的归并排序
 * @author YCH
 */
public class MergeBU {
    /**
     * 原地归并所需的辅助数组
     */
    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];

        for (int size = 1; size < n; size += size) {
            for (int lo = 0; lo < n - size; lo += (size + size)) {
                merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, n - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortTemplate.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

}
