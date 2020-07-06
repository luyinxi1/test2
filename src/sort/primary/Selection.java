package sort.primary;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

/**
 * 选择排序。
 * @author YCH
 */
public class Selection{
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            //最小元素的索引
            int min = i;
            //将a[i]和a[i + 1,...,n]中最小的元素交换
            for (int j = i + 1; j < n; j++) {
                if (SortTemplate.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortTemplate.exch(a, i, min);
        }
    }
}
