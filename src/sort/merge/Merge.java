package sort.merge;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

/**
 * 自顶向下的原地归并排序
 * @author YCH
 */
public class Merge {
    /**
     * 原地归并所需的辅助数组
     */
    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

//        有序性判断，若a[mid]<=a[mid+1]，我们认为数组已有序，不需归并，这样对于任意已有序数组的处理就变成了线性级别
//        if (SortTemplate.less(a[mid], a[mid+1])) {
//            return ;
//        }
        merge(a, lo, mid, hi);
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

    /**
     * 按降序将a[]的后半部分复制到aux[]中，并将索引从后向前移动，这样可以减少对某半边是否用尽的判断。
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void mergeHalf(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= mid; k++) {
            aux[k] = a[k];
        }
        for (int k = mid + 1; k <= hi; k++) {
            aux[k] = a[hi - k + 1 + mid];
        }
        for (int k = lo; k <= hi; k++) {
            if (SortTemplate.less(aux[j], aux[i])) {
                a[k] = aux[j--];
            } else {
                a[k] = aux[i++];
            }
        }
    }


}
