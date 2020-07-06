package sort.application;

import edu.princeton.cs.algs4.StdRandom;
import sort.SortTemplate;

/**
 * @author acer
 */
public class KthSmallestElement {
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        int key = k - 1;

        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j == key) {
                return a[key];
            } else if (j > key) {
                hi = j - 1;
            } else if (j < key) {
                lo = j + 1;
            }
        }
        return a[key];
    }


    private static int partition(Comparable[] a, int lo, int hi) {
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
            if (i >= j) {
                break;
            }
            SortTemplate.exch(a, i, j);
        }

        SortTemplate.exch(a, lo, j);
        return j;
    }

    /*以下为递归实现*/
    public static Comparable selectRe(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        int key = k - 1;

        selectAux(a, lo, hi, key);
        return a[key];
    }
    private static void selectAux(Comparable[] a, int lo, int hi, int key) {
        if (lo >= hi) {
            return;
        }

        int j = partition(a, lo, hi);
        if (j == key) {
            return ;
        } else if (j > key) {
            selectAux(a, lo, j - 1, key);
        } else {
            selectAux(a, j + 1, hi, key);
        }
    }
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(selectRe(integers, 5));
    }
}
