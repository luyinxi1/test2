package sort.primary;

import edu.princeton.cs.algs4.In;
import sort.SortTemplate;

import java.util.ArrayList;

/**
 * 希尔排序。
 * @author YCH
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                //将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...中
                for (int j = i; j >= h && SortTemplate.less(a[j], a[j-h]); j -= h) {
                    SortTemplate.exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
//      2.1.11-预先计算递增序列并存储在一个数组中。
//    public static void sort(Comparable[] a) {
//        int n = a.length;
//        int h = 1;
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(h);
//        while (h < n / 3) {
//            h = 3 * h + 1;
//            list.add(h);
//        }
//
//        int[] ints = new int[list.size()];
//        for (int i = 0; i < ints.length; i++) {
//            ints[i] = list.get(i);
//        }
//
//        for (int i = ints.length - 1; i >= 0; i-- ){
//            int t = ints[i];
//            for (int j = t; j < n; j++) {
//                //将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...中
//                for (int k = j; k >= t && SortTemplate.less(a[k], a[k-t]); k -= t) {
//                    SortTemplate.exch(a, k, k - t);
//                }
//            }
//        }
//    }
}
