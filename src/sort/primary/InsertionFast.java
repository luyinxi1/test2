package sort.primary;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

/**
 * 2.1.25-插入排序的优化：在内循环中将较大的元素右移而不是交换两个元素，数组的访问次数将减少一半。
 * @author YCH
 */
public class InsertionFast {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable temp = a[i];
            int j;
            for (j = i - 1; j >= 0 && SortTemplate.less(temp, a[j]); j--) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
}
