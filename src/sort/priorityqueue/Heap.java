package sort.priorityqueue;


import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

import java.util.Arrays;

/**
 * 堆排序
 * @author YCH
 */
public class Heap {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = n / 2; i >= 1 ; i--) {
            sink(a, i, n);
        }

        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }

            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }
}
