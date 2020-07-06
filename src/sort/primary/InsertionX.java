package sort.primary;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

/**
 * 添加了哨兵的插入排序。
 * @author YCH
 */
public class InsertionX {
    public static void sort(Comparable[] a) {
        int n = a.length;

        //找出最小的元素当做哨兵
        int exchange = 0;
        for (int i = n - 1; i > 0 ; i--) {
            if (SortTemplate.less(a[i], a[i-1])) {
                SortTemplate.exch(a, i, i - 1);
                exchange++;
            }
        }
        //exchange为0即数组为有序或主键全部相等的数组
        if (exchange == 0) {
            return ;
        }

        for (int i = 1; i < a.length; i++) {
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...中
            for (int j = i; SortTemplate.less(a[j], a[j-1]); j--) {
                SortTemplate.exch(a, j, j - 1);
            }
        }
    }
}
