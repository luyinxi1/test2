package sort.merge;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;
import sort.primary.Insertion;

/**
 * 2.2.11-归并排序的优化
 *
 * <p>1.辅助数组不再以静态类变量的形式存在，这样可能造成多个程序同时使用该类时造成错误。</p>
 * <p>2.添加了数组有序性的检查，是有序数组的处理时间变为线性。</p>
 * <p>3.递归时反复交换排序所使用的数组和被排序数组的角色,避免数组复制。</p>
 *
 * @author YCH
 */
public class MergeX {
    private static final int CUTOFF = 15;
    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();

        //第一层递归调整参数保证最后被排序的是原数组
        sort(aux, a, 0, a.length - 1);
    }

    /**
     *
     * @param src 递归中某一层的排序所使用的数组
     * @param dest 递归中某一层的被排序数组
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] src, Comparable[] dest, int lo, int hi) {
        if (hi - lo < CUTOFF) {
            insertion(dest, lo, hi);
            return;
        }
        int mid = (lo + hi) / 2;
        sort(dest, src, lo, mid);
        sort(dest, src, mid + 1, hi);

        //有序性判断，若a[mid]<=a[mid+1]，我们认为数组已有序，不需归并，这样对于任意已有序数组的处理就变成了线性级别
        if (SortTemplate.less(src[mid], src[mid+1])) {
            System.arraycopy(src, lo, dest, lo, hi - lo + 1);
            return;
       }
        merge(src, dest, lo, mid, hi);
    }

    /**
     *
     * @param src 排序所使用的数组
     * @param dest 被排序数组
     * @param mid
     * @param lo
     * @param hi
     */
    private static void merge(Comparable[] src, Comparable[] dest, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dest[k] = src[j++];
            } else if (j > hi) {
                dest[k] = src[i++];
            } else if (SortTemplate.less(src[j], src[i])) {
                dest[k] = src[j++];
            } else {
                dest[k] = src[i++];
            }
        }
    }

    private static void insertion(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && SortTemplate.less(a[j], a[j-1]); j--) {
                SortTemplate.exch(a, j, j - 1);
            }
        }
    }
}
